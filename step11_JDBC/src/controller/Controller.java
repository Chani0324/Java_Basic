package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Emp01DAO;
import model.domain.Emp01DTO;
import view.EndView;

public class Controller {
	
	// 모든 직원 정보 요청을 받는 메소드 - all 인 경우	ArrayList<Emp01DTO> getEmps()
	// 해당 직원의 정보 검색 요청 받는 메소드 - 사번	Emp01DTO getEmp(int empno)
	/*
	 * client null / length 0 문자열
	 * 
	 * 실행 결과
	 * 1. 정상 실행
	 * 	1. 데이터 있다.
	 * 	2. 데이터가 없다.
	 * 2. 비정상 실행 - 예외 발생
	 */
	
	public static void allRequestResponse(String data) {
		if (data != null && data.length() != 0) {
			if(data.equals("all")) {	// data 변수가 보유한 데이터가 all 여부 확인
				try {
					ArrayList<Emp01DTO> all = Emp01DAO.getEmps();
					
					if(all.size() != 0) {	// 데이터가 있을 시
						EndView.allEmpView(all);
					}else {	// 데이터가 없을 시
						EndView.SuccessMsg("해당하는 직원 정보가 없습니다.");
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
					EndView.failMsg("모든 직원 검색 도중 문제가 발생했습니다.");
				}
				
			}else {	// 사번으로 해당 사원정보 요청 로직
				try {
					int empno = Integer.parseInt(data);
					Emp01DTO en = Emp01DAO.getEmp(empno);
					
					if(en != null) {	// 데이터가 있을 때
						EndView.empView(en);
					}else {	// 데이터가 없을 때
						EndView.SuccessMsg("해당하는 직원 정보가 없습니다.");
					}
					
				}catch (SQLException e) {
					e.printStackTrace();
					EndView.failMsg("해당 직원 검색 도중 문제가 발생했습니다.");
				}catch (NumberFormatException e) {
					e.printStackTrace();
					EndView.failMsg("입력 데이터가 올바른지 확인하세요");
				}
			}
			
		}else {
//			EndView.failMsg("잘못된 요청입니다.");
		}
	}
	
}
