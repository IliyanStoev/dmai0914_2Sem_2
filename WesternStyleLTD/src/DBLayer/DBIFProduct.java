package DBLayer;

import java.util.List;
import modelLayer.Product;

public interface DBIFProduct {
	public List<Product> getAllProducts(boolean retrieveAssociation);
	public Product findProduct(String name, boolean retrieveAssociation) ;
	public List<Product> searchProduct(String name, boolean retrieveAssociation);
	public int updateProduct (Product p);
	public int removeProduct (Product p);
	public int insertProduct (Product p);
}
