package controlLayer;

import modelLayer.*;
import DBLayer.*;

public class ClothingCtr {

	public void insertClothing(String name, double purchasePrice, double salePrice, String country, int inStock, 
			int minStock, String size, String color) throws Exception
    {    
         Clothing clo = new Clothing();
         clo.setName(name);
         clo.setPurchasePrice(purchasePrice);
         clo.setSalesPrice(salePrice);
         clo.setCountryOfOrigin(country);
         clo.setInStock(inStock);
         clo.setMinStock(minStock);
         clo.setSize(size);
         clo.setColor(color);
  
         try{
          DBConnection.startTransaction();
          DBProduct dbProduct = new DBProduct();
	      dbProduct.insertProduct(clo, 1);
          DBConnection.commitTransaction();
         }
         catch(Exception e)
         {
             DBConnection.rollbackTransaction();
             throw new Exception("Product not inserted");
         }
    }

	public Clothing findClothing(int pid) {
		DBClothing dbClothing = new DBClothing();
		Clothing clo = dbClothing.findClothing(pid);
		
		return clo;
	}
	
	public void updateClothing(String name, double purchasePrice, double salePrice, String country, int inStock, 
			int minStock, String size, String color, int pid) {
		DBIFProduct dbProduct = new DBProduct();
        Clothing clo = new Clothing();
        clo.setName(name);
        clo.setPurchasePrice(purchasePrice);
        clo.setSalesPrice(salePrice);
        clo.setCountryOfOrigin(country);
        clo.setInStock(inStock);
        clo.setMinStock(minStock);
        clo.setSize(size);
        clo.setColor(color);
        clo.setPid(pid);
        dbProduct.updateProduct(clo, 1);
	}

	public void removeClothing(Clothing clo) {
		DBIFClothing dbClothing = new DBClothing();
    	dbClothing.removeClothing(clo);
	}

}
