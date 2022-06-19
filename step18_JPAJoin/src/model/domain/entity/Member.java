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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Builder(builderMethodName = "memberBuilder")
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	private long memberId;
	
	@Column(length = 10)
	private String name;
	
	private int age;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "team_id")	// team table의 team_id 컬럼 참조. fk 설정
	private Team teamId;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Member [memberId=");
		builder.append(memberId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", age=");
		builder.append(age);
		builder.append(", teamId=");
		builder.append(teamId);
		builder.append("]");
		return builder.toString();
	}

}
