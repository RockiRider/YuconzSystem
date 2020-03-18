package authApp.Roles;

import authApp.User;

/**
 * Child class of the User, which dictates the User is a Manager
 */
public class Manager extends User {

	public Manager(String fName, String lName,int id) {
		super(fName, lName, "Manager", false,id);
		// TODO Auto-generated constructor stub
	}

}
