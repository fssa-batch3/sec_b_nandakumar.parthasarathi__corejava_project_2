package in.fssa.mynotes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;

import in.fssa.mynotes.model.Tasks;
import in.fssa.mynotes.service.TasksService;

public class TestListAllUserTask {
	
	@Test
	void getAllTaskByUserById(){
		TasksService taskService = new TasksService();
		
		try {
			Set<Tasks> task = taskService.getAllUserTasks(1);
			System.out.println(task);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
