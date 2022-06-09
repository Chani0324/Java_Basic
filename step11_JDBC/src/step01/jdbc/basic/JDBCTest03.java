package step01.jdbc.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.Test;

import model.domain.Dept01DTO;
import model.domain.Emp01DTO;
import util.DBUtil;

public class JDBCTest03 {
	
	public void insert(int newDeptno, String newDname, String newLoc) {
		Connection conn = null;
		Statement stmt = null;
		int cnt = 0;
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			
			String sql = "insert into dept01 values ("+ newDeptno +", '"+ newDname +"', '"+ newLoc +"')";
			
			cnt = stmt.executeUpdate(sql);
			
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
	
	
	// PreparedStatement API 활용하기
	/*
	 * - sql 문장으로 생성시키는 문장 실행 객체
	 * - 그 이외의 다른 sql 문장 실행 불가
	 * - 가변적인 데이터 표현은 메소드와 ? 표기로 매핑해서 설정
	 * - 동일한 sql 문장을 다수가 실행하게 되는 로직인 경우 db 자체적으로 컴파일은 한번만 동작
	 * - 이미 존재하는 코드로 실행하기 때문에 실행 속도가 빠름
	 * 	- 참고 : Statement는 client가 요청시 실행시마다 무조건 컴파일 -> 실행 진행
	 */
	public void insert2(int newDeptno, String newDname, String newLoc) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int cnt = 0;
		String sql = "insert into dept01 values (?, ?, ?)";
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);	// insert만 실행 가능한 객체
			
			pstmt.setInt(1, newDeptno);	// 첫번쨰 ? 부분에 값 대입
			pstmt.setString(2, newDname);
			pstmt.setString(3, newLoc);
			
			cnt = pstmt.executeUpdate();
			
			if(cnt == 1) {
				System.out.println("저장 완료");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("db 접속 문제 발생.");
		} finally {
			DBUtil.close(conn, pstmt);
		}
	}
	
	
	// 동적 요청 처리하는 update, PreparedStatment로 변환
