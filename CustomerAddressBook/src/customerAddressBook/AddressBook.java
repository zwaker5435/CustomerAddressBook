package customerAddressBook;

<<<<<<< HEAD
import java.awt.event.ActionListener;
=======
import java.awt.EventQueue;
>>>>>>> branch 'master' of https://github.com/zwaker5435/CustomerAddressBook
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import bitSim.GUI;

public class AddressBook {
	Object[] row;
	DefaultTableModel model;

	public AddressBook(){
		JFrame frame = new JFrame();
		JTable table = new JTable();
		
		Object[] columns = {"CustomerId", "CustomerName", "AddressLine1", "", "", "", "", "", "", "", "", "", };
		
		// btnAdd, del edit, search
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "INSERT INTO AddressBook  (CustomerName, AddressLine1)";
			}
			
		}
		
		
	}
	
	public static Connection connect(){
		Connection conn = null;
		
		try{
			String url="jdbc:sqlite:C:/AddressBook/AddressBook.db";
			conn = DriverManager.getConnection(url);
			
			System.out.println("Successful connection");
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		
		return conn;
	}
	
	public static void refresh(){
		row = new Object[3];
		model.setRowCount(0);
		
		String sql = "SELECT ID, fName, lName FROM Student";
		
		try{
			Connection conn = connect();
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()){
				row[0] = rs.getInt("ID");
				row[1] = rs.getString("fName");
				row[2] = rs.getString("lName");
				
				model.addRow(row);
			}
			
			rs.close();
			stat.close();
			conn.close();
			
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		
	}

}






/**
 * 
 * 
 * public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 * 
 * 
 * 
 */
