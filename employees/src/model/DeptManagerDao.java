package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.DBHelper;

public class DeptManagerDao {
	public int selectDeptManagerCount() {
		int count = 0 ;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		final String sql = "SELECT COUNT(*) FROM dept_manager";
		
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("COUNT(*)");
			}
		}	catch(Exception e) {
			
		}	finally	{
			DBHelper.close(rs, stmt, conn);
		}
		return count;
	}
}
