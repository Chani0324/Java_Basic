/*
 * Entity ?
 * 	- 테이블에 대응하는 하나의 클래스라고 생각하면 됨.
 * 	- 엔티티 클래스는 자바 클래스에 @Entity 어노테이션을 붙여, 테이블과 매핑한다고 JPA에게 알려주는 클래스임.
 * 
 * 1. EntityManagerFactory 생성시 table 생성
 * 2. EntityManager 생성과 EntityTransaction 생성의 필요성 확인
 * 3. persist() - insert 수행 단 commit()해야 실제 실행
 * 4. persist() -> select 등으로 데이터 확인 -> commit()
 * 		persist() -> select 등으로 데이터 확인 가능한 시점엔 db에 실제 insert 진행 불가
 * 		JPA는 실제 메모리를 별도로 생성 및 관리
 * 		메모리에 생성한 실제 로직들은 commit() 시점에 db에 영향을 줌.
 * 		crud 작업시에는 db에 바로 반영하는게 아니라 임시 메모리 부분에 실행을 해놨다가 commit시에 반영.
 * 5. 실행시 crud는 db에 직접 실행 이전에 임시 jpa만의 임시 메모리에 작업 수행
 * 	- 임시 메모리는 Entity 자체에 crud 하는 상황.
 */
package run.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import step01.entity.Member;


@Slf4j
public class Step01Test {
	
/*
 create table Member (
 	id varchar(255) not null, 
 	age integer, 
 	name varchar(255), 
 	primary key (id)
 ) engine=InnoDB;
 
 insert into Member (age, name, id) values (?, ?, ?)
 update Member set age=?, name=? where id=?
 select member0_.id as id1_1_, member0_.age as age2_1_, member0_.name as name3_1_ 
 from Member member0_;	
 */
	
	/*
	 *  create table Member (
		 	id varchar(255) not null, 
		 	age integer, 
		 	name varchar(255), 
		 	primary key (id)
		 ) engine=InnoDB;
		 
	 */
	
	@Test  
	public void memberCrud() {
		log.info("member table에 crud 적용하기 ------------------\n");
		
		// jpa의 설정 파일을 read해서 mysqlDB라는 이름의 설정 db와 접속 및 필요 table들 구성
		// persistence.xml 파일로 설정
		
		// 해당하는 설정 정보를 기반으로 DB와 소통 가능한 EntityManager를 반환할 수 있는
		// EntityManagerFactory 객체 생성.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqlDB");

		// entity 클래스들을 관리하는 핵심 객체
		// Connection -> PreparedStatement -> ResultSet API 기능 보유한 관리 객체
		EntityManager em = emf.createEntityManager();
		
		// 현 접속된 기능의 EntityManager 객체의 transaction 처리를 담당하는 API
		EntityTransaction tx = em.getTransaction();
		tx.begin();  // tx 시작 선언 (create/drop/select는 불필요)

		//insert into Member (age, name, id) values (?, ?, ?)
		/*
		 * insert sql 문장이 db에 정상 실행되게 하려면 commit() 호출 필수.
		 */
		Member member = new Member("id1", "신동엽1", 10);
		em.persist(member);
		
		//update Member set age=?, name=? where id=?		
//		member.setAge(40);  
		
		/*
		 * commit()의 유무와 무관하게 무조건 실행 및 데이터 정상 출력
		 * commit() 호출하지 않았을 경우 db에 insert가 안 되어 있는 상황.
		 */
		Member oneFindMember = em.find(Member.class, "id1");	// pk로 검색
		System.out.println("*** " + oneFindMember);

		/*
		 * commit()의 유무와 무관하게 무조건 실행 및 데이터 정상 출력
		 * commit() 호출하지 않았을 경우 db에 insert가 안 되어 있는 상황.
		 */
		// select member0_.id as id1_1_, member0_.age as age2_1_, member0_.name as name3_1_ from Member member0_;	
		List<Member> allMember = em.createQuery("select m from Member m", Member.class).getResultList();
		System.out.println("회원 수 : " + allMember.size());

//		for (Member m : allMember) {
//			System.out.println(m);
//		}
		
		// delete from Member where id = ?
		em.remove(oneFindMember);
		tx.commit();	// DML에만 영향을 줌 (insert/update/delete)
		
		System.out.println("-- 삭제 후 검색 해 보기 --");
		oneFindMember = em.find(Member.class, "id1");
		System.out.println(oneFindMember);
		
	}

}


