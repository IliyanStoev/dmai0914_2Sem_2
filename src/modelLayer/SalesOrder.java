package modelLayer;

import java.util.ArrayList;

public class SalesOrder {
	
	private int oid;
	private String date;
	private double ordAmount;
	private String deliveryDate;
	private String deliveryStatus;
	private Customer cust;
	private ArrayList<SalesLine> salesLines;
	
	
	public SalesOrder(int oid) { 
		this.oid = oid;
	}
	
	public SalesOrder() {
		salesLines = new ArrayList<>();
		
	}
	
	
	public int getOid() {
		return oid;
	}
	
	
	public void setOid(int oid) {
		this.oid = oid;
	}
	
	
	public String getDate() {
		return date;
	}
	
	
	public void setDate(String date) {
		this.date = date;
	}
	
	
	public double getOrdAmount() {
		return ordAmount;
	}
	
	
	public void setAmount(double ordAmount) {
		this.ordAmount = ordAmount;
	}
	
	
	public String getDeliveryDate() {
		return deliveryDate;
	}
	
	
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	
	
	public String getDeliveryStatus() {
		return deliveryStatus;
	}
	
	
	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	
	public Customer getCustomer() {
		return cust;
	}
	
	public void setCustomer(Customer cust) {
		this.cust = cust;
	}
	
	public ArrayList<SalesLine> getSalesLines() {
		return salesLines;
	}
	
	public void setSalesLines(ArrayList<SalesLine> salesLines) {
		this.salesLines = salesLines;
	}
}


