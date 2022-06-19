/* 
 * Entity 클래스
 * 	1. db의 table과 1:1 매핑되는 클래스
 * 	2. 멤버 변수 = table의 컬럼
 * 	3. 단, table과 column명은 설정으로 변경 가능
 * 	4. 
 */


package step01.entity;

import javax.persistence.Entity;	// entity 클래스 의미
import javax.persistence.Id;	// pk 설정
import javax.persistence.Column;	// 컬럼 의미 및 이름 변경

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity 
public class Member {
	@Id  // p.k. 의미
	@Column(name = "id")	// table에 생성되는 column명을 명시적으로 설정
	private String id;	// id varchar(255)

	@Column(name = "name")
	private String userName;	// name varchar(255)
	
	@Column(precision = 10)
	private int age;	// age int

}
