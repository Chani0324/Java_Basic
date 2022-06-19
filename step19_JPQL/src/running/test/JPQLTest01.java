package running.test;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.junit.Test;

import model.domain.entity.Employee;
import util.PublicCommon;

public class JPQLTest01 {
	// NamedQuery 기본 활용에 대한 학습
//	@Test
	public void step01 () {
		EntityManager em = PublicCommon.getEntityManager();
		
		try {
			Employee e1 = (Employee)em.createNamedQuery("Employee.findByEmpno").setParameter("empno", 7369).getSingleResult();
			System.out.println(e1);
			
			Employee e2 = (Employee)em.createNamedQuery("Employee.findByEmpnoAndEname").setParameter("empno", 7839).setParameter("ename", "KING").getSingleResult();
			System.out.println(e2);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
	}
	
	// 없는 데이터 검색 시에는 예외 발생(NoResultException)
	// 존재할 경우 존재하는 데이터 출력, 미존재할 경우에는 "존재하는 데이터 없습니다."출력
	@Test
	public void step02 () {
		EntityManager em = PublicCommon.getEntityManager();
		
		try {
			Employee e1 = (Employee)em.createNamedQuery("Employee.findByEmpno").setParameter("empno", 7369).getSingleResult();
			System.out.println(e1);
			
			Employee e2 = (Employee)em.createNamedQuery("Employee.findByEmpnoAndEname").setParameter("empno", 7839).setParameter("ename", "KING").getSingleResult();
			System.out.println(e2);
			
		/*
		 * 예외처리 기본 rule
		 * 	1. 다수의 catch로 처리 시
		 * 		child 타입 먼저 catch -> parent 타입
		 * 	2. 타입 무관하게 모든 예외 처리를 하나의 catch로 처리시
		 * 		Exception 즉 예외들의 상위 타입으로 처리
		 */
		}catch(NoResultException e) {
			System.out.println("존재하지 않습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
	}
	
}
