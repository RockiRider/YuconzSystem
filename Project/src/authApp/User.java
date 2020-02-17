package authApp;

/*
 * This is essentially a session class for the User
 */
public class User {

	private String firstName;
	private String lastName;
	private String role;
	private boolean higherAccess;
	
	public User(String fName, String lName, String tempRole, boolean access) {
		
		firstName = fName;
		lastName = lName;
		role = tempRole;
		higherAccess = access;
	}
}
