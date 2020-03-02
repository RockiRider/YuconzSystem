package authApp.PD;

import java.sql.*;

import javax.swing.JOptionPane;

public class GetDetails {
	
	private Connection myDb = null;
	
	
	public GetDetails() {
		
	}
	/**
	* Method to connect DB
	* @return Database
	*/
	public Connection connectToDb() {
		try {
			 // load the SQLite-JDBC driver using the current class loader
		      Class.forName("org.sqlite.JDBC");
		      myDb = DriverManager.getConnection("jdbc:sqlite:Auth.db");
		      
		      Statement statement = myDb.createStatement();
		      statement.setQueryTimeout(30);  // set timeout to 30 seconds.
		      return myDb;
		}catch(Exception e){
			
			JOptionPane.showMessageDialog(null,
	    		    "Cannot Connect to DB",
	    		    "Error",
	    		    JOptionPane.ERROR_MESSAGE);
			
			return null;
		}
	}
	/**
	 * Checks if Personal Details Exists for this User
	 * @return Boolean
	 */
	public boolean checkDb(int userId) {
		
		return false;
	}
	public void loadDetails() {
		
	}
	public void errorMsg() {
		
	}
}
