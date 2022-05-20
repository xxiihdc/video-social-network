package test;

import java.util.List;
import java.util.Map;

import dao.ReplyCommentDAO;
import dao.VideoDAO;
import model.Comment;
import model.Video;

public class TestRepCmt {
	public static void main(String[] args) {
		VideoDAO dao = new VideoDAO();
		Video v = dao.find("zOILX7GCbjQ");
		List<Comment> lst = v.getComments();
		
		ReplyCommentDAO rdao = new ReplyCommentDAO();
		Map<Long,Integer> map = rdao.getCountReplyCommentByVideo(v);
		for (Map.Entry<Long, Integer> entry : map.entrySet()) {
			System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
		}
		dao.closeSession();
	}
}
