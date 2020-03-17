package authApp.Roles;
import authApp.User;

public class HRDirector extends User {

	public HRDirector(String fName, String lName,int id) {
		super(fName, lName, "HR Director", true,id);
	}

}
