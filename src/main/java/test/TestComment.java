package test;

import java.util.List;

import dao.VideoDAO;
import model.Comment;
import model.Video;

public class TestComment {
	public static void main(String[] args) {
		Video v = new VideoDAO().find("BokHXojuyrM");
		List<Comment> lst = v.getComments();
		System.out.println(lst.size());
	}
	
}
