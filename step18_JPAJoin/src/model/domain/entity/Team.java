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
import lombok.Builder;
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

@Entity
@Builder(builderMethodName = "teamBuilder")
public class Team {
	@Id		// pk
	@GeneratedValue(strategy = GenerationType.IDENTITY)		
	@Column(name = "team_id")
	private long teamId;
	
	@Column(name = "team_name")
	private String teamName;
	
	/*
	 * team_id라는 column에 의존하는 멤버변수
	 * table의 column으로 새로 생성하는 
	 */
	@OneToMany(mappedBy = "teamId")
	private List<Member> members = new ArrayList<>();
	
	// 현 멤버 수 반환하는 메소드
	public int getMembersCount() {
		return members.size();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Team [teamId=");
		builder.append(teamId);
		builder.append(", teamName=");
		builder.append(teamName.toString());
		
		// List의 toString()에 보유하고 있는 모든 객체들의 toString() 호출해서 결과값을 append 유도
		// List내부에 Member의 toString() -> Team의 toString() -> List내부에 Member의 toString() -> Team의 toString()... 재귀호출 야기
		// stackoverflow err 발생
//		builder.append(", members=");
//		builder.append(members.toString());
		
		builder.append("]");
		return builder.toString();
	}
	
}
