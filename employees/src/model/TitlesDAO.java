package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import db.DBHelper;
import vo.Employees;
import vo.Titles;

public class TitlesDAO {
	public List<String> selectTitlesListDistinct() {
		String sql = "SELECT DISTINCT title FROM titles";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<String> list = new ArrayList<String>();
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				list.add(rs.getString("title"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(rs, stmt, conn);
		}
		return list;
	}
	public int selectTitlesRowCount() {
		int titlesRowCount = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) cnt FROM titles";
		try {
			conn = DBHelper.getConnection();			
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) {
				titlesRowCount = rs.getInt("cnt");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(rs, stmt, conn);
		}
		return titlesRowCount;
	}
}

