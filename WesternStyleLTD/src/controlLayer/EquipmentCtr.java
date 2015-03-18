package controlLayer;

import modelLayer.*;
import DBLayer.*;

public class EquipmentCtr {

	public void insertEquipment(String name, double purchasePrice, double salePrice, String country, int inStock, 
			int minStock, String type, String description) throws Exception
    {    
         Equipment eq = new Equipment();
         eq.setName(name);
         eq.setPurchasePrice(purchasePrice);
         eq.setSalesPrice(salePrice);
         eq.setCountryOfOrigin(country);
         eq.setInStock(inStock);
         eq.setMinStock(minStock);
         eq.setEtype(type);
         eq.setDescription(description);
  
         try{
          DBConnection.startTransaction();
          DBProduct dbProduct = new DBProduct();
	      dbProduct.insertProduct(eq, 2);
          DBConnection.commitTransaction();
         }
         catch(Exception e)
         {
             DBConnection.rollbackTransaction();
             throw new Exception("Product not inserted");
         }
    }

	public Equipment findEquipment(int pid) {
		DBEquipment dbEquipment = new DBEquipment();
		Equipment eq = dbEquipment.findEquipment(pid);
		
		return eq;
	}
	
	public void updateEquipment(String name, double purchasePrice, double salePrice, String country, int inStock, 
			int minStock, String type, String description, int pid) {
		DBIFProduct dbProduct = new DBProduct();
        Equipment eq = new Equipment();
        eq.setName(name);
        eq.setPurchasePrice(purchasePrice);
        eq.setSalesPrice(salePrice);
        eq.setCountryOfOrigin(country);
        eq.setInStock(inStock);
        eq.setMinStock(minStock);
        eq.setEtype(type);
        eq.setDescription(description);
        eq.setPid(pid);
        dbProduct.updateProduct(eq, 2);
	}

	public void removeEquipment(Equipment eq) {
		DBIFEquipment dbEquipment = new DBEquipment();
    	dbEquipment.removeEquipment(eq);
	}

}
