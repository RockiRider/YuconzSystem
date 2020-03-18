package authApp.Roles;

import authApp.User;

/**
 * Child class of the User, which dictates the User is a Reviewer.
 */
public class Reviewer extends User{

	public Reviewer(String fName, String lName,int id) {
		super(fName, lName, "Reviewer", false,id);
		// TODO Auto-generated constructor stub
	}

}
