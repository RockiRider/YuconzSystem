package authApp;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


/**
 * This class generates the GUI for the main display, which is generated after the user successfully logs in.
 */
public class MainDisplay {

	private JFrame frmYuconzSystem;


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
				AppController.logOut();
			}
		});
		btnLogout.setBounds(324, 216, 89, 23);
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
		
		JLabel lblName = new JLabel("<dynamic> <dynamic>");
		lblName.setText(fName + " "+ sName);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(0, 100, 436, 23);
		frmYuconzSystem.getContentPane().add(lblName);
		
		JLabel lblRole = new JLabel("Role: "+role);
		lblRole.setBounds(10, 11, 157, 14);
		frmYuconzSystem.getContentPane().add(lblRole);
		
		JLabel lblAccessLevel = new JLabel("Access Level: "+accessLvl);
		lblAccessLevel.setBounds(10, 36, 186, 14);
		frmYuconzSystem.getContentPane().add(lblAccessLevel);
		
		JLabel lblWelcome_1 = new JLabel("Welcome,");
		lblWelcome_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome_1.setBounds(0, 81, 436, 14);
		frmYuconzSystem.getContentPane().add(lblWelcome_1);
		
		JButton btnMyPersonalDetails = new JButton("My Personal Details");
		btnMyPersonalDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppController.generatePd();
			}
		});
		btnMyPersonalDetails.setBounds(139, 157, 157, 23);
		frmYuconzSystem.getContentPane().add(btnMyPersonalDetails);
	}
}
