package authApp.PD;

import java.sql.*;

import javax.swing.JOptionPane;

public class GetDetails {
	
	private Connection myDb = null;
	private static PdStore currentDetails;
	private String sql;
	
	public GetDetails(int id) {
		connectToDb();
		sql = "select * from PersonalDetails where id='"+id+"'";
		currentDetails = new PdStore();
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
		//String sql = "select * from PersonalDetails where id='"+userId+"'";
		System.out.println("checker runs");
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
	public void pushDetails(int userId) {
		System.out.println("Here");
		//String sql = "select * from PersonalDetails where id='"+userId+"'";
		System.out.println("Before Try");
		System.out.println(userId);
		try(Connection conn = myDb;
				
				Statement stmt = conn.createStatement();
				ResultSet rs  = stmt.executeQuery(sql)){
			System.out.println("Inside Try");
			int foundId = rs.getInt("id");
			System.out.println(foundId);
			if(foundId == userId) {
				// Get new details from database
				String firstName = rs.getString("sName");
				String lastName = rs.getString("fName");
				String dob = rs.getString("dob");
				String address1 = rs.getString("address1");
				String address2 = rs.getString("address2");
				String city = rs.getString("city");
				//String county = rs.getString("county");
				String postCode = rs.getString("postcode");
				String mobileNum = rs.getString("mobileNum");
				String telephoneNum = rs.getString("telephoneNum");
				String emergencyContact = rs.getString("emergencyContact");
				String emergencyNum = rs.getString("emergencyContactNum");
			
				System.out.println("here");
				// Set new Details
				currentDetails.setFirstName(firstName);
				currentDetails.setLastName(lastName);
				currentDetails.setDoB(dob);
				currentDetails.setAddress1(address1);
				currentDetails.setAddress2(address2);
				currentDetails.setCity(city);
				//detailStorage.setCounty(county);
				currentDetails.setPostcode(postCode);
				currentDetails.setMobile(mobileNum);
				currentDetails.setTelenum(telephoneNum);
				currentDetails.setEmergencyContact(emergencyContact);
				currentDetails.setEmergencyNum(emergencyNum);
			}else {
				JOptionPane.showMessageDialog(null,
		    		    "Connection Made but User not found!",
		    		    "Error-User Not Found",
		    		    JOptionPane.ERROR_MESSAGE);
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null,
	    		    "Cannot Fetch Your Details!",
	    		    "Error",
	    		    JOptionPane.ERROR_MESSAGE);
		}
		
		
		
	}
	
	public static PdStore getMyCurrentDetails() {
		return currentDetails;
	}
}
