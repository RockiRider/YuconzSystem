package authApp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
This is the App Controller, essentially the main class for the app that brings everything together.
*/
public class AppController {

	private User session;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginDisplay window = new LoginDisplay();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public AppController() {
		
	}
	
    public static void logIn(String uName, String pwd) {
    	Auth auth = new Auth();
    	if(auth.checkValidUser(uName, pwd)) {
    		try {
				MainDisplay newWindow = new MainDisplay();
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else {
    		//custom title, error icon
    		
    		JOptionPane.showMessageDialog(null,
    		    "Username or Password is incorrect.",
    		    "Error",
    		    JOptionPane.ERROR_MESSAGE);
    	}
    	
    }
    public static void logOut() {
    	//session = null;
    	System. exit(0);
    }

}
