package step01.jdbc.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import util.DBUtil;

public class JDBCTset02 {
//	@Test
	// deptno 값으로 부서 하나의 정보 검색
	public void selectOne() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			rset = stmt.executeQuery("select * from dept where deptno = 10");
			
			if(rset.next()) {
				System.out.println(rset.getInt("deptno") + " " 
							+ rset.getString("dname") + " " 
							+ rset.getString("loc"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("db 접속 문제 발생.");
		} finally {
			DBUtil.close(conn, stmt, rset);
		}
		
	}
	
//	@Test
	public void select() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int dept_no = 10;
		
		try {
			String sql = "select * from dept where deptno = ?";
			
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, dept_no);
			
			rset = pstmt.executeQuery();

			if(rset.next()) {
				System.out.println(rset.getInt("deptno") + " " 
						+ rset.getString("dname") + " " 
						+ rset.getString("loc"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("db 접속 문제 발생.");
		} finally {
			DBUtil.close(conn, pstmt, rset);
		}
		
	}
	
	
	// table 복제해서 생성시에는 dept의 제약조건까지 복제 되지 않음.
	// insert - insert into dept01 values (50, '교육부', '서초');
//	@Test
	public void insert() {
		Connection conn = null;
		Statement stmt = null;
		int cnt = 0;
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			cnt = stmt.executeUpdate("insert into dept01 values (50, '교육부', '서초')");
			
			if(cnt == 1) {
				System.out.println("저장 완료");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("db 접속 문제 발생.");
		} finally {
			DBUtil.close(conn, stmt);
		}
	}
	
	
	// update
//	@Test
	public void update() {
		Connection conn = null;
		Statement stmt = null;
		int cnt = 0;
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			cnt = stmt.executeUpdate("update dept01 set loc = '강남' where deptno = 50");
			
			if(cnt == 1) {
				System.out.println("수정 완료");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("db 접속 문제 발생.");
		} finally {
			DBUtil.close(conn, stmt);
		}
	}	
	
	
	// delete
	@Test
	public void delete() {
		Connection conn = null;
		Statement stmt = null;
		int cnt = 0;
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			cnt = stmt.executeUpdate("delete from dept01 where deptno = 50");
			
			if(cnt != 0) {	// 여러개 동시 삭제 시에는 cnt != 0 조건을 사용하면 됨.
				System.out.println("삭제 완료" + cnt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("db 접속 문제 발생.");
		} finally {
			DBUtil.close(conn, stmt);
		}
	}	
	
	
	
//	@Test
	public void selectAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			rset = stmt.executeQuery("select * from dept");
			
			while(rset.next()) {
				System.out.println(rset.getInt("deptno") + " " 
							+ rset.getString("dname") + " " 
							+ rset.getString("loc"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("db 접속 문제 발생.");
		} finally {
			DBUtil.close(conn, stmt, rset);
		}
		
	}
	
}
