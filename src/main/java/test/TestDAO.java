package test;

import java.util.List;

import dao.VideoDAO;
import model.Video;

public class TestDAO {
	public static void main(String[] args) {
//		User u = new User();
//		u.setUsername("rose");
//		Map<String,String> map = new HistoryDAO().likeByUser(u);
//		System.out.println(map.size());
//		System.out.println(map.get("s"));
		
		
		VideoDAO dao = new VideoDAO();
		List<Video> lst = dao.findAllDesc("views",0,8);
		System.out.println(lst.size());
		for(Video v :lst) {
			System.out.println(v.getTitle());
		}
	}
}
