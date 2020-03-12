package authApp.Search;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;

import authApp.PD.MyPdWindow;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class UserOverview {

	private JFrame frame;
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
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(MyPdWindow.class.getResource("/authApp/img/LogoNoText.png")));
		frame.setTitle("Yuconz System");
		frame.getContentPane().setFont(new Font("Calibri", Font.BOLD, 26));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(152, 11, 139, 38);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Create Personal Details");
		btnNewButton.setBounds(112, 75, 218, 32);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View Personal Details");
		btnNewButton_1.setBounds(112, 123, 218, 32);
		frame.getContentPane().add(btnNewButton_1);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 	//Needs to be changed
	}
}
