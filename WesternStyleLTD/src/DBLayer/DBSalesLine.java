package DBLayer;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelLayer.*;

public class DBSalesLine {

	public void insertSalesLine(SalesLine sl, int oid) {
		String q = "insert into salesLine (quantity, oid, pid) values (?, ?, ?)";
		try(PreparedStatement ps = DBConnection.getInstance().getDBcon().prepareStatement(q)
		){
			ps.setInt(1, sl.getQuantity());
			ps.setInt(2, oid);
			ps.setInt(3, sl.getProduct().getPid());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
