package in.fssa.mynotes;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import in.fssa.mynotes.model.Tasks;
import in.fssa.mynotes.service.TasksService;

public class TestUpdateTaskDetails {

    @Test
    void testUpdateTaskName() {
        TasksService tasksService = new TasksService();

        // Create a task for testing
        Tasks newTask = new Tasks();
        newTask.setId(2);
        newTask.setName("Practice match against stall7");
        newTask.setDescription("We want victory or intense neck to neck game");
        newTask.setStatus("Pending");

        assertDoesNotThrow(() -> {
            tasksService.updateTask(newTask.getId(), newTask);
        });
    }
}
