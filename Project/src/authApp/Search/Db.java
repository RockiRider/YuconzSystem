package authApp.Search;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import authApp.User;
import authApp.PD.PdStore;


public class Db {

	private static User selectedUser;
	private Connection myDb = null;
	private ArrayList<ArrayList <String>> result = new ArrayList<ArrayList<String>>();
	private String[][] data;
	private static PdStore selectedUserDetails;
	
	public Db() {
		connectToDb();
		populateAllEmployees();
		convertData();
		selectedUserDetails = new PdStore();
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
	
	
	/**
	 * Finds the data matching the id, inside the Employees table 
	 * @param id
	 */
	public void findUser(int id) {
		
		String sql = "select * from Employees where id='"+id+"'";
		connectToDb();
		try(Connection conn = myDb;
				Statement stmt = conn.createStatement();
				ResultSet rs  = stmt.executeQuery(sql)){
			
				String foundRole =  rs.getString("role");
				selectedUser = new User(rs.getString("fName"), rs.getString("sName"), foundRole, false);
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null,
	    		    "Cannot connect to the Database",
	    		    "Error",
	    		    JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Checks PersonalDetails Table in the Database, to see if there is an entry matching the userId.
	 * @param userId
	 * @return boolean
	 */
	public boolean matchPersonalDetails(int userId) {
		
		String sql = "select id from PersonalDetails where id='"+userId+"'";
		connectToDb();
		try(Connection conn = myDb;
			Statement stmt = conn.createStatement();
			ResultSet rs  = stmt.executeQuery(sql)){
				if(rs.getInt("id") == userId) {
					
					rs.close();
					myDb.close();
					return true;
				}
		}catch(SQLException e){
			
			return false;
		}
		return false;
	}
	
	/**
	 * Sets user with no Personal Details document with empty fields in the selectedUserDetails object.
	 */
	public void creatingPd() {
		selectedUserDetails.setFirstName(" ");
		selectedUserDetails.setLastName(" ");
		selectedUserDetails.setDoB(" ");
		selectedUserDetails.setAddress1(" ");
		selectedUserDetails.setAddress2(" ");
		selectedUserDetails.setCity(" ");
		selectedUserDetails.setCounty(" ");
		selectedUserDetails.setPostcode(" ");
		selectedUserDetails.setMobile(" ");
		selectedUserDetails.setTelenum(" ");
		selectedUserDetails.setEmergencyNum(" ");
		selectedUserDetails.setEmergencyContact(" ");
	}
	public void insertNew(int id) {
		connectToDb();
		String sql = "INSERT INTO PersonalDetails(id,sName,fName,dob,address1,address2,city,county,postcode,telephoneNum,mobileNum,emergencyContact,emergencyContactNum) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try(Connection conn = myDb;
                PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setInt(1,id);
			pstmt.setString(2, selectedUserDetails.getLastName());
            pstmt.setString(3, selectedUserDetails.getFirstName());
            pstmt.setString(4, selectedUserDetails.getDoB());
            pstmt.setString(5, selectedUserDetails.getAddress1());
            pstmt.setString(6, selectedUserDetails.getAddress2());
            pstmt.setString(7, selectedUserDetails.getCity());
            pstmt.setString(8, selectedUserDetails.getCounty());
            pstmt.setString(9, selectedUserDetails.getPostcode());
            pstmt.setString(10, selectedUserDetails.getTelenum());
            pstmt.setString(11, selectedUserDetails.getMobile());
            pstmt.setString(12, selectedUserDetails.getEmergencyContact());
            pstmt.setString(13, selectedUserDetails.getEmergencyNum());
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null,
	    		    "Cannot connect to the Database",
	    		    "Error",
	    		    JOptionPane.ERROR_MESSAGE);
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
	public static PdStore getSelectedUserDetails() {
		return selectedUserDetails;
	}
	
}
