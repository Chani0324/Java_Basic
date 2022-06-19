package model.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import model.domain.entity.EmployeeDTO;
import util.PublicCommon;

public class EmployeeDAO {

	// 전체 검색 기능
	public static List<EmployeeDTO> getAllEmp() throws Exception, NoResultException {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			String sql1 = "select e from EmployeeDTO e";
			List<EmployeeDTO> e1 = em.createQuery(sql1, EmployeeDTO.class).getResultList();

			return e1;

		} finally {
			em.close();
		}
	}

	// Employee 등록
	public static boolean addEmployee(EmployeeDTO emp) throws Exception, NoResultException {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			String sql1 = "select count(e.eid) from EmployeeDTO e";
			Long cntBefore = em.createQuery(sql1, Long.class).getSingleResult();

			em.persist(emp);

			String sql2 = "select count(e.eid) from EmployeeDTO e";
			Long cntAfter = em.createQuery(sql2, Long.class).getSingleResult();

			if (cntBefore != cntAfter) {
				tx.commit();
				return true;
			}

		} finally {
			em.close();
		}
		return false;
	}

	// 사번으로 검색 기능
	public static List<EmployeeDTO> getEmp(int empno) throws Exception, NoResultException {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			String sql1 = "select e from EmployeeDTO e where e.eid = :eid";
			List<EmployeeDTO> e1 = em.createQuery(sql1, EmployeeDTO.class).setParameter("eid", empno)
															.getResultList();

			return e1;

		} finally {
			em.close();
		}
	}
	
	// 사번으로 검색해서 월급 업데이트
	public static boolean updateSal(int empno, double sal) throws Exception, NoResultException {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			String sql1 = "update EmployeeDTO e set e.salary = :sal where e.eid = :eid";
			em.createQuery(sql1).setParameter("sal", sal)
								.setParameter("eid", empno)
								.executeUpdate();
			
			tx.commit();
			return true;
		}finally {
			em.close();
		}
	}
}
