package authApp;


import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingUtilities;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * This class generates the GUI for the Login functionality
 * 
 * @author Tsotne
 *
 */
public class LoginDisplay{

	private JFrame frmYuconzSystem;
	private JPasswordField passwordField;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	
	/**
	* Create the Frame.
	*/
	public LoginDisplay() {
		initialize();
	}

	/**
	* Initialise the contents of the frame.
	*/
	private void initialize() {
		frmYuconzSystem = new JFrame();
		frmYuconzSystem.setResizable(false);
		frmYuconzSystem.setIconImage(Toolkit.getDefaultToolkit().getImage(MainDisplay.class.getResource("/authApp/img/LogoNoText.png")));
		frmYuconzSystem.setTitle("Yuconz System");
		frmYuconzSystem.getContentPane().setFont(new Font("Calibri", Font.BOLD, 26));
		frmYuconzSystem.setBounds(100, 100, 450, 301);
		frmYuconzSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmYuconzSystem.getContentPane().setLayout(null);
		frmYuconzSystem.setLocationRelativeTo(null); 
		frmYuconzSystem.setVisible(true);
		
		
		JLabel lblTitle = new JLabel("Yuconz");
		lblTitle.setFont(new Font("Calibri", Font.BOLD, 28));
		lblTitle.setBounds(177, 11, 88, 27);
		frmYuconzSystem.getContentPane().add(lblTitle);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		passwordField.setBounds(128, 136, 190, 27);
		frmYuconzSystem.getContentPane().add(passwordField);
		
		textField = new JTextField();
		textField.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		textField.setBounds(127, 90, 191, 27);
		frmYuconzSystem.getContentPane().add(textField);
		textField.setColumns(10);
		
		/**
		 * Creates the login button
		 */
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBounds(128, 186, 88, 38);
		frmYuconzSystem.getContentPane().add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String uName = textField.getText();
				char[] pass = passwordField.getPassword();
				String pwd = String.valueOf(pass);  
				AppController.logIn(uName, pwd);
			}
		});
		
		JRootPane rootPane = SwingUtilities.getRootPane(btnLogin); 
		rootPane.setDefaultButton(btnLogin);
		
		/**
		 * Creates the Exit button
		 */
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setBounds(229, 186, 88, 38);
		frmYuconzSystem.getContentPane().add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LoginDisplay.class.getResource("/authApp/img/user25.png")));
		lblNewLabel.setBounds(92, 90, 25, 27);
		frmYuconzSystem.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(LoginDisplay.class.getResource("/authApp/img/lock25.png")));
		lblNewLabel_1.setBounds(93, 136, 25, 27);
		frmYuconzSystem.getContentPane().add(lblNewLabel_1);
	}
	public void remove() {
		frmYuconzSystem.dispose();
	}
	
}