package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import domain.ActivityUser;
import model.Share;
import model.User;

public class ShareDAO extends AbstractEntityDAO<Share>{

	public ShareDAO() {
		super(Share.class);
		// TODO Auto-generated constructor stub
	}
	public List<ActivityUser> getActivityByUser(User u){
		String jpql = "SELECT new domain.ActivityUser(s.user.username,s.video.id,s.email,s.date,s.video.title) "
				+ " FROM Share s where s.user.username = :username";
		EntityManager em = JpaUtils.getEntityManager();
		List<ActivityUser> lst = null;
		try {
			TypedQuery<ActivityUser> query = em.createQuery(jpql,ActivityUser.class);
			query.setParameter("username", u.getUsername());
			lst = query.getResultList();
		}finally {
			em.close();
		}
		for(ActivityUser a : lst) {
			a.setContent("Chia sẻ video đến: "+ a.getContent());
		}
		return lst;
	}

}
