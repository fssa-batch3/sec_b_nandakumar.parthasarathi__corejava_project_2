package in.fssa.mynotes.validator;

import java.time.LocalDateTime;
import java.util.Date;

import in.fssa.mynotes.exception.ValidationException;
import in.fssa.mynotes.model.Priority;
import in.fssa.mynotes.model.Tasks;

public class TasksValidator {

    public static void validateTask(Tasks task) throws ValidationException {
        if (task == null) {
            throw new ValidationException("Task cannot be null");
        }
        validateName(task.getName());
        validateDescription(task.getDescription());
        validateStatus(task.getStatus());
        validatePriority(task.getPriority());
        validateDueDate(task.getDueDate());
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
        if (tasksStatus == null || tasksStatus.trim().isEmpty() ||
                (!tasksStatus.equals("Pending") && !tasksStatus.equals("Progress") && !tasksStatus.equals("Completed"))) {
            throw new ValidationException("Task status cannot be null, empty, or invalid");
        }
    }

    private static void validatePriority(String priority) throws ValidationException {
        if (priority == null) {
            throw new ValidationException("Task priority cannot be null");
        }

        // Assuming Priority is an enum with values Low, Medium, and High
        boolean isValidPriority = false;

        try {
            Priority.fromValue(priority);
            isValidPriority = true;
        } catch (Exception e) {
            isValidPriority = false;
        }

        if (!isValidPriority) {
            throw new ValidationException("Task priority is invalid");
        }
    }

    private static void validateDueDate(LocalDateTime localDateTime) throws ValidationException {
        if (localDateTime == null) {
            throw new ValidationException("Due date cannot be null");
        }
    }

//    private static void validateDurationHours(String durationHours) throws ValidationException {
//        if (durationHours == null || durationHours.trim().isEmpty()) {
//            throw new ValidationException("Duration hours cannot be null or empty");
//        }
//
//        try {
//            int hours = Integer.parseInt(durationHours);
//            if (hours < 0) {
//                throw new ValidationException("Duration hours cannot be negative");
//            }
//            // You can add more specific validation rules for duration hours if needed
//        } catch (NumberFormatException e) {
//            throw new ValidationException("Invalid duration hours format");
//        }
//    }
}
