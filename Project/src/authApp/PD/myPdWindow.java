package authApp.PD;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class myPdWindow {

	private JFrame frame;
	
	private JPanel contentPane;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_12;
	

	/**
	 * Create the application.
	 */
	public myPdWindow() {
		initialise();
	}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialise() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setBounds(300, 300, 750, 600);
	    contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    frame.setContentPane(contentPane);
	    contentPane.setLayout(null);

	    JLabel lblRole = new JLabel("Role: <dynamic>");
	    lblRole.setBounds(10, 11, 157, 14);
	    contentPane.add(lblRole);

	    JLabel lblAccessLevel = new JLabel("Access Level: Normal");
	    lblAccessLevel.setBounds(10, 36, 186, 14);
	    contentPane.add(lblAccessLevel);

	    JButton btnLogout = new JButton("LOGOUT");
	    btnLogout.setBounds(615, 499, 89, 23);
	    contentPane.add(btnLogout);

	    JLabel lblNewLabel = new JLabel("Personal Details");
	    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel.setBounds(119, 10, 393, 16);
	    contentPane.add(lblNewLabel);

	    JLabel lblNewLabel_1 = new JLabel("Staff No: ");
	    lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_1.setBounds(208, 35, 91, 16);
	    contentPane.add(lblNewLabel_1);

	    JLabel lblNewLabel_2 = new JLabel("<dynamic>");
	    lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_2.setBounds(310, 35, 105, 16);
	    contentPane.add(lblNewLabel_2);

	    JLabel lblNewLabel_3 = new JLabel("Name");
	    lblNewLabel_3.setBounds(10, 106, 56, 16);
	    contentPane.add(lblNewLabel_3);

	    JLabel lblNewLabel_3_1 = new JLabel("Surname");
	    lblNewLabel_3_1.setBounds(231, 106, 56, 16);
	    contentPane.add(lblNewLabel_3_1);

	    JLabel lblNewLabel_3_1_1 = new JLabel("Date of Birth");
	    lblNewLabel_3_1_1.setBounds(473, 106, 80, 16);
	    contentPane.add(lblNewLabel_3_1_1);

	    textField_3 = new JTextField();
	    textField_3.setBounds(78, 103, 116, 22);
	    contentPane.add(textField_3);
	    textField_3.setColumns(10);

	    textField_4 = new JTextField();
	    textField_4.setBounds(327, 103, 116, 22);
	    contentPane.add(textField_4);
	    textField_4.setColumns(10);

	    textField_5 = new JTextField();
	    textField_5.setBounds(590, 103, 116, 22);
	    contentPane.add(textField_5);
	    textField_5.setColumns(10);

	    JLabel lblNewLabel_3_2 = new JLabel("Address");
	    lblNewLabel_3_2.setBounds(10, 176, 56, 16);
	    contentPane.add(lblNewLabel_3_2);

	    textField_6 = new JTextField();
	    textField_6.setColumns(10);
	    textField_6.setBounds(80, 173, 116, 22);
	    contentPane.add(textField_6);

	    JLabel lblNewLabel_3_1_2 = new JLabel("Town/City");
	    lblNewLabel_3_1_2.setBounds(231, 176, 80, 16);
	    contentPane.add(lblNewLabel_3_1_2);

	    textField_7 = new JTextField();
	    textField_7.setColumns(10);
	    textField_7.setBounds(80, 208, 116, 22);
	    contentPane.add(textField_7);

	    textField_8 = new JTextField();
	    textField_8.setColumns(10);
	    textField_8.setBounds(327, 173, 116, 22);
	    contentPane.add(textField_8);

	    JLabel lblNewLabel_3_1_2_1 = new JLabel("County");
	    lblNewLabel_3_1_2_1.setBounds(473, 176, 80, 16);
	    contentPane.add(lblNewLabel_3_1_2_1);

	    textField_9 = new JTextField();
	    textField_9.setColumns(10);
	    textField_9.setBounds(590, 173, 116, 22);
	    contentPane.add(textField_9);

	    JLabel lblNewLabel_3_2_1 = new JLabel("Postcode");
	    lblNewLabel_3_2_1.setBounds(10, 289, 56, 16);
	    contentPane.add(lblNewLabel_3_2_1);

	    textField_10 = new JTextField();
	    textField_10.setColumns(10);
	    textField_10.setBounds(80, 286, 116, 22);
	    contentPane.add(textField_10);

	    JLabel lblNewLabel_3_2_1_1 = new JLabel("Telephone Number");
	    lblNewLabel_3_2_1_1.setBounds(474, 289, 129, 16);
	    contentPane.add(lblNewLabel_3_2_1_1);

	    textField_11 = new JTextField();
	    textField_11.setColumns(10);
	    textField_11.setBounds(588, 286, 116, 22);
	    contentPane.add(textField_11);

	    JLabel lblNewLabel_3_1_2_2 = new JLabel("Mobile Number");
	    lblNewLabel_3_1_2_2.setBounds(231, 289, 101, 16);
	    contentPane.add(lblNewLabel_3_1_2_2);

	    textField = new JTextField();
	    textField.setColumns(10);
	    textField.setBounds(327, 286, 116, 22);
	    contentPane.add(textField);

	    JLabel lblNewLabel_3_2_1_2_1 = new JLabel("Emergency Contact");
	    lblNewLabel_3_2_1_2_1.setBounds(10, 348, 116, 16);
	    contentPane.add(lblNewLabel_3_2_1_2_1);

	    JLabel lblNewLabel_3_2_1_2_1_1 = new JLabel("Emergency Contact Number");
	    lblNewLabel_3_2_1_2_1_1.setBounds(364, 348, 170, 16);
	    contentPane.add(lblNewLabel_3_2_1_2_1_1);

	    textField_1 = new JTextField();
	    textField_1.setColumns(10);
	    textField_1.setBounds(546, 345, 160, 22);
	    contentPane.add(textField_1);

	    textField_12 = new JTextField();
	    textField_12.setColumns(10);
	    textField_12.setBounds(138, 345, 194, 22);
	    contentPane.add(textField_12);
	    textField_2.setColumns(10);
	}

}
