package in.fssa.mynotes;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import in.fssa.mynotes.model.Tasks;
import in.fssa.mynotes.service.TasksService;

public class TestUpdateUserTaskStatus {

	 @Test
	    void testUpdateTaskName() {
	        TasksService tasksService = new TasksService();

	        // Create a task for testing
	        Tasks newTask = new Tasks();
	        newTask.setId(2);
	        newTask.setStatus("Pending");

	        assertDoesNotThrow(() -> {
	            tasksService.updateTaskStatus(newTask.getId(), newTask.getStatus() );
	        });
	    }

}
