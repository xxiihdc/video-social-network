package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import domain.ActivityUser;
import model.Comment;
import model.User;
import model.Video;

public class CommentDAO extends AbstractEntityDAO<Comment> {

	public CommentDAO() {
		super(Comment.class);
		// TODO Auto-generated constructor stub
	}

	public Comment findLastId() {
		EntityManager em = JpaUtils.getEntityManager();
		try {

			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Comment> cq = cb.createQuery(Comment.class);
			Root<Comment> root = cq.from(Comment.class);
			cq.orderBy(cb.desc(root.get("id")));
			Query query = em.createQuery(cq);
			Comment c = (Comment) query.getResultList().get(0);
			return c;
		} finally {
			em.close();
		}
	}

	public List<ActivityUser> getActivityByUser(User u) {
		String jpql = "SELECT new domain.ActivityUser(c.user.username,c.video.id,c.text,c.date,c.video.title) "
				+ " FROM Comment c where c.user.username = :username";
		EntityManager em = JpaUtils.getEntityManager();
		List<ActivityUser> lst = null;
		try {
			TypedQuery<ActivityUser> query = em.createQuery(jpql, ActivityUser.class);
			query.setParameter("username", u.getUsername());
			lst = query.getResultList();
		} finally {
			em.close();
		}
		return lst;
	}

}
