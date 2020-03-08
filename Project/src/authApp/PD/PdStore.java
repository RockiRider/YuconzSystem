package authApp.PD;

public class PdStore {
	private String sName;
	private String fName;
	private String dob;
	private String address1;
	private String address2;
	private String city;
	private String postcode;
	private String county;
	private String telenum;
	private String mobile;
	private String emergencyContact;
	private String emergencyNum;
	
	public PdStore() {
		//For Testing Purposes
		
		sName = "Tsot";
		fName = "Gvad";
		dob = "06/11/1997";
		address1 = "Pallamon";
		address2 = "Court";
		city = "London";
		postcode = "G6 7WA";
		county = "Kent";
		telenum = "08812381832";
		mobile = "07737844935";
		emergencyContact = "Aj";
		emergencyNum = "07769482183";
	}
	public String getFirstName() {
		return sName;
	}
	public String getLastName() {
		return fName;
	}
	public String getDoB() {
		return dob;
	}
	public String getAddress1() {
		return address1;
	}
	public String getAddress2() {
		return address2;
	}
	public String getCity() {
		return city;
	}
	public String getPostcode() {
		return postcode;
	}
	public String getCounty() {
		return emergencyNum;
	}
	public String getTelenum() {
		return telenum;
	}
	public String getMobile() {
		return mobile;
	}
	public String getEmergencyContact() {
		return emergencyContact;
	}
	public String getEmergencyNum() {
		return emergencyNum;
	}
	/**
	* Setters below
	*/
	public void setFirstName(String input) {
		sName = input;
	}
	public void setLastName(String input) {
		fName = input;
	}
	public void setDoB(String input) {
		 dob = input;
	}
	public void setAddress1(String input) {
		address1 = input;
	}
	public void setAddress2(String input) {
		 address2= input;
	}
	public void setCity(String input) {
		 city = input;
	}
	public void setPostcode(String input) {
		 postcode = input;
	}
	public void setCounty(String input) {
		 postcode = input;
	}
	public void setTelenum(String input) {
		 telenum = input;
	}
	public void setMobile(String input) {
		 mobile = input;
	}
	public void setEmergencyContact(String input) {
		 emergencyContact = input;
	}
	public void setEmergencyNum(String input) {
		 emergencyNum = input;
	}
}


