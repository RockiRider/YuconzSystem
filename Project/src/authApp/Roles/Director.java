package authApp.Roles;

import authApp.User;

/**
 * Child class of the User, which dictates the User is a Director
 */
public class Director extends User{

	public Director(String fName, String lName,int id) {
		super(fName, lName, "Director", false,id);
	}
}
