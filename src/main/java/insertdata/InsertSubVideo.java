package insertdata;

import java.util.List;

import dao.SubVideoDAO;
import dao.VideoDAO;
import model.Video;
import sub.model.SubVideo;

public class InsertSubVideo {
	public static void main(String[] args) {
		List<Video> lst = new VideoDAO().findAll();
		int i = 1;
		for(Video v : lst) {
			if(!v.getId().equals("WXBHCQYxwr0")) {
				SubVideo sub = new SubVideo();
				sub.setVideoId(v);
				new SubVideoDAO().insert(sub);
				System.out.println(i);
				i++;
			}
		}
	}
}
