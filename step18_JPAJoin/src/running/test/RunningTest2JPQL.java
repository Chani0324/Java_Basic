/*
 * 코드 상에서 검색 명령어 개발 학습
 * "select m from Member m"
 * 		- 참조변수 m을 설정.
 */

package running.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import model.domain.entity.Member;
import util.PublicCommon;

public class RunningTest2JPQL {

//	@Test
	public void step01() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			// 쿼리문 작성시 별칭 필수.(참조 변수)
			List<Member> datas = em.createQuery("select m from Member m where m.age >= 18", Member.class).getResultList();
			datas.forEach(v -> System.out.println(v.toString()));
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
		
		tx.commit();
	}
	
	@Test
	// 1번팀에 소속된 모든 팀원들의 모든 정보를 검색해서 출력.
	public void step02() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			
			// List<Member> datas = em.createQuery("select m from Member m join m.teamId t where t.teamId=1L", Member.class).getResultList();
			/*
			 * m.teamId t
			 * 	- Member Entity가 보유한 teamId라는 변수는 table 관점에선 team table 참조하면서 team table 활용 가능하게 하는 변수
			 * 	- Team teamId; 로 선언되어 있음.
			 * 		m.teamId t 는 Team 객체를 활용 가능한 별칭
			 * 		t로 Team 객체의 teamId 호출 = t.teamId
			 * 
			 * select m from Member m join m.teamId t where t.teamId=1L
			 * 		Member m = new Member();
			 * 		Team t = m.teamId;
			 * 
			 */
			
			// createQuery에서 data를 받을 type을 잘 알고 설정 필요
			List<Member> datas = em.createQuery("select m from Member m inner join Team t on m.teamId = t.teamId where m.teamId = 1L", Member.class).getResultList();
			datas.forEach(System.out::println);
			
			// 이름만 출력
			// createQuery에서 data를 받을 type을 잘 알고 설정 필요
			datas.forEach(v -> System.out.println(v.getName()));
			List<String> datas2 = em.createQuery("select m.name from Member m inner join Team t on m.teamId = t.teamId where m.teamId = 1L", String.class).getResultList();
			datas2.forEach(System.out::println);
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
		
		tx.commit();
	}
}
