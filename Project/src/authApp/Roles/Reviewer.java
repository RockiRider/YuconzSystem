package authApp.Roles;

import authApp.User;

/**
 * Child class of the User, which dictates the User is a Reviewer.
 */
public class Reviewer extends User{

	public Reviewer(String fName, String lName) {
		super(fName, lName, "Reviewer", false);
		// TODO Auto-generated constructor stub
	}

}
