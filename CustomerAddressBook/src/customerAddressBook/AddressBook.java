package customerAddressBook;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
		
		//search fields
		JTextField textIdSearch = new JTextField();
		JLabel IdSearch = new JLabel();
		
		//text field labels
		JLabel CustomerId = new JLabel();
		JLabel CustomerName = new JLabel();
		JLabel AddressLine1 = new JLabel();
		JLabel AddressLine2 = new JLabel();
		JLabel AddressLine3 = new JLabel();
		JLabel City = new JLabel();
		JLabel Province = new JLabel();
		JLabel Country = new JLabel();
		JLabel PostalCode = new JLabel();
		JLabel PhoneNumber = new JLabel();
		JLabel FaxNumber = new JLabel();
		JLabel EmailAddress = new JLabel();
		
		// Error JLabels
		JLabel CustomerIdError = new JLabel();
		JLabel CustomerNameError = new JLabel();
		JLabel AddressLine1Error = new JLabel();
		JLabel AddressLine2Error = new JLabel();
		JLabel AddressLine3Error = new JLabel();
		JLabel CityError = new JLabel();
		JLabel ProvinceError = new JLabel();
		JLabel CountryError = new JLabel();
		JLabel PostalCodeError = new JLabel();
		JLabel PhoneNumberError = new JLabel();
		JLabel FaxNumberError = new JLabel();
		JLabel EmailAddressError = new JLabel();
		
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
		
		//name text field labels
		/**
		CustomerIdError.setText("There is problem.");
		CustomerNameError.setText("There is problem.");
		AddressLine1Error.setText("There is problem.");
		AddressLine2Error.setText("There is problem.");
		AddressLine3Error.setText("There is problem.");
		CityError.setText("There is problem.");
		ProvinceError.setText("There is problem.");
		CountryError.setText("There is problem.");
		PostalCodeError.setText("There is problem.");
		PhoneNumberError.setText("There is problem.");
		FaxNumberError.setText("There is problem.");
		EmailAddressError.setText("There is problem.");
		**/
		//name IdSearch
		
		IdSearch.setText("Id:");
		//set text fields
		textCustomerId.setBounds(20, 805, 100, 25);
		textCustomerName.setBounds(140, 805, 100, 25);
		textAddressLine1.setBounds(260, 805, 100, 25);
		textAddressLine2.setBounds(380, 805, 100, 25);
		textAddressLine3.setBounds(500, 805, 100, 25);
		textCity.setBounds(620, 805, 100, 25);
		textProvince.setBounds(740, 805, 100, 25);
		textCountry.setBounds(860, 805, 100, 25);
		textPostalCode.setBounds(980, 805, 100, 25);
		textPhoneNumber.setBounds(1100, 805, 100, 25);
		textFaxNumber.setBounds(1220, 805, 100, 25);
		textEmailAddress.setBounds(1340, 805, 100, 25);
		
		//set text field errors
		CustomerIdError.setBounds(20, 850, 100, 25);
		CustomerNameError.setBounds(140, 850, 100, 25);
		AddressLine1Error.setBounds(260, 850, 100, 25);
		AddressLine2Error.setBounds(380, 850, 100, 25);
		AddressLine3Error.setBounds(500, 850, 100, 25);
		CityError.setBounds(620, 850, 100, 25);
		ProvinceError.setBounds(740, 850, 100, 25);
		CountryError.setBounds(860, 850, 100, 25);
		PostalCodeError.setBounds(980, 850, 100, 25);
		PhoneNumberError.setBounds(1100, 850, 100, 25);
		FaxNumberError.setBounds(1220, 850, 100, 25);
		EmailAddressError.setBounds(1340, 850, 100, 25);
		
		//set search fields
		textIdSearch.setBounds(530, 895, 75, 25);
		IdSearch.setBounds(500, 895, 20, 25);
		
		//set text field labels
		CustomerId.setBounds(20, 755, 100, 25);
		CustomerName.setBounds(140, 755, 100, 25);
		AddressLine1.setBounds(260, 755, 100, 25);
		AddressLine2.setBounds(380, 755, 100, 25);
		AddressLine3.setBounds(500, 755, 100, 25);
		City.setBounds(620, 755, 100, 25);
		Province.setBounds(740, 755, 100, 25);
		Country.setBounds(860, 755, 100, 25);
		PostalCode.setBounds(980, 755, 100, 25);
		PhoneNumber.setBounds(1100, 755, 100, 25);
		FaxNumber.setBounds(1220, 755, 100, 25);
		EmailAddress.setBounds(1340, 755, 100, 25);
		
		//set buttons
		btnAdd.setBounds(20, 895, 75, 25);
		btnDelete.setBounds(140, 895, 75, 25);
		btnEdit.setBounds(260, 895, 75, 25);
		btnSearch.setBounds(380, 895, 75, 25);
		
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(8, 8, 1440, 400);
		
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
		
		frame.add(CustomerId);
		frame.add(CustomerName);
		frame.add(AddressLine1);
		frame.add(AddressLine2);
		frame.add(AddressLine3);
		frame.add(City);
		frame.add(Province);
		frame.add(Country);
		frame.add(PostalCode);
		frame.add(PhoneNumber);
		frame.add(FaxNumber);
		frame.add(EmailAddress);
		
		frame.add(CustomerIdError);
		frame.add(CustomerNameError);
		frame.add(AddressLine1Error);
		frame.add(AddressLine2Error);
		frame.add(AddressLine3Error);
		frame.add(CityError);
		frame.add(ProvinceError);
		frame.add(CountryError);
		frame.add(PostalCodeError);
		frame.add(PhoneNumberError);
		frame.add(FaxNumberError);
		frame.add(EmailAddressError);
		
		frame.add(textIdSearch);
		frame.add(IdSearch);
		
		frame.add(btnAdd);
		frame.add(btnDelete);
		frame.add(btnEdit);
		frame.add(btnSearch);
		
		refresh();
		
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
				String sql = "INSERT INTO CustomerAddressBook (CustomerName, AddressLine1, AddressLine2, AddressLine3, City, Province, Country, PostalCode, PhoneNumber, FaxNumber, EmailAddress) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				String name, address1, address2, address3, city, province, country, postalcode, phone, fax, email;
				boolean[] error = new boolean[12]; 
				
				name = textCustomerName.getText();
				address1 = textAddressLine1.getText();
				address2 = textAddressLine2.getText();
				address3 = textAddressLine3.getText();
				city = textCity.getText();
				province = textProvince.getText();
				country = textCountry.getText();
				postalcode = textPostalCode.getText();
				phone = textPhoneNumber.getText();
				fax = textFaxNumber.getText();
				email = textEmailAddress.getText();
				
				if(name.length()<=30){
					error[0]=true;
				}else{
					CustomerNameError.setText("There is problem.");
					error[0]=false;
				}
				
				if(address1.length()<=30){
					error[1]=true;
				}else{
					AddressLine1Error.setText("There is problem.");
					error[1]=false;
				}

				if(address2.length()<=30){
					error[2]=true;
				}else{
					AddressLine2Error.setText("There is problem.");
					error[2]=false;
				}

				if(address3.length()<=30){
					error[3]=true;
				}else{
					AddressLine3Error.setText("There is problem.");
					error[3]=false;
				}

				if(city.length()<=30){
					error[4]=true;
				}else{
					CityError.setText("There is problem.");
					error[4]=false;
				}

				if(province.length()<=20){
					error[5]=true;
				}else{
					ProvinceError.setText("There is problem.");
					error[5]=false;
				}
				
				if(country.length()<=36){
					error[6]=true;
				}else{
					CountryError.setText("There is problem.");
					error[6]=false;
				}

				if(postalcode.length()<=6){
					error[7]=true;
				}else{
					PostalCodeError.setText("There is problem.");
					error[7]=false;
				}
				
				if(phone.length()==10){
					error[8]=true;
				}else{
					PhoneNumberError.setText("10 numbers only");
					error[8]=false;
				}
				
				if(fax.length()==10 || fax.length()==11){
					error[9]=true;
				}else{
					FaxNumberError.setText("10 or 11 numbers only");
					error[9]=false;
				}
				
				if(email.indexOf('@')==1){
					error[10]=true;
				}else{
					EmailAddressError.setText("There is problem.");
					error[10]=false;
					EmailAddressError.setText("There must be an @");
				}
				
				//Checks if any are false
				for(int i=0;i<error.length;i++){
					if(error[i]=false){
						error[11]=false;
					}
				}
				
				if(error[11]==true){
					try {
						Connection conn = connect();
						PreparedStatement pst = conn.prepareStatement(sql);
						
						pst.setString(1, textCustomerName.getText());
						pst.setString(2, textAddressLine1.getText());
						pst.setString(3, textAddressLine2.getText());
						pst.setString(4, textAddressLine3.getText());
						pst.setString(5, textCity.getText());
						pst.setString(6, textProvince.getText());
						pst.setString(7, textCountry.getText());
						pst.setString(8, textPostalCode.getText());
						pst.setString(9, textPhoneNumber.getText());
						pst.setString(10, textFaxNumber.getText());
						pst.setString(11, textEmailAddress.getText());
						
						pst.executeUpdate();
						
						pst.close();
						conn.close();
						
						CustomerIdError.setText("");
						CustomerNameError.setText("");
						AddressLine1Error.setText("");
						AddressLine2Error.setText("");
						AddressLine3Error.setText("");
						CityError.setText("");
						ProvinceError.setText("");
						CountryError.setText("");
						PostalCodeError.setText("");
						PhoneNumberError.setText("");
						FaxNumberError.setText("");
						EmailAddressError.setText("");
						
					} catch(SQLException ex) {
						System.out.println(ex.getMessage());
					}
					
					refresh();
				}
			}
			
		});
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "DELETE FROM CustomerAddressBook WHERE CustomerId = ?";
				
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
				String sql = "UPDATE CustomerAddressBook SET CustomerName = ?, AddressLine1 = ?, AddressLine2 = ?, AddressLine3 = ?, City = ?, Province = ?, Country = ?, PostalCode = ?, PhoneNumber = ?, FaxNumber = ?, EmailAddress = ? WHERE CustomerId = ?";
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
					
					pst.setInt(12, Integer.parseInt(textCustomerId.getText()));
					
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
				String id;
				String sql = "INSERT INTO CustomerAddressBook  (CustomerName, AddressLine1, AddressLine2, AddressLine3, City, Province, Country, PostalCode, PhoneNumber, FaxNumber, EmailAddress)";
				id = textIdSearch.getText();
				SearchEngine search = new SearchEngine(id);
			}
			
		});
		
		frame.setSize(2000, 1000);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
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
	
	private void refresh(){
		row = new Object[12];
		model.setRowCount(0);
		
		String sql = "SELECT CustomerId, CustomerName, AddressLine1, AddressLine2, AddressLine3, City, Province, Country, PostalCode, PhoneNumber, FaxNumber, EmailAddress FROM CustomerAddressBook";
		
		try{
			Connection conn = connect();
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			
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
			stat.close();
			conn.close();
			
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		
	}
	
}
