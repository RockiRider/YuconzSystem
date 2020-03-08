package authApp;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JToggleButton;

/**
 * This class generates the GUI for the main display, which is generated after
 * the user successfully logs in.
 */
public class MainDisplay {

	private JFrame frmYuconzSystem;
	private boolean accessLevel;
	boolean tempAccessLevel;

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
		
		frmYuconzSystem.setIconImage(
				Toolkit.getDefaultToolkit().getImage(MainDisplay.class.getResource("/authApp/img/LogoNoText.png")));
		frmYuconzSystem.setBounds(100, 100, 715, 433);
		
		frmYuconzSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmYuconzSystem.getContentPane().setLayout(null);
		frmYuconzSystem.setLocationRelativeTo(null); 
		frmYuconzSystem.setVisible(true);

		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppController.logOut();
			}
		});
		btnLogout.setBounds(581, 360, 89, 23);
		frmYuconzSystem.getContentPane().add(btnLogout);

		// Get USER INFO

		String fName = Auth.getCurrentUser().getFirstName();
		String sName = Auth.getCurrentUser().getLastName();
		String role = Auth.getCurrentUser().getRole();
		int userId = Auth.getCurrentId();
		accessLevel = Auth.getCurrentUser().getAccess();
		tempAccessLevel = accessLevel;
		
		
		String accessLvl = "Normal";
		if (accessLevel) {
			accessLvl = "High";
		}

		JLabel lblName = new JLabel("<dynamic> <dynamic>");
		lblName.setText(fName + " " + sName);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(131, 100, 436, 23);
		frmYuconzSystem.getContentPane().add(lblName);

		JLabel lblRole = new JLabel("Role: " + role);
		lblRole.setBounds(10, 11, 157, 14);
		frmYuconzSystem.getContentPane().add(lblRole);

		JLabel lblAccessLevel = new JLabel("Access Level: " + accessLvl);
		lblAccessLevel.setBounds(10, 36, 186, 14);
		frmYuconzSystem.getContentPane().add(lblAccessLevel);

		JLabel lblWelcome = new JLabel("Welcome,");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(131, 81, 436, 14);
		frmYuconzSystem.getContentPane().add(lblWelcome);
		
		JButton btnMyPd = new JButton("My Personal Details");
		btnMyPd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppController.generatePd(userId);
			}
		});
		btnMyPd.setBounds(271, 164, 157, 23);
		frmYuconzSystem.getContentPane().add(btnMyPd);
		JButton btnChangeAccess = new JButton("Toggle Access Level");
		btnChangeAccess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(accessLevel) {
					lblAccessLevel.setText("Access Level: Normal");
					accessLevel = false;
				}else{
					lblAccessLevel.setText("Access Level: High");
					accessLevel = true;
				}
			}
		});
		btnChangeAccess.setBounds(10, 61, 157, 23);
		frmYuconzSystem.getContentPane().add(btnChangeAccess);
		btnChangeAccess.setVisible(false);
		if(tempAccessLevel) {
			btnChangeAccess.setVisible(true);
		}


		

	}
	public void hide() {
		frmYuconzSystem.setVisible(false);
	}
	public void show() {
		frmYuconzSystem.setVisible(true);
	}
	public void die() {
		frmYuconzSystem.dispose();
	}
}
