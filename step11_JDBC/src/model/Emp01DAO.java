package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.domain.Emp01DTO;
import util.DBUtil;

public class Emp01DAO {
	// 모든 emp01 table 데이터 검색(연봉)
	/*
	 * 실행 결과
	 * 1. 정상 실행
	 * 	1. 데이터 있다.
	 * 	2. 데이터가 없다.
	 * 2. 비정상 실행 - 예외 발생
	 */
	public static ArrayList<Emp01DTO> getEmps() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		ArrayList<Emp01DTO> all = null;

		try {
			conn = DBUtil.getConnection();
			pstmt = conn
					.prepareStatement("select empno, ename, sal, comm, sal*12 + ifnull(null, 0) as t_sal from emp01");

			// table이 존재한다면 null 값이 아님
			// 데이터 존재시 검색 결과 객체 반환 / 없어도 검색 결과 객체 반환
			rset = pstmt.executeQuery();

			all = new ArrayList<>(); // 실질적으로 사용하기 직전에 메모리에 할당하면서 메모리 사용 효율을 높임.
			while (rset.next()) {
				// 데이터 존재 시 파라미터를 가지는 생성자 반환.
				// Dept01DTO의 @AllArgu 로 파라미터 받는 생성자를 생성해놨었음.
				// Dept01DTO에 파라미터를 받는 생성자를 여러개 생성해서 사용해도 됨.(파라미터 개수와 타입은 달라야 함.)
				all.add(new Emp01DTO(rset.getInt("empno"), rset.getString("ename"), rset.getInt("sal"),
						rset.getInt("t_sal")));
			}
		} finally {
			DBUtil.close(conn, pstmt, rset);
		}
		return all;
	}

	// 사번으로 해당 사원의 정보 검색(연봉)
	public static Emp01DTO getEmp(int empno) throws SQLException {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select empno, ename, sal, comm, sal*12 + IFNULL(null, 0) as t_sal from emp01 where empno = ?";

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, empno);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				return new Emp01DTO(rset.getInt("empno"), rset.getString("ename"), rset.getInt("sal"),
						rset.getInt("t_sal"));
			}

		} finally {
			DBUtil.close(conn, pstmt, rset);
		}

		return null;
	}

}
