package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import db.DBHelper;
import vo.Employees;

public class DeptEmpDAO {
	public List<Employees> selectEmplyeesList(int limit) {
		String sql = "SELECT emp_no, birth_date, first_name, last_name, gender, hire_date FROM employees LIMIT ?";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Employees> list = new ArrayList<Employees>();
		try {
			conn = DBHelper.getConnection();			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,limit);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Employees employees = new Employees();
				employees.setEmpNo(rs.getInt("emp_no"));
				employees.setBirthDate(rs.getString("birth_date"));
				employees.setFirstName(rs.getString("first_name"));
				employees.setLastName(rs.getString("last_name"));
				employees.setGender(rs.getString("gender"));
				employees.setHireDate(rs.getString("hire_date"));
				list.add(employees);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(rs, stmt, conn);
		}
		return list;
	}
	public int selectDeptEmpRowCount() {
		int deptEmpRowCount = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) cnt FROM dept_emp";
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) {
				deptEmpRowCount = rs.getInt("cnt");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(rs, stmt, conn);
		}
		return deptEmpRowCount;
	}
}

