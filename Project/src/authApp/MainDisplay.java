package authApp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainDisplay {

	private JFrame frmYuconzSystem;
	private AppController app;


	/**
	* Create the Frame.
	*/
	public MainDisplay() {
		initialize();
	}

	/**
	* Initialise the contents of the frame.
	*/
	private void initialize() {
		frmYuconzSystem = new JFrame();
		frmYuconzSystem.setTitle("Yuconz System");
		frmYuconzSystem.setVisible(true);
		frmYuconzSystem.setIconImage(Toolkit.getDefaultToolkit().getImage(MainDisplay.class.getResource("/authApp/img/LogoNoText.png")));
		frmYuconzSystem.setBounds(100, 100, 450, 300);
		frmYuconzSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmYuconzSystem.getContentPane().setLayout(null);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.logOut();
			}
		});
		btnLogout.setBounds(174, 174, 89, 23);
		frmYuconzSystem.getContentPane().add(btnLogout);
		
		//Get USER INFO
		
		String fName = Auth.getCurrentUser().getFirstName();
		String sName = Auth.getCurrentUser().getLastName();
		String role = Auth.getCurrentUser().getRole();
		boolean accessLevel = Auth.getCurrentUser().getAccess();
		String accessLvl = "Normal";
		if (accessLevel) {
			accessLvl = "High";
		}
		
		JLabel lblWelcome = new JLabel("Welcome "+fName+" "+sName);
		lblWelcome.setBounds(142, 62, 186, 23);
		frmYuconzSystem.getContentPane().add(lblWelcome);
		
		JLabel lblRole = new JLabel("Role: "+role);
		lblRole.setBounds(269, 11, 157, 14);
		frmYuconzSystem.getContentPane().add(lblRole);
		
		JLabel lblAccessLevel = new JLabel("Access Level: "+accessLvl);
		lblAccessLevel.setBounds(215, 36, 211, 14);
		frmYuconzSystem.getContentPane().add(lblAccessLevel);
	}
}
