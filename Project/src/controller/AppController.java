package controller;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;


import authApp.*;
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
	private static PDFrame viewPersonalDetails;
	
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
    			auth.logAuth();
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
    	if(searchFrame != null) {
    		searchFrame.die();
    	}
    	if(userInfo != null) {
    		userInfo.die();
    	}
    	if(createPersonalDetails != null) {
    		createPersonalDetails.die();
    	}
    	if(viewPersonalDetails != null) {
    		viewPersonalDetails.die();
    	}
    }
    /**
     * Generates Personal Details Frame and Populates it
     * @param id
     */
    public static void generatePd() {
    	
    	mainFrame.hide();
    	detailsLookUp = new AllDetails();
    	if(detailsLookUp.checkDb()) {
    		detailsLookUp.pullDetails();
    		myPdFrame = new MyPdFrame();
    	}else{
    		JOptionPane.showMessageDialog(null,
        		    "Your Personal Details have not yet been created by the HR Team",
        		    "Error",
        		    JOptionPane.ERROR_MESSAGE);
    		showMain();
    	}
    }
    /**
     * Creates a Frame that shows all Current Employees in a table.
     */
    public static void showLookUp() {
    	connection = new Db();
    	searchFrame = new UsersDisplay(connection.getEmployees());
    }
    
    /**
     * Creates a Frame for the selected user, that gives an overview of the selected User and actions that can be taken.
     * @param id
     */
    public static void selectedDetails() {
    	//int id = connection.getSelectedUser().getId();
    	connection.findUser();
    	
    	if(connection.matchPersonalDetails()) {
    		userInfo = new UserOverview(true);
    	}else {
    		userInfo = new UserOverview(false);
    	}
    	
    }
    
    /**
     * Creates a Frame that allows allows User to create Personal Details for another Employee
     * @param id
     */
    public static void createDetails() {
    	connection.creatingPd();
    	createPersonalDetails = new PdCreateFrame();
    }
    
    /**
     * Creates a Frame that allows user to view other Employees Personal Details
     * @param id
     */
    public static void viewDetails() {
    	connection.pullDetails();
    	viewPersonalDetails = new PDFrame();
    }
    
    /**
     * Inserts new entry into PersonalDetails Table, by calling the method that handles that.
     * @param id
     */
    public static void insertMyDetails() {
    	connection.insertNew();
    }
    
    /**
     * Updates the current users PersonalDetails in the Database, by calling the method that handles that.
     * @param id
     */
    public static void saveMyDetails() {
    	detailsLookUp.pushDetails();
    }
    /**
     * Updates selected Employees Personal Details, by calling the method that handles that.
     * @param id
     */
    public static void saveTheirDetails() {
    	connection.pushDetails();
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
