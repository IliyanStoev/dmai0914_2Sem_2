package DBLayer;

import modelLayer.SalesOrder;

public interface DBIFSalesOrder {

	public SalesOrder findSalesOrder(int oid, boolean retrieveAssociation) ;
	public int insertSalesOrder (SalesOrder so);
}
