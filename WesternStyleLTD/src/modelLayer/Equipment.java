package modelLayer;

public class Equipment extends Product {
	private String eType;
	private String description;
	
	public Equipment(String name, double purchasePrice, double salesPrice, String countryOfOrigin, int inStock, int minStock, char type,
					String etype, String description) {
		super(name, purchasePrice, salesPrice, countryOfOrigin, inStock, minStock, type);
		this.eType = etype;
		this.description = description;
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
