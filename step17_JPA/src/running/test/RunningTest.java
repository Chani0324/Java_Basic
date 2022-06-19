package running.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import model.domain.entity.Member;
import model.domain.entity.Team;

public class RunningTest {
	
	@Test
	public void step01() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dbinfo");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		//step01
//		Team t1 = new Team("북산");
//		em.persist(t1);
//
//		Member m1 = new Member("강백호", 1);
//		em.persist(m1);
		
		
		//step02 - 1:1 관계
		/*
		 * @OneToOne & @JoinColumn으로 인해 Member의 teamId값은 반드시 Team table의 teamId여야만 함.
		 * Team table의 teamId값은 auto_increment
		 * 객체 생성 방법?
		 */
//		Team t1 = new Team("북산");
//		em.persist(t1);
//
//		Member m1 = new Member("강백호");
//		m1.setTeamId(t1); 	// team table의 team_id 값을 자동 반영.
//		em.persist(m1);
		
		
		//step03
		Team t1 = new Team();
		t1.setTeamName("북산");
		
		Member m1 = new Member();
		m1.setName("강백호");
		m1.setTeamId(t1);
		
		Member m2 = new Member();
		m2.setName("서태웅");
		m2.setTeamId(t1);
		
		t1.getMembers().add(m1);
		t1.getMembers().add(m2);
		
		t1.getMembers().stream().peek(x -> System.out.println(x));
		
		em.persist(t1);
		em.persist(m1);
		em.persist(m2);
		
		
		tx.commit();
	}
}
