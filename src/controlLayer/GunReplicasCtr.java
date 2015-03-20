package controlLayer;

import modelLayer.*;
import DBLayer.*;

public class GunReplicasCtr {

	public void insertGunReplicas(String name, double purchasePrice, double salePrice, String country, int inStock, 
			int minStock, String fabric, double calibre) throws Exception
    {    
         GunReplicas gr = new GunReplicas();
         gr.setName(name);
         gr.setPurchasePrice(purchasePrice);
         gr.setSalesPrice(salePrice);
         gr.setCountryOfOrigin(country);
         gr.setInStock(inStock);
         gr.setMinStock(minStock);
         gr.setFabric(fabric);
         gr.setCalibre(calibre);
  
         try{
          DBConnection.startTransaction();
          DBProduct dbProduct = new DBProduct();
	      dbProduct.insertProduct(gr, 3);
          DBConnection.commitTransaction();
         }
         catch(Exception e)
         {
             DBConnection.rollbackTransaction();
             throw new Exception("Product not inserted");
         }
    }

	public GunReplicas findGunReplicas(int pid) {
		DBGunReplicas dbGunReplicas = new DBGunReplicas();
		GunReplicas gr = dbGunReplicas.findGunReplicas(pid);
		
		return gr;
	}
	
	public void updateGunReplicas(String name, double purchasePrice, double salePrice, String country, int inStock, 
			int minStock, String fabric, double calibre, int pid) {
		DBIFProduct dbProduct = new DBProduct();
		GunReplicas gr = new GunReplicas();
        gr.setName(name);
        gr.setPurchasePrice(purchasePrice);
        gr.setSalesPrice(salePrice);
        gr.setCountryOfOrigin(country);
        gr.setInStock(inStock);
        gr.setMinStock(minStock);
        gr.setFabric(fabric);
        gr.setCalibre(calibre);
        gr.setPid(pid);
        dbProduct.updateProduct(gr, 3);
	}

	public void removeGunReplicas(GunReplicas gr) {
		DBIFGunReplicas dbGunReplicas = new DBGunReplicas();
    	dbGunReplicas.removeGunReplicas(gr);
	}

}
