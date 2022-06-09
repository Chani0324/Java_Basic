// DB연동 공통 코드들로만 구성된 클래스

package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	// byte code가 메모리에 저장(로딩), 적재시에 단 한번만 실행
	static {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println("해당 mysql db의 driver가 없습니다.");
			}
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/playdata?characterEncoding=UTF-8&serverTimezone=UTC",
											"root", "playdata");
	}
	
	public static void close(Connection conn, Statement stmt, ResultSet rset) {
		try {
			if (rset != null) {
				rset.close();
				rset = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("자원반환 실패");
		} 
	}
	
	// DML용 자원반환 method
	public static void close(Connection conn, Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("자원반환 실패");
		} 
	}
	
}
