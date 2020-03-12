package authApp.Search;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

import authApp.User;
import authApp.Roles.Director;
import authApp.Roles.Employee;
import authApp.Roles.HRDirector;
import authApp.Roles.HREmployee;
import authApp.Roles.Manager;
import authApp.Roles.Reviewer;

public class Db {

	private static User selectedUser;
	private Connection myDb = null;
	private ArrayList<ArrayList <String>> result = new ArrayList<ArrayList<String>>();
	private String[][] data;
	
	public Db() {
		connectToDb();
		populateAllEmployees();
		convertData();
	}
	
	/**
	 * Connects to the Database
	 * @return myDb
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
	 * Gets all Employees inside the Employee Table in the Database and places the Data inside ArrayLists.
	 */
	public void populateAllEmployees() {
		
		String sql = "select id,fName,sName,role from Employees";
		
		connectToDb();
		try(Connection conn = myDb;
				Statement stmt = conn.createStatement();
				ResultSet rs  = stmt.executeQuery(sql)){
				
			int columnCount = rs.getMetaData().getColumnCount();
			while(rs.next())
			{
			    ArrayList<String> row = new  ArrayList<String>();
			    for (int i=0; i <columnCount ; i++)
			    {
			       row.add( rs.getString(i + 1));
			    }
			    result.add(row);
			}
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null,
	    		    "Cannot connect to the Database",
	    		    "Error",
	    		    JOptionPane.ERROR_MESSAGE);
		}
	}
	/**
	 * Converts ArrayLists into a 2D Array, that can be used by the JTable.
	 */
	public void convertData(){
		data = result.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);
	}
	public void findUser(int id) {
		
		String sql = "select * from Employees where id='"+id+"'";
		connectToDb();
		try(Connection conn = myDb;
				Statement stmt = conn.createStatement();
				ResultSet rs  = stmt.executeQuery(sql)){
			
				String foundRole =  rs.getString("role");
				selectedUser = new User(rs.getString("fName"), rs.getString("sName"), foundRole, false);
		}catch(SQLException e){
			
		}
	}
	
	/**
	 * Get Method for the 2D Array
	 * @return data
	 */
	public String[][] getEmployees() {
		return data;
	}
	public static User getSelectedUser() {
		return selectedUser;
	}
	
}
