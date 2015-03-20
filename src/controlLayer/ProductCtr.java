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
	
	public Product findProduct(int pid) {
		Product prod = new Product();
		DBClothing dbClothing = new DBClothing();
		Clothing clo = dbClothing.findClothing(pid);
		if(clo == null) {
				DBEquipment dbEquipment = new DBEquipment();
				Equipment eq = dbEquipment.findEquipment(pid);
				if( eq == null) {
						DBGunReplicas dbGunReplicas = new DBGunReplicas();
						GunReplicas gr = dbGunReplicas.findGunReplicas(pid);
						if(gr == null) {
							return null;
						}
						else {
							prod = gr;
						}
					}
				else { 
					prod = eq;
				}
			}
		else {
			prod = clo;
		}
		
		return prod;
	}
	
	public SalesLine createSalesLine(Product prod, int quantity) {
        SalesLine sl = new SalesLine(prod, quantity);
        return sl;
    }
}
