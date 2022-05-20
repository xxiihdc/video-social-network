package insertdata;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import dao.HistoryDAO;
import dao.UserDAO;
import dao.VideoDAO;
import model.History;
import model.User;
import model.Video;

public class FakeHistoryData {
	public static void main(String[] args) {
		String[] users = { "admin", "baga", "ductvh", "gdragon", "gg.ductran090500", "gg.ductvhpd04166", "khanhnk",
				"rose", "user10", "user11", "user12", "user13", "user14", "user15", "user16", "user17", "user18",
				"user19", "user20", "user21", "user22", "user23", "user25", "user8", "user9", "yelly" };
		int[] likes = { 1, 3, 5 };
		List<User> lst = new UserDAO().findAll();
		List<Video> lstV = new VideoDAO().findAll();
		Map<Integer, Video> map = new HashMap<Integer, Video>();
		for (int i = 0; i < lstV.size(); i++) {
			map.put(i, lstV.get(i));
		}
//		StringBuilder sb = new StringBuilder();
//		sb.append("{ \"");
//		//System.out.println(sb.toString());
//		for(User u : lst) {
//			sb.append(u.getUsername()+"\",\"");
//		}
//		System.out.println(sb.toString());
		Random rand = new Random();
		HistoryDAO dao = new HistoryDAO();
		for (User u : lst) {
			Map<Integer, Video> map2 = new HashMap<Integer, Video>();
			map2.putAll(map);
			for (int j = 0; j < 31; j++) {
				Object [] objs = getVideo(map, rand);
				Video v = (Video) objs[0];
				map.remove(objs[1]);
				
				History h = new History();
				h.setDate(new Date());
				h.setUser(u);
				h.setLikes(likes[rand.nextInt(3)]);
				h.setVideo(v);
				dao.insert(h);
				System.out.println(u.getUsername() + "Lan thu: " + j);
			}

		}
	}

	public static Object[] getVideo(Map<Integer, Video> map, Random rand) {
		int random = rand.nextInt();
		Video v = map.get(rand.nextInt(78));
		if (v==null) {
			getVideo(map, rand);
		}
		Object [] objs = {v,random};
		return objs;
	}
}
