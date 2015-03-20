package modelLayer;

public class Clothing extends Product {
	private String size;
	private String color;
	
	public Clothing(String name, double purchasePrice, double salesPrice, String countryOfOrigin, int inStock,
					int minStock,String size, String color) {
		super(name, purchasePrice, salesPrice, countryOfOrigin, inStock, minStock);
		this.size = size;
		this.color = color;
	}
	
	public Clothing() {
		
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}
