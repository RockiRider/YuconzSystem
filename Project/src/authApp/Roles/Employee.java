package authApp.Roles;

import authApp.User;

/**
 * Child class of the User, which dictates the User is a Employee
 */
public class Employee extends User{

	public Employee(String fName, String lName) {
		super(fName, lName, "Employee", false);
		// TODO Auto-generated constructor stub
	}

}
