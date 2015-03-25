package DBLayer;

import modelLayer.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DBProduct implements DBIFProduct {

	@Override
	public int insertProduct(Product prod, int type) {
		String q = "insert into product (name, purchasePrice, salesPrice, countryOfOrig, inStock, minStock) values (?, ?, ?, ?, ?, ?)";
		int res = -1;
		try(PreparedStatement ps = DBConnection.getInstance().getDBcon().prepareStatement(q, Statement.RETURN_GENERATED_KEYS)
		){
			ps.setString(1, prod.getName());
			ps.setDouble(2, prod.getPurchasePrice());
			ps.setDouble(3, prod.getSalesPrice());
			ps.setString(4, prod.getCountryOfOrigin());
			ps.setInt(5, prod.getInStock());
			ps.setInt(6, prod.getMinStock());
			
			res = ps.executeUpdate();
			int pid = new GeneratedKey().getGeneratedKey(ps);
			prod.setPid(pid);
			switch(type) {
			case 1 : DBClothing dbClothing = new DBClothing();
	        		 dbClothing.insertClothing((Clothing)prod);
	        		 break;
			case 2 : DBEquipment dbEquipment = new DBEquipment();
					 dbEquipment.insertEquipment((Equipment)prod);
					 break;
			case 3 : DBGunReplicas dbGunReplicas = new DBGunReplicas();
			 		 dbGunReplicas.insertGunReplicas((GunReplicas)prod);
			 		 break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	@Override
	public void updateProduct(Product prod, int type) {
		if( prod != null ) {
			String q = "update Product set "
					+ "name='" + prod.getName() + "', "
							+ "purchasePrice='" + prod.getPurchasePrice() + "', "
									+ "salesPrice='" + prod.getSalesPrice() + "', "
											+ "countryOfOrig='" + prod.getCountryOfOrigin() + "', "
													+ "inStock='" + prod.getInStock() + "', "
														+ "minStock='" + prod.getMinStock() + "' "
					+ "where pid = " + prod.getPid();
			try(Statement s = DBConnection.getInstance().getDBcon().createStatement()) {
				s.executeUpdate(q);
				switch(type) {
				case 1 : DBIFClothing dbClothing = new DBClothing();
						 dbClothing.updateClothing((Clothing)prod);
						 break;
				case 2 : DBIFEquipment dbEquipment = new DBEquipment();
						 dbEquipment.updateEquipment((Equipment)prod);
						 break;
				case 3 : DBIFGunReplicas dbGunReplicas = new DBGunReplicas();
				 dbGunReplicas.updateGunReplicas((GunReplicas)prod);
				 break;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public int removeProduct(Product prod) {
		int res = -1;
		try(PreparedStatement ps = DBConnection.getInstance().getDBcon().prepareStatement("delete from product where pid = ?")) {
			ps.setInt(1, prod.getPid());
			res = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public Product findProduct(int pid) {
		return null;
	}
}
























