package in.fssa.mynotes.service;

import java.util.Set; 

import in.fssa.mynotes.dao.UserDAO;
import in.fssa.mynotes.exception.PersistanceException;
import in.fssa.mynotes.exception.ServiceException;
import in.fssa.mynotes.exception.ValidationException;
import in.fssa.mynotes.model.User;
import in.fssa.mynotes.validator.UserValidator;

public class UserService {
	

	public void createUser(User newUser) throws ValidationException, ServiceException {

		try {
			UserValidator.validate(newUser);
			UserDAO userDAO = new UserDAO();
			userDAO.create(newUser);
		} catch (PersistanceException e) {
			System.out.println(e);
			throw new ServiceException(e.getMessage());
		}
	}

	public void updateUser(int id, User updateUser) throws ValidationException, ServiceException {

		try {
			UserValidator.validate(updateUser);
			UserValidator.isIdValid(id);
			UserDAO newUserDAO = new UserDAO();
			newUserDAO.update(id, updateUser);
			
		} catch (PersistanceException e) {
			e.printStackTrace();
			throw new ServiceException("Failed to " + e.getMessage());
		}
	}

	
}