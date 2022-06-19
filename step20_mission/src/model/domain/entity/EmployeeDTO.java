package model.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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

@Entity
@Builder
@Table(name = "employeedto")
public class EmployeeDTO {

	@Id
	@Column(name = "empno")
	private int eid;
	
	@Column(name = "ename", length = 20)
	private String name;
	
	@Column(name = "sal")
	private double salary;
	
	@ManyToOne
	@JoinColumn(name = "deptno")
	private DepartmentDTO deptNo;
	
	
	
}
