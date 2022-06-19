package step01.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter 
@Setter

@Entity   
public class Customer {
	@Id   
	@Column(name="id")   
	private String id;
	
	@Column(name="name")   
	private String userName;
	
	@Column 		
	private int age;  
   
	@Column
	private String job;
}  

