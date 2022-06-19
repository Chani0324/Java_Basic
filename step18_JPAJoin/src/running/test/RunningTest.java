package running.test;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.junit.Test;

import model.domain.entity.Member;
import model.domain.entity.Team;
import util.PublicCommon;

public class RunningTest {

//	@Test
	public void step01() {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		// team.members NullPointException 발생. 이유 확인 및 해결 필요
		Team t1 = Team.teamBuilder().teamName("북산").build();

		Member m1 = Member.memberBuilder().name("강백호").age(17).teamId(t1).build();

		Member m2 = Member.memberBuilder().name("서태웅").age(17).teamId(t1).build();

		t1.getMembers().add(m1);
		t1.getMembers().add(m2);

//		t1.getMembers().stream().peek(x -> System.out.println(x));

		em.persist(t1);
		em.persist(m1);
		em.persist(m2);

		tx.commit();
//		PublicCommon.close();
	}

//	@Test
	public void step02() {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		// builder 패턴에서 다른 값들을 넣어주지 않으면 String은 null, int는 0으로 인식
		// 따라서 members에 값을 넣어주지 않으면 객체를 null로 인식해서 없다고 뜸.
		// builder에서는 객체를 만들어 주어야 함.
		Team t1 = Team.teamBuilder().teamName("북산").members(new ArrayList<Member>()).build();

		Member m1 = Member.memberBuilder().name("강백호").age(17).teamId(t1).build();

		Member m2 = Member.memberBuilder().name("서태웅").age(17).teamId(t1).build();

		t1.getMembers().add(m1);
		t1.getMembers().add(m2);

//		t1.getMembers().stream().peek(x -> System.out.println(x));

		em.persist(t1);
		em.persist(m1);
		em.persist(m2);

		tx.commit();
//		PublicCommon.close();
	}

//	@Test	
	// persistence context, flush & clear
	public void step03() {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		// builder 패턴에서 다른 값들을 넣어주지 않으면 String은 null, int는 0으로 인식
		// 따라서 members에 값을 넣어주지 않으면 객체를 null로 인식해서 없다고 뜸.
		// builder에서는 객체를 만들어 주어야 함.
		Team t1 = Team.teamBuilder().teamName("북산").members(new ArrayList<Member>()).build();

		Member m1 = Member.memberBuilder().name("강백호").age(17).teamId(t1).build();

		Member m2 = Member.memberBuilder().name("서태웅").age(17).teamId(t1).build();

		t1.getMembers().add(m1);
		t1.getMembers().add(m2);

//		t1.getMembers().stream().peek(x -> System.out.println(x));

		em.persist(t1);
		em.persist(m1);
		em.persist(m2);

		em.flush();
		em.clear();

		Team t3 = em.find(Team.class, t1.getTeamId());
		System.out.println("팀에 소속된 멤버 수 : " + t3.getMembersCount());

		tx.commit();
//		PublicCommon.close();
	}

//	@Test
	public void step04() {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {

			// builder 패턴에서 다른 값들을 넣어주지 않으면 String은 null, int는 0으로 인식
			// 따라서 members에 값을 넣어주지 않으면 객체를 null로 인식해서 없다고 뜸.
			// builder에서는 객체를 만들어 주어야 함.
			Team t1 = Team.teamBuilder().teamName("북산").members(new ArrayList<Member>()).build();

			Member m1 = Member.memberBuilder().name("강백호").age(17).teamId(t1).build();

			Member m2 = Member.memberBuilder().name("서태웅").age(17).teamId(t1).build();

			t1.getMembers().add(m1);
			t1.getMembers().add(m2);

//		t1.getMembers().stream().peek(x -> System.out.println(x));

			em.persist(t1);
			em.persist(m1);
			em.persist(m2);

			em.flush();
			em.clear();

			Team t3 = em.find(Team.class, t1.getTeamId());
			System.out.println("팀에 소속된 멤버 수 : " + t3.getMembersCount());

			/*
			 * 1 = int / 1L or 1l = long 타입
			 * JPA 기반의 Member id 타입을 long으로 선언했으니 검색도 long 타입으로 검색해야 함.
			 */
			Member m3 = em.find(Member.class, 1L);
			System.out.println(m3.getName());

			tx.commit();
//		PublicCommon.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	// find 메소드 호출로 인한 select 문장 확인
	// 단 전제조건 : select를 필수로 실행하기 위해 persistent context 메모리 청소 필수
//	@Test
	public void step05() {
		
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			
			// builder 패턴에서 다른 값들을 넣어주지 않으면 String은 null, int는 0으로 인식
			// 따라서 members에 값을 넣어주지 않으면 객체를 null로 인식해서 없다고 뜸.
			// builder에서는 객체를 만들어 주어야 함.
			Team t1 = Team.teamBuilder().teamName("북산").members(new ArrayList<Member>()).build();
			
			Member m1 = Member.memberBuilder().name("강백호").age(17).teamId(t1).build();
			
			Member m2 = Member.memberBuilder().name("서태웅").age(17).teamId(t1).build();
			
			t1.getMembers().add(m1);
			t1.getMembers().add(m2);
			
			
			em.persist(t1);
			em.persist(m1);
			em.persist(m2);
			
			em.flush();
			em.clear();
			
			// select tea, select member
			Team t3 = em.find(Team.class, t1.getTeamId());
			System.out.println("팀에 소속된 멤버 수 : " + t3.getMembersCount());
			
			// 이미 Team t3 코드로 실행된 검색 결과를 활용
			// 즉 해당 코드로 인한 select 문장 실행되지 않음.
			Member m3 = em.find(Member.class, 1L);
			System.out.println("멤버 이름 : " + m3.getName());
			System.out.println("멤버가 소속된 팀 정보 : " + m3.getTeamId().getTeamName());
			
			tx.commit();
//		PublicCommon.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	
	// step05의 일부코드 생략 후 실행
//	@Test
	public void step06() {
		
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			
			// builder 패턴에서 다른 값들을 넣어주지 않으면 String은 null, int는 0으로 인식
			// 따라서 members에 값을 넣어주지 않으면 객체를 null로 인식해서 없다고 뜸.
			// builder에서는 객체를 만들어 주어야 함.
			Team t1 = Team.teamBuilder().teamName("북산").members(new ArrayList<Member>()).build();
			
			Member m1 = Member.memberBuilder().name("강백호").age(17).teamId(t1).build();
			
			Member m2 = Member.memberBuilder().name("서태웅").age(17).teamId(t1).build();
			
			t1.getMembers().add(m1);
			t1.getMembers().add(m2);
			
			
			em.persist(t1);
			em.persist(m1);
			em.persist(m2);
			
			em.flush();
			em.clear();
			
			// select team, select member
//			Team t3 = em.find(Team.class, t1.getTeamId());
//			System.out.println("팀에 소속된 멤버 수 : " + t3.getMembersCount());
			
			// 이미 Team t3 코드로 실행된 검색 결과를 활용
			// 즉 해당 코드로 인한 select 문장 실행되지 않음.
			// 다른 class에 연관지어서 검색 가능.
			Member m3 = em.find(Member.class, 1L);
			System.out.println("멤버 이름 : " + m3.getName());
			System.out.println("멤버가 소속된 팀 정보 : " + m3.getTeamId().getTeamName());
			
			tx.commit();
//		PublicCommon.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	
	@Test
	public void step07() {
		
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			
			// builder 패턴에서 다른 값들을 넣어주지 않으면 String은 null, int는 0으로 인식
			// 따라서 members에 값을 넣어주지 않으면 객체를 null로 인식해서 없다고 뜸.
			// builder에서는 객체를 만들어 주어야 함.
			Team t1 = Team.teamBuilder().teamName("북산").members(new ArrayList<Member>()).build();
			
			Member m1 = Member.memberBuilder().name("강백호").age(17).teamId(t1).build();
			
			Member m2 = Member.memberBuilder().name("서태웅").age(17).teamId(t1).build();
			
			t1.getMembers().add(m1);
			t1.getMembers().add(m2);
			
			
			em.persist(t1);
			em.persist(m1);
			em.persist(m2);
			
			em.flush();
			em.clear();
			
			/*	지연로딩 설정
			 * 	@ManyToOne(fetch = FetchType.LAZY)
				@JoinColumn(name = "team_id")	// team table의 team_id 컬럼 참조. fk 설정
				private Team teamId;
			 */
			Member m3 = em.find(Member.class, 1L);
			
			// fetch 설정으로 member table만 select
			System.out.println("멤버 이름 : " + m3.getName());
			
			// fetch 설정으로 team table만 select
			System.out.println("멤버가 소속된 팀 정보 : " + m3.getTeamId().getTeamName());
			
			tx.commit();
//		PublicCommon.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	
}
