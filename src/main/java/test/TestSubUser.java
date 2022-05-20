package test;

import dao.SubUserDAO;
import sub.model.SubUser;

public class TestSubUser {
	public static void main(String[] args) {
		SubUser sub = new SubUserDAO().findByUser("user8");
		System.out.println(sub.getId());
	}
}
