package in.fssa.mynotes.service;

import java.util.Set; 

import in.fssa.mynotes.dao.UserDAO;
import in.fssa.mynotes.exception.PersistanceException;
import in.fssa.mynotes.exception.ServiceException;
import in.fssa.mynotes.exception.ValidationException;
import in.fssa.mynotes.model.User;
import in.fssa.mynotes.validator.UserValidator;

public class UserService {
	
	/**
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public Set<User> getAllUsers() throws ServiceException {
		UserDAO userDao = new UserDAO();
		Set<User> userList = null;
		try {
			userList = userDao.findAll();
			
		} catch (PersistanceException e) {
			System.out.println(e);
			throw new ServiceException(e.getMessage());
		}
		return userList;
	}
	
	/**
	 * 
	 * @param userId
	 * @return
	 * @throws ValidationException
	 * @throws ServiceException
	 */
	
	public User findById(int userId) throws ValidationException, ServiceException {
		
		User user = null;
		try {
			UserValidator.isIdValid(userId);
			UserDAO userDao = new UserDAO();
			user = userDao.findById(userId);
			
		} catch (PersistanceException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
		return user;
	}
	

	public void create(User newUser) throws ValidationException, ServiceException {

		try {
			UserValidator.validate(newUser);
			UserDAO userDao = new UserDAO();
			userDao.create(newUser);
		} catch (PersistanceException e) {
			System.out.println(e);
			throw new ServiceException(e.getMessage());
		}
	}

	public void update(int id, User updateUser) throws ValidationException, ServiceException {

		try {
			UserValidator.validate(updateUser);
			UserValidator.isIdValid(id);
			UserDAO newUserDao = new UserDAO();
			newUserDao.update(id, updateUser);
			
		} catch (PersistanceException e) {
			e.printStackTrace();
			throw new ServiceException("Failed to " + e.getMessage());
		}
	}

	
}