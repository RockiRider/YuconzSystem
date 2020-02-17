package authApp;

import java.awt.EventQueue;

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
	
    public void logIn(String uName, String pwd) {
    	//User session = new User();
    	
    }
    public void logOut() {
    	session = null;
    }

}
