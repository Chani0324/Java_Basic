package controller;

import javax.persistence.NoResultException;

import model.dao.ModelService;
import view.EndView;

public class ControllerDept {

	public static ModelService service = ModelService.getInstance();

	// 모든 Department table 정보 검색
	public static void getAllDept() {
		try {
			EndView.deptAllView(service.getAllDept());
		}catch(NoResultException e) {
			System.out.println("데이터 없음.");
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void addDept(int deptno, String dname, String loc) {
		
		try {
			boolean tf = service.addDepartment(deptno, dname, loc);
			
			if (tf==true) {
				EndView.successMsg("저장 완료.");
			}else {
				EndView.failMsg("저장 실패.");
			}
		}catch (NoResultException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
