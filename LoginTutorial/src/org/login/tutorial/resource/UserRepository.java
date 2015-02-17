package org.login.tutorial.resource;

import java.util.ArrayList;
import java.util.List;

/**
 * UserRepository : This class is used for generating the some test user data for testing purpose.
 * Implemented Singleton Design pattern for making only one object of this class at time. It will
 * help to make data consist. 
 * @author Ravi Raj
 *
 */
public class UserRepository {
	
	private static volatile UserRepository instance = null;
	
	private List<UserDetailsDTO> userCollection = new ArrayList<UserDetailsDTO>();
	 
    // private constructor
    private UserRepository() {
    	userCollection = new ArrayList<UserDetailsDTO>();
		UserDetailsDTO userDetails1 = new UserDetailsDTO("Ravi Raj", "ravi.raj", "ravi@gmail.com","password");
		userCollection.add(userDetails1);
		UserDetailsDTO userDetails2 = new UserDetailsDTO("Pranav Jha", "pranav", "pranav@gmail.com","password");
		userCollection.add(userDetails2);
		UserDetailsDTO userDetails3 = new UserDetailsDTO("Sumit Raj", "sumit", "sumit@gmail.com","password");
		userCollection.add(userDetails3);
		UserDetailsDTO userDetails4 = new UserDetailsDTO("Deepak Raj", "deepak", "deepak@gmail.com","password");
		userCollection.add(userDetails4);
    }
 
    /**
     * Factory method for getting singleton object of this class
     * @return
     */
    public static UserRepository getInstance() {
        if (instance == null) {
            synchronized (UserRepository.class) {
                // Double check
                if (instance == null) {
                    instance = new UserRepository();
                }
            }
        }
        return instance;
    }
    

    /**
     * Method for returning the list of user details object.
     * @return List<UserDetailsDTO> userCollection
     */
	public List<UserDetailsDTO> getUserCollection() {
		return userCollection;
	}

	/**
	 * Private setter method for making data consist.
	 * @param userCollection
	 */
	private void setUserCollection(List<UserDetailsDTO> userCollection) {
		this.userCollection = userCollection;
	}

}
