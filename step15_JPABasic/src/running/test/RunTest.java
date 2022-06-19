package running.test;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import model.domain.entity.Dept;

@Slf4j
public class RunTest {

	@Test
	public void deptTest() {
		// dept table crud 작업 구현.
		log.info("dept table에 crud 적용하기 ------------------\n");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dbinfo");

		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		// insert to entity 
		Dept dept01 = new Dept(50, "MANUFAC", "TOKYO");
		em.persist(dept01);
		
		// update
		dept01.setDname("DIO");
		
		// select
		Dept findDept = em.find(Dept.class, 50);	// 이거 pk로 찾는듯
		System.out.println("====" + findDept);
		
		List<Dept> allDept = em.createQuery("select a from Dept a", Dept.class).getResultList();
		System.out.println("부서 수 : " + allDept.size());
		
		allDept.stream().peek(x -> System.out.println(x)).collect(Collectors.toList());
		
		em.remove(findDept);
		tx.commit();
		
		System.out.println(allDept.stream().filter(x -> x.getDeptno() == 50).map(p -> new Dept(p.getDeptno(), p.getDname(), p.getLoc())).collect(Collectors.toList()).get(0));
		
		
	}
}
