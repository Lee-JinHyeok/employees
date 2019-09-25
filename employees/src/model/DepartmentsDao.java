package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DBHelper;
import vo.Departments;

public class DepartmentsDao {
	
	public List<Map<String, Object>> selectDepartmentsCountByDeptNo(){
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		final String sql =
		"SELECT d.dept_no, d.dept_name, COUNT(d.dept_no) FROM dept_emp de INNER join departments d "
		+ "ON de.dept_no = d.dept_no WHERE de.to_date = '9999-01-01' GROUP BY de.dept_no ORDER BY COUNT(d.dept_no) desc";
		
		try {
			conn = DBHelper.getConnection();
			stmt =conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("deptNo",rs.getString("d.dept_no"));
				map.put("deptName",rs.getString("d.dept_name"));
				map.put("deptCount", rs.getString("COUNT(d.dept_no)"));
				list.add(map);
			}
		}	catch	(Exception e){
		}	finally	{
			DBHelper.close(rs, stmt, conn);
		}
		return list;
	}
	
	public List<Departments> selectDepartmentsList(){
		List<Departments> list = new ArrayList<Departments>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		final String sql = "SELECT dept_no, dept_name FROM departments";
		
		try {
			conn = DBHelper.getConnection();
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
	public int selectDepartmentsRowCount() {
		int count = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		final String sql = "SELECT COUNT(*) FROM departments";		
		
		try {
			conn = DBHelper.getConnection();
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

}
