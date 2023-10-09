package in.fssa.mynotes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import in.fssa.mynotes.exception.PersistanceException;
import in.fssa.mynotes.model.TaskHistory;
import in.fssa.mynotes.model.Tasks;
import in.fssa.mynotes.util.ConnectionUtil;

public class TasksDAO {
	
	public List<Tasks> findAllUserTasks(int userId) throws PersistanceException {
	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    List<Tasks> userTaskList = new ArrayList<>();

	    try {
	        // Modify the SQL query to include an ORDER BY clause
	        String query = "SELECT id, name, description, created_by, priority, status, due_date " +
	                       "FROM tasks " +
	                       "WHERE created_by = ? " +
	                       "ORDER BY created_at DESC"; // Order by created_at in descending order
	                       
	        con = ConnectionUtil.getConnection();
	        ps = con.prepareStatement(query);
	        ps.setInt(1, userId);
	        rs = ps.executeQuery();

	        while (rs.next()) {
	            Tasks task = new Tasks();
	            task.setId(rs.getInt("id"));
	            task.setName(rs.getString("name"));
	            task.setDescription(rs.getString("description"));
	            task.setStatus(rs.getString("status"));
	            task.setCreatedBy(rs.getInt("created_by"));

	            String priority = "";

	            if (rs.getString("priority") == null) {
	                priority = "medium";
	            } else {
	                priority = rs.getString("priority");
	            }

	            task.setPriority(priority);

	            // Retrieve the "due_date" column from the ResultSet and set it in the Tasks
	            // object
	            java.sql.Timestamp dueDateTimestamp = rs.getTimestamp("due_date");
	            if (dueDateTimestamp != null) {
	                task.setDueDate(dueDateTimestamp.toLocalDateTime());
	            } else {
	                // Handle the case where "due_date" is null
	                task.setDueDate(null);
	            }

	            userTaskList.add(task);
	        }
	        System.out.println(userTaskList);
	    } catch (SQLException e) {
	        throw new PersistanceException("Error while fetching user tasks: " + e.getMessage());
	    } finally {
	        ConnectionUtil.close(con, ps, rs);
	    }
	    return userTaskList;
	}


	public Tasks findTaskById(int taskId) throws PersistanceException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String query = "SELECT id, name, description, priority, created_by, status, due_date FROM tasks WHERE id = ?";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, taskId);
			rs = ps.executeQuery();

			if (rs.next()) {
				Tasks task = new Tasks();
				task.setId(rs.getInt("id"));
				task.setName(rs.getString("name"));
				task.setDescription(rs.getString("description"));
				task.setCreatedBy(rs.getInt("created_by"));
				task.setStatus(rs.getString("status"));

				String priority = "";

				if (rs.getString("priority") == null) {
					priority = "medium";
				} else {
					priority = rs.getString("priority");
				}

				task.setPriority(priority);

				// Retrieve the "due_date" column from the ResultSet and set it in the Tasks
				// object
				java.sql.Timestamp dueDateTimestamp = rs.getTimestamp("due_date");
				if (dueDateTimestamp != null) {
					task.setDueDate(dueDateTimestamp.toLocalDateTime());
				} else {
					// Handle the case where "due_date" is null
					task.setDueDate(null);
				}

				return task;
			} else {
				// Task with the specified ID not found
				return null;
			}
		} catch (SQLException e) {
			throw new PersistanceException("Error while fetching task by ID: " + e.getMessage());
		} finally {
			ConnectionUtil.close(con, ps, rs);
		}
	}

	public void createTask(Tasks newTask) throws PersistanceException {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			String query = "INSERT INTO tasks (name, description, status, created_by, priority, due_date) VALUES (?, ?, ?, ?, ?, ?)";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);

			ps.setString(1, newTask.getName());
			ps.setString(2, newTask.getDescription());
			ps.setString(3, newTask.getStatus());
			ps.setInt(4, newTask.getCreatedBy());
			ps.setString(5, newTask.getPriority());
			ps.setTimestamp(6, Timestamp.valueOf(newTask.getDueDate()));
//	        ps.setString(7, newTask.getDuration()); // Set the duration_duration field

			ps.executeUpdate();
			System.out.println("Task has been created successfully");

		} catch (SQLException e) {
			throw new PersistanceException("Error while creating task: " + e.getMessage());
		} finally {
			ConnectionUtil.close(con, ps);
		}
	}

	public void updateTask(int taskId, Tasks updatedTask) throws PersistanceException {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			String query = "UPDATE tasks SET name = ?, description = ?, status = ?, priority = ?, due_date = ? WHERE id = ?";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);

			ps.setString(1, updatedTask.getName());
			ps.setString(2, updatedTask.getDescription());
			ps.setString(3, updatedTask.getStatus());
			ps.setString(4, updatedTask.getPriority());
			ps.setTimestamp(5, Timestamp.valueOf(updatedTask.getDueDate())); // Set the due date
//	        ps.setString(6, updatedTask.getDuration()); // Set the duration_duration field
			ps.setInt(6, taskId); // Set the taskId parameter

			ps.executeUpdate();
			System.out.println("Task has been updated successfully");

		} catch (SQLException e) {
			throw new PersistanceException("Error while updating task: " + e.getMessage());
		} finally {
			ConnectionUtil.close(con, ps);
		}
	}

	public void deleteTask(int taskId) throws PersistanceException {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			String query = "DELETE FROM tasks WHERE id = ?";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, taskId);

			ps.executeUpdate();
			System.out.println("Task has been deleted successfully");

		} catch (SQLException e) {
			throw new PersistanceException("Error while deleting task: " + e.getMessage());
		} finally {
			ConnectionUtil.close(con, ps);
		}
	}
	
	
	public List<TaskHistory> findTaskHistoryByTaskId(int taskId) throws PersistanceException {
	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    List<TaskHistory> taskHistoryList = new ArrayList<>();

	    try {
	        String query = "SELECT id, action, task_name, task_description, created_at " +
	                       "FROM tasks_history " +
	                       "WHERE task_id = ? " +
	                       "ORDER BY created_at DESC"; // Order by created_at in descending order

	        con = ConnectionUtil.getConnection();
	        ps = con.prepareStatement(query);
	        ps.setInt(1, taskId);
	        rs = ps.executeQuery();

	        while (rs.next()) {
	            TaskHistory taskHistory = new TaskHistory();
	            taskHistory.setId(rs.getInt("id"));	
	            taskHistory.setAction(rs.getString("action"));
	            taskHistory.setTaskName(rs.getString("task_name"));
	            taskHistory.setTaskDescription(rs.getString("task_description"));
	            
	            // Retrieve the "created_at" column from the ResultSet and set it in the TaskHistory object
	            java.sql.Timestamp createdAtTimestamp = rs.getTimestamp("created_at");
	            if (createdAtTimestamp != null) {
	                taskHistory.setCreatedAt(createdAtTimestamp.toLocalDateTime());
	            } else {
	                // Handle the case where "created_at" is null
	                taskHistory.setCreatedAt(null);
	            }

	            taskHistoryList.add(taskHistory);
	        }
	    } catch (SQLException e) {
	        throw new PersistanceException("Error while fetching task history: " + e.getMessage());
	    } finally {
	        ConnectionUtil.close(con, ps, rs);
	    }
	    return taskHistoryList;
	}


}
