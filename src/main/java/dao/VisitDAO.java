package dao;



import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import model.Visit;

public class VisitDAO extends AbstractEntityDAO<Visit>{

	public VisitDAO() {
		super(Visit.class);
		// TODO Auto-generated constructor stub
	}
	public Visit getLastVisit() {
		String jpql = "SELECT v FROM Visit v order by v.id desc";
		EntityManager em = JpaUtils.getEntityManager();
		TypedQuery<Visit> query = em.createQuery(jpql, Visit.class).setMaxResults(1);
		Visit v = query.getSingleResult();
		em.close();
		return v;
	}
	public List<Visit> getTwoWeekVisit(){
		String jpql = "SELECT v FROM Visit v order by v.id desc";
		EntityManager em = JpaUtils.getEntityManager();
		TypedQuery<Visit> query = em.createQuery(jpql, Visit.class).setMaxResults(14);
		List<Visit> lst = query.getResultList();
		em.close();
		return lst;
	}
	public Long getCountVisit() {
		Session session = JpaUtils.getSession();
		String nativeQuery = "select sum(count) from visits";
		NativeQuery query = session.createSQLQuery(nativeQuery);
		Object o = query.getSingleResult();
		BigInteger big = (BigInteger) o;
		Long l = big.longValue();
		session.close();
		return l;
		
	}
}
