package DBLayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelLayer.*;

public class DBClothing implements DBIFClothing{

	@Override
	public int insertClothing(Clothing clo) {
		String q = "insert into clothing (size, colour, pid) values (?, ?, ?)";
		int res = -1;
		try(PreparedStatement ps = DBConnection.getInstance().getDBcon().prepareStatement(q)
		){
			ps.setString(2, clo.getSize());
			ps.setString(1, clo.getColor());
			ps.setInt(3, clo.getPid());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Clothing findClothing(int pid) {
		String w = "clothing.pid = " + pid + "AND product.pid = " + pid;
		Clothing clo = this.singleWhere(w);
		return clo;
	}

	@Override
	public int updateClothing(Clothing clo) {
		int res = -1;
		if( clo != null ) {
			String q = "update Clothing set "
					+ "size='" + clo.getSize() + "', "
							+ "colour='" + clo.getColor() + "' "
					+ "where pid = " + clo.getPid();
			try(Statement s = DBConnection.getInstance().getDBcon().createStatement()) {
				res = s.executeUpdate(q);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}

	@Override
	public int removeClothing(Clothing clo) {
		int res = -1;
		try(PreparedStatement ps = DBConnection.getInstance().getDBcon().prepareStatement("delete from clothing where pid = ?")) {
			ps.setInt(1, clo.getPid());
			res = ps.executeUpdate();
			DBIFProduct dbProduct = new DBProduct();
	    	dbProduct.removeProduct(clo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	private String buildQuery(String where) {
		String q = "select product.*, size, colour from product, clothing";
		if(where != null && where.trim().length() > 0) {
			q += " where " + where;
		}
		return q;
	}
	
	private Clothing buildClothing(ResultSet rs) {
		Clothing clo = null;
		try {
			clo = new Clothing();
			clo.setPid(rs.getInt("pid"));
			clo.setName(rs.getString("name"));
			clo.setPurchasePrice(rs.getDouble("purchasePrice"));
			clo.setSalesPrice(rs.getDouble("salesPrice"));
			clo.setCountryOfOrigin(rs.getString("countryOfOrig"));
			clo.setInStock(rs.getInt("inStock"));
			clo.setMinStock(rs.getInt("minStock"));
			clo.setSize(rs.getString("size"));
			clo.setColor(rs.getString("colour"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clo;
	}
	
	private Clothing singleWhere(String where) {
		List<Clothing> res = miscWhere(where);
		if(res.size() > 0) {
			return res.get(0);
		}
		return null;
	}
	
	private List<Clothing> miscWhere(String where) {
		List<Clothing> res = new ArrayList<>();
		try(Statement s = DBConnection.getInstance().getDBcon().createStatement()
		) {
			String q = buildQuery(where);
			ResultSet rs = s.executeQuery(q);
			Clothing clo = null;
			while(rs.next()) {
				clo = buildClothing(rs);
				res.add(clo);
			}
			rs.close();
		
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

}
