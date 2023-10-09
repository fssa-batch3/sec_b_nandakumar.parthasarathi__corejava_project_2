package in.fssa.mynotes.service;

import java.util.List;
import in.fssa.mynotes.dao.TasksDAO;
import in.fssa.mynotes.exception.PersistanceException;
import in.fssa.mynotes.exception.ValidationException;
import in.fssa.mynotes.model.TaskHistory;
import in.fssa.mynotes.model.Tasks;
import in.fssa.mynotes.validator.TasksValidator;

public class TasksService {

    private TasksDAO tasksDAO;

    public TasksService() {
        this.tasksDAO = new TasksDAO();
    }

    /**
     * Get a task by its ID.
     *
     * @param taskId The ID of the task to retrieve.
     * @return The task with the specified ID, or null if not found.
     * @throws PersistanceException If an error occurs during data access.
     */
    public Tasks getTaskById(int taskId) throws PersistanceException {
        return tasksDAO.findTaskById(taskId);
    }

    /**
     * Create a new task.
     *
     * @param newTask The task to create.
     * @throws PersistanceException If an error occurs during data access.
     * @throws ValidationException If the task data is invalid.
     */
    public void createTask(Tasks newTask) throws PersistanceException, ValidationException {
        // Validate the task data before creating it
        TasksValidator.validateTask(newTask);
        tasksDAO.createTask(newTask);
    }

    /**
     * Update an existing task.
     *
     * @param taskId  The ID of the task to update.
     * @param newTask The updated task data.
     * @throws PersistanceException If an error occurs during data access.
     */
    public void updateTask(int taskId, Tasks newTask) throws PersistanceException {
        // Update the task using the DAO
        tasksDAO.updateTask(taskId, newTask);
    }

    /**
     * Delete a task by its ID.
     *
     * @param taskId The ID of the task to delete.
     * @throws PersistanceException If an error occurs during data access.
     */
    public void deleteTask(int taskId) throws PersistanceException {
        tasksDAO.deleteTask(taskId);
    }

    /**
     * Get all tasks created by a specific user.
     *
     * @param userId The ID of the user.
     * @return A list of tasks created by the user.
     * @throws PersistanceException If an error occurs during data access.
     */
    public List<Tasks> getAllUserTasks(int userId) throws PersistanceException {
        return tasksDAO.findAllUserTasks(userId);
    }

    public List<TaskHistory> getTaskHistoryByTaskId(int taskId) throws PersistanceException {
        return tasksDAO.findTaskHistoryByTaskId(taskId);
    }

}
