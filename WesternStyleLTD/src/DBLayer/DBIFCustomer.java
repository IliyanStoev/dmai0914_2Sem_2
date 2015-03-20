package DBLayer;

import modelLayer.*;

public interface DBIFCustomer {	
	public int insertCustomer(Customer c);
	public Customer findCustomer(int cid) ;
	public int updateCustomer(Customer c);
	public int removeCustomer (Customer c);
}
