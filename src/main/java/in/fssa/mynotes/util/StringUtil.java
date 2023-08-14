package in.fssa.mynotes.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import in.fssa.mynotes.exception.ValidationException;

public class StringUtil {

	public static void rejectIfInvaildString(String input, String inputName) throws ValidationException {
		if (input == null || "".equals(input.trim())) {
			throw new ValidationException(inputName.concat(" cannot be null or empty"));
		}
	}

	public static boolean isValid(String input) {
		if (input == null || "".equals(input.trim())) {
			return false;
		}
		return true;
	}

	public static boolean isInValid(String input) {
		if (input == null || "".equals(input.trim())) {
			return true;
		}
		return false;
	}
	
	public static void rejectIfInvalidId(int id, String inputName) throws ValidationException {
		if(id <= 0) {
			throw new ValidationException(inputName.concat(" cannot be zero or below zero"));
		}
	}

	public static void rejectIfInvalidNumber(long number, String inputNumber) throws ValidationException {
		if (number < 6000000001l || number > 9999999999l) {
			throw new ValidationException(inputNumber.concat(" must start between 6 - 9 and have 10 digits"));
		}
	}
	
	public static void rejectIfInvalidEmail(String email) throws ValidationException {
		
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";  
		Pattern pattern = Pattern.compile(regex);  
		Matcher matcher = pattern.matcher(email);  
		if(matcher.matches() == false) {
			throw new ValidationException("Invalid Email Id");
		}
	}
		
	public static void rejectIfInvalidPassword(String password) throws ValidationException {
		
		String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$";
		Pattern patter = Pattern.compile(regex);
		Matcher matcher = patter.matcher(password);
		if(matcher.matches() == false) {
			throw new ValidationException("Password does not match the requested pattern");
		}
	}
}