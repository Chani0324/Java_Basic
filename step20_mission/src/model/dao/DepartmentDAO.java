package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import model.domain.entity.DepartmentDTO;
import util.PublicCommon;

public class DepartmentDAO {

	// 전체 검색 기능
	public static List<DepartmentDTO> getAllDept() throws Exception, NoResultException {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			String sql1 = "select d from DepartmentDTO d";
			List<DepartmentDTO> d1 = em.createQuery(sql1, DepartmentDTO.class).getResultList();

			return d1;

		} finally {
			em.close();
		}
	}
	
	public static boolean addDepartment(DepartmentDTO dept) throws Exception, NoResultException {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			String sql1 = "select count(d.deptNo) from DepartmentDTO d";
			Long cntBefore = em.createQuery(sql1, Long.class).getSingleResult();
			
			em.persist(dept);
			
			String sql2 = "select count(d.deptNo) from DepartmentDTO d";
			Long cntAfter = em.createQuery(sql2, Long.class).getSingleResult();
			
			if (cntBefore != cntAfter) {
				tx.commit();
				return true;
			}
			
		}finally {
			em.close();
		}
		return false;
	}
	
	// 부서 삭제 -> employ에서도 부서 정보 update 필요함.
	
	// 부서 업데이트 -> employ에서도 부서 정보 update 필요.
}
