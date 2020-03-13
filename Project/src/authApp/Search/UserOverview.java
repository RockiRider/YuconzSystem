package authApp.Search;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import authApp.AppController;
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
	public UserOverview(boolean input,int id) {
		exists = input;
		initialize(id);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int id) {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(UserOverview.class.getResource("/authApp/img/LogoNoText.png")));
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
		
		String fName = Db.getSelectedUser().getFirstName();
		String lName = Db.getSelectedUser().getLastName();
		String fullName =fName +" " + lName;
		
		JLabel lblNewLabel = new JLabel(fullName);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(112, 11, 218, 38);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btncreateBtn = new JButton("Create Personal Details");
		btncreateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppController.createDetails(id);
				die();
			}
		});
		btncreateBtn.setBounds(112, 99, 218, 32);
		frame.getContentPane().add(btncreateBtn);
		
		JButton btnView = new JButton("View Personal Details");
		btnView.setBounds(112, 154, 218, 32);
		frame.getContentPane().add(btnView);
		
		if(exists) {
			btncreateBtn.setVisible(false);
		}else {
			btnView.setVisible(false);
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
