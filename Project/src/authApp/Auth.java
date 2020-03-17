package authApp;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

import javax.swing.JOptionPane;

import authApp.Roles.*;
/**
 * This class ensures authentication. It connects to the SQL Lite Database and tries to find the user thats currently logging in. 
 * Depending on the user's role within the company then creates an object of the correct role for the user.
 * 
 * @author Tsotne
 *
 */
public class Auth {
	
	private Connection myDb = null;
	private static User currentUser;
	
	/**
	* Constructor Method for Auth, which automatically tries to connect to the DB.
	*/
	public Auth() {
		connectToDb();
	}
	/**
	 * Logs the successful and unsuccessful login attempts inside AuthorisationLogs.txt File.
	 * @param uName
	 * @param pwd
	 * @param success
	 */
	public void logAttempt(String uName, String pwd, boolean success) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime currentTime = LocalDateTime.now();
		String formatted = currentTime.format(dtf);
		String outcome = "Failed";
		if(success) {
			outcome = "Successful";
			
			try {
	            FileWriter writer = new FileWriter("AuthorisationLogs.txt", true);
	            writer.write("\r\n"+"--------------------------------------------------------------------"); 
	            writer.write("\r\n");
	            writer.write(outcome +"\t "+ uName +" \t "+ pwd +" \t "+ formatted);
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			
		}else {
			try {
	            FileWriter writer = new FileWriter("AuthorisationLogs.txt", true);
	            writer.write("\r\n"+"--------------------------------------------------------------------"); 
	            writer.write("\r\n");
	            writer.write(outcome +"\t \t "+ uName +" \t "+ pwd +" \t "+ formatted);
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
		
        
	}
	/**
	* Connect to the LOCAL Database
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
	* Checks if the user is inside the database or not. 
	* If the user exists, creates the correct currentUser object with the data provided in the Database
	* 
	*/
	public boolean checkValidUser(String uName, String pwd) {
		
		String sql = "select * from Employees where username='"+uName+"' and password='"+pwd+"'";
		
		try(Connection conn = myDb;
				Statement stmt = conn.createStatement();
				ResultSet rs  = stmt.executeQuery(sql)){
			
			if(rs.getString("username").contentEquals(uName) && rs.getString("password").contentEquals(pwd)) {
				
				String foundRole =  rs.getString("role");
				switch(foundRole) {
				case "Director":
					currentUser = new Director(rs.getString("fName"),rs.getString("sName"),rs.getInt("id"));
					break;
				case "HR Employee":
					currentUser = new HREmployee(rs.getString("fname"),rs.getString("sName"),rs.getInt("id"));
					break;
				case "HR Director":
					currentUser = new HRDirector(rs.getString("fname"),rs.getString("sName"),rs.getInt("id"));
					break;
				case "Manager":
					currentUser = new Manager(rs.getString("fname"),rs.getString("sName"),rs.getInt("id"));
					break;
				case "Reviewer":
					currentUser = new Reviewer(rs.getString("fname"),rs.getString("sName"),rs.getInt("id"));
					break;
				case "Employee":
					currentUser = new Employee(rs.getString("fname"),rs.getString("sName"),rs.getInt("id"));
					break;
				}
				return true;
			}
			return false;
		}catch(SQLException e){
			return false;
		}
	}

	/**
	 * Getter method for Current User
	 * @return
	 */
	public static User getCurrentUser() {
		return currentUser;
	}

}
