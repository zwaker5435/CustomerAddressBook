package customerAddressBook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AddressBook {

	public static void main(String[] args) {
		connect();

	}
	
	public static void connect(){
		Connection conn = null;
		
		try{
			String url="jdbc:sqlite:C:/AddressBook/AddressBook.db";
			conn = DriverManager.getConnection(url);
			
			System.out.println("Successful connection");
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
	}

}
