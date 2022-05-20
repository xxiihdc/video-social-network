package test;

import java.util.List;

import dao.UserDAO;
import model.Video;
import recomended.RecomendedItem;

public class TestRecomend {
	public static void main(String[] args) {
		List<Video> lst = new RecomendedItem().getRecomendVideo(new UserDAO().find("user23"));
		if (lst != null) {
			System.out.println(lst.size());
			for (Video v : lst) {
				System.out.println(v.getTitle());
			}
		}else {
			System.out.println("hong tim thay mat hang nao");
		}
		
	}
}
