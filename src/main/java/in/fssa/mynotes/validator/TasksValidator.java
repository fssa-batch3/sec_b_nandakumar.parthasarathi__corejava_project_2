package in.fssa.mynotes.validator;

import in.fssa.mynotes.exception.ValidationException;
import in.fssa.mynotes.model.Tasks;

public class TasksValidator {

    public static void validateTask(Tasks task) throws ValidationException {
    	
    	if(task == null) {
    		throw new ValidationException("Task cannot be null");
    	}
        validateName(task.getName());
        validateDescription(task.getDescription());
        validateStatus(task.getStatus());
        // You can add more validation checks for other fields if needed
    }

    private static void validateName(String taskName) throws ValidationException {
        if (taskName == null || taskName.trim().isEmpty()) {
            throw new ValidationException("Task name cannot be null or empty");
        }
    }
    
    

    private static void validateDescription(String tasksDescription) throws ValidationException {
        if (tasksDescription == null || tasksDescription.trim().isEmpty()) {
            throw new ValidationException("Task description cannot be null or empty");
        }
    }

    private static void validateStatus(String tasksStatus) throws ValidationException {
    	
        if (tasksStatus == null || tasksStatus.trim().isEmpty() || !tasksStatus.equals("Pending") || !tasksStatus.equals("Progress") || !tasksStatus.equals("Completed")) {
            throw new ValidationException("Task status cannot be null or empty");
        }
    }
}
