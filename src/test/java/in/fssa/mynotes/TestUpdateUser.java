package in.fssa.mynotes;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import in.fssa.mynotes.exception.ValidationException;
import in.fssa.mynotes.model.User;
import in.fssa.mynotes.service.UserService;

public class TestUpdateUser {

	@Test
	public void testUpdateUserWithValidInput() {

		UserService userService = new UserService();

		User newUser = new User();
		newUser.setEmail("thara@gmail.com");
		newUser.setName("Tharakai");
		newUser.setPassword("Thara@12345");

		assertDoesNotThrow(() -> {
			userService.updateUser(3, newUser);
		});
	}

	// Invalid Input
	@Test
	public void testUpdateUserWithInvaidInput() {
		UserService userService = new UserService();
		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.updateUser(0, null);
		});
		String expectedMessage = "User cannot be null";
		String receivedMessage = exception.getMessage();
		System.out.println(receivedMessage);
		assertTrue(expectedMessage.equals(receivedMessage));
	}

	// Password null check
	@Test
	public void testUserWithPasswordNull() {
		UserService userService = new UserService();

		User newUser = new User();
		newUser.setEmail("nanda@gmail.com");
		newUser.setName("Nanda");
		newUser.setPassword(null);

		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.updateUser(1, newUser);
		});

		String expectedMessage = "Password cannot be null or empty";
		String receivedMessage = exception.getMessage();
		System.out.println(receivedMessage);
		assertTrue(expectedMessage.equals(receivedMessage));
	}

	// Password is Empty
	@Test
	public void testUserWithPasswordEmpty() {

		UserService userService = new UserService();

		User newUser = new User();
		newUser.setEmail("nanda@gmail.com");
		newUser.setName("Nanda");
		newUser.setPassword("");
		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.updateUser(1, newUser);

		});

		String expectedMessage = "Password cannot be null or empty";
		String receivedMessage = exception.getMessage();
		System.out.println(receivedMessage);
		assertTrue(expectedMessage.equals(receivedMessage));
	}

	// Name null check
	@Test
	public void testUserWithNameNull() {
		UserService userService = new UserService();

		User newUser = new User();
		newUser.setEmail("nanda@gmail.com");
		newUser.setName(null);
		newUser.setPassword("nanda66");

		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.updateUser(1, newUser);
		});

		String expectedMessage = "Name cannot be null or empty";
		String receivedMessage = exception.getMessage();
		System.out.println(receivedMessage);
		assertTrue(expectedMessage.equals(receivedMessage));
	}

	// Name is empty
	@Test
	public void testUserWithNameEmpty() {

		UserService userService = new UserService();

		User newUser = new User();
		newUser.setEmail("nanda@gmail.com");
		newUser.setName("");
		newUser.setPassword("nanda66");
		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.updateUser(1, newUser);

		});

		String expectedMessage = "Name cannot be null or empty";
		String receivedMessage = exception.getMessage();
		System.out.println(receivedMessage);
		assertTrue(expectedMessage.equals(receivedMessage));
	}
}