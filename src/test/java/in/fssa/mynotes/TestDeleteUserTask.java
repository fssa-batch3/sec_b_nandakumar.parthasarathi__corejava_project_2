package in.fssa.mynotes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import in.fssa.mynotes.model.Tasks;
import in.fssa.mynotes.service.TasksService;

public class TestDeleteUserTask {
    
    @Test
    void testDeleteSingleTaskForUserById() {
        TasksService taskService = new TasksService();
        
        // Create a task for testing
        Tasks newTask = new Tasks();
        newTask.setId(6);
        
        // Delete the created task
        assertDoesNotThrow(() -> {
            taskService.deleteTask(newTask.getId());
        });
    }
}

