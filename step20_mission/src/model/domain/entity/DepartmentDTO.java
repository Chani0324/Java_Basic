package model.domain.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "departmentdto")
public class DepartmentDTO {

	@Id
	@Column(name = "deptno")
	private int deptNo;
	
	@Column(name = "dname")
	private String dName;
	
	@Column(name = "loc")
	private String loc;
	
	@OneToMany(mappedBy = "deptNo")
	private List<EmployeeDTO> employees = new ArrayList<>();

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DepartmentDTO [deptNo=");
		builder.append(deptNo);
		builder.append(", dName=");
		builder.append(dName);
		builder.append(", loc=");
		builder.append(loc);
//		builder.append(", employees=");
//		builder.append(employees);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
