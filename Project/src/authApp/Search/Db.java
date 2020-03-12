package authApp.Search;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

public class Db {

	private Connection myDb = null;
	private ArrayList<ArrayList <String>> result = new ArrayList<ArrayList<String>>();
	private String[][] data;
	
	public Db() {
		connectToDb();
		populateAllEmployees();
		convertData();
		
	}
	
	public Connection connectToDb() {
		try {
			 // load the SQLite-JDBC driver using the current class loader
		      Class.forName("org.sqlite.JDBC");
		      myDb = DriverManager.getConnection("jdbc:sqlite:Auth.db");
		      Statement statement = myDb.createStatement();
		      statement.setQueryTimeout(30);  // set timeout to 30 seconds.
		      return myDb;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,
	    		    "Cannot Connect to DB",
	    		    "Error",
	    		    JOptionPane.ERROR_MESSAGE);
			
			return null;
		}
	}
	
	/**
	 * Gets all Employees inside the Employee Table in the Database.
	 */
	public void populateAllEmployees() {
		
		String sql = "select id,fName,sName,role from Employees";
		
		connectToDb();
		try(Connection conn = myDb;
				Statement stmt = conn.createStatement();
				ResultSet rs  = stmt.executeQuery(sql)){
				
			int columnCount = rs.getMetaData().getColumnCount();
			while(rs.next())
			{
			    ArrayList<String> row = new  ArrayList<String>();
			    for (int i=0; i <columnCount ; i++)
			    {
			       row.add( rs.getString(i + 1));
			    }
			    result.add(row);
			}
			System.out.println(Arrays.deepToString(result.toArray()));
			
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null,
	    		    "Cannot connect to the Database",
	    		    "Error",
	    		    JOptionPane.ERROR_MESSAGE);
		}
	}
	public void convertData(){
		data = result.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);
		System.out.println(Arrays.deepToString(result.toArray()));
	}
	public String[][] getEmployees() {
		return data;
	}
	
}
