package in.fssa.mynotes.validator;


import in.fssa.mynotes.dao.UserDAO;
import in.fssa.mynotes.exception.PersistenceException;
import in.fssa.mynotes.exception.ValidationException;
import in.fssa.mynotes.model.User;
import in.fssa.mynotes.util.StringUtil;

public class UserValidator {

	public static void validate(User user) throws ValidationException {

		if (user == null) {
			throw new ValidationException("Invalid User Input");
		}

		StringUtil.rejectIfInvaildString(user.getEmail(), "Email");
		StringUtil.rejectIfInvaildString(user.getName(), "Name");
		StringUtil.rejectIfInvaildString(user.getPassword(), "Password");

		StringUtil.rejectIfInvalidEmail(user.getEmail());
		StringUtil.rejectIfInvalidPassword(user.getPassword());
	}

	public static void isIdValid(int id) throws ValidationException {
		
		try {
			StringUtil.rejectIfInvalidId(id, "User Id");
			UserDAO userDao = new UserDAO();
			userDao.checkIdExists(id);
		} catch (PersistanceException e) {
			e.printStackTrace();
			throw new ValidationException(e.getMessage());
		}
		
	}

}