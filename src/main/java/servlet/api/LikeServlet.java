package servlet.api;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;
import org.json.JSONObject;

import common.SessionUtils;
import dao.DataDAO;
import dao.HistoryDAO;
import dao.VideoDAO;
import model.History;
import model.User;
import model.Video;

@WebServlet("/like")
public class LikeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, String> map = new HashMap<String,String>();
		String valueLike = request.getParameter("value");
		int like;
		if((valueLike+"").equals("null")) {
			like = 5;
		}else {
			like = Integer.parseInt(valueLike);
		}
		if (SessionUtils.isLogin(request)) {
			System.out.println("like thanh cong");
			String id = request.getParameter("id");
			User u = (User) SessionUtils.get(request, "user");
			History his = new HistoryDAO().findByVideoAndUser(id, u.getUsername());
			Map<String,Video> mapLike = new HashMap<String,Video>();
			if(his == null) {
				VideoDAO dao = new VideoDAO();
				his = new History();
				his.setDate(new Date());
				his.setLikes(like);
				his.setUser(u);
				his.setVideo(dao.find(id));
				if(SessionUtils.get(request, "mapLikeByUser") != null) {
					mapLike = (Map<String, Video>) SessionUtils.get(request, "mapLikeByUser");
					mapLike.put(id, his.getVideo());
				}
				dao.closeSession();
			}else {
				if(his.getLikes()==1 || his.getLikes()==3) {
					his.setLikes(like);
					if(SessionUtils.get(request, "mapLikeByUser") != null) {
						mapLike = (Map<String, Video>) SessionUtils.get(request, "mapLikeByUser");
						mapLike.put(id, his.getVideo());
					}
				}else {
					his.setLikes(3);
					if(SessionUtils.get(request, "mapLikeByUser") != null) {
						mapLike = (Map<String, Video>) SessionUtils.get(request, "mapLikeByUser");
						mapLike.remove(id);
					}
				}	
			}
			SessionUtils.add(request, "mapLikeByUser", mapLike);
			VideoDAO dao = new VideoDAO();
			new HistoryDAO().update(his);
			Video v = dao.find(id);
			v.addViews();
			dao.update(v);
			dao.closeSession();
			new DataDAO().updateFileData(his.getUser().getUsername(), his.getVideo().getId(),his.getLikes());
			map.put("status", "true");
		} else {
			map.put("status", "false");
			System.out.println("like khong thanh cong");
		}
		JSONObject json = new JSONObject(map);
		response.getWriter().write(json.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}

}
