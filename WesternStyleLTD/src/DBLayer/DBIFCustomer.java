package DBLayer;

import java.util.List;
import modelLayer.*;

public interface DBIFCustomer {
	public List<Customer> getAllCustomers(boolean retrieveAssociation);
	public Customer findCustomer(int cid, boolean retrieveAssociation) ;
	public List<Customer> searchCustomer(String name, boolean retrieveAssociation);
	public int updateCustomer(Customer c);
	public int removeCustomer (Customer c);
	public int insertCustomer(Customer c);
	
}
