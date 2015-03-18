package DBLayer;

import java.util.List;
import modelLayer.*;

public interface DBIFCustomer {
	public List<Customer> getAllCustomers();
	public List<Customer> searchCustomer(String name);
	
	public int insertCustomer(Customer c);
	public Customer findCustomer(int cid) ;
	public int updateCustomer(Customer c);
	public int removeCustomer (Customer c);
}
