package authApp;

public class Auth {
	
	private boolean connected;
	
	public Auth(String uName, String pwd) {
		connectToDb();
		checkValidUser(uName,pwd);
	}
	
	private void connectToDb() {
		//try & catch 
		connected = false;
	}
	public boolean checkValidUser(String uName, String pwd) {
		//if connected = true;
		if(uName == "Miles" && pwd == "123") {
			return true;
		}
		return false;
	}
	/* 
	 * Maybe need a sessions method or getUser Data method
	 */
	public boolean getConnected() {
		return connected;
	}
	
}
