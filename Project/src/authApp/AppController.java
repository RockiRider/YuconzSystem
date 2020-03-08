package authApp;

import java.awt.EventQueue;
import javax.swing.JOptionPane;

import authApp.PD.*;

/**
This is the App Controller, essentially the main class for the Application that brings everything together.
*The frames are created from here, and the main method is here as well.
*/
public class AppController {

	//private User session;
	private static LoginDisplay loginFrame;
	private static MainDisplay mainFrame;
	private static MyPdWindow myPdFrame;
	private static GetDetails myDetails;
	
	/**
	* Launch the application.
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 loginFrame = new LoginDisplay();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Authorises the login and checks if the user is valid and in the database
	 * @param uName username
	 * @param pwd password
	 */

    public static void logIn(String uName, String pwd) {
    	Auth auth = new Auth();
    	if(auth.checkValidUser(uName, pwd)) {
    		try {
    			auth.logAttempt(uName, pwd, true);
    			AppController.loginFrame.remove();
    			mainFrame = new MainDisplay();
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else {
    		auth.logAttempt(uName, pwd, false);
    		JOptionPane.showMessageDialog(null,
    		    "Username or Password is incorrect.",
    		    "Warning",
    		    JOptionPane.WARNING_MESSAGE);
    	}
    }
    /**
     * Logs out the User and closes the System
     */
    public static void logOut() {
    	System. exit(0);
    }
    /**
     * Generates Personal Details Frame and Populates it
     * @param id
     */
    public static void generatePd(int id) {
    	
    	mainFrame.hide();
    	myDetails = new GetDetails(id);
    	myPdFrame = new MyPdWindow(id);
    }
    public static void showMain() {
    	mainFrame.show();
    }


   
    
}
