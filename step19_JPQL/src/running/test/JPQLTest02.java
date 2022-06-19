package running.test;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;

import model.domain.entity.Employee;
import util.PublicCommon;

public class JPQLTest02 {
	
	@Test
	public void JPQLTest02() {
		
		EntityManager em = PublicCommon.getEntityManager();
		
		try {
			// employee table에 있는 ename값을 소문자로 검색
			// 힌트 : lower()
//			List<String> e1 = em.createQuery("select lower(e.name) from Employee e", String.class).getResultList();
//			e1.forEach(System.out::println);
			
			// 최고 급여 검색
//			String sql1 = "select max(e.salary) from Employee e";
			// Object -> double 참조(class) 타입으로 변환 후 double인 기본타입으로 변환.
//			double e2 = (double)em.createQuery(sql1).getSingleResult();
//			System.out.println(e2);
			
			// 급여 800~3000이하인 직원들 모든 정보 검색
			String sql2 = "select e from Employee e where e.salary between 800 and 3000";
			List<Employee> e3 = em.createQuery(sql2, Employee.class).getResultList();
			e3.forEach(System.out::println);
			
			// 사원명이 M으로 시작되는 모든 사원명 검색
			String sql3 = "select e.name from Employee e where e.name like 'M%'";
			List<String> e4 = em.createQuery(sql3, String.class).getResultList();
			e4.forEach(System.out::println);
			
			// 사원명 검색 단 오름차순 정렬
			String sql4 = "select e.name from Employee e order by 1 asc";
			List<String> e5 = em.createQuery(sql4, String.class).getResultList();
			e5.forEach(System.out::println);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}

	}

}
