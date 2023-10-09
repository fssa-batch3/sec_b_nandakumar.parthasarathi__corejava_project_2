package in.fssa.mynotes;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;

import org.junit.jupiter.api.Test;

import in.fssa.mynotes.exception.ValidationException;
import in.fssa.mynotes.model.Tasks;
import in.fssa.mynotes.service.TasksService;

public class TestUpdateTaskDetails {

	@Test
	public void testUpdateTaskWithValidInput() {
	    TasksService tasksService = new TasksService();
	    
	    // Create a task to update
	    Tasks taskToUpdate = new Tasks();
	    taskToUpdate.setId(5); // Replace with the ID of the task to update
	    taskToUpdate.setName("Play against Stall7");
	    taskToUpdate.setDescription("intence Match");
	    taskToUpdate.setStatus("Pending");
	    taskToUpdate.setPriority("High");
	    
	    // Set a new due date using LocalDateTime
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	    try {
	        LocalDateTime dueDate = LocalDateTime.parse("2023-10-22 07:15:00", formatter);
	        taskToUpdate.setDueDate(dueDate);
	    } catch (DateTimeParseException e) {
	        e.printStackTrace();
	    }

	    assertDoesNotThrow(() -> {
	        tasksService.updateTask(taskToUpdate.getId(), taskToUpdate);
	    });
	}

//    @Test
//    public void testUpdateTaskWithInvalidInput() {
//        TasksService tasksService = new TasksService();
//        
//        // Create a task with invalid input for update
//        Tasks taskToUpdate = new Tasks();
//        taskToUpdate.setId(999); // Replace with a non-existent task ID
//        taskToUpdate.setName("Updated Task Name");
//        taskToUpdate.setDescription("Updated task description");
//        taskToUpdate.setStatus("Completed");
//        taskToUpdate.setPriority("High");
//        
//        // Set a new due date (replace with your desired due date)
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        try {
//            Date dueDate = new Date(dateFormat.parse("2023-09-30 16:30:00").getTime());
//            taskToUpdate.setDueDate(dueDate);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        
//        // Calculate duration based on due date and current date
//        Calendar calendar = Calendar.getInstance();
//        Date currentDate = new Date(calendar.getTimeInMillis());
//        long timeDifference = taskToUpdate.getDueDate().getTime() - currentDate.getTime();
//        long durationDays = timeDifference / (24 * 60 * 60 * 1000); // Convert milliseconds to days
//        long durationHours = (timeDifference % (24 * 60 * 60 * 1000)) / (60 * 60 * 1000); // Convert remaining milliseconds to hours
//        
//        String duration = "";
//        if (durationDays > 0) {
//            duration += durationDays + " day(s) ";
//        }
//        if (durationHours > 0) {
//            duration += durationHours + " hour(s)";
//        }
//        
//        taskToUpdate.setDurationDays(String.valueOf(durationDays)); // Store the duration in days as a string
//        taskToUpdate.setDurationHours(String.valueOf(durationHours)); // Convert durationHours to String and store it
//
//        // Expect a ValidationException because the task ID is invalid
//        assertThrows(ValidationException.class, () -> {
//            tasksService.updateTask(taskToUpdate.getId(), taskToUpdate);
//        });
//    }
}
