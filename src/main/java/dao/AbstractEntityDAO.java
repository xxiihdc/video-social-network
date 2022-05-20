package dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

public abstract class AbstractEntityDAO<T> {
	private Class<T> entityClass;
	public Session session = JpaUtils.getSession();

	public AbstractEntityDAO(Class<T> cls) {
		this.entityClass = cls;
	
	}

	public void insert(T entity) {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(entity);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public void update(T entity) {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(entity);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public void delete(Object id) {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			T entity = em.find(entityClass, id);
			em.remove(em.merge(entity));
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public T find(Object id) {
		EntityManager em = JpaUtils.getEntityManager();
//		EntityTransaction trans = em.getTransaction();
		try {
//			T entity = session.load(entityClass, (Serializable) id);
			T entity = em.find(entityClass, id);
			em.close();
			return entity;
		} finally {
			//session.close();
			em.close();
		}

	}
	public void closeSession() {
		this.session.close();
	}
	public List<T> findAll() {
		EntityManager em = JpaUtils.getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			cq.select(cq.from(entityClass));
			return em.createQuery(cq).getResultList();
		} finally {
			em.close();
		}
	}

	public List<T> findAllDesc(String field) {
		EntityManager em = JpaUtils.getEntityManager();
		try {
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<T> cq = cb.createQuery(entityClass);
			Root<T> root = cq.from(entityClass);
			cq.orderBy(cb.desc(root.get(field)));
			return em.createQuery(cq).getResultList();
		} finally {
			em.close();
		}
	}

	
	public List<T> findAllDesc(String field,int first,int max) {
		EntityManager em = JpaUtils.getEntityManager();
		try {
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<T> cq = cb.createQuery(entityClass);
			Root<T> root = cq.from(entityClass);
			cq.orderBy(cb.desc(root.get(field)));
			Query query = em.createQuery(cq);
			query.setFirstResult(first);
			query.setMaxResults(max);
			return query.getResultList();
		} finally {
			em.close();
		}
	}
	
	public Long count() {
		EntityManager em = JpaUtils.getEntityManager();
		CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
		Root<T> rt = cq.from(entityClass);
		try {
			cq.select(em.getCriteriaBuilder().count(rt));
			Query q = em.createQuery(cq);
			return (Long) q.getSingleResult();
		} finally {
			em.close();
		}
	}

	public List<T> findAll(int first, int max) {
		EntityManager em = JpaUtils.getEntityManager();
		CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
		try {
			cq.select(cq.from(entityClass));
			Query q = em.createQuery(cq);
			q.setMaxResults(max);
			q.setFirstResult(first);

			return q.getResultList();
		} finally {
			em.close();
		}
	}
}
