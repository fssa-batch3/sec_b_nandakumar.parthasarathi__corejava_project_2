package in.fssa.mynotes.service;


import in.fssa.mynotes.dao.UserDAO;
import in.fssa.mynotes.exception.PersistanceException;
import in.fssa.mynotes.exception.ServiceException;
import in.fssa.mynotes.exception.ValidationException;
import in.fssa.mynotes.model.User;
import in.fssa.mynotes.util.StringUtil;
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
	

    public void loginUser(String email, String password) throws ValidationException, ServiceException {

        try {
            StringUtil.rejectIfInvaildString(email, "Email");
            
            StringUtil.rejectIfInvaildString(password, "Password");

            UserDAO userDao = new UserDAO();
            userDao.checkUserCredentials(email, password);

        } catch (PersistanceException e) {
            throw new ServiceException(e.getMessage());
        }
    }
    
    public User findUserByEmail(String email) throws PersistanceException {
    	
    	User user = new User();
    	
        // You can add additional validation or processing logic here if needed
        try {
			UserDAO userDAO = new UserDAO();
			user = userDAO.findUserByEmail(email);
		} catch (PersistanceException e) {
			e.printStackTrace();
		}
        return user;
    }

	
}