package in.fssa.mynotes.service;



import in.fssa.mynotes.dao.UserDAO;
import in.fssa.mynotes.exception.PersistanceException;
import in.fssa.mynotes.exception.ServiceException;
import in.fssa.mynotes.exception.ValidationException;
import in.fssa.mynotes.model.User;
import in.fssa.mynotes.validator.UserValidator;

public class UserService {

	public void create(User newUser) throws ValidationException, ServiceException {

		try {
			UserValidator.validate(newUser);
			UserDAO userDao = new UserDAO();
			userDao.create(newUser);
		} catch (PersistenceException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public void update(int id, User updateUser) throws ValidationException, ServiceException {

		try {
			UserValidator.validate(updateUser);
			UserValidator.isIdValid(id);
			UserDAO newUserDao = new UserDAO();
			newUserDao.update(id, updateUser);
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiceException("Failed to " + e.getMessage());
		}
	}

	
}