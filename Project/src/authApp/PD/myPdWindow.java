package authApp.PD;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;

import authApp.AppController;

//import authApp.AppController;

public class myPdWindow {

private JFrame frame;


private JPanel contentPane;
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
public myPdWindow(int myid) {
    initialise(myid);
}

/**
 * Initialise the contents of the frame.
 */
private void initialise(int tempid) {
    frame = new JFrame();
    frame.setTitle("My Personal Details");
    frame.setVisible(false);
    frame.setIconImage(Toolkit.getDefaultToolkit().getImage(myPdWindow.class.getResource("/authApp/img/LogoNoText.png")));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBounds(300, 300, 750, 600);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    frame.setContentPane(contentPane);
    contentPane.setLayout(null);

	//Get ID
	String myid = Integer.toString(tempid);
	System.out.println("BEFORE Decl");
	//Get Personal Details
	String firstName = GetDetails.getMyCurrentDetails().getFirstName();
	String lastName = GetDetails.getMyCurrentDetails().getLastName();
	String dob = GetDetails.getMyCurrentDetails().getDoB();
	String address1 = GetDetails.getMyCurrentDetails().getAddress1();
	String address2 = GetDetails.getMyCurrentDetails().getAddress2();
	String city = GetDetails.getMyCurrentDetails().getCity();
	//String county = GetDetails.getMyCurrentDetails().getCounty();
	String postCode = GetDetails.getMyCurrentDetails().getPostcode();
	String mobileNum = GetDetails.getMyCurrentDetails().getMobile();
	String telephoneNum = GetDetails.getMyCurrentDetails().getTelenum();
	String emergencyContact = GetDetails.getMyCurrentDetails().getEmergencyContact();
	String emergencyNum = GetDetails.getMyCurrentDetails().getEmergencyNum(); 
	System.out.println("After Decl");

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

    JLabel lblNewLabel_2 = new JLabel(myid);
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

    sNameField = new JTextField();
    sNameField.setBounds(78, 103, 116, 22);
    contentPane.add(sNameField);
    sNameField.setText(firstName);
    sNameField.setColumns(10);

    fNameField = new JTextField();
    fNameField.setBounds(327, 103, 116, 22);
    contentPane.add(fNameField);
    fNameField.setText(lastName);
    fNameField.setColumns(10);

    dobField = new JTextField();
    dobField.setBounds(590, 103, 116, 22);
    contentPane.add(dobField);
    dobField.setColumns(10);
    dobField.setText(dob);

    JLabel lblNewLabel_3_2 = new JLabel("Address");
    lblNewLabel_3_2.setBounds(10, 176, 56, 16);
    contentPane.add(lblNewLabel_3_2);

    address1Field = new JTextField();
    address1Field.setColumns(10);
    address1Field.setBounds(80, 173, 116, 22);
    contentPane.add(address1Field);
    address1Field.setText(address1);

    JLabel lblNewLabel_3_1_2 = new JLabel("Town/City");
    lblNewLabel_3_1_2.setBounds(231, 176, 80, 16);
    contentPane.add(lblNewLabel_3_1_2);

    address2Field = new JTextField();
    address2Field.setColumns(10);
    address2Field.setBounds(80, 208, 116, 22);
    contentPane.add(address2Field);
    address2Field.setText(address2);

    cityField = new JTextField();
    cityField.setColumns(10);
    cityField.setBounds(327, 173, 116, 22);
    contentPane.add(cityField);
   cityField.setText(city);

    JLabel lblNewLabel_3_1_2_1 = new JLabel("County");
    lblNewLabel_3_1_2_1.setBounds(473, 176, 80, 16);
    contentPane.add(lblNewLabel_3_1_2_1);

    countyField = new JTextField();
    countyField.setColumns(10);
    countyField.setBounds(590, 173, 116, 22);
    contentPane.add(countyField);
   // countyField.setText(county);


    JLabel lblNewLabel_3_2_1 = new JLabel("Postcode");
    lblNewLabel_3_2_1.setBounds(10, 289, 56, 16);
    contentPane.add(lblNewLabel_3_2_1);

    postcodeField = new JTextField();
    postcodeField.setColumns(10);
    postcodeField.setBounds(80, 286, 116, 22);
    //postcodeField.setText(postCode);
    contentPane.add(postcodeField);


    JLabel lblNewLabel_3_2_1_1 = new JLabel("Telephone Number");
    lblNewLabel_3_2_1_1.setBounds(474, 289, 129, 16);
    contentPane.add(lblNewLabel_3_2_1_1);

    teleNumField = new JTextField();
    teleNumField.setColumns(10);
    teleNumField.setBounds(588, 286, 116, 22);
    contentPane.add(teleNumField);
   // teleNumField.setText(telephoneNum);

    JLabel lblNewLabel_3_1_2_2 = new JLabel("Mobile Number");
    lblNewLabel_3_1_2_2.setBounds(231, 289, 101, 16);
    contentPane.add(lblNewLabel_3_1_2_2);

    mobNumField = new JTextField();
    mobNumField.setColumns(10);
    mobNumField.setBounds(327, 286, 116, 22);
    contentPane.add(mobNumField);
   // mobNumField.setText(mobileNum);

    JLabel lblNewLabel_3_2_1_2_1 = new JLabel("Emergency Contact");
    lblNewLabel_3_2_1_2_1.setBounds(10, 348, 116, 16);
    contentPane.add(lblNewLabel_3_2_1_2_1);

    JLabel lblNewLabel_3_2_1_2_1_1 = new JLabel("Emergency Contact Number");
    lblNewLabel_3_2_1_2_1_1.setBounds(364, 348, 170, 16);
    contentPane.add(lblNewLabel_3_2_1_2_1_1);

    emerNumField = new JTextField();
    emerNumField.setColumns(10);
    emerNumField.setBounds(546, 345, 160, 22);
    contentPane.add(emerNumField);
   // emerNumField.setText(emergencyNum);

    emerContactField = new JTextField();
    emerContactField.setColumns(10);
    emerContactField.setBounds(138, 345, 194, 22);
   // emerContactField.setText(emergencyContact);
    contentPane.add(emerContactField);

    JButton btnBack = new JButton("BACK");
    btnBack.setBounds(37, 499, 89, 23);
    contentPane.add(btnBack);
    textField_2.setColumns(10);

    System.out.println("End of Frame");
}
	public void setVis(boolean input) {
		frame.setVisible(input);
	}
public void remove() {
    frame.dispose();
	}
}