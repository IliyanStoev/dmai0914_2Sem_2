package modelLayer;

public class SalesLine {

	private int quantity;
	private Product prod;
	
	public SalesLine(Product prod, int quantity){
		this.prod = prod;
		this.quantity = quantity;
	}
	
	public void setQuantity(int quantity) { 
		this.quantity = quantity;
		
	}
	
	public int getQuantity(){
		return quantity;
	}

	public void setProduct(Product prod) { 
		this.prod = prod;
	}
	
	public Product getProduct(){
		return prod;
	}
}
