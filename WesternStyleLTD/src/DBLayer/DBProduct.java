package DBLayer;

import modelLayer.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBProduct implements DBIFProduct {

	@Override
	public List<Product> getAllProducts(boolean retrieveAssociation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findProduct(String name, boolean retrieveAssociation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> searchProduct(String name, boolean retrieveAssociation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateProduct(Product p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeProduct(Product p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertProduct(Product p) {
		String q = "insert into product (name, purchasePrice, salesPrice, countryOfOrig, inStock, minStock, type) values (?, ?, ?, ?, ?, ?, ?)";
		int res = -1;
		try(PreparedStatement ps = DBConnection.getInstance().getDBcon().prepareStatement(q, Statement.RETURN_GENERATED_KEYS)
		){
			ps.setString(1, p.getName());
			ps.setDouble(2, p.getPurchasePrice());
			ps.setDouble(3, p.getSalesPrice());
			ps.setString(4, p.getCountryOfOrigin());
			ps.setInt(5, p.getInStock());
			ps.setInt(6, p.getMinStock());
			ps.setString(7, p.getType());
			
			res = ps.executeUpdate();
			int pid = new GeneratedKey().getGeneratedKey(ps);
			p.setPid(pid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	private String buildQuery(String where) {
		String q = "select cid, name, address, zipCode, city, phoneNo from customer";
		if(where != null && where.trim().length() > 0) {
			q += " where " + where;
		}
		return q;
	}
	
	private Customer buildProduct(ResultSet rs) {
		Customer c = null;
		try {
			c = new Customer();
			c.setCid(rs.getInt("cid"));
			c.setName(rs.getString("name"));
			//c.setAddress(rs.getString("address"));
			c.setZipCode(rs.getString("zipCode"));
			c.setCity(rs.getString("city"));
			c.setPhoneNo(rs.getString("phoneNo"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	

}
























