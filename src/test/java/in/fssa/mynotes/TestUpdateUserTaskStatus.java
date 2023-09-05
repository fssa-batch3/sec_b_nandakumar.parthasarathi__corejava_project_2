package in.fssa.mynotes;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import in.fssa.mynotes.model.Tasks;
import in.fssa.mynotes.service.TasksService;

public class TestUpdateUserTaskStatus {

    @Test
    void testUpdateTaskStatus() {
        TasksService tasksService = new TasksService();

        // Create a task for testing
        Tasks updatedTask = new Tasks();
        updatedTask.setId(2);
        updatedTask.setStatus("Pending"); // New status

        assertDoesNotThrow(() -> {
            tasksService.updateTask(updatedTask.getId(), updatedTask);
        });
    }
}
