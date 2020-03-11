package authApp.Search;

import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JFrame;
import authApp.PD.MyPdWindow;
import javax.swing.JLabel;
import javax.swing.JTable;

public class UsersDisplay {

	private JFrame frame;
	private JTable table;
	private String[] columnNames = {"First Name","Last Name","Role"};



	/**
	 * Create the application.
	 */
	public UsersDisplay() {
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
		frame.setBounds(100, 100, 787, 534);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFName = new JLabel("First Name");
		lblFName.setBounds(10, 11, 69, 26);
		frame.getContentPane().add(lblFName);
		
		JLabel lblRoles = new JLabel("Roles");
		lblRoles.setBounds(158, 11, 69, 26);
		frame.getContentPane().add(lblRoles);
		
		JLabel lblSName = new JLabel("Last Name");
		lblSName.setBounds(87, 17, 61, 14);
		frame.getContentPane().add(lblSName);
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setBounds(30, 62, 307, 316);
		frame.getContentPane().add(table);
		frame.setLocationRelativeTo(null); 
		frame.setVisible(true);
	}
}
