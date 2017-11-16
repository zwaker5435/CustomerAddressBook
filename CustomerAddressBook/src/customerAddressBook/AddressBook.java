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
		
		
		
		
		
		

		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "INSERT INTO AddressBook  (CustomerName, AddressLine1, AddressLine2, AddressLine3, City, Province, Country, PostalCode, PhoneNumber, FaxNumber, EmailAddress) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				
				try {
					Connection conn = connect();
					PreparedStatement pst = conn.prepareStatement(sql);
					
					pst.setString(1, textCustomerName.getText());
					pst.setString(2, textAddressLine1.getText());
					pst.setString(2, textAddressLine2.getText());
					pst.setString(2, textAddressLine3.getText());
					pst.setString(2, textCity.getText());
					pst.setString(2, textProvince.getText());
					pst.setString(2, textCountry.getText());
					pst.setString(2, textPostalCode.getText());
					pst.setString(2, textPhoneNumber.getText());
					pst.setString(2, textFaxNumber.getText());
					pst.setString(2, textEmailAddress.getText());
					
					pst.executeUpdate();
					
					pst.close();
					conn.close();
					
				} catch(SQLException ex) {
					System.out.println(ex.getMessage());
				}
				
				refresh();
			}
			
		});
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "DELETE FROM student WHERE ID = ?";
				
				try {
					Connection conn = connect();
					PreparedStatement pst = conn.prepareStatement(sql);
					
					pst.setInt(1, Integer.parseInt(textCustomerId.getText()));
					
					pst.executeUpdate();
					
					pst.close();
					conn.close();
					
				} catch(SQLException ex) {
					System.out.println(ex.getMessage());
				}
				
				refresh();
			}
			
		});
		
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "UPDATE student SET fName = ?, lName = ? WHERE ID = ?";
				try {
					Connection conn = connect();
					PreparedStatement pst = conn.prepareStatement(sql);
					
					pst.setString(1, (textCustomerName.getText()));
					pst.setString(2, (textAddressLine1.getText()));
					pst.setString(3, (textAddressLine2.getText()));
					pst.setString(4, (textAddressLine3.getText()));
					pst.setString(5, (textCity.getText()));
					pst.setString(6, (textProvince.getText()));
					pst.setString(7, (textCountry.getText()));
					pst.setString(8, (textPostalCode.getText()));
					pst.setString(9, (textPhoneNumber.getText()));
					pst.setString(10, (textFaxNumber.getText()));
					pst.setString(11, (textEmailAddress.getText()));
					
					pst.setInt(3, Integer.parseInt(textCustomerId.getText()));
					
					pst.executeUpdate();
					
					pst.close();
					conn.close();
					
				} catch(SQLException ex) {
					System.out.println(ex.getMessage());
				}
				
				refresh();
			}
			
		});
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "INSERT INTO AddressBook  (CustomerName, AddressLine1)";
			}
			
		});
		
		
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
