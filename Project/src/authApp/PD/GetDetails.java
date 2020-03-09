package authApp.PD;

import java.sql.*;

import javax.swing.JOptionPane;

public class GetDetails {
	
	private Connection myDb = null;
	private static MyPdStore myCurrentDetails;
	
	public GetDetails(int id) {
		connectToDb();
		myCurrentDetails = new MyPdStore();
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
		
		String sql = "select id from PersonalDetails where id='"+userId+"'";
		
		try(Connection conn = myDb;
			Statement stmt = conn.createStatement();
			ResultSet rs  = stmt.executeQuery(sql)){
				if(rs.getInt("id") == userId) {
					rs.close();
					myDb.close();
					return true;
				}
		}catch(SQLException e){
			
			myDb = null;
		}
		return false;
	}
	
	/**
	* Loads the Details?
	*/
	public void pushDetails(int userId) {
		String sql = "select * from PersonalDetails where id='"+userId+"'";
		
		connectToDb();
		
		try(Connection conn = myDb;
			Statement stmt = conn.createStatement();
			ResultSet rs  = stmt.executeQuery(sql)){
			
				int foundId = rs.getInt("id");
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
			
				
					// Set new Details
					myCurrentDetails.setFirstName(firstName);
					myCurrentDetails.setLastName(lastName);
					myCurrentDetails.setDoB(dob);
					myCurrentDetails.setAddress1(address1);
					myCurrentDetails.setAddress2(address2);
					myCurrentDetails.setCity(city);
					//detailStorage.setCounty(county);
					myCurrentDetails.setPostcode(postCode);
					myCurrentDetails.setMobile(mobileNum);
					myCurrentDetails.setTelenum(telephoneNum);
					myCurrentDetails.setEmergencyContact(emergencyContact);
					myCurrentDetails.setEmergencyNum(emergencyNum);
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
	
	public static MyPdStore getMyCurrentDetails() {
		return myCurrentDetails;
	}
}
