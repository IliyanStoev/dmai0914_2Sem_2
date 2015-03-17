package modelLayer;

public class GunReplicas extends Product {
	private String fabric;
	private double calibre;
	
	public GunReplicas(String name, double purchasePrice, double salesPrice, String countryOfOrigin, int inStock, int minStock, char type,
						String fabric, double calibre) {
		super(name, purchasePrice, salesPrice, countryOfOrigin, inStock, minStock, type);
		this.fabric = fabric;
		this.calibre = calibre;
	}

	public String getFabric() {
		return fabric;
	}

	public void setFabric(String fabric) {
		this.fabric = fabric;
	}

	public double getCalibre() {
		return calibre;
	}

	public void setCalibre(double calibre) {
		this.calibre = calibre;
	}
	
	
}
