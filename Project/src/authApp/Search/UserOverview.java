package authApp.Search;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import authApp.MainDisplay;
import authApp.PD.MyPdWindow;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class UserOverview {

	private JFrame frame;
	private boolean exists;
	
	
	/**
	 * Create the application.
	 */
	public UserOverview() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(MainDisplay.class.getResource("/authApp/img/LogoNoText.png")));
		frame.setTitle("Yuconz System");
		frame.getContentPane().setFont(new Font("Calibri", Font.BOLD, 26));
		frame.setBounds(100, 100, 450, 301);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
			     die();
			     UsersDisplay.table.setEnabled(true);
			}
		});
		frame.setLocationRelativeTo(null); 
		frame.setVisible(true);
		
		String fName = Db.getSelectedUser().getFirstName();
		String lName = Db.getSelectedUser().getLastName();
		String fullName =fName +" " + lName;
		
		JLabel lblNewLabel = new JLabel(fullName);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(112, 11, 218, 38);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Create Personal Details");
		btnNewButton.setBounds(112, 75, 218, 32);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View Personal Details");
		btnNewButton_1.setBounds(112, 123, 218, 32);
		frame.getContentPane().add(btnNewButton_1);
		
	}
	public void die() {
		frame.dispose();
	}
	public void hide() {
		frame.setVisible(false);
	}
	public void show() {
		frame.setVisible(true);
	}
}
