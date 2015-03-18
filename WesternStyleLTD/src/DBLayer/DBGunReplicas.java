package DBLayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelLayer.*;

public class DBGunReplicas implements DBIFGunReplicas{

	@Override
	public int insertGunReplicas(GunReplicas gr) {
		String q = "insert into gunReplica (fabric, calibre, pid) values (?, ?, ?)";
		int res = -1;
		try(PreparedStatement ps = DBConnection.getInstance().getDBcon().prepareStatement(q)
		){
			ps.setString(1, gr.getFabric());
			ps.setDouble(2, gr.getCalibre());
			ps.setInt(3, gr.getPid());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public GunReplicas findGunReplicas(int pid) {
		String w = "product.pid = " + pid;
		GunReplicas gr = this.singleWhere(w);
		return gr;
	}

	@Override
	public int updateGunReplicas(GunReplicas gr) {
		int res = -1;
		if( gr != null ) {
			String q = "update gunReplica set "
					+ "fabric='" + gr.getFabric() + "', "
							+ "calibre='" + gr.getCalibre() + "' "
					+ "where pid = " + gr.getPid();
			try(Statement s = DBConnection.getInstance().getDBcon().createStatement()) {
				res = s.executeUpdate(q);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}

	@Override
	public int removeGunReplicas(GunReplicas gr) {
		int res = -1;
		try(PreparedStatement ps = DBConnection.getInstance().getDBcon().prepareStatement("delete from gunReplica where pid = ?")) {
			ps.setInt(1, gr.getPid());
			res = ps.executeUpdate();
			DBIFProduct dbProduct = new DBProduct();
	    	dbProduct.removeProduct(gr);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	private String buildQuery(String where) {
		//String q = "select product.pid, name, purchasePrice, salesPrice, countryOfOrig, inStock, minStock, size, colour from product, GunReplicas";
		String q = "select product.*, fabric, calibre from product, gunReplica";
		if(where != null && where.trim().length() > 0) {
			q += " where " + where;
		}
		return q;
	}
	
	private GunReplicas buildGunReplicas(ResultSet rs) {
		GunReplicas gr = null;
		try {
			gr = new GunReplicas();
			gr.setPid(rs.getInt("pid"));
			gr.setName(rs.getString("name"));
			gr.setPurchasePrice(rs.getDouble("purchasePrice"));
			gr.setSalesPrice(rs.getDouble("salesPrice"));
			gr.setCountryOfOrigin(rs.getString("countryOfOrig"));
			gr.setInStock(rs.getInt("inStock"));
			gr.setMinStock(rs.getInt("minStock"));
			gr.setFabric(rs.getString("fabric"));
			gr.setCalibre(Double.parseDouble(rs.getString("calibre")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gr;
	}
	
	private GunReplicas singleWhere(String where) {
		List<GunReplicas> res = miscWhere(where);
		if(res.size() > 0) {
			return res.get(0);
		}
		return null;
	}
	
	private List<GunReplicas> miscWhere(String where) {
		List<GunReplicas> res = new ArrayList<>();
		try(Statement s = DBConnection.getInstance().getDBcon().createStatement()
		) {
			String q = buildQuery(where);
			ResultSet rs = s.executeQuery(q);
			GunReplicas gr = null;
			while(rs.next()) {
				gr = buildGunReplicas(rs);
				res.add(gr);
			}
			rs.close();
		
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

}
