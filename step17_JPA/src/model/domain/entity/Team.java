/*
  create table Team (
      team_id bigint not null auto_increment,
      teamName varchar(255),
      primary key (team_id)
   ) engine=InnoDB
   
+-----------+--------------+------+-----+---------+----------------+
| Field     | Type         | Null | Key | Default | Extra          |
+-----------+--------------+------+-----+---------+----------------+
| team_id   | bigint       | NO   | PRI | NULL    | auto_increment |
| team_name | varchar(255) | YES  |     | NULL    |                |
+-----------+--------------+------+-----+---------+----------------+

 */


package model.domain.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString

@Entity
public class Team {
	// step01 - auto increment 적용
//	@Id		// pk
//	@GeneratedValue(strategy = GenerationType.IDENTITY)		// auto_increment 설정
//	@Column(name = "team_id")
//	private long teamId;
//	
//	@NonNull	// Team(String teamName) {this.teamName = teamName;}
//	@Column(name = "team_name")
//	private String teamName;
	
	
	// step02 - 1:1 관계. team 하나에 member 한명만 포함 / member 한명은 team 하나에만 포함.
//	@Id		// pk
//	@GeneratedValue(strategy = GenerationType.IDENTITY)		// auto_increment 설정
//	@Column(name = "team_id")
//	private long teamId;
//	
//	@NonNull	// Team(String teamName) {this.teamName = teamName;}
//	@Column(name = "team_name")
//	private String teamName;
	
	
	//step03 - 하나의 team에는 다수의 member들 존재
	@Id		// pk
	@GeneratedValue(strategy = GenerationType.IDENTITY)		// auto_increment 설정
	@Column(name = "team_id")
	private long teamId;
	
	@NonNull	// Team(String teamName) {this.teamName = teamName;}
	@Column(name = "team_name")
	private String teamName;
	
	// 다수의 회원 정보를 보유 가능한 List 타입 변수
	/*
	 * team당 다수의 멤버들 보유 가능한 구조
	 * java 코드로 table 구조를 구성 - java 코드의 데이터로 table의 row값들 구성
	 * 	- 연관된 table 간의 row들도 구성
	 */
	@OneToMany(mappedBy = "teamId")
	private List<Member> members = new ArrayList<>();
	
	
}
