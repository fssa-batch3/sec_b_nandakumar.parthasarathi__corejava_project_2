package in.fssa.mynotes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import in.fssa.mynotes.exception.PersistanceException;
import in.fssa.mynotes.model.Tasks;
import in.fssa.mynotes.model.User;
import in.fssa.mynotes.util.ConnectionUtil;

public class TasksDAO {

    public Set<Tasks> findAllTasks() throws PersistanceException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Set<Tasks> taskList = new HashSet<>();

        try {
            String query = "SELECT id, name, description, created_by, status FROM tasks";
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Tasks task = new Tasks();
                task.setId(rs.getInt("id"));
                task.setName(rs.getString("name"));
                task.setDescription(rs.getString("description"));
                task.setCreatedBy(rs.getInt("created_by"));
                task.setStatus(rs.getString("status"));
                taskList.add(task);
            }
        } catch (SQLException e) {
            throw new PersistanceException("Error while fetching tasks: " + e.getMessage());
        } finally {
            ConnectionUtil.close(con, ps, rs);
        }
        return taskList;
    }

    public Set<Tasks> findAllUserTasks(int userId) throws PersistanceException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Set<Tasks> userTaskList = new HashSet<>();

        try {
            String query = "SELECT t.* FROM tasks t JOIN tasks ut ON t.id = ut.id WHERE ut.id = ?";
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
                userTaskList.add(task);
            }
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
            String query = "SELECT id, name, description, created_by, status FROM tasks WHERE id = ?";
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
            String query = "INSERT INTO tasks (name, description, status , created_by) VALUES (?, ?, ? , ?)";
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(query);

            ps.setString(1, newTask.getName());
            ps.setString(2, newTask.getDescription());
            ps.setString(3, newTask.getStatus());
            ps.setInt(4, newTask.getCreatedBy());


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
            String query = "UPDATE tasks SET name = ?, description = ?, status = ? WHERE id = ?";
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(query);

            ps.setString(1, updatedTask.getName());
            ps.setString(2, updatedTask.getDescription());
            ps.setString(3, updatedTask.getStatus());
            ps.setInt(4, taskId);

            ps.executeUpdate();
            System.out.println("Task has been updated successfully");

        } catch (SQLException e) {
            throw new PersistanceException("Error while updating task: " + e.getMessage());
        } finally {
            ConnectionUtil.close(con, ps);
        }
    }
    
    public void updateTaskStatus(int taskId, String updateStatus) throws PersistanceException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            String query = "UPDATE tasks SET status = ? WHERE id = ?";
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(query);

            ps.setString(1, updateStatus);
            ps.setInt(2, taskId);

            ps.executeUpdate();
            System.out.println("Status updated successfully");

        } catch (SQLException e) {
            throw new PersistanceException("Error while updating status: " + e.getMessage());
        } finally {
            ConnectionUtil.close(con, ps);
        }
    }
    
    

//    public void updateUserTaskDetails(int userId, int taskId, Tasks updatedTask) throws PersistanceException {
//        Connection con = null;
//        PreparedStatement ps = null;
//
//        try {
//            String query = "UPDATE user_tasks SET status = ?, additional_info = ? WHERE user_id = ? AND task_id = ?";
//            con = ConnectionUtil.getConnection();
//            ps = con.prepareStatement(query);
//
//            ps.setString(1, updatedTask.getStatus());
//            ps.setInt(2, userId);
//            ps.setInt(3, taskId);
//
//            ps.executeUpdate();
//            System.out.println("User task details have been updated successfully");
//
//        } catch (SQLException e) {
//            throw new PersistanceException("Error while updating user task details: " + e.getMessage());
//        } finally {
//            ConnectionUtil.close(con, ps);
//        }
//    }

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

   
}