//	@Test
	public void update(int upDeptno, String newLoc) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int cnt = 0;
		String sql = "update dept01 set loc = ? where deptno = ?";
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, newLoc);
			pstmt.setInt(2, upDeptno);
			
			cnt = pstmt.executeUpdate();
			
			if(cnt == 1) {
				System.out.println("수정 완료");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("db 접속 문제 발생.");
		} finally {
			DBUtil.close(conn, pstmt);
		}
	}	
	
	/*
	 * 모든 부서 정보 검색
	 * 단, 메소드의 반환값으로 검색된 모든 부서 정보 반환
	 * 	- 타입?
	 * 	- 부서별 데이터를 명확하게 구분하기 위해서는 어떻게 반환할지...?
	 * 
	 * 모든 직원의 데이터를 반환하는 메소드의 타입은 어떤 타입이 가장 좋을지?
	 * select empno, ename, sal*12 + ifnull(null, 0) as t_sal from emp01;
	 * 
	 * 배열 : 배열 생성 후 배열 내에 해당 index에 Emp01DTO 객체들 저장
	 * 	- 배열 생성시 크기 정보 필요
	 * 리스트 : 리스트 생성 후에 해당 index에 Emp01DTO 객체들 저장.
	 */
	
	public ArrayList<Emp01DTO> selectAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ArrayList<Emp01DTO> all = null;
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("select empno, ename, sal, comm, sal*12 + ifnull(null, 0) as t_sal from emp01");
			
			// table이 존재한다면 null 값이 아님
			// 데이터 존재시 검색 결과 객체 반환 / 없어도 검색 결과 객체 반환
			rset = pstmt.executeQuery();

			all = new ArrayList<>();	// 실질적으로 사용하기 직전에 메모리에 할당하면서 메모리 사용 효율을 높임.
			while(rset.next()) {
				// 데이터 존재 시 파라미터를 가지는 생성자 반환.
				// Dept01DTO의 @AllArgu 로 파라미터 받는 생성자를 생성해놨었음.
				// Dept01DTO에 파라미터를 받는 생성자를 여러개 생성해서 사용해도 됨.(파라미터 개수와 타입은 달라야 함.)
				all.add(new Emp01DTO(rset.getInt("empno"), rset.getString("ename"), 
						rset.getInt("sal"), rset.getInt("t_sal")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("db 접속 또는 sql 실행 문제 발생.");
		} finally {
			DBUtil.close(conn, pstmt, rset);
		}
		return all;
	}
	
	
	/*
	 * 하나의 부서 정보는 어떻게 반환?
	 *  - DTO(Data Transfer Object, get set 등 사용) - 모든 컬럼값과 일치되는 변수들로 구성된 객체를 반환
	 *  - 메소드 실행 결과값은 데이터가 존재할 경우엔 Dept01DTO 객체 반환
	 *    데이터가 미존재할 경우? null 반환
	 */

	// select * from dept where deptno = ?; deptno는 pk
	public Dept01DTO selectOne(int deptno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("select * from dept where deptno = ?");
			
			pstmt.setInt(1, deptno);
			
			// table이 존재한다면 null 값이 아님
			// 데이터 존재시 검색 결과 객체 반환 / 없어도 검색 결과 객체 반환
			rset = pstmt.executeQuery();

			if(rset.next()) {
				// 데이터 존재 시 파라미터를 가지는 생성자 반환.
				// Dept01DTO의 @AllArgu 로 파라미터 받는 생성자를 생성해놨었음.
				// Dept01DTO에 파라미터를 받는 생성자를 여러개 생성해서 사용해도 됨.(파라미터 개수와 타입은 달라야 함.)
				return new Dept01DTO(rset.getInt("deptno"), rset.getString("dname"), rset.getString("loc"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("db 접속 또는 sql 실행 문제 발생.");
		} finally {
			DBUtil.close(conn, pstmt, rset);
		}
		// 데이터가 존재하지 않을 경우.
		return null;
	}
	
	/*
	 * ? create table emp01 as select empno, ename, sal, comm from emp;
	 * 검색 메소드
	 * 1. 기능 : 해당 사원의 모든 정보 검색해서 반환
	 * 2. 단, 연봉(sal*12 + comm)
	 * 3. Emp01DTO로 반환 및 출력
	 * 4. 사번으로 해당 사원의 정보 검색 후 DTO로 반환
	 * 5. 단, DTO 클래스는 꼭 컬럼과 100% 일치하지 않아도 됩니다.
	 * 	- 즉, 필요에 의해서 DTO 클래스들은 다수 개발 가능.
	 */
	
	public Emp01DTO getEmp(int empno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select empno, ename, sal, comm, sal*12 + IFNULL(null, 0) as t_sal from emp01 where empno = ?";
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, empno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				return new Emp01DTO(rset.getInt("empno"), rset.getString("ename"), 
						rset.getInt("sal"), rset.getInt("t_sal"));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("db 접속 또는 sql 실행 문제 발생.");
		} finally {
			DBUtil.close(conn, pstmt, rset);
		}
		
		return null;
	}
	
	
	@Test
	public void runTest() {
//		insert2(60, "교육부", "서초");
//		update(50, "일산");
		
//		Dept01DTO v1 = selectOne(10);
//		if (v1 != null) {
//			System.out.println(v1); 	// v1.toString() 호출 코드와 동일함.
//		}else {
//			System.out.println("부서 정보 없음.");
//		}
		
//		Emp01DTO v2 = getEmp(7698);
//		if (v2 != null) {
//			System.out.println(v2); 	// v1.toString() 호출 코드와 동일함.
//		}else {
//			System.out.println("정보 없음.");
//		}

		ArrayList<Emp01DTO> all = selectAll();
		if (all != null) {
			for (Emp01DTO tp : all) {
				System.out.println(tp);
			}
		}else {
			System.out.println("현 시점엔 직원이 없습니다.");
		}
	
	}
		
}
