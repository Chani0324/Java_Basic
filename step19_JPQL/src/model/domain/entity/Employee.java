package model.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

// 사번으로 해당 사원 검색
@NamedQuery(name = "Employee.findByEmpno", query = "select e from Employee e where e.eid = :empno")	// :eid 가변데이터

// 사번과 이름으로 사원 검색
@NamedQuery(name = "Employee.findByEmpnoAndEname", query = "select e from Employee e where e.eid = :empno and e.name = :ename")

@Entity
@Builder
public class Employee {

	@Id
	@Column(name = "empno")
	private int eid;
	
	@Column(name = "ename", length = 20)
	private String name;
	
	@Column(name = "sal")
	private double salary;
	
	@Column(name = "deptno")
	private int department;
	
	
	
}
