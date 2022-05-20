package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.User;
import sub.model.ResetPasswordToken;

public class ResetPasswordTokenDAO extends AbstractEntityDAO<ResetPasswordToken> {

	public ResetPasswordTokenDAO() {
		super(ResetPasswordToken.class);
		// TODO Auto-generated constructor stub
	}

	public ResetPasswordToken findByToken(String token) {
		String jpql = "SELECT r FROM ResetPasswordToken r Where r.token=?0";
		EntityManager em = JpaUtils.getEntityManager();
		TypedQuery<ResetPasswordToken> query = em.createQuery(jpql, ResetPasswordToken.class);
		query.setParameter(0, token);
		List<ResetPasswordToken> lst = query.getResultList();
		em.close();
		if (lst.size() > 0) {
			return lst.get(0);
		}
		return null;
	}

}
