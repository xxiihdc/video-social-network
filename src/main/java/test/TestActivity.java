package test;

import java.util.List;

import dao.ActivityUserDAO;
import dao.CommentDAO;
import dao.HistoryDAO;
import dao.ReplyCommentDAO;
import dao.ShareDAO;
import domain.ActivityUser;
import model.User;

public class TestActivity {
	public static void main(String[] args) {
//		ShareDAO dao = new ShareDAO();
		User u = new User();
		u.setUsername("rose");
//		List<ActivityUser> lst = dao.getActivityByUser(u); 
//		if(!lst.isEmpty()) {
//			System.out.println(lst.get(0).getContent());
//		}
//		System.out.println("done");
//		
//		HistoryDAO hdao = new HistoryDAO();
//		List<ActivityUser> lst2 = hdao.getActivityByUser(u); 
//		for(ActivityUser a: lst2) {
//			System.out.println(a.getVideoTitle());
//		}
//		CommentDAO cdao = new CommentDAO();
//		List<ActivityUser> lst3 = cdao.getActivityByUser(u); 
//		for(ActivityUser a: lst3) {
//			System.out.println(a.getContent());
//		}
//		
//		ReplyCommentDAO rdao = new ReplyCommentDAO();
//		List<ActivityUser> lst4 = rdao.getActivityByUser(u); 
//		for(ActivityUser a: lst4) {
//			System.out.println(a.getContent());
//		}
		ActivityUserDAO dao = new ActivityUserDAO();
		List<ActivityUser> lst = dao.getActivity(u);
		System.out.println(lst.size());
	}
}
