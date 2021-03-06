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

// I hate github
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class CustomerId {
	static Object[] row;
	static DefaultTableModel model;

	public CustomerId(){
		JFrame frame = new JFrame();
		JTable table = new JTable();
	
		Object[] columns = {"ContactId", "FirstName", "LastName", "AddressLine1", "AddressLine2", "AddressLine3", "City", "Province", "Country", "PostalCode", "PhoneNumber", "FaxNumber", "EmailAddress"};
		model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		
		table.setModel(model);
		
		//set column titles size
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
		table.getColumnModel().getColumn(12).setMinWidth(140);
		
		JTextField textContactId = new JTextField();
		JTextField textFirstName = new JTextField();
		JTextField textLastName = new JTextField();
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

		JLabel ContactId = new JLabel();
		JLabel FirstName = new JLabel();
		JLabel LastName = new JLabel();
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
		
		JLabel FirstNameError = new JLabel();
		JLabel LastNameError = new JLabel();
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
		
		JButton btnAdd = new JButton();
		JButton btnDelete = new JButton();
		JButton btnEdit = new JButton();
		
		btnAdd.setText("Add");
		btnDelete.setText("Delete");
		btnEdit.setText("Edit");
		
		ContactId.setText("CustomerId");
		FirstName.setText("FirstName");
		LastName.setText("LastName");
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
		
		textContactId.setBounds(20, 435, 100, 25);
		textFirstName.setBounds(140, 435, 100, 25);
		textLastName.setBounds(260, 435, 100, 25);
		textAddressLine1.setBounds(380, 435, 100, 25);
		textAddressLine2.setBounds(500, 435, 100, 25);
		textAddressLine3.setBounds(620, 435, 100, 25);
		textCity.setBounds(740, 435, 100, 25);
		textProvince.setBounds(860, 435, 100, 25);
		textCountry.setBounds(980, 435, 100, 25);
		textPostalCode.setBounds(1100, 435, 100, 25);
		textPhoneNumber.setBounds(1220, 435, 100, 25);
		textFaxNumber.setBounds(1340, 435, 100, 25);
		textEmailAddress.setBounds(1460, 435, 100, 25);
		
		FirstNameError.setBounds(140, 460, 100, 50);
		LastNameError.setBounds(260, 460, 100, 50);
		AddressLine1Error.setBounds(380, 460, 100, 50);
		AddressLine2Error.setBounds(500, 460, 100, 50);
		AddressLine3Error.setBounds(620, 460, 100, 50);
		CityError.setBounds(740, 460, 100, 50);
		ProvinceError.setBounds(860, 460, 100, 25);
		CountryError.setBounds(980, 460, 100, 25);
		PostalCodeError.setBounds(1100, 460, 100, 25);
		PhoneNumberError.setBounds(1220, 460, 100, 25);
		FaxNumberError.setBounds(1340, 460, 100, 25);
		EmailAddressError.setBounds(1460, 460, 100, 25);
		
		ContactId.setBounds(20, 405, 100, 25);
		FirstName.setBounds(140, 405, 100, 25);
		LastName.setBounds(260, 405, 100, 25);
		AddressLine1.setBounds(380, 405, 100, 25);
		AddressLine2.setBounds(500, 405, 100, 25);
		AddressLine3.setBounds(620, 405, 100, 25);
		City.setBounds(740, 405, 100, 25);
		Province.setBounds(860, 405, 100, 25);
		Country.setBounds(980, 405, 100, 25);
		PostalCode.setBounds(1100, 405, 100, 25);
		PhoneNumber.setBounds(1220, 405, 100, 25);
		FaxNumber.setBounds(1340, 405, 100, 25);
		EmailAddress.setBounds(1460, 405, 100, 25);
		
		btnAdd.setBounds(20, 515, 75, 25);
		btnDelete.setBounds(140, 515, 75, 25);
		btnEdit.setBounds(260, 515, 75, 25);
		
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(8, 8, 1580, 400);
		
		frame.setLayout(null);
		
		frame.add(pane);
		
		frame.add(textContactId);
		frame.add(textFirstName);
		frame.add(textLastName);
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
		
		frame.add(ContactId);
		frame.add(FirstName);
		frame.add(LastName);
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
		
		frame.add(FirstNameError);
		frame.add(LastNameError);
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
		
		frame.add(btnAdd);
		frame.add(btnDelete);
		frame.add(btnEdit);
		
		refresh();
		
		table.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				
				textContactId.setText(model.getValueAt(i, 0).toString());	
				textFirstName.setText(model.getValueAt(i, 1).toString());
				textLastName.setText(model.getValueAt(i, 2).toString());
				textAddressLine1.setText(model.getValueAt(i, 3).toString());
				textAddressLine2.setText(model.getValueAt(i, 4).toString());
				textAddressLine3.setText(model.getValueAt(i, 5).toString());
				textCity.setText(model.getValueAt(i, 6).toString());
				textProvince.setText(model.getValueAt(i, 7).toString());
				textCountry.setText(model.getValueAt(i, 8).toString());
				textPostalCode.setText(model.getValueAt(i, 9).toString());
				textPhoneNumber.setText(model.getValueAt(i, 10).toString());
				textFaxNumber.setText(model.getValueAt(i, 11).toString());
				textEmailAddress.setText(model.getValueAt(i, 12).toString());
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "INSERT INTO ContactTable (FirstName, LastName, AddressLine1, AddressLine2, AddressLine3, City, Province, Country, PostalCode, PhoneNumber, FaxNumber, EmailAddress) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				
				String firstName, lastName, address1, address2, address3, city, province, country, postalcode, phone, fax, email;
				boolean[] error = new boolean[13];
				
				FirstNameError.setText("");
				LastNameError.setText("");
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
				
				firstName = textFirstName.getText();
				lastName = textLastName.getText();
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
				
				for(int i=0;i<error.length;i++) {
					error[i] = true;
				}
				
				if(firstName.length()<=30){
					error[0]=true;
				}else{
					FirstNameError.setText("<html><font color='red'>Must be less than 31 characters</font></html>");
					error[0]=false;
				}
				
				if(lastName.length()<=30){
					error[1]=true;
				}else{
					LastNameError.setText("<html><font color='red'>Must be less than 31 characters</font></html>");
					error[1]=false;
				}
				
				if(address1.length()<=30){
					error[1]=true;
				}else{
					AddressLine1Error.setText("<html><font color='red'>Must be less than 31 characters</font></html>");
					error[1]=false;
				}

				if(address2.length()<=30){
					error[2]=true;
				}else{
					AddressLine2Error.setText("<html><font color='red'>Must be less than 31 characters</font></html>");
					error[2]=false;
				}

				if(address3.length()<=30){
					error[3]=true;
				}else{
					AddressLine3Error.setText("<html><font color='red'>Must be less than 31 characters</font></html>");
					error[3]=false;
				}

				if(city.length()<=30){
					error[4]=true;
				}else{
					CityError.setText("<html><font color='red'>Must be less than 31 characters</font></html>");
					error[4]=false;
				}

				if(province.length()<=20){
					error[5]=true;
				}else{
					ProvinceError.setText("<html><font color='red'>Must be less than 21 characters</font></html>");
					error[5]=false;
				}
				
				if(country.length()<=36){
					error[6]=true;
				}else{
					CountryError.setText("<html><font color='red'>Must be less than 37 characters</font></html>");
					error[6]=false;
				}

				if(postalcode.length()<=6){
					error[7]=true;
				}else{
					PostalCodeError.setText("<html><font color='red'>6 digits only</font></html>");
					error[7]=false;
				}
				
				if(phone.length()==10){
					error[8]=true;
				}else{
					PhoneNumberError.setText("<html><font color='red'>10 digits only</font></html>");
					error[8]=false;
				}
				
				if(fax.length()==10 || fax.length()==11){
					error[9]=true;
				}else{
					FaxNumberError.setText("<html><font color='red'>10 or 11 digits</font></html>");
					error[9]=false;
				}
				
				if(email.indexOf('@')!=-1){
					error[10]=true;
				}else{
					error[10]=false;
					EmailAddressError.setText("<html><font color='red'>You need an @</font></html>");
				}
				
				//Checks if any are false
				for(int i=0;i<error.length;i++){
					if(error[i]==false){
						error[12]=false;
					}
				}
				
				if(error[12]==true){
					try {
						Connection conn = connect();
						PreparedStatement pst = conn.prepareStatement(sql);
						
						pst.setString(1, textFirstName.getText());
						pst.setString(2, textLastName.getText());
						pst.setString(3, textAddressLine1.getText());
						pst.setString(4, textAddressLine2.getText());
						pst.setString(5, textAddressLine3.getText());
						pst.setString(6, textCity.getText());
						pst.setString(7, textProvince.getText());
						pst.setString(8, textCountry.getText());
						pst.setString(9, textPostalCode.getText());
						pst.setString(10, textPhoneNumber.getText());
						pst.setString(11, textFaxNumber.getText());
						pst.setString(12, textEmailAddress.getText());
						
						pst.executeUpdate();
						
						pst.close();
						conn.close();
						
						FirstNameError.setText("");
						LastNameError.setText("");
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
				String sql = "DELETE FROM ContactTable WHERE ContactId = ?";
				
				try {
					Connection conn = connect();
					PreparedStatement pst = conn.prepareStatement(sql);
					
					pst.setInt(1, Integer.parseInt(textContactId.getText()));
					
					pst.executeUpdate();
					
					pst.close();
					conn.close();
					
				} catch(SQLException ex) {
					System.out.println(ex.getMessage());
				}
				
				refresh();
			}
			
		});
		
		btnEdit.addActionListener(new ActionListener() {//13 ? 12 things to fill them
			public void actionPerformed(ActionEvent e) {
				String sql = "UPDATE ContactTable SET FirstName = ?, LastName = ?, AddressLine1 = ?, AddressLine2 = ?, AddressLine3 = ?, City = ?, Province = ?, Country = ?, PostalCode = ?, PhoneNumber = ?, FaxNumber = ?, EmailAddress = ? WHERE ContactId = ?";
				
				FirstNameError.setText("");
				LastNameError.setText("");
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
				
				String firstName, lastName, address1, address2, address3, city, province, country, postalcode, phone, fax, email;
				boolean[] error = new boolean[13];
			
				firstName = textFirstName.getText();
				lastName = textLastName.getText();
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
				
				for(int i=0;i<error.length;i++) {
					error[i] = true;
				}
				
				if(firstName.length()<=30){
					error[0]=true;
				}else{
					FirstNameError.setText("<html><font color='red'>Must be less than 31 characters</font></html>");
					error[0]=false;
				}
				
				if(lastName.length()<=30){
					error[1]=true;
				}else{
					LastNameError.setText("<html><font color='red'>Must be less than 31 characters</font></html>");
					error[1]=false;
				}
				
				if(address1.length()<=30){
					error[2]=true;
				}else{
					AddressLine1Error.setText("<html><font color='red'>Must be less than 31 characters</font></html>");
					error[2]=false;
				}

				if(address2.length()<=30){
					error[3]=true;
				}else{
					AddressLine2Error.setText("<html><font color='red'>Must be less than 31 characters</font></html>");
					error[3]=false;
				}

				if(address3.length()<=30){
					error[4]=true;
				}else{
					AddressLine3Error.setText("<html><font color='red'>Must be less than 31 characters</font></html>");
					error[4]=false;
				}

				if(city.length()<=30){
					error[5]=true;
				}else{
					CityError.setText("<html><font color='red'>Must be less than 31 characters</font></html>");
					error[5]=false;
				}

				if(province.length()<=20){
					error[6]=true;
				}else{
					ProvinceError.setText("<html><font color='red'>Must be less than 21 characters</font></html>");
					error[6]=false;
				}
				
				if(country.length()<=36){
					error[7]=true;
				}else{
					CountryError.setText("<html><font color='red'>Must be less than 36 characters</font></html>");
					error[7]=false;
				}

				if(postalcode.length()<=6){
					error[8]=true;
				}else{
					PostalCodeError.setText("<html><font color='red'>6 digits only</font></html>");
					error[8]=false;
				}
				
				if(phone.length()==10){
					error[9]=true;
				}else{
					PhoneNumberError.setText("<html><font color='red'>10 digits only</font></html>");
					error[9]=false;
				}
				
				if(fax.length()==10 || fax.length()==11){
					error[10]=true;
				}else{
					FaxNumberError.setText("<html><font color='red'>10 or 11 digits</font></html>");
					error[10]=false;
				}
				
				if(email.indexOf('@')!=-1){
					error[11]=true;
				}else{
					error[11]=false;
					EmailAddressError.setText("<html><font color='red'>You need an @</font></html>");
				}
				
				//Checks if any are false
				for(int i=0;i<error.length;i++){
					if(error[i] == false){
						error[12]=false;
					}
				}
				
				if(error[11]==true){
					try {
						Connection conn = connect();
						PreparedStatement pst = conn.prepareStatement(sql);
						
						
						pst.setString(1, textAddressLine1.getText());
						pst.setString(2, textAddressLine2.getText());
						pst.setString(3, textAddressLine3.getText());
						pst.setString(4, textCity.getText());
						pst.setString(5, textProvince.getText());
						pst.setString(6, textCountry.getText());
						pst.setString(7, textPostalCode.getText());
						pst.setString(8, textPhoneNumber.getText());
						pst.setString(9, textFaxNumber.getText());
						pst.setString(10, textEmailAddress.getText());
						
						pst.setInt(11, Integer.parseInt(textContactId.getText()));
						
						pst.executeUpdate();
						
						pst.close();
						conn.close();
						
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
		
		frame.setSize(1612, 600);
		frame.setLocationRelativeTo(null);
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
		row = new Object[13];
		model.setRowCount(0);
		
		String sql = "SELECT ContactId, FirstName, LastName, AddressLine1, AddressLine2, AddressLine3, City, Province, Country, PostalCode, PhoneNumber, FaxNumber, EmailAddress FROM ContactTable";
		
		try{
			Connection conn = connect();
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()){
				row[0] = rs.getInt("ContactId");
				row[1] = rs.getString("FirstName");
				row[2] = rs.getString("LastName");
				row[3] = rs.getString("AddressLine1");
				row[4] = rs.getString("AddressLine2");
				row[5] = rs.getString("AddressLine3");
				row[6] = rs.getString("City");
				row[7] = rs.getString("Province");
				row[8] = rs.getString("Country");
				row[9] = rs.getString("PostalCode");
				row[10] = rs.getString("PhoneNumber");
				row[11] = rs.getString("FaxNumber");
				row[12] = rs.getString("EmailAddress");
				
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
