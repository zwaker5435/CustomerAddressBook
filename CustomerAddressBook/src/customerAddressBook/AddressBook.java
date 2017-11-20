package customerAddressBook;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AddressBook {
	static Object[] row;
	static DefaultTableModel model;

	
	public AddressBook(){
		JFrame frame = new JFrame();
		JTable table = new JTable();
		
		
		//creates a table model and sets column headings
		Object[] columns = {"CustomerId", "CustomerName", "AddressLine1", "AddressLine2", "AddressLine3", "City", "Province", "Country", "PostalCode", "PhoneNumber", "FaxNumber", "EmailAddress"};
		model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		
		table.setModel(model);
		
		//set column titles
		table.getColumnModel().getColumn(0).setMinWidth(100);
		table.getColumnModel().getColumn(1).setMinWidth(100);
		table.getColumnModel().getColumn(2).setMinWidth(100);
		table.getColumnModel().getColumn(3).setMinWidth(100);
		table.getColumnModel().getColumn(4).setMinWidth(100);
		table.getColumnModel().getColumn(5).setMinWidth(100);
		table.getColumnModel().getColumn(6).setMinWidth(100);
		table.getColumnModel().getColumn(7).setMinWidth(100);
		table.getColumnModel().getColumn(8).setMinWidth(100);
		table.getColumnModel().getColumn(9).setMinWidth(100);
		table.getColumnModel().getColumn(10).setMinWidth(100);
		table.getColumnModel().getColumn(11).setMinWidth(100);
		
		//text fields
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
		
		//text field labels
		JTextField CustomerId = new JTextField();
		JTextField CustomerName = new JTextField();
		JTextField AddressLine1 = new JTextField();
		JTextField AddressLine2 = new JTextField();
		JTextField AddressLine3 = new JTextField();
		JTextField City = new JTextField();
		JTextField Province = new JTextField();
		JTextField Country = new JTextField();
		JTextField PostalCode = new JTextField();
		JTextField PhoneNumber = new JTextField();
		JTextField FaxNumber = new JTextField();
		JTextField EmailAddress = new JTextField();
		
		//buttons
		JButton btnAdd = new JButton();
		JButton btnDelete = new JButton();
		JButton btnEdit = new JButton();
		JButton btnSearch = new JButton();
		
		//name buttons
		btnAdd.setText("Add");
		btnDelete.setText("Delete");
		btnEdit.setText("Edit");
		btnSearch.setText("Search");
		
		//name text field labels
		CustomerId.setText("CustomerId");
		CustomerName.setText("CustomerName");
		AddressLine1.setText("AddressLine1");
		AddressLine2.setText("AddressLine2");
		AddressLine3.setText("AddressLine3");
		City.setText("City");
		Province.setText("Province");
		Country.setText("Country");
		PostalCode.setText("PostalCode");
		PhoneNumber.setText("PhoneNumber");
		FaxNumber.setText("FaxNumber");
		EmailAddress.setText("EmailAddress");
		
		//set text fields
		textCustomerId.setBounds(990, 20, 100, 25);
		textCustomerName.setBounds(990, 80, 100, 25);
		textAddressLine1.setBounds(990, 140, 100, 25);
		textAddressLine2.setBounds(990, 200, 100, 25);
		textAddressLine3.setBounds(990, 260, 100, 25);
		textCity.setBounds(990, 320, 100, 25);
		textProvince.setBounds(990, 380, 100, 25);
		textCountry.setBounds(990, 440, 100, 25);
		textPostalCode.setBounds(990, 500, 100, 25);
		textPhoneNumber.setBounds(990, 560, 100, 25);
		textFaxNumber.setBounds(990, 620, 100, 25);
		textEmailAddress.setBounds(990, 680, 100, 25);
		
		//set text field labels
		CustomerId.setBounds(890, 20, 100, 25);
		CustomerName.setBounds(890, 80, 100, 25);
		AddressLine1.setBounds(890, 140, 100, 25);
		AddressLine2.setBounds(890, 200, 100, 25);
		AddressLine3.setBounds(890, 260, 100, 25);
		City.setBounds(890, 320, 100, 25);
		Province.setBounds(890, 380, 100, 25);
		Country.setBounds(890, 440, 100, 25);
		PostalCode.setBounds(890, 500, 100, 25);
		PhoneNumber.setBounds(890, 560, 100, 25);
		FaxNumber.setBounds(890, 620, 100, 25);
		EmailAddress.setBounds(890, 680, 100, 25);
		
		btnAdd.setBounds(1100, 20, 75, 25);
		btnDelete.setBounds(1100, 70, 75, 25);
		btnEdit.setBounds(1100, 120, 75, 25);
		btnSearch.setBounds(1100, 170, 75, 25);
		
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(8, 8, 1200, 200);
		
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
		
		
		table.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				
				textCustomerId.setText(model.getValueAt(i, 0).toString());	
				textCustomerName.setText(model.getValueAt(i, 1).toString());
				textAddressLine1.setText(model.getValueAt(i, 2).toString());
				textAddressLine2.setText(model.getValueAt(i, 3).toString());
				textAddressLine3.setText(model.getValueAt(i, 4).toString());
				textCity.setText(model.getValueAt(i, 5).toString());
				textProvince.setText(model.getValueAt(i, 6).toString());
				textCountry.setText(model.getValueAt(i, 7).toString());
				textPostalCode.setText(model.getValueAt(i, 8).toString());
				textPhoneNumber.setText(model.getValueAt(i, 9).toString());
				textFaxNumber.setText(model.getValueAt(i, 10).toString());
				textEmailAddress.setText(model.getValueAt(i, 11).toString());
			}
		});
		
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
		
		frame.setSize(2000, 1000);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
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
