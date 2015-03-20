package DBLayer;

import modelLayer.SalesOrder;

public interface DBIFSalesOrder {

	public SalesOrder findSalesOrder(int oid, boolean retrieveAssociation) ;
	public int cancelSalesOrder (SalesOrder so);
	public int insertSalesOrder (SalesOrder so);
}
