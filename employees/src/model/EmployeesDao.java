package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeesDao {
	
	public int selectEmployeesCount() {
		
		int count = 0;
		final String sql = "SELECT COUNT(*) FROM employees";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		//try꼭해야함 db쪽에서 우리가 원하지 않는 에러발생할수있으니
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/employees","root","java1234");
			stmt =conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("COUNT(*)");
			}
		}	catch(Exception e) {//자바의 변수 생명주기는 {}(블럭)이다 25번라인 e와 별개이다.
			e.printStackTrace();//예외가 났으면 뭘 해야되는데 귀찮으니 콘솔창(서버창)에 예외를 보여줘라 
			
		}	finally	{
			try {
				rs.close();
				stmt.close();
				conn.close();
			}	catch(Exception e)	{
				e.printStackTrace();
			}
		}
		return count;
		
	}	
}