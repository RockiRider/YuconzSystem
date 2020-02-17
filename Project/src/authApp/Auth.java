package authApp;

import java.sql.*;

import javax.swing.JOptionPane;

public class Auth {
	
	private Connection myDb = null;
	
	public Auth() {
		connectToDb();
	}
	
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

	public boolean checkValidUser(String uName, String pwd) {
		//if connected = true;
		if(uName.contentEquals("Miles") && pwd.contentEquals("123")) {
			return true;
		}
		return false;
	}
	/* 
	 * Maybe need a sessions method or getUser Data method
	 */
	
}
