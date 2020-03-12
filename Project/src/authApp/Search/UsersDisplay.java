package authApp.Search;

import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JFrame;
import authApp.PD.MyPdWindow;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Generates a JFrame with a JTable that is filled with all current Employees in the Database.
 * @author Tsotne
 *
 */
public class UsersDisplay {

	private JFrame frame;
	private String[] columnNames = {"First Name","Last Name","Role"};
	// Data to be displayed in the JTable 
    String[][] data = { 
        { "Kundan Kumar Jha", "4031", "CSE" }, 
        { "Anand Jha", "6014", "IT" } 
    }; 

    // Column Names  
    private JTable table;


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
		frame.setBounds(100, 100, 718, 534);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);	//Needs to be changed
		//frame.getContentPane().setLayout(null);
		table = new JTable(data, columnNames);
		table.setBounds(10, 41, 528, 286);
		table.setDefaultEditor(Object.class, null);
		JScrollPane sp = new JScrollPane(table); 
        frame.getContentPane().add(sp); 
		frame.setLocationRelativeTo(null); 
		frame.setVisible(true);
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	            // do some actions here, for example
	            // print first column value from selected row
	        	//We want to get their staff id
	            System.out.println(table.getValueAt(table.getSelectedRow(), 0).toString());
	        }
	    });
		
	
	}
}
