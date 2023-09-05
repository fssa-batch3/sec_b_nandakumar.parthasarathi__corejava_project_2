package in.fssa.mynotes.service;

import java.util.Set;

import in.fssa.mynotes.dao.TasksDAO;
import in.fssa.mynotes.exception.PersistanceException;
import in.fssa.mynotes.exception.ValidationException;
import in.fssa.mynotes.model.Tasks;
import in.fssa.mynotes.validator.TasksValidator;

public class TasksService {

    public TasksDAO tasksDAO;

    public TasksService() {
        this.tasksDAO = new TasksDAO();
    }

    public Set<Tasks> getAllTasks() throws PersistanceException {
        return tasksDAO.findAllTasks();
    }

    public Set<Tasks> getAllUserTasks(int userId) throws PersistanceException {
        return tasksDAO.findAllUserTasks(userId);
    }

    public Tasks getTaskById(int taskId) throws PersistanceException {
        return tasksDAO.findTaskById(taskId);
    }

    public void createTask(Tasks newTask) throws PersistanceException, ValidationException {
        TasksValidator.validateTask(newTask);
        tasksDAO.createTask(newTask);
    }

    public void updateTask(int taskId, Tasks newTask) throws PersistanceException {
        tasksDAO.updateTask(taskId, newTask);
    }

    public void deleteTask(int taskId) throws PersistanceException {
        tasksDAO.deleteTask(taskId);
    }

	

}
