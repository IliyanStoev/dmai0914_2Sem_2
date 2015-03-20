package DBLayer;

import static org.junit.Assert.*;

import org.junit.Test;
import modelLayer.*;


public class DBCustomerTest {

	@Test
	public void testInsertCustomer() {
		DBCustomer dbcust = new DBCustomer();
		Customer cust = new Customer();
		cust.setName("Boril");
		cust.setAddress("Bispensgade");
		cust.setZipCode(9000);
		cust.setCity("Aalborg");
		cust.setPhoneNo("23232323");
		cust.setEmail("boril@yahoo.com");
		
		dbcust.insertCustomer(cust);
	}
	
	@Test
	public void testFailInsertCustomer() {
		DBCustomer dbcust = new DBCustomer();
		Customer cust = new Customer();
		cust.setName("Boril");
		cust.setAddress("Bispensgade");
		cust.setZipCode("9000");
		cust.setCity("Aalborg");
		cust.setPhoneNo("23232323");
		cust.setEmail("boril@yahoo.com");
		
		dbcust.insertCustomer(cust);
	}

}
