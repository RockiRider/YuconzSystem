package authApp.PD;

import java.sql.*;

import javax.swing.JOptionPane;

public class GetDetails {
	
	private Connection myDb = null;
	
	
	public GetDetails() {
		connectToDb();
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
		String sql = "select * from PersonalDetails where id='"+userId+"'";
		
		try(Connection conn = myDb;
				Statement stmt = conn.createStatement();
				ResultSet rs  = stmt.executeQuery(sql)){
		if(rs.getInt("id") == userId) {
			return true;
		}
		}catch(SQLException e){
			return false;
		}
		return false;
	}
	/**
	 * Loads the Details?
	 */
	public void loadDetails() {
		
	}
	/**
	 * Generates a Msg saying MyPersonal Details has not been created yet
	 */
	public void errorMsg() {
		
	}
}
