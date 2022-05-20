package dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import sub.model.SubUser;
import sub.model.SubVideo;

public class SubVideoDAO extends AbstractEntityDAO<SubVideo> {

	public SubVideoDAO() {
		super(SubVideo.class);
		// TODO Auto-generated constructor stub
	}

	public SubVideo findByVideo(String videoId) {
		String jpql = "SELECT o FROM SubVideo o Where o.videoId.id=?0";
		EntityManager em = JpaUtils.getEntityManager();
		TypedQuery<SubVideo> query = em.createQuery(jpql,SubVideo.class);
		query.setParameter(0, videoId);
		SubVideo u = query.getSingleResult();
		em.close();
		return u;
	}
	

}
