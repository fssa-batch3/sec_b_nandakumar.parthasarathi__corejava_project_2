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

    private static void validateName(String name) throws ValidationException {
        if (name == null || name.trim().isEmpty()) {
            throw new ValidationException("Task name cannot be null ot empty");
        }
        
       
    }
    
    

    private static void validateDescription(String description) throws ValidationException {
        if (description == null || description.trim().isEmpty()) {
            throw new ValidationException("Task description cannot be null or empty");
        }
    }

    private static void validateStatus(String status) throws ValidationException {
        if (!status.equals("Pending") && !status.equals("In Progress") && !status.equals("Completed")) {
            throw new ValidationException("Task status cannot be null or empty");
        }
    }
}
