package databaseTestingCrudMethodAug;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class mycrudMethods {

	Connection con = null;

	java.sql.Statement stm = null;

	ResultSet rs;

	@BeforeTest

	public void myBeforeTest() throws SQLException {

		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "abed");
	}

	@Test(enabled = false)
	public void InsertData() throws SQLException {
		stm = con.createStatement();

		String myQuery = "INSERT INTO customers (customerNumber, customerName, contactLastName, contactFirstName, phone, addressLine1, city, country) "
				+ "VALUES (5581, 'Mohammad Ahmad', 'Ahmad', 'Mohammad', 079778882, 'Tlaaalali', 'Amman', 'Jordan')";

		int rowEffected = stm.executeUpdate(myQuery);
		if (rowEffected > 0) {
			System.out.println("query is done");
		} else {
			System.out.println("query is failed ");
		}

	}

	@Test(enabled = false)
	public void updateQuery() throws SQLException {
		stm = con.createStatement();

		String myQuery = "UPDATE customers SET customerName = 'sawsn Omar' WHERE customerNumber = 119";

		int rowEffected = stm.executeUpdate(myQuery);

		Assert.assertEquals(rowEffected > 0, true, "sorry the update has a problem");

	}
	
	@Test(enabled = false)
	public void readTheData() throws SQLException {
		stm = con.createStatement();
		String myQuery = "select * from customers where customerNumber= 5581"; 
		
		rs=stm.executeQuery(myQuery);
		
		while (rs.next()) {
			String thecustomerName = rs.getString("customerName");
			String CustomerCity = rs.getString("city");
			
			String customerLastName = rs.getString("contactLastName");
			
			System.out.println(thecustomerName);
			System.out.println(CustomerCity);

			System.out.println(customerLastName);
			
			Assert.assertEquals(customerLastName, "abuhmaid");


		}
		

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Test()
	public void DeleteQuery() throws SQLException {
		stm = con.createStatement();

		String myQuery = "delete from customers where customerName='sawsn Omar' and customerNumber = 5588";

		int rowEffected = stm.executeUpdate(myQuery);

		Assert.assertEquals(rowEffected > 0, true, "sorry the delete has a problem");

	}
	
	
	
	
	
	
	

}
