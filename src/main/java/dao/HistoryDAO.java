package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import domain.ActivityUser;
import domain.LikeReport;
import domain.LikeReportFull;
import model.History;
import model.User;
import model.Video;

public class HistoryDAO extends AbstractEntityDAO<History> {

	public HistoryDAO() {
		super(History.class);
	}

	public History findByVideoAndUser(String vid, String uid) {
		String jpql = "select o from History o Where o.user.id=:uid and o.video.id=:vid";
		EntityManager em = JpaUtils.getEntityManager();
		TypedQuery<History> query = em.createQuery(jpql, History.class);
		query.setParameter("uid", uid);
		query.setParameter("vid", vid);
		List<History> lst = query.getResultList();
		if (lst.size() > 0) {
			return lst.get(0);
		}
		return null;
	}

	public Long likeCount(String id) {
		// String jpql = "select o from History o Where o.likes = ?0 and o.video.id =
		// ?1";
		String jpql = "select count(o) from History o Where o.likes = ?0 and o.video.id = ?1";
		EntityManager em = JpaUtils.getEntityManager();
		TypedQuery<Long> query = em.createQuery(jpql, Long.class);
		query.setParameter(0, 2);
		query.setParameter(1, id);
		return query.getSingleResult();
	}
	public Long allLikeCount() {
		try {
			String jpql = "select count(o) from History o Where o.likes = 5";
			EntityManager em = JpaUtils.getEntityManager();
			TypedQuery<Long> query = em.createQuery(jpql, Long.class);
			return query.getSingleResult();
		} finally {
			// TODO: handle finally clause
		}
		
	}

	public Map<String, String> likeByVideo() {
		String jpql = "select new domain.LikeReport(h.video.id, count(h)) from History h where h.likes = 5 group by h.video.id";
		EntityManager em = JpaUtils.getEntityManager();
		List<LikeReport> lst = null;
		Map<String, String> map = new HashMap<String,String>();
		try {
			TypedQuery<LikeReport> query = em.createQuery(jpql, LikeReport.class);
			lst = query.getResultList();

			if (lst.size() > 0) {
				for (LikeReport l : lst) {
					map.put(l.getVideoId(), l.getLikeCount() + "");
				}
			}
		} finally {
			em.close();
		}
		return map;
	}

	public Map<String, Video> likeByUser(User u) {
		String jpql = "SELECT h FROM  History h Where h.likes=?0 AND h.user.username = ?1";
		EntityManager em = JpaUtils.getEntityManager();
		TypedQuery<History> query = em.createQuery(jpql, History.class);
		query.setParameter(0, 5);
		query.setParameter(1, u.getUsername());
		List<History> lst;
		lst = query.getResultList();
		Map<String, Video> map = new HashMap<String,Video>();
		for (History h : lst) {
			map.put(h.getVideo().getId(), h.getVideo());
		}
		return map;
	}
	public List<LikeReportFull> reportLikeByVideoForAdmin(String videoId){
		String jpql = "SELECT new domain.LikeReportFull(h.user.username,h.user.fullName,h.user.email,h.date) "
				+ " FROM History h where h.video.id = :videoId and h.likes = 5";
		EntityManager em = JpaUtils.getEntityManager();
		List<LikeReportFull> lst = null;
		try {
			TypedQuery<LikeReportFull> query = em.createQuery(jpql,LikeReportFull.class);
			query.setParameter("videoId", videoId);
			lst = query.getResultList();
		}finally {
			em.close();
		}
		return lst;
	}
	public List<ActivityUser> getActivityByUser(User u){
		String jpql = "SELECT new domain.ActivityUser(h.user.username,h.video.id,h.likes,h.date,h.video.title) "
				+ " FROM History h where h.user.username = :username and h.likes != 3";
		EntityManager em = JpaUtils.getEntityManager();
		List<ActivityUser> lst = null;
		try {
			TypedQuery<ActivityUser> query = em.createQuery(jpql,ActivityUser.class);
			query.setParameter("username", u.getUsername());
			lst = query.getResultList();
		}finally {
			em.close();
		}
		return lst;
	}
	
	
	
}	
