package DBLayer;

import modelLayer.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBCustomer implements DBIFCustomer {

	@Override
	public int insertCustomer(Customer c) {
		String q = "insert into customer (name, address, zipCode, city, phoneNo) values (?, ?, ?, ?, ?)";
		int res = -1;
		try(PreparedStatement ps = DBConnection.getInstance().getDBcon().prepareStatement(q, Statement.RETURN_GENERATED_KEYS)
		){
			ps.setString(1, c.getName());
			ps.setString(2, c.getAddress());
			ps.setInt(3, c.getZipCode());
			ps.setString(4, c.getCity());
			ps.setString(5, c.getPhoneNo());
			
			res = ps.executeUpdate();
			int id = new GeneratedKey().getGeneratedKey(ps);
			c.setCid(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	@Override
	public List<Customer> getAllCustomers(boolean retrieveAssociation) {
		List<Customer> res = miscWhere("", retrieveAssociation);
		return res; 
	}

	@Override
	public Customer findCustomer(int cid, boolean retrieveAssociation) {
		String w = "cid = " + cid;
		Customer c = this.singleWhere(w, retrieveAssociation);
		return c;
	}

	@Override
	public List<Customer> searchCustomer(String name, boolean retrieveAssociation) {
		String w = "name like '%" + (name == null ? "" : name) + "%'";
		List<Customer> res = this.miscWhere(w, retrieveAssociation);
		return res;
	}

	@Override
	public int updateCustomer(Customer cust) {
		int res = -1;
		if( cust != null ) {
			String q = "update Customer set "
					+ "name='" + cust.getName() + "', "
							+ "address='" + cust.getAddress() + "', "
									+ "zipCode='" + cust.getZipCode() + "', "
											+ "city='" + cust.getCity() + "', "
													+ "phoneNo='" + cust.getPhoneNo() + "' "
					+ "where cid = " + cust.getCid();
			try(Statement s = DBConnection.getInstance().getDBcon().createStatement()) {
				res = s.executeUpdate(q);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}

	@Override
	public int removeCustomer(Customer cust) {
		int res = -1;
		try(PreparedStatement ps = DBConnection.getInstance().getDBcon().prepareStatement("delete from customer where cid = ?")) {
			ps.setInt(1, cust.getCid());
			res = ps.executeUpdate();
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
	
	private Customer buildCustomer(ResultSet rs) {
		Customer c = null;
		try {
			c = new Customer();
			c.setCid(rs.getInt("cid"));
			c.setName(rs.getString("name"));
			c.setAddress(rs.getString("address"));
			c.setZipCode(rs.getInt("zipCode"));
			c.setCity(rs.getString("city"));
			c.setPhoneNo(rs.getString("phoneNo"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	
	private Customer singleWhere(String where, boolean retrieveAssociation) {
		List<Customer> res = miscWhere(where, retrieveAssociation);
		if(res.size() > 0) {
			return res.get(0);
		}
		return null;
	}
	
	private List<Customer> miscWhere(String where, boolean retrieveAssociation) {
		List<Customer> res = new ArrayList<>();
		try(Statement s = DBConnection.getInstance().getDBcon().createStatement()
		) {
			String q = buildQuery(where);
			ResultSet rs = s.executeQuery(q);
			Customer c = null;
			while(rs.next()) {
				c = buildCustomer(rs);
				res.add(c);
			}
			rs.close();
		
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

}
























