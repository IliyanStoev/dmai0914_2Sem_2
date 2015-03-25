package DBLayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelLayer.*;

public class DBEquipment implements DBIFEquipment{

	@Override
	public int insertEquipment(Equipment eq) {
		String q = "insert into Equipment (eType, descr, pid) values (?, ?, ?)";
		int res = -1;
		try(PreparedStatement ps = DBConnection.getInstance().getDBcon().prepareStatement(q)
		){
			ps.setString(1, eq.getEtype());
			ps.setString(2, eq.getDescription());
			ps.setInt(3, eq.getPid());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Equipment findEquipment(int pid) {
		String w = "equipment.pid = " + pid + "AND product.pid = " + pid;
		Equipment clo = this.singleWhere(w);
		return clo;
	}

	@Override
	public int updateEquipment(Equipment clo) {
		int res = -1;
		if( clo != null ) {
			String q = "update Equipment set "
					+ "type='" + clo.getEtype() + "', "
							+ "descr='" + clo.getDescription() + "' "
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
	public int removeEquipment(Equipment clo) {
		int res = -1;
		try(PreparedStatement ps = DBConnection.getInstance().getDBcon().prepareStatement("delete from Equipment where pid = ?")) {
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
		String q = "select product.*, equipment.type, descr from product, equipment";
		if(where != null && where.trim().length() > 0) {
			q += " where " + where;
		}
		return q;
	}
	
	private Equipment buildEquipment(ResultSet rs) {
		Equipment clo = null;
		try {
			clo = new Equipment();
			clo.setPid(rs.getInt("pid"));
			clo.setName(rs.getString("name"));
			clo.setPurchasePrice(rs.getDouble("purchasePrice"));
			clo.setSalesPrice(rs.getDouble("salesPrice"));
			clo.setCountryOfOrigin(rs.getString("countryOfOrig"));
			clo.setInStock(rs.getInt("inStock"));
			clo.setMinStock(rs.getInt("minStock"));
			clo.setEtype(rs.getString("type"));
			clo.setDescription(rs.getString("descr"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clo;
	}
	
	private Equipment singleWhere(String where) {
		List<Equipment> res = miscWhere(where);
		if(res.size() > 0) {
			return res.get(0);
		}
		return null;
	}
	
	private List<Equipment> miscWhere(String where) {
		List<Equipment> res = new ArrayList<>();
		try(Statement s = DBConnection.getInstance().getDBcon().createStatement()
		) {
			String q = buildQuery(where);
			ResultSet rs = s.executeQuery(q);
			Equipment clo = null;
			while(rs.next()) {
				clo = buildEquipment(rs);
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
