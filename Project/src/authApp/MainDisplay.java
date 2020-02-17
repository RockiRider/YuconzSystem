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
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setBounds(119, 58, 216, 23);
		frmYuconzSystem.getContentPane().add(lblWelcome);
		
		JLabel lblRole = new JLabel("Role: ");
		lblRole.setBounds(303, 11, 49, 14);
		frmYuconzSystem.getContentPane().add(lblRole);
	}
}
