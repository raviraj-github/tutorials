package org.login.tutorials.DAO;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import org.login.tutorial.resource.UserDetailsDTO;
import org.login.tutorial.resource.UserRepository;
import org.login.tutorials.servlets.UserRegistrationServlet;

/**
 * UserDAO : For accessing data from database or repository.
 * @author Ravi Raj
 *
 */
public class UserDAO {
	
	private List<UserDetailsDTO>  userCollection= null;
	private final static Logger LOGGER = Logger.getLogger(UserRegistrationServlet.class.getName()); 
	
	public UserDAO() {
		UserRepository repository = UserRepository.getInstance();
		userCollection = repository.getUserCollection();
	}
	
	/**
	 * Method for getting the userCollection
	 * @return List<UserDetailsDTO>
	 */
	public List<UserDetailsDTO> getUserCollection() {
		return userCollection;
	}
	
	/**
	 * Method for adding user into collection or database.
	 * @param name
	 * @param userId
	 * @param email
	 * @param password
	 * @return boolean
	 */
	public boolean addUser(String name, String userId, String email, String password) {
		
		UserDetailsDTO userDetailsDTO = new UserDetailsDTO(name, userId, email, password);
		if(isUserExist(userId)) {
			LOGGER.info("Username already in use: " + userId);
			return false;
		}
		if(userCollection.add(userDetailsDTO)) {
			LOGGER.info("User("+userId+") added sucessfully");
			return true;
		}
		return false;
	}
	
	/**
	 * Method for validating the user in DB or collection.
	 * If user exist in DB or collection then return UserDetails object 
	 * otherwise return null.
	 * @param userName
	 * @param password
	 * @return UserDetailsDTO
	 */
	public UserDetailsDTO validateLogin(String userName, String password) {

		UserDetailsDTO user = getUserDetails(userName);

		if (user == null) {
			System.out.println("User not in database");
			return null;
		}

		if (user.getUserName().equalsIgnoreCase(userName) && user.getPassword().equals(password)) {
			return user;
		} else {
			return null;
		}
	}
	
	/**
	 * Method for getting single user details on the basis of user name.
	 * If user exist in DB or collection then return UserDetails object 
	 * otherwise return null
	 * @param userName
	 * @return UserDetailsDTO
	 */
	public UserDetailsDTO getUserDetails(String userName) {

		if (userName == null) {
			return null;
		}

		Iterator<UserDetailsDTO> iterator = userCollection.iterator();

		while (iterator.hasNext()) {
			UserDetailsDTO userDetailsDTO = (UserDetailsDTO) iterator.next();

			if (userName.equalsIgnoreCase(userDetailsDTO.getUserName())) {
				return userDetailsDTO;
			}
		}

		return null;
	}
	
	/**
	 * Method for validating the user is exist in DB or not.
	 * @param userName
	 * @return boolean
	 */
	public boolean isUserExist(String userName) {
		
		UserDetailsDTO userDetailsDTO = getUserDetails(userName);
		if(userDetailsDTO != null) 
			return true;
		else 
			return false;
	}

}
