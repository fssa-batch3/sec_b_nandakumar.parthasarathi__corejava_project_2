package in.fssa.mynotes;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import in.fssa.mynotes.exception.ValidationException;
import in.fssa.mynotes.model.Tasks;
import in.fssa.mynotes.service.TasksService;

public class TestCreateTask {

    @Test
    public void testCreateTaskWithValidInput() {
        TasksService tasksService = new TasksService();
        Tasks newTask = new Tasks();
        newTask.setName("Irritation nanda");
        newTask.setDescription("Buy milk, bread, and eggs");
        newTask.setStatus("Pending"); // Valid status value

        assertDoesNotThrow(() -> {
            tasksService.createTask(newTask);
        });
    }

    @Test
    public void testCreateTaskWithNullInput() {
        TasksService tasksService = new TasksService();
        Exception exception = assertThrows(ValidationException.class, () -> {
            tasksService.createTask(null);
        });
        String expectedMessage = "Task cannot be null";
        String receivedMessage = exception.getMessage();
        assertTrue(expectedMessage.equals(receivedMessage));
    }

    @Test
    public void testCreateTaskWithEmptyName() {
        TasksService tasksService = new TasksService();
        Tasks newTask = new Tasks();
        newTask.setName("");
        newTask.setDescription("This is a description");
        newTask.setStatus("Pending");

        Exception exception = assertThrows(ValidationException.class, () -> {
            tasksService.createTask(newTask);
        });
        String expectedMessage = "Task name cannot be null or empty";
        String receivedMessage = exception.getMessage();
        assertTrue(expectedMessage.equals(receivedMessage));
    }

    @Test
    public void testCreateTaskWithNullName() {
        TasksService tasksService = new TasksService();
        Tasks newTask = new Tasks();
        newTask.setName(null);
        newTask.setDescription("This is a description");
        newTask.setStatus("Pending");

        Exception exception = assertThrows(ValidationException.class, () -> {
            tasksService.createTask(newTask);
        });
        String expectedMessage = "Task name cannot be null or empty";
        String receivedMessage = exception.getMessage();
        assertTrue(expectedMessage.equals(receivedMessage));
    }

    @Test
    public void testCreateTaskWithEmptyDescription() {
        TasksService tasksService = new TasksService();
        Tasks newTask = new Tasks();
        newTask.setName("Task Name");
        newTask.setDescription("");
        newTask.setStatus("Pending");

        Exception exception = assertThrows(ValidationException.class, () -> {
            tasksService.createTask(newTask);
        });
        String expectedMessage = "Task description cannot be null or empty";
        String receivedMessage = exception.getMessage();
        System.out.println(receivedMessage);
        assertTrue(expectedMessage.equals(receivedMessage));
    }

    @Test
    public void testCreateTaskWithNullDescription() {
        TasksService tasksService = new TasksService();
        Tasks newTask = new Tasks();
        newTask.setName("Task Name");
        newTask.setDescription(null);
        newTask.setStatus("Pending");

        Exception exception = assertThrows(ValidationException.class, () -> {
            tasksService.createTask(newTask);
        });
        String expectedMessage = "Task description cannot be null or empty";
        String receivedMessage = exception.getMessage();
        System.out.println(receivedMessage);
        assertTrue(expectedMessage.equals(receivedMessage));
    }
    
    
    @Test
    public void testCreateTaskWithEmptyStatus() {
        TasksService tasksService = new TasksService();
        Tasks newTask = new Tasks();
        newTask.setName("Task Name");
        newTask.setDescription("This is a description");
        newTask.setStatus("");

        Exception exception = assertThrows(ValidationException.class, () -> {
            tasksService.createTask(newTask);
        });
        String expectedMessage = "Task status cannot be null or empty";
        String receivedMessage = exception.getMessage();
        System.out.println(receivedMessage);
        assertTrue(expectedMessage.equals(receivedMessage));
    }

    @Test
    public void testCreateTaskWithNullStatus() {
        TasksService tasksService = new TasksService();
        Tasks newTask = new Tasks();
        newTask.setName("Task Name");
        newTask.setDescription("This is a description");
        newTask.setStatus(null);

        Exception exception = assertThrows(ValidationException.class, () -> {
            tasksService.createTask(newTask);
        });
        String expectedMessage = "Task status cannot be null or empty";
        String receivedMessage = exception.getMessage();
        System.out.println(receivedMessage);
        assertTrue(expectedMessage.equals(receivedMessage));
    }

    
    // Additional test cases can be added here to cover more scenarios
}
