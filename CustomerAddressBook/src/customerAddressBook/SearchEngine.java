package customerAddressBook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class SearchEngine extends JFrame {

	private JPanel contentPane;
	static DefaultTableModel model;
	static Object[] row;

	public SearchEngine(String id) {
		setSize(1473, 100);
		setLocationRelativeTo(null);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTable table = new JTable();
		
		Object[] columns = {"CustomerId", "CustomerName", "AddressLine1", "AddressLine2", "AddressLine3", "City", "Province", "Country", "PostalCode", "PhoneNumber", "FaxNumber", "EmailAddress"};
		model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);
				
		table.setModel(model);
				
		table.getColumnModel().getColumn(0).setMinWidth(120);
		table.getColumnModel().getColumn(1).setMinWidth(120);
		table.getColumnModel().getColumn(2).setMinWidth(120);
		table.getColumnModel().getColumn(3).setMinWidth(120);
		table.getColumnModel().getColumn(4).setMinWidth(120);
		table.getColumnModel().getColumn(5).setMinWidth(120);
		table.getColumnModel().getColumn(6).setMinWidth(120);
		table.getColumnModel().getColumn(7).setMinWidth(120);
		table.getColumnModel().getColumn(8).setMinWidth(120);
		table.getColumnModel().getColumn(9).setMinWidth(120);
		table.getColumnModel().getColumn(10).setMinWidth(120);
		table.getColumnModel().getColumn(11).setMinWidth(120);
		
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(8, 8, 1440, 400);
		
		add(pane);
		
		refresh(id);
	}
	
	private Connection connect(){
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
	
	private void refresh(String id){
		row = new Object[12];
		model.setRowCount(0);
		
		String sql = "SELECT CustomerId, CustomerName, AddressLine1, AddressLine2, AddressLine3, City, Province, Country, PostalCode, PhoneNumber, FaxNumber, EmailAddress FROM CustomerAddressBook WHERE CustomerId =";
		
		try{
			Connection conn = connect();
			Statement stat = conn.createStatement();
			
			sql = sql + id;
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				row[0] = rs.getInt("CustomerId");
				row[1] = rs.getString("CustomerName");
				row[2] = rs.getString("AddressLine1");
				row[3] = rs.getString("AddressLine2");
				row[4] = rs.getString("AddressLine3");
				row[5] = rs.getString("City");
				row[6] = rs.getString("Province");
				row[7] = rs.getString("Country");
				row[8] = rs.getString("PostalCode");
				row[9] = rs.getString("PhoneNumber");
				row[10] = rs.getString("FaxNumber");
				row[11] = rs.getString("EmailAddress");
				
				model.addRow(row);
			}
			
			rs.close();
			ps.close();
			stat.close();
			conn.close();
			
			
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		
	}
}
