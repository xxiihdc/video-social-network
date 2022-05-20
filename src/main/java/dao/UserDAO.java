package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.User;

public class UserDAO extends AbstractEntityDAO<User> {

	public UserDAO() {
		super(User.class);

	}

	public boolean checkEmail(String email) {
		String jpql = "SELECT o FROM User o Where o.email=?0";
		EntityManager em = JpaUtils.getEntityManager();
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		query.setParameter(0, email);
		List<User> lst = query.getResultList();
		em.close();
		return lst.isEmpty();
	}


}
