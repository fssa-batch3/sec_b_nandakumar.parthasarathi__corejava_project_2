package in.fssa.mynotes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import in.fssa.mynotes.exception.ValidationException;
import in.fssa.mynotes.model.Tasks;
import in.fssa.mynotes.service.TasksService;

public class TestUpdateTaskDetails {

    @Test
    void testUpdateTaskName() {
        TasksService tasksService = new TasksService();

        // Create a task for testing
        Tasks newTask = new Tasks();
        newTask.setId(2);
        newTask.setName("Practice match against Airborne");
        newTask.setDescription("We want good intense game");
        newTask.setStatus("completed");

        assertDoesNotThrow(() -> {
            tasksService.updateTask(newTask.getId(),newTask );
        });

    }

}
