package modelLayer;

public class Equipment extends Product {
	private String eType;
	private String description;
	
	public Equipment(String name, double purchasePrice, double salesPrice, String countryOfOrigin, int inStock, int minStock,
					String etype, String description) {
		super(name, purchasePrice, salesPrice, countryOfOrigin, inStock, minStock);
		this.eType = etype;
		this.description = description;
	}
	
	public Equipment() {
		
	}

	public String getEtype() {
		return eType;
	}

	public void setEtype(String etype) {
		this.eType = etype;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
