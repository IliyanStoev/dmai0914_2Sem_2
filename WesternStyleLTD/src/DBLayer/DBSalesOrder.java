package DBLayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import modelLayer.*;

public class DBSalesOrder implements DBIFSalesOrder {

	@Override
	public int cancelSalesOrder(SalesOrder so) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSalesOrder(SalesOrder so) {
		String q = "insert into salesOrder (date, amount, deliveryStatus, deliveryDate, cid) values (?, ?, ?, ?, ?)";
		int res = -1;
		try(PreparedStatement ps = DBConnection.getInstance().getDBcon().prepareStatement(q, Statement.RETURN_GENERATED_KEYS)
		){
			ps.setString(1, so.getDate());
			ps.setDouble(2, so.getOrdAmount());
			ps.setString(3, so.getDeliveryStatus());
			ps.setString(4, so.getDeliveryDate());
			ps.setInt(5, so.getCustomer().getCid());
			
			res = ps.executeUpdate();
			int oid = new GeneratedKey().getGeneratedKey(ps);
			so.setOid(oid);
			
			DBSalesLine dbSalesLine = new DBSalesLine();
			for(SalesLine sl : so.getSalesLines()) {
				dbSalesLine.insertSalesLine(sl, oid);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public SalesOrder findSalesOrder(int oid, boolean retrieveAssociation) {
		String w = "oid = " + oid;
		SalesOrder so = this.singleWhere(w, retrieveAssociation);
		return so;
	}

	
	private SalesOrder singleWhere(String where, boolean retrieveAssociation) {
		List<SalesOrder> res = miscWhere(where, retrieveAssociation);
		if(res.size() > 0) {
			return res.get(0);
		}
		return null;
	}
	
	private List<SalesOrder> miscWhere(String where, boolean retrieveAssociation) {
		List<SalesOrder> res = new ArrayList<>();
		try(Statement s = DBConnection.getInstance().getDBcon().createStatement()
		) {
			String q = buildQuery(where);
			ResultSet rs = s.executeQuery(q);
			SalesOrder so = null;
			while(rs.next()) {
				so = buildSalesOrder(rs);
				res.add(so);
			}
			rs.close();
			if (so != null) {
				if(retrieveAssociation) {
					DBCustomer dbCustomer = new DBCustomer();
	                int cid = so.getCustomer().getCid();
	                Customer cust = dbCustomer.singleWhere(" cid = '" + cid + "'");
	                so.setCustomer(cust);
	            }
			}
		
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	private String buildQuery(String where) {
		String q = "select * from salesOrder";
		if(where != null && where.trim().length() > 0) {
			q += " where " + where;
		}
		return q;
	}
	
	private SalesOrder buildSalesOrder(ResultSet rs) {
		SalesOrder so = null;
		try {
			so = new SalesOrder();
			so.setDate(rs.getString("date"));
			so.setAmount(rs.getDouble("amount"));
			so.setDeliveryStatus(rs.getString("deliveryStatus"));
			so.setDeliveryDate(rs.getString("deliveryDate"));
			so.setCustomer(new Customer(rs.getInt("cid")));
			//so.setSalesLines(new ArrayList<SalesLine>());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return so;
	}
	
	public void changeDeliveryStatus(SalesOrder so) {
		if( so != null ) {
			String q = "update salesOrder set "
					+ "deliveryStatus='" + so.getDeliveryStatus() + "' "
						+ "where oid = " + so.getOid();
			try(Statement s = DBConnection.getInstance().getDBcon().createStatement()) {
				s.executeUpdate(q);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void updateInStockAmount(Product prod, int amount) {
		if(prod != null) {
			String q = "update product set inStock = inStock +'" + amount + "' where pid=" + prod.getPid();
			try(Statement s = DBConnection.getInstance().getDBcon().createStatement()) {
				s.executeUpdate(q);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
