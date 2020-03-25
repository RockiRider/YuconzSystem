package authApp.Search;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import controller.*;
import authApp.Auth;
import authApp.MainDisplay;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserOverview {

	private JFrame frame;
	private boolean exists;
	
	
	/**
	 * Create the application.
	 */
	public UserOverview(boolean input) {
		exists = input;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		int id = Db.getSelectedUser().getId();
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(UserOverview.class.getResource("/authApp/img/LogoNoText.png")));
		frame.setTitle("Yuconz System");
		frame.getContentPane().setFont(new Font("Calibri", Font.BOLD, 26));
		frame.setBounds(100, 100, 545, 392);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
			     UsersDisplay.table.setEnabled(true);
			     die();
			}
		});
		frame.setLocationRelativeTo(null); 
		
		String fName = Db.getSelectedUser().getFirstName();
		String lName = Db.getSelectedUser().getLastName();
		String fullName =fName +" " + lName;
		
		JLabel lblNewLabel = new JLabel(fullName);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(160, 11, 218, 38);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btncreateBtn = new JButton("Create Personal Details");
		btncreateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppController.createDetails();
				die();
			}
		});
		btncreateBtn.setBounds(160, 169, 218, 32);
		frame.getContentPane().add(btncreateBtn);
		
		JButton btnView = new JButton("View Personal Details");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppController.viewDetails();
				die();
			}
		});
		btnView.setBounds(160, 228, 218, 32);
		frame.getContentPane().add(btnView);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppController.showTable();
				die();
			}
		});
		btnBack.setBounds(10, 312, 89, 23);
		frame.getContentPane().add(btnBack);
		
		JButton btnNewButton = new JButton("View Reviews");
		btnNewButton.setBounds(160, 107, 218, 32);
		frame.getContentPane().add(btnNewButton);
		
		// Checks if Personal Details Exists or not
		if(exists) {
			btncreateBtn.setVisible(false);
		}else {
			btnView.setVisible(false);
		}
		
		// Checks to see if the current User has HR Access or not.
		if(!Auth.getCurrentUser().getHrAccess()) {
			btnView.setVisible(false);
			btncreateBtn.setVisible(false);
		}
		
		frame.setVisible(true);
		
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
