package controlLayer;

import modelLayer.*;
import DBLayer.*;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import DBLayer.*;

public class SalesOrderCtr {

	public void insertSalesOrder(Customer cust, ArrayList<SalesLine> salesLines, String date, double total) throws Exception{
		SalesOrder so = new SalesOrder();
		so.setCustomer(cust);
		so.setSalesLines(salesLines);
		so.setDate(date);
		so.setDeliveryStatus("Registered");
		so.setDeliveryDate("+4 DAYS");
		so.setAmount(total);
		
		try{
          DBConnection.startTransaction();
          DBSalesOrder dbSalesOrder = new DBSalesOrder();
          dbSalesOrder.insertSalesOrder(so);
          DBConnection.commitTransaction();
         }
         catch(Exception e)
         {
             DBConnection.rollbackTransaction();
             throw new Exception("Order not registered");
         }
	}
	
	public SalesOrder findSalesOrder(int oid) {
		DBSalesOrder dbSalesOrder = new DBSalesOrder();
		SalesOrder so = dbSalesOrder.findSalesOrder(oid, true);
		return so;
	}
	
	public void changeDeliveryStatus(SalesOrder so) {
	      DBSalesOrder dbSalesOrder = new DBSalesOrder();
		  dbSalesOrder.changeDeliveryStatus(so);
	}
	
	public void updateInStockAmount(Product prod, int amount) {
		DBSalesOrder dbSalesOrder = new DBSalesOrder();
		dbSalesOrder.updateInStockAmount(prod, amount);
	}
	
	
	
	public void removeSalesOrder(SalesOrder so) {
		
	}
	
	public Customer findCustomer(int cid) {
		Customer cust = new Customer();
		CustomerCtr custCtr = new CustomerCtr();
		cust = custCtr.findByCid(cid);
		return cust;
	}
	
	public Product findProduct(int pid) {
		Product prod = new Product();
		ProductCtr prodCtr = new ProductCtr();
		prod = prodCtr.findProduct(pid) ;
		return prod;
	}
	
	public SalesLine createSalesLine(Product prod, int quantity) {
		ProductCtr prodCtr = new ProductCtr();
		SalesLine sl = prodCtr.createSalesLine(prod, quantity);
		return sl;
	}
}
