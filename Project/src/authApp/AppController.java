package authApp;

import java.awt.EventQueue;
import javax.swing.JOptionPane;

/**
This is the App Controller, essentially the main class for the Application that brings everything together.
*
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
					LoginDisplay loginFrame = new LoginDisplay();
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
				MainDisplay mainFrame = new MainDisplay();
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else {
    		JOptionPane.showMessageDialog(null,
    		    "Username or Password is incorrect.",
    		    "Error",
    		    JOptionPane.ERROR_MESSAGE);
    	}
    	
    }
    public static void logOut() {
    	System. exit(0);
    }

}
