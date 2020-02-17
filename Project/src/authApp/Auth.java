package authApp;

import java.sql.*;

import javax.swing.JOptionPane;

public class Auth {
	
	private Connection myDb = null;
	private static User currentUser;
	
	public Auth() {
		connectToDb();
	}
	/*
	 * Connect to the Database
	 */
	public Connection connectToDb() {
		//try & catch 
		//connected = false;
		try {
			 // load the sqlite-JDBC driver using the current class loader
		      Class.forName("org.sqlite.JDBC");
		      myDb = DriverManager.getConnection("jdbc:sqlite:Auth.db");
		      
		      Statement statement = myDb.createStatement();
		      statement.setQueryTimeout(30);  // set timeout to 30 sec.
		     
		      return myDb;
		}catch(Exception e){
			
			JOptionPane.showMessageDialog(null,
	    		    "Cannot Connect to DB",
	    		    "Error",
	    		    JOptionPane.ERROR_MESSAGE);
			
			return null;
		}
	}
	/* 
	* Checks if the user is inside the database or not
	*/
	public boolean checkValidUser(String uName, String pwd) {
		
		String sql = "select * from Employees where username='"+uName+"' and password='"+pwd+"'";
		
		try(Connection conn = myDb;
				Statement stmt = conn.createStatement();
				ResultSet rs  = stmt.executeQuery(sql)){
			
			if(rs.getString("username").contentEquals(uName) && rs.getString("password").contentEquals(pwd)) {
				
				String foundRole =  rs.getString("role");
				boolean access = false;
				
				//If Director or HR employee change access level
				if(foundRole.contentEquals("Director") || foundRole.contentEquals("HR Employee")){
					access = true;
				}
				
				currentUser = new User(rs.getString("fName"),rs.getString("sName"),foundRole,access);
				
				return true;
			}
			return false;
		}catch(SQLException e){
			
			JOptionPane.showMessageDialog(null,
	    		    "User Does Not Exist",
	    		    "Error",
	    		    JOptionPane.ERROR_MESSAGE);
			
			return false;
		}
	}

	//Getter method for Current User
	public static User getCurrentUser() {
		return currentUser;
	}
	
}
