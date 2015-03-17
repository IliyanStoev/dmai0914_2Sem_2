package modelLayer;

public class SalesOrder {
	
	private int oid;
	private String date;
	private int ordAmount;
	private String deliveryDate;
	private String deliveryStatus;
	
	
public SalesOrder(int oid) { 
	this.oid = oid;
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


public int getOrdAmount() {
	return ordAmount;
}


public void setAmount(int ordAmount) {
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
}


