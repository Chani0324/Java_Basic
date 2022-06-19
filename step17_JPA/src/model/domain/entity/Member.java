/*
 * create table Member (
       member_id bigint not null auto_increment,
       name varchar(10),
       team_id bigint,
       primary key (member_id)
    ) engine=InnoDB
 
+-----------+-------------+------+-----+---------+----------------+
| Field     | Type        | Null | Key | Default | Extra          |
+-----------+-------------+------+-----+---------+----------------+
| member_id | bigint      | NO   | PRI | NULL    | auto_increment |
| name      | varchar(10) | YES  |     | NULL    |                |
| team_id   | bigint      | YES  |     | NULL    |                |
+-----------+-------------+------+-----+---------+----------------+
    
 */

package model.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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
public class Member {
	//step01
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "member_id")
//	private long memberId;
//	
//	
//	@NonNull
//	@Column(length = 10)
//	private String name;
//	
//	
//	@NonNull
//	@Column(name = "team_id")
//	private long teamId;
		
	//step02 - member table의 team_id는 team table의 team_id값을 참조.
	/*
	 * member 클래스의 멤버 변수인 Team 타입의 teamId는 DB관점에서 해석시에 
	 * Team 클래스가 보유한 모든 멤버 데이터를 다 보유하는 설계가 아닌 Team의 team_id값만 참조 관계형성
	 * 일반 DTO와 Entity 차이 - Entity는 Team 타입의 team_id로 인해 table에 insert 되는 데이터는
	 * team table의 id 값만 저장함.
	 */
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "member_id")
//	private long memberId;
//	
//	@NonNull
//	@Column(length = 10)
//	private String name;
//	
//	@OneToOne
//	@JoinColumn(name = "team_id")	// team table의 team_id 컬럼 참조. fk 설정
//	private Team teamId;
	
	
	//step03
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	private long memberId;
	
	@NonNull
	@Column(length = 10)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "team_id")	// team table의 team_id 컬럼 참조. fk 설정
	private Team teamId;
	
}
