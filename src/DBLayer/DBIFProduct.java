package DBLayer;

import modelLayer.Product;

public interface DBIFProduct {
	public Product findProduct(int pid) ;
	public void updateProduct (Product p, int type);
	public int removeProduct (Product p);
	public int insertProduct (Product p, int type);
}
