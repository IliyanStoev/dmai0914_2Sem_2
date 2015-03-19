package controlLayer;

import modelLayer.*;
import DBLayer.*;

public class ProductCtr {

	public ProductCtr() {
		
	}
	
	public void insertProduct(String name, double purchasePrice, double salePrice, String country, int inStock, int minStock, String type) throws Exception
    {    
         Product prod = new Product();
         prod.setName(name);
         prod.setPurchasePrice(purchasePrice);
         prod.setSalesPrice(salePrice);
         prod.setCountryOfOrigin(country);
         prod.setInStock(inStock);
         prod.setMinStock(minStock);
  
         try{
          DBConnection.startTransaction();
          DBProduct dbProduct = new DBProduct();
          dbProduct.insertProduct(prod, 0);
          DBConnection.commitTransaction();
         }
         catch(Exception e)
         {
             DBConnection.rollbackTransaction();
             throw new Exception("Product not inserted");
         }
    }
}
