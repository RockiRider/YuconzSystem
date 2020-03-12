package authApp.Search;

import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JFrame;

import authApp.AppController;
import authApp.PD.MyPdWindow;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Generates a JFrame with a JTable that is filled with all current Employees in the Database.
 * @author Tsotne
 *
 */
public class UsersDisplay {

	
	private JFrame frame;
	private String[] columnNames = {"Staff ID","First Name","Last Name","Role"};


    // Column Names  
    static JTable table;
    

	/**
	 * Create the application.
	 */
	public UsersDisplay(String[][] input) {
		initialize(input);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String[][] input) {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(MyPdWindow.class.getResource("/authApp/img/LogoNoText.png")));
		frame.setTitle("Yuconz System");
		frame.getContentPane().setFont(new Font("Calibri", Font.BOLD, 26));
		frame.setBounds(100, 100, 718, 534);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);	//Needs to be changed
		table = new JTable(input, columnNames);
		table.setBounds(10, 41, 528, 286);
		table.setDefaultEditor(Object.class, null);
		JScrollPane sp = new JScrollPane(table); 
        frame.getContentPane().add(sp); 
		//frame.setLocationRelativeTo(null); 
		frame.setVisible(true);
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	            //do some actions here, for example
	            //print first column value from selected row
	        	//We want to get their staff id
	            //System.out.println(table.getValueAt(table.getSelectedRow(), 0).toString());
	        	int column = 0;
	        	int row = table.getSelectedRow();
	        	String value = table.getModel().getValueAt(row, column).toString();
	        	AppController.selectedDetails(value);
	        	table.setEnabled(false);
	        }
	    });
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
