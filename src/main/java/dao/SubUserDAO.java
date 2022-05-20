package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.User;
import sub.model.SubUser;

public class SubUserDAO  extends AbstractEntityDAO<SubUser>{

	public SubUserDAO() {
		super(SubUser.class);
		// TODO Auto-generated constructor stub
	}

	public SubUser findByUser(String username) {
		String jpql = "SELECT o FROM SubUser o Where o.username.username=?0";
		EntityManager em = JpaUtils.getEntityManager();
		TypedQuery<SubUser> query = em.createQuery(jpql,SubUser.class);
		query.setParameter(0, username);
		SubUser u = query.getSingleResult();
		em.close();
		return u;
	}

}
