package authApp.PD;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Toolkit;

import authApp.AppController;
import authApp.MainDisplay;

//import authApp.AppController;

public class MyPdWindow {

private JFrame frame;


private JTextField textField_2;
private JTextField sNameField;
private JTextField fNameField;
private JTextField dobField;
private JTextField address1Field;
private JTextField address2Field;
private JTextField cityField;
private JTextField countyField;
private JTextField postcodeField;
private JTextField teleNumField;
private JTextField mobNumField;
private JTextField emerNumField;
private JTextField emerContactField;


/**
 * Create the application.
 */
public MyPdWindow(int myid) {
	initialize(myid);
}

/**
 * Initialise the contents of the frame.
 */
private void initialize(int tempid) {
	frame = new JFrame();
	frame.setVisible(true);
	frame.setResizable(false);
	frame.setIconImage(Toolkit.getDefaultToolkit().getImage(MyPdWindow.class.getResource("/authApp/img/LogoNoText.png")));
	frame.setTitle("Yuconz System");
	frame.getContentPane().setFont(new Font("Calibri", Font.BOLD, 26));
	frame.setBounds(100, 100, 1038, 611);
	frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	frame.addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent evt) {
		     backFunction();
		}
	});

	//Get ID
	String myid = Integer.toString(tempid);
	//Get Personal Details
	String firstName = GetDetails.getMyCurrentDetails().getFirstName();
	String lastName = GetDetails.getMyCurrentDetails().getLastName();
	String dob = GetDetails.getMyCurrentDetails().getDoB();
	String address1 = GetDetails.getMyCurrentDetails().getAddress1();
	String address2 = GetDetails.getMyCurrentDetails().getAddress2();
	String city = GetDetails.getMyCurrentDetails().getCity();
	String county = GetDetails.getMyCurrentDetails().getCounty();
	String postCode = GetDetails.getMyCurrentDetails().getPostcode();
	String mobileNum = GetDetails.getMyCurrentDetails().getMobile();
	String telephoneNum = GetDetails.getMyCurrentDetails().getTelenum();
	String emergencyContact = GetDetails.getMyCurrentDetails().getEmergencyContact();
	String emergencyNum = GetDetails.getMyCurrentDetails().getEmergencyNum(); 

    JLabel lblRole = new JLabel("Role: <dynamic>");
    lblRole.setBounds(10, 11, 157, 14);
    frame.getContentPane().add(lblRole);

    JLabel lblAccessLevel = new JLabel("Access Level: Normal");
    lblAccessLevel.setBounds(10, 36, 186, 14);
    frame.getContentPane().add(lblAccessLevel);

    JButton btnLogout = new JButton("LOGOUT");
    btnLogout.setBounds(615, 499, 89, 23);
    frame.getContentPane().add(btnLogout);

    JLabel lblNewLabel = new JLabel("Personal Details");
    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
    lblNewLabel.setBounds(119, 10, 393, 16);
    frame.getContentPane().add(lblNewLabel);

    JLabel lblNewLabel_1 = new JLabel("Staff No: ");
    lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
    lblNewLabel_1.setBounds(208, 35, 91, 16);
    frame.getContentPane().add(lblNewLabel_1);

    JLabel lblNewLabel_2 = new JLabel(myid);
    lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
    lblNewLabel_2.setBounds(310, 35, 105, 16);
    frame.getContentPane().add(lblNewLabel_2);

    JLabel lblNewLabel_3 = new JLabel("Name");
    lblNewLabel_3.setBounds(10, 106, 56, 16);
    frame.getContentPane().add(lblNewLabel_3);

    JLabel lblNewLabel_3_1 = new JLabel("Surname");
    lblNewLabel_3_1.setBounds(231, 106, 56, 16);
    frame.getContentPane().add(lblNewLabel_3_1);

    JLabel lblNewLabel_3_1_1 = new JLabel("Date of Birth");
    lblNewLabel_3_1_1.setBounds(473, 106, 80, 16);
    frame.getContentPane().add(lblNewLabel_3_1_1);

    sNameField = new JTextField();
    sNameField.setBounds(78, 103, 116, 22);
    frame.getContentPane().add(sNameField);
    sNameField.setText(firstName);
    sNameField.setColumns(10);

    fNameField = new JTextField();
    fNameField.setBounds(327, 103, 116, 22);
    frame.getContentPane().add(fNameField);
    fNameField.setText(lastName);
    fNameField.setColumns(10);

    dobField = new JTextField();
    dobField.setBounds(590, 103, 116, 22);
    frame.getContentPane().add(dobField);
    dobField.setColumns(10);
    dobField.setText(dob);

    JLabel lblNewLabel_3_2 = new JLabel("Address");
    lblNewLabel_3_2.setBounds(10, 176, 56, 16);
    frame.getContentPane().add(lblNewLabel_3_2);

    address1Field = new JTextField();
    address1Field.setColumns(10);
    address1Field.setBounds(80, 173, 116, 22);
    frame.getContentPane().add(address1Field);
    address1Field.setText(address1);

    JLabel lblNewLabel_3_1_2 = new JLabel("Town/City");
    lblNewLabel_3_1_2.setBounds(231, 176, 80, 16);
    frame.getContentPane().add(lblNewLabel_3_1_2);

    address2Field = new JTextField();
    address2Field.setColumns(10);
    address2Field.setBounds(80, 208, 116, 22);
    frame.getContentPane().add(address2Field);
    address2Field.setText(address2);

    cityField = new JTextField();
    cityField.setColumns(10);
    cityField.setBounds(327, 173, 116, 22);
    frame.getContentPane().add(cityField);
    cityField.setText(city);

    JLabel lblNewLabel_3_1_2_1 = new JLabel("County");
    lblNewLabel_3_1_2_1.setBounds(473, 176, 80, 16);
    frame.getContentPane().add(lblNewLabel_3_1_2_1);

    countyField = new JTextField();
    countyField.setColumns(10);
    countyField.setBounds(590, 173, 116, 22);
    frame.getContentPane().add(countyField);
    countyField.setText(county);


    JLabel lblNewLabel_3_2_1 = new JLabel("Postcode");
    lblNewLabel_3_2_1.setBounds(10, 289, 56, 16);
    frame.getContentPane().add(lblNewLabel_3_2_1);

    postcodeField = new JTextField();
    postcodeField.setColumns(10);
    postcodeField.setBounds(80, 286, 116, 22);
    postcodeField.setText(postCode);
    frame.getContentPane().add(postcodeField);


    JLabel lblNewLabel_3_2_1_1 = new JLabel("Telephone Number");
    lblNewLabel_3_2_1_1.setBounds(474, 289, 129, 16);
    frame.getContentPane().add(lblNewLabel_3_2_1_1);

    teleNumField = new JTextField();
    teleNumField.setColumns(10);
    teleNumField.setBounds(588, 286, 116, 22);
    frame.getContentPane().add(teleNumField);
    teleNumField.setText(telephoneNum);

    JLabel lblNewLabel_3_1_2_2 = new JLabel("Mobile Number");
    lblNewLabel_3_1_2_2.setBounds(231, 289, 101, 16);
    frame.getContentPane().add(lblNewLabel_3_1_2_2);

    mobNumField = new JTextField();
    mobNumField.setColumns(10);
    mobNumField.setBounds(327, 286, 116, 22);
    frame.getContentPane().add(mobNumField);
    mobNumField.setText(mobileNum);

    JLabel lblNewLabel_3_2_1_2_1 = new JLabel("Emergency Contact");
    lblNewLabel_3_2_1_2_1.setBounds(10, 348, 116, 16);
    frame.getContentPane().add(lblNewLabel_3_2_1_2_1);

    JLabel lblNewLabel_3_2_1_2_1_1 = new JLabel("Emergency Contact Number");
    lblNewLabel_3_2_1_2_1_1.setBounds(364, 348, 170, 16);
    frame.getContentPane().add(lblNewLabel_3_2_1_2_1_1);

    emerNumField = new JTextField();
    emerNumField.setColumns(10);
    emerNumField.setBounds(546, 345, 160, 22);
    frame.getContentPane().add(emerNumField);
    emerNumField.setText(emergencyNum);

    emerContactField = new JTextField();
    emerContactField.setColumns(10);
    emerContactField.setBounds(138, 345, 194, 22);
    emerContactField.setText(emergencyContact);
    frame.getContentPane().add(emerContactField);

    JButton btnBack = new JButton("BACK");
    btnBack.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		backFunction();
    	}
    });
    btnBack.setBounds(37, 499, 89, 23);
    frame.getContentPane().add(btnBack);

    
	}
	public void hide() {
		frame.setVisible(false);
	}
	public void show() {
		frame.setVisible(true);
	}
	public void backFunction(){
		AppController.showMain();
		hide();
	}
}