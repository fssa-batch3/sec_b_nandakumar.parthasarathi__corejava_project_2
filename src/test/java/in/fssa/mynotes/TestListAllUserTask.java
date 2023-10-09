package in.fssa.mynotes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import in.fssa.mynotes.model.Tasks;
import in.fssa.mynotes.service.TasksService;

public class TestListAllUserTask {

    @Test
    void testGetAllUserTasksValidUserId() {
        // Create an instance of TasksService
        TasksService taskService = new TasksService();

        try {
            List<Tasks> tasks = taskService.getAllUserTasks(1);
            for (Tasks task : tasks) {
                System.out.println(task); // Assuming your Tasks class has a meaningful toString method
            }

            // Add your assertions here to verify the correctness of the result
            assertNotNull(tasks);
            assertTrue(tasks.size() > 0);
            // You can add more specific assertions based on your requirements

        } catch (Exception e) {
            e.printStackTrace();
            fail("An exception occurred for a valid user ID: " + e.getMessage());
        }
    }
} 
