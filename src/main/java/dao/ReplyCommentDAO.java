package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import domain.ActivityUser;
import model.Comment;
import model.ReplyComment;
import model.User;
import model.Video;

public class ReplyCommentDAO extends AbstractEntityDAO<ReplyComment>{

	public ReplyCommentDAO() {
		super(ReplyComment.class);
	}
	public List<ReplyComment> getReplyCommentByCommentId(long commentId){
		EntityManager em = JpaUtils.getEntityManager();
		try {
			String jpql = "SELECT r FROM ReplyComment r Where r.commentId=?0";
			TypedQuery<ReplyComment> query = em.createQuery(jpql,ReplyComment.class);
			query.setParameter(0, commentId);
			return query.getResultList();
		} finally {
			em.close();
		} 
	}
	public Map<Long,Integer> getCountReplyCommentByVideo(Video v){// Long: cmt id , Integer : reply count
		Map<Long,Integer> map = new HashMap<>();
		List<Comment> cmts = v.getComments();
		for(Comment c : cmts) {
			map.put(c.getId(), this.countReplyByCommentId(c.getId()));
		}
		return map;
	}
	private int countReplyByCommentId(long id) {
		String nativeQuery = "SELECT COUNT(*) FROM ReplyComments WHERE ReplyComments.commentId = "+id;
		Session session = JpaUtils.getSession();
		NativeQuery query = session.createSQLQuery(nativeQuery);
		Object value = query.getSingleResult();
		session.close();
		return (int) value;
	}
	
	public List<ActivityUser> getActivityByUser(User u) {
		String jpql = "SELECT new domain.ActivityUser(r.user.username,r.commentId,r.text,r.date) "
				+ " FROM ReplyComment r where r.user.username = :username";
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
