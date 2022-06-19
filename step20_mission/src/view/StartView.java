package view;

import controller.ControllerDept;
import controller.ControllerEmp;

public class StartView {

	public static void main(String[] args) {
		
		System.out.println("=====모든 DepartmentDTO table 정보 검색=====");
//		ControllerEmp.getAllEmp();
		
		System.out.println("=====모든 EmployeeDTO table 정보 검색=====");
//		ControllerDept.getAllDept();
		
		System.out.println("=====EmployeeDTO에 새로운 사원 입력=====");
//		ControllerEmp.addEmp(7638, "강백호", 3000);
//		ControllerEmp.getAllEmp();
		
		System.out.println("=====DepartmentDTO에 새로운 부서 입력=====");
//		ControllerDept.addDept(50, "힘들다", "퇴근하자");
//		ControllerDept.getAllDept();
		
		System.out.println("=====EmployeeDTO에서 사번으로 검색=====");
//		ControllerEmp.getEmp(7369);
		
		System.out.println("=====EmployeeDTO 월급 수정=====");
//		ControllerEmp.updateSal(7369, 1000);
//		ControllerEmp.getEmp(7369);
		
		System.out.println("=====DepartmentDTO에서 삭제 후 EmployeeDTO에서도 부서 정보 삭제=====");
		
		
	}
}
