package model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import model.domain.entity.DepartmentDTO;
import model.domain.entity.EmployeeDTO;

public class ModelService {

	private static ModelService instance = new ModelService();
	
	private ModelService() {}
	
	public static ModelService getInstance() {
		return instance;
	}
	
	// Employee table 모든 정보 검색
	public List<EmployeeDTO> getAllEmp() throws Exception, NoResultException {
		return EmployeeDAO.getAllEmp();
	}

	// Employee table에 새 정보 등록
	public boolean addEmployee(int empno, String ename, double sal) throws Exception, NoResultException {
		
		EmployeeDTO e1 = EmployeeDTO.builder().eid(empno)
												.name(ename)
												.salary(sal)
												.build();
		
		return EmployeeDAO.addEmployee(e1);
	}
	
	// 사번으로 검색 기능
	public List<EmployeeDTO> getEmp(int empno) throws Exception, NoResultException {
		return EmployeeDAO.getEmp(empno);
	}
	
	// 사번검색해서 월급 업데이트
	public boolean updateSal(int empno, double sal) throws Exception, NoResultException {
		return EmployeeDAO.updateSal(empno, sal);
	}

	
	
	// DepartmentDTO table 모든 정보 검색
	public List<DepartmentDTO> getAllDept() throws Exception, NoResultException {
		return DepartmentDAO.getAllDept();
	}
	
	// DepartmentDTO table에 새 정보 등록
	public boolean addDepartment(int deptno, String dname, String loc) throws Exception, NoResultException {
		
		DepartmentDTO d1 = DepartmentDTO.builder().deptNo(deptno)
												.dName(dname)
												.loc(loc)
												.employees(new ArrayList<EmployeeDTO>())
												.build();
		
		return DepartmentDAO.addDepartment(d1);
	}
	
	
}
