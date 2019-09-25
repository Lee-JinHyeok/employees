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
import vo.Employees;

public class EmployeesDao {
	public int selectLastPage(int rowPerPage) {
	int totalCount = this.selectEmployeesCount();
	System.out.println("seelectLastPage : total Count : "+totalCount);
	System.out.println("seelectLastPage : rowPerPage: "+rowPerPage);
	int lastPage = totalCount / rowPerPage;
	if((lastPage % rowPerPage) != 0) {
		lastPage++;
	}
	return lastPage;
	}
	//페이징 작업 몇페이지에 몇개 씩 보여줄건지 하는 
	public  List<Employees> selectEmployeesListByPage(int currentPage, int rowPerPage){
		List<Employees> list = new ArrayList<Employees>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = 
	"SELECT emp_no, birth_date, first_name, last_name, gender, hire_date FROM employees limit ?, ?";
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			int startRow = (currentPage - 1) * rowPerPage;	//rowPerPage, currentPage -> startRow : (currentPage - 1) * rowPerPage;
			stmt.setInt(1, startRow);
			stmt.setInt(2, rowPerPage);
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
		}	catch(Exception e) {
		}	finally {
			DBHelper.close(rs, stmt, conn);
		}
		return list;
		
		
	}
	
	
	public List<Map<String, Object>> selectEmployeesCountGroupByGender(){
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT gender, COUNT(gender) FROM employees GROUP BY gender";
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("gender", rs.getString("gender"));
				map.put("count", rs.getInt("COUNT(gender)"));
				list.add(map);
			}
		}	catch(Exception e) {
		}	finally {
			DBHelper.close(rs, stmt, conn);
		}
		return list;
	}
	
	public List<Employees> selectEmployeesListBetween(int begin, int end){
		List<Employees> list = new ArrayList<Employees>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		final String sql =
				"SELECT emp_no, birth_date, first_name, last_name, gender, hire_date FROM employees WHERE emp_no BETWEEN ? AND ? ORDER BY emp_no as";
		
		try {
			conn = DBHelper.getConnection();
			stmt =conn.prepareStatement(sql);
			stmt.setInt(1, begin);
			stmt.setInt(2, end);
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
		}	catch	(Exception e){
		}	finally	{
			DBHelper.close(rs, stmt, conn);
		}
		return list;
	}
	
	public int selectEmpNo(String str) {
		int empNo = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "";
		// 동적쿼리
		if(str.equals("max")) {
			sql = "SELECT MAX(emp_no) FROM employees";
		} else if(str.equals("min")) {
			sql = "SELECT MIN(emp_no) FROM employees";
		}
		
		try {
			conn = DBHelper.getConnection();
			stmt =conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) {
				empNo = rs.getInt(1);
			}
		}	catch	(Exception e){
		}	finally	{
			DBHelper.close(rs, stmt, conn);
		}
		return empNo;
	}
	public List<Employees> selcetEmployeesListOrderBy(String order){
		String sql = "";
		if(order.equals("asc")) {
			sql = "SELECT emp_no, birth_date, first_name, last_name, gender, hire_date FROM employees ORDER BY first_name ASC limit 50";
		}	else if (order.equals("desc")) {
			sql = "SELECT emp_no, birth_date, first_name, last_name, gender, hire_date FROM employees ORDER BY first_name DESC limit 50";
		}
		
		List<Employees> list = new ArrayList<Employees>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
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
		}	catch(Exception e) {
		}	finally {
			DBHelper.close(rs, stmt, conn);
		}
		return list;
	}
	
	public int selectEmployeesCount() {//RowCount
		//employees데이터베이스 총 사원의 인원 구하는 메소드
		int count = 0;
		final String sql = "SELECT COUNT(*) FROM employees";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		//try꼭해야함 db쪽에서 우리가 원하지 않는 에러발생할수있으니
		try {
			conn = DBHelper.getConnection();
			stmt =conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("COUNT(*)");
			}
		}	catch(Exception e) {//자바의 변수 생명주기는 {}(블럭)이다 25번라인 e와 별개이다.
			e.printStackTrace();//예외가 났으면 뭘 해야되는데 귀찮으니 콘솔창(서버창)에 예외를 보여줘라 
		}	finally	{
			DBHelper.close(rs, stmt, conn);
		}
		return count;
	}	
	
	public List<Employees> selectEmployeesListByLimit(int limit){
		List<Employees> list = new ArrayList<Employees>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		final String sql ="SELECT emp_no, birth_date, first_name, last_name, gender, hire_date FROM employees limit ?";
		
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, limit);
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
		}	catch	(Exception e)	{
		}	finally	{
			DBHelper.close(rs, stmt, conn);
		}
		return list;
	}
}