package dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import model.User;
import model.Video;

public class VideoDAO extends AbstractEntityDAO<Video> {

	public VideoDAO() {
		super(Video.class);
	}

	@Override
	public List<Video> findAllDesc(String field, int first, int max) {
		EntityManager em = JpaUtils.getEntityManager();
		try {
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Video> cq = cb.createQuery(Video.class);
			Root<Video> root = cq.from(Video.class);
			cq.orderBy(cb.desc(root.get(field)));
			cq.where(root.get("active"));
			Query query = em.createQuery(cq);
			query.setFirstResult(first);
			query.setMaxResults(max);
			System.out.println("active");
			return query.getResultList();
		} finally {
			em.close();
		}
	}

	@Override
	public Video find(Object id) {
		EntityManager em = JpaUtils.getEntityManager();
		try {
			Video entity = session.load(Video.class, (Serializable) id);
			em.close();
			return entity;
		} catch (Exception e) {
			return null;
		} finally {
			em.close();
		}

	}

	public List<Video> findAllHide() {
		EntityManager em = JpaUtils.getEntityManager();
		try {
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Video> cq = cb.createQuery(Video.class);
			Root<Video> root = cq.from(Video.class);
			cq.where(cb.equal(root.get("active").as(Boolean.class), false));
			Query query = em.createQuery(cq);
			return query.getResultList();
		} finally {
			em.close();
		}
	}
	public boolean isExist(String id) {
		String jpql = "SELECT v FROM Video v WHERE v.id=?0";
		EntityManager em = JpaUtils.getEntityManager();
		TypedQuery<Video> query = em.createQuery(jpql, Video.class);
		query.setParameter(0, id);
		List<Video> lst = query.getResultList();
		em.close();
		return !lst.isEmpty();
	}
	public List<Video> findByKeyword(String key){
		String jpql = "SELECT v FROM Video v WHERE v.title like ?0";
		EntityManager em = JpaUtils.getEntityManager();
		TypedQuery<Video> query = em.createQuery(jpql, Video.class);
		query.setParameter(0, "%"+key+"%");
		List<Video> lst = query.getResultList();
		em.close();
		return lst;
	}
}
