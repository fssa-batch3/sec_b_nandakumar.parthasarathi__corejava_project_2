package in.fssa.mynotes;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

import org.junit.jupiter.api.Test;

import in.fssa.mynotes.exception.ValidationException;
import in.fssa.mynotes.model.User;
import in.fssa.mynotes.service.UserService;

public class TestCreateUser {

	private Random random = new Random();

	public String generateRandomString(int length) {
		String characters = "abcdefghijklmnopqrstuvwxyz";
		StringBuilder randomString = new StringBuilder();

		for (int i = 0; i < length; i++) {
			int index = random.nextInt(characters.length());
			randomString.append(characters.charAt(index));
		}
		return randomString.toString();
	}

	// Valid Input
	@Test
	public void testCreateUserWithValidInput() {

		UserService userService = new UserService();
		User newUser = new User();
		newUser.setName("Ram");
		newUser.setEmail(generateRandomString(5) + "@gmail.com");
		newUser.setPassword("Ram@12345");

		assertDoesNotThrow(() -> {
			userService.createUser(newUser);
		});
	}

	// Invalid Input
	@Test
	public void testCreateUserWithInvaidInput() {
		UserService userService = new UserService();
		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.createUser(null);
		});
		String expectedMessage = "User cannot be null";
		String receivedMessage = exception.getMessage();
		System.out.println(receivedMessage);
		assertTrue(expectedMessage.equals(receivedMessage));
	}

	// Email null check
	@Test
	public void testUserWithEmailNull() {
		UserService userService = new UserService();

		User newUser = new User();
		newUser.setEmail(null);
		newUser.setName("Inba");
		newUser.setPassword("Abcd1234");

		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.createUser(newUser);
		});

		String expectedMessage = "Email cannot be null or empty";
		String receivedMessage = exception.getMessage();
		System.out.println(receivedMessage);
		assertTrue(expectedMessage.equals(receivedMessage));
	}

	// Email is Empty
	@Test
	public void testUserWithEmailEmpty() {

		UserService userService = new UserService();

		User newUser = new User();
		newUser.setEmail("");
		newUser.setName("Inba");
		newUser.setPassword("Abcd1234");
		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.createUser(newUser);

		});

		String expectedMessage = "Email cannot be null or empty";
		String receivedMessage = exception.getMessage();
		System.out.println(receivedMessage);
		assertTrue(expectedMessage.equals(receivedMessage));
	}

	// Password null check
	@Test
	public void testUserWithPasswordNull() {
		UserService userService = new UserService();

		User newUser = new User();
		newUser.setEmail("inba@gmail.com");
		newUser.setName("Inba");
		newUser.setPassword(null);

		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.createUser(newUser);
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
		newUser.setEmail("inba@gmail.com");
		newUser.setName("Inba");
		newUser.setPassword("");
		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.createUser(newUser);

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
		newUser.setEmail("inba@gmail.com");
		newUser.setName(null);
		newUser.setPassword("Inba12345");

		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.createUser(newUser);
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
		newUser.setEmail("inba@gmail.com");
		newUser.setName("");
		newUser.setPassword("Inba12345");
		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.createUser(newUser);

		});

		String expectedMessage = "Name cannot be null or empty";
		String receivedMessage = exception.getMessage();
		System.out.println(receivedMessage);
		assertTrue(expectedMessage.equals(receivedMessage));
	}

	// Name Pattern check
	@Test
	public void testUserWithNameInValidPattern() {

		UserService userService = new UserService();
		User newUser = new User();
		newUser.setEmail("inba@gmail.com");
		newUser.setName("Akil123");
		newUser.setPassword("Inba1234");

		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.createUser(newUser);

		});
		String expectedMessage = "Name should contains only alphabets";
		String receivedMessage = exception.getMessage();
		System.out.println(receivedMessage);
		assertTrue(expectedMessage.equals(receivedMessage));

	}

	// Email Pattern check
	@Test
	public void testUserWithEmailInValidPattern() {

		UserService userService = new UserService();
		User newUser = new User();
		newUser.setEmail("@.com");
		newUser.setName("Akil");
		newUser.setPassword("Inba12345");

		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.createUser(newUser);

		});
		String expectedMessage = "Email does not match the Pattern";
		String receivedMessage = exception.getMessage();
		System.out.println(receivedMessage);
		assertTrue(expectedMessage.equals(receivedMessage));

	}

	// Password Pattern check
	@Test
	public void testUserWithPasswordInValidPattern() {

		UserService userService = new UserService();
		User newUser = new User();
		newUser.setEmail("inba@gmail.com");
		newUser.setName("Akil");
		newUser.setPassword("inba1234");

		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.createUser(newUser);

		});
		String expectedMessage = "Password does not match the Pattern";
		String receivedMessage = exception.getMessage();
		System.out.println(receivedMessage);
		assertTrue(expectedMessage.equals(receivedMessage));

	}

}