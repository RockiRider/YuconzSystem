package authApp;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

import authApp.PD.*;
import authApp.Search.*;

/**
This is the App Controller, essentially the main class for the Application that brings everything together.
*The frames are created from here, and the main method is here as well.
*/
public class AppController {

	//private User session;
	private static LoginDisplay loginFrame;
	private static MainDisplay mainFrame;
	private static MyPdFrame myPdFrame;
	private static AllDetails detailsLookUp;
	private static UsersDisplay searchFrame;
	private static UserOverview userInfo;
	private static Db connection;
	private static PdCreateFrame createPersonalDetails;
	
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
    	main(null);
    	removeMain();
    }
    /**
     * Generates Personal Details Frame and Populates it
     * @param id
     */
    public static void generatePd(int id) {
    	
    	mainFrame.hide();
    	detailsLookUp = new AllDetails(id);
    	if(detailsLookUp.checkDb(id)) {
    		detailsLookUp.pullDetails(id);
    		myPdFrame = new MyPdFrame(id);
    	}else{
    		JOptionPane.showMessageDialog(null,
        		    "Your Personal Details have not yet been created by the HR Team",
        		    "Error",
        		    JOptionPane.ERROR_MESSAGE);
    		showMain();
    	}
    }
    /**
     * Creates a Frame that shows all Current Employees.
     */
    public static void showLookUp() {
    	connection = new Db();
    	searchFrame = new UsersDisplay(connection.getEmployees());
    }
    
    /**
     * Creates a Frame for the selected user.
     * @param id
     */
    public static void selectedDetails(String id) {
    	int input = Integer.parseInt(id);
    	connection.findUser(input);
    	
    	if(connection.matchPersonalDetails(input)) {
    		userInfo = new UserOverview(true,input);
    	}else {
    		userInfo = new UserOverview(false,input);
    	}
    	
    }
    
    public static void createDetails(int id) {
    	connection.creatingPd();
    	createPersonalDetails = new PdCreateFrame(id);
    }
    
    public static void viewDetails(int id) {
    	
    }
    
    public static void insertMyDetails(int id) {
    	connection.insertNew(id);
    }
    public static void saveMyDetails(int id) {
    	detailsLookUp.pushDetails(id);
    }
    public static void showMain() {
    	mainFrame.show();
    }
    public static void showTable() {
    	searchFrame.show();
    }
    public static void showUserDisplay() {
    	userInfo.show();
    }
    public static void removeMain() {
    	mainFrame.die();
    }
    public static void removeMyPd() {
    	myPdFrame.die();
    }
    
}
