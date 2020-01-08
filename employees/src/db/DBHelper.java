package db;

import java.sql.*;

public class DBHelper {
	public static Connection getConnection() throws Exception {
		Class.forName("org.mariadb.jdbc.Driver");
		// hosting용 db
		//Connection conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/j5539538","j5539538","J12");
		// test용 db
		Connection conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/employees", "root", "java1234");
		return conn;
	}
	
	public static void close(ResultSet rs, Statement stmt, Connection conn) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
