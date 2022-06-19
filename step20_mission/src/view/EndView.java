package view;

import java.util.List;

import model.domain.entity.DepartmentDTO;
import model.domain.entity.EmployeeDTO;

public class EndView {

	public static void deptAllView(List<DepartmentDTO> allDept) {
		allDept.forEach(System.out::println);
		
	}

	public static void empAllView(List<EmployeeDTO> allEmp) {
		allEmp.forEach(System.out::println);
	}

	public static void successMsg(String message) {
		System.out.println(message);
	}

	public static void failMsg(String message) {
		System.out.println(message);
	}
	
}
