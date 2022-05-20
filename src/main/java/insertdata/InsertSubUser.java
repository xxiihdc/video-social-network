package insertdata;

import java.util.List;

import dao.SubUserDAO;
import dao.UserDAO;
import model.User;
import sub.model.SubUser;

public class InsertSubUser {
	public static void main(String[] args) {
		List<User> lst = new UserDAO().findAll();
		SubUserDAO dao = new SubUserDAO();
		int i = 1;
		for(User u : lst) {
			SubUser sub = new SubUser();
			sub.setUserId(u);
			dao.insert(sub);
			System.out.println(i);
			i++;
		}
	}
}
