package authApp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainDisplay {

	private JFrame frame;


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
		frame = new JFrame();
		frame.setVisible(true);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(MainDisplay.class.getResource("/authApp/img/LogoNoText.png")));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnLogout.setBounds(174, 174, 89, 23);
		frame.getContentPane().add(btnLogout);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setBounds(119, 58, 216, 23);
		frame.getContentPane().add(lblWelcome);
		
		JLabel lblRole = new JLabel("Role: ");
		lblRole.setBounds(303, 11, 49, 14);
		frame.getContentPane().add(lblRole);
	}
}
