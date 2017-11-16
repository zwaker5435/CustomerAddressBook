package customerAddressBook;

import java.awt.event.ActionListener;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AddressBook {
	Object[] row;
	DefaultTableModel model;

	public AddressBook(){
		JFrame frame = new JFrame();
		JTable table = new JTable();
		
		//creates a table model and sets column headings
		Object[] columns = {"CustomerId", "CustomerName", "AddressLine1", "AddressLine2", "AddressLine3", "City", "Province", "Country", "PostalCode", "PhoneNumber", "FaxNumber", "EmailAddress"};
		model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		
		table.setModel(model);
		
		JTextField textCustomerId = new JTextField();
		JTextField textCustomerName = new JTextField();
		JTextField textAddressLine1 = new JTextField();
		JTextField textAddressLine2 = new JTextField();
		JTextField textAddressLine3 = new JTextField();
		JTextField textCity = new JTextField();
		JTextField textProvince = new JTextField();
		JTextField textCountry = new JTextField();
		JTextField textPostalCode = new JTextField();
		JTextField textPhoneNumber = new JTextField();
		JTextField textFaxNumber = new JTextField();
		JTextField textEmailAddress = new JTextField();
		
		JButton btnAdd = new JButton();
		JButton btnDelete = new JButton();
		JButton btnEdit = new JButton();
		JButton btnSearch = new JButton();
		
		textCustomerId.setBounds(20, 20, 50, 25);
		textCustomerName.setBounds(20, 80, 50, 25);
		textAddressLine1.setBounds(20, 140, 50, 25);
		textAddressLine2.setBounds(20, 200, 50, 25);
		textAddressLine3.setBounds(20, 260, 50, 25);
		textCity.setBounds(20, 320, 50, 25);
		textProvince.setBounds(20, 380, 50, 25);
		textCountry.setBounds(20, 440, 50, 25);
		textPostalCode.setBounds(20, 500, 50, 25);
		textPhoneNumber.setBounds(20, 560, 50, 25);
		textFaxNumber.setBounds(20, 620, 50, 25);
		textEmailAddress.setBounds(20, 680, 50, 25);
		
		btnAdd.setBounds(40, , width, height);
		btnDelete.setBounds(40, , width, height);
		btnEdit.setBounds(40, , width, height);
		btnSearch.setBounds(40, , width, height);
		
		
		
		frame.setLayout(null);
		
		frame.add(pane);
		
		frame.add(textCustomerId);
		frame.add(textCustomerName);
		frame.add(textAddressLine1);
		frame.add(textAddressLine2);
		frame.add(textAddressLine3);
		frame.add(textCity);
		frame.add(textProvince);
		frame.add(textCountry);
		frame.add(textPostalCode);
		frame.add(textPhoneNumber);
		frame.add(textFaxNumber);
		frame.add(textEmailAddress);
		
		frame.add(btnAdd);
		frame.add(btnDelete);
		frame.add(btnEdit);
		frame.add(btnSearch);
		
		
		// btnAdd, delete, edit, search
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "INSERT INTO AddressBook  (CustomerName, AddressLine1, AddressLine2, AddressLine3, City, Province, Country, PostalCode, PhoneNumber, FaxNumber, EmailAddress) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				
				try {
					Connection conn = connect();
					PreparedStatement pst = conn.prepareStatement(sql);
					
					pst.setString(1, CustomerName.getText());
					pst.setString(2, AddressLine1.getText());
					
					pst.executeUpdate();
					
					pst.close();
					conn.close();
					
				} catch(SQLException ex) {
					System.out.println(ex.getMessage());
				}
				
				refresh();
			}
			
		}
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "INSERT INTO AddressBook  (CustomerName, AddressLine1)";
			}
			
		}
		
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "INSERT INTO AddressBook  (CustomerName, AddressLine1)";
			}
			
		}
		
		btnSearch.addActionListener(new ActionListener() {
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
