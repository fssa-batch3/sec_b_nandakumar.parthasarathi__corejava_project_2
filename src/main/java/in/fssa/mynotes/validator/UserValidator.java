package in.fssa.mynotes.validator;

import java.util.regex.Pattern;

import in.fssa.mynotes.exception.ValidationException;
import in.fssa.mynotes.model.User;

public class UserValidator {
    
	private static final String NAME_PATTERN = "^[A-Za-z][A-Za-z\\s]*$";
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9]+([a-zA-Z0-9_+\\-\\. ]*[a-zA-Z0-9]+)?@[a-zA-Z0-9]+([a-zA-Z0-9\\-\\.]*[a-zA-Z0-9])?\\.[a-zA-Z]{2,}$";
    private static final String PASSWORD_PATTERN = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}";
    
    public static void validate(User user) throws ValidationException {
        if (user == null) {
            throw new ValidationException("User cannot be null");
        }
        
        if (user.getName() == null || user.getName().trim().isEmpty()) {
            throw new ValidationException("Name cannot be null or empty");
        }
        
        if (!Pattern.matches(NAME_PATTERN, user.getName())) {
            throw new ValidationException("Name should contains only alphabets");
        }

        if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
            throw new ValidationException("Email cannot be null or empty");
        }
        
        if (!Pattern.matches(EMAIL_PATTERN, user.getEmail())) {
            throw new ValidationException("Email does not match the Pattern");
        }

        if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
            throw new ValidationException("Password cannot be null or empty");
        }
        
        if (!Pattern.matches(PASSWORD_PATTERN, user.getPassword())) {
            throw new ValidationException("Password does not match the Pattern");
        }
    }
    
    public static void isIdValid(int userId) throws ValidationException {
        if (userId <= 0) {
            throw new ValidationException("Invalid user ID");
        }
    }
}
