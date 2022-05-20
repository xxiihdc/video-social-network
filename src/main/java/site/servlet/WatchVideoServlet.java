package site.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.SessionUtils;
import dao.DataDAO;
import dao.HistoryDAO;
import dao.ReplyCommentDAO;
import dao.UserDAO;
import dao.VideoDAO;
import model.Comment;
import model.History;
import model.User;
import model.Video;
import recomended.RecomendedItem;


@WebServlet("/watch")
public class WatchVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = (User) SessionUtils.get(request, "user");
		String id = request.getParameter("id");
		String link = getLink(id);
		VideoDAO dao = new VideoDAO();
		request.setAttribute("link", link);
		Video v = dao.find(id);
		v.setViews(v.getViews()+1);
		new VideoDAO().update(v);
		request.setAttribute("video", v);
		request.setAttribute(link, response);
		List<Comment> lst = v.getComments();
		List<Video> recommended = new ArrayList<Video>();
		if(SessionUtils.get(request, "recomendedVideo") != null) {
			List<Video> list = (List<Video>) SessionUtils.get(request, "recomendedVideo");
			recommended = list;
		}else {
			recommended = new RecomendedItem().getRecomendVideo(new UserDAO().find(u.getUsername()));
		}
		
		if(recommended.isEmpty()) {
			recommended = dao.findAll(0, 8);
		}
		request.setAttribute("rcm", recommended);
		request.setAttribute("videoCmt", lst);
		ReplyCommentDAO rdao = new ReplyCommentDAO();
		Map<Long,Integer> map = rdao.getCountReplyCommentByVideo(v);
		request.setAttribute("mapCmt", map);
		
		
		
		History history;
		HistoryDAO hdao = new HistoryDAO();
		history = hdao.findByVideoAndUser(v.getId(),u.getUsername());
		boolean isLike = false;
		boolean isDisLike = false;
		if(history!=null) {
			history.setDate(new Date());
			hdao.update(history);
			if(history.getLikes()==5) {
				isLike=true;
				isDisLike=false;
			}else if(history.getLikes()==1) {
				isDisLike=true;
				isLike=false;
			}
			System.out.println("update history");
		}else {
			history = new History();
			history.setDate(new Date());
			history.setLikes(3);//da xem
			history.setUser((User) SessionUtils.get(request, "user"));
			history.setVideo(v);
			new HistoryDAO().insert(history);
			new DataDAO().updateFileData(history.getUser().getUsername(), v.getId(), 3);
		}
		request.setAttribute("isLike", isLike);
		request.setAttribute("isDisLike", isDisLike);
		request.getRequestDispatcher("views/site/watch-video.jsp").forward(request, response);
		if(SessionUtils.get(request, "lstHistory")!= null) {
			List<Video> lst2 = (List<Video>) SessionUtils.get(request, "lstHistory");
			lst2.add(0,v);
			SessionUtils.add(request, "lstHistory", lst2);
		}
		dao.closeSession();
	}


	private String getLink(String id) {
		return "https://www.youtube.com/embed/"+id;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
