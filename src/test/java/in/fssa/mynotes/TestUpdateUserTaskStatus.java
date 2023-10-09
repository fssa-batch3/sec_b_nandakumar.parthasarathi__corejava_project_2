package in.fssa.mynotes;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import in.fssa.mynotes.model.Tasks;
import in.fssa.mynotes.model.Priority;
import in.fssa.mynotes.service.TasksService;

public class TestUpdateUserTaskStatus {

    @Test
    void testUpdateTaskStatusAndPriority() {
        TasksService tasksService = new TasksService();

        // Create a task for testing
        Tasks updatedTask = new Tasks();
        updatedTask.setId(2);
        updatedTask.setStatus("Completed"); // New status
        updatedTask.setPriority("Low");
        

        assertDoesNotThrow(() -> {
            tasksService.updateTask(updatedTask.getId(), updatedTask);
        });
    }
}

