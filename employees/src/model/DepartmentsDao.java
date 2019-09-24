package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBHelper;
import vo.Departments;

public class DepartmentsDao {
	
	public int selectDepartmentsRowCount() {
		int count = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		final String sql = "SELECT COUNT(*) FROM departments";		
		
		try {
			conn = DBHelper.getConneciton();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("COUNT(*)");
			}
		}	catch(Exception e) {
			
		}	finally {
			DBHelper.close(rs, stmt, conn);
		}
		return count;
	}
	
	public List<Departments> selectDepartmentsList(){
		List<Departments> list = new ArrayList<Departments>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		final String sql = "SELECT dept_no, dept_name FROM departments";
		
		try {
			conn = DBHelper.getConneciton();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Departments departments = new Departments();
				departments.setDeptNo(rs.getString("dept_no"));
				departments.setDeptName(rs.getString("dept_name"));
				list.add(departments);
			}
		}	catch(Exception e)	{
			
		}	finally {
			DBHelper.close(rs, stmt, conn);
		}
		return list;
	}
	

}
