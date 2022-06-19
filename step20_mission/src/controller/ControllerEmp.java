package controller;

import javax.persistence.NoResultException;

import model.dao.ModelService;
import view.EndView;

public class ControllerEmp {

	public static ModelService service = ModelService.getInstance();

	// 모든 Employee table 정보 검색
	public static void getAllEmp() {
		try {
			EndView.empAllView(service.getAllEmp());
		} catch (NoResultException e) {
			System.out.println("데이터 없음.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Employee 등록
	public static void addEmp(int empno, String ename, double sal) {

		try {
			boolean tf = service.addEmployee(empno, ename, sal);

			if (tf == true) {
				EndView.successMsg("저장 완료.");
			} else {
				EndView.failMsg("저장 실패.");
			}
		} catch (NoResultException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 사번으로 검색
	public static void getEmp(int empno) {
		try {
			EndView.empAllView(service.getEmp(empno));
		} catch (NoResultException e) {
			System.out.println("데이터 없음.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 사번으로 검색하여 월급 업데이트
	public static void updateSal(int empno, double sal) {
		try {
			boolean tf = service.updateSal(empno, sal);
			
			if(tf == true) {
				EndView.successMsg("업데이트 완료");
			}else {
				EndView.failMsg("업데이트 도중 문제 발생");
			}
		} catch (NoResultException e) {
			System.out.println("데이터 없음.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}