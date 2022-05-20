package dao;


import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.hibernate.Session;


public class JpaUtils {
	public static EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("Java4-Asm").createEntityManager();
	}

	public static Session getSession() {
		return getEntityManager().unwrap(Session.class);
	}
}
