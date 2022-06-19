package model.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
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
@Table(name = "dept")
public class Dept {
	@Id
	@Column(name = "deptno")
	private int deptno;

	@Column(name = "dname")
	private String dname;
	
	@Column(name = "loc")
	private String loc;
}
