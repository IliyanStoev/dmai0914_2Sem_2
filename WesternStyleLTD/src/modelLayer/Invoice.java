package modelLayer;

public class Invoice {

	private int invoiceNo;
	private String paymentDate;
	private int inAmount;
	
	
public Invoice(int invoiceNo) {
	this.invoiceNo = invoiceNo;
}


public int getInvoiceNo() {
	return invoiceNo;
}


public void setInvoiceNo(int invoiceNo) {
	this.invoiceNo = invoiceNo;
}


public String getPaymentDate() {
	return paymentDate;
}


public void setPaymentDate(String paymentDate) {
	this.paymentDate = paymentDate;
}


public int getInAmount() {
	return inAmount;
}


public void setInAmount(int inAmount) {
	this.inAmount = inAmount;
}
}
