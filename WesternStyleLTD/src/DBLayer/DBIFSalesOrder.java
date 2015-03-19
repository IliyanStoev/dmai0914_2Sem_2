package DBLayer;

import modelLayer.SalesOrder;

public interface DBIFSalesOrder {

	public SalesOrder findSalesOrder(int oid, boolean retrieveAssociation) ;
	public void updateSalesOrder (SalesOrder p);
	public int removeSalesOrder (SalesOrder p);
	public int insertSalesOrder (SalesOrder p);
}
