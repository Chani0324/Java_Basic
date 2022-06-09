/*
 * 개발 단계
 * 1. db driver 설치(로딩)
 * 	- com.mysql.cj.jdbc.Driver
 * 2. db 접속
 * 	- url(ip, db명, database이름) / id : root / pw : playdata
 * 	- url
 * 		"jdbc:mysql://localhost/playdata?characterEncoding=UTF-8&serverTimezone=UTC"
 * 3. sql문장 실행
 * 	- emp00 새로 생성해서 사용
 * 4. sql문장 실행 결과 활용
 * 5. 더이상 사용하지 않는 db 자원들 반환
 */

package step01.jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest01 {
	// mysql 실습
	public static void main(String[] args) {
		
		// 1단계 - driver 로딩
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("해당 mysql db의 driver가 없습니다.");
		}
		
		// 2단계 - 접속 객체 생성
		/*
		 * jdbc: db와 java언어의 통신 규약
		 */
		String url = "jdbc:mysql://localhost/playdata?characterEncoding=UTF-8&serverTimezone=UTC";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
//				DEPTNO DNAME                        LOC
//		    ---------- ---------------------------- --------------------------
//		            10 ACCOUNTING                   NEW YORK
//		            20 RESEARCH                     DALLAS
//		            30 SALES                        CHICAGO
//		            40 OPERATIONS                   BOSTON
		
		try {
			conn = DriverManager.getConnection(url, "root", "playdata");
//			System.out.println(conn);
			
			// 3단계 - 문장 실행 객체 생성
			stmt = conn.createStatement();
			
			// 4단계 - sql 문장 실행 및 활용
			// dept table만 검색 - select * from dept;
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
			try {
				// 5단계 - 자원 반환
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
			}
		}
		
	}
	
	
	
	// oracle 접속 전용
	public static void oracle() {
		
		try {
			// driver 로딩(설치)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 접속 개체 생성 - 정상 실행인 경우 자바로 oracle 접속 성공
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			Connection con = DriverManager.getConnection(url, "SCOTT", "TIGER");
			
			// 정상적인 접속 객체는 주소값 보유
			System.out.println(con);	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// mysql 접속 전용
	public static void mysql() {
		
		try {
			// driver 로딩(설치)
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 접속 개체 생성 - 정상 실행인 경우 자바로 mysql 접속 성공
			String url = "jdbc:mysql://localhost/playdata?characterEncoding=UTF-8&serverTimezone=UTC";
			Connection con = DriverManager.getConnection(url, "root", "playdata");
			
			// 정상적인 접속 객체는 주소값 보유
			System.out.println(con);	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


