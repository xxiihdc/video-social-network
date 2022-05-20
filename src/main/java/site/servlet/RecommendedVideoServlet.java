package site.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.PageInfo;
import common.PageType;
import common.SessionUtils;
import dao.HistoryDAO;
import dao.UserDAO;
import model.History;
import model.User;
import model.Video;
import recomended.RecomendedItem;

@WebServlet("/recomended")
public class RecommendedVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RecommendedVideoServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User u = (User) SessionUtils.get(request, "user");
		UserDAO udao = new UserDAO();
		new RecomendedItem();
		List<Video> lst = new ArrayList<Video>();
		if(SessionUtils.get(request,"recomendedVideo" )== null) {
			lst = RecomendedItem.getRecomendVideo(new UserDAO().find(u.getUsername()));
		}else {
			lst = (List<Video>) SessionUtils.get(request, "recomendedVideo");
		}
		Map<String, String> map = new HashMap<>();
		if(SessionUtils.get(request, "") == null) {
			map = new HistoryDAO().likeByVideo();
		}else {
			map = (Map<String, String>) SessionUtils.get(request, "likeByVideo");
		}
		List<Video> lstHistory = new ArrayList<Video>();
		if (SessionUtils.get(request, "lstHistory") != null) {
			lstHistory = (List<Video>) SessionUtils.get(request, "lstHistory");
		}else {
			u = new UserDAO().find(u.getUsername());
			List<History> lstH = udao.find(u.getUsername()).getHistories();
			if (u.getHistories().size() > 0) {
				for (History h : lstH) {
					lstHistory.add(h.getVideo());
					if(lstHistory.size()>10) {
						break;
					}
				}
				SessionUtils.add(request, "lstHistory", lstHistory);
			}
		}
		request.setAttribute("his", lstHistory);
		request.setAttribute("videos", lst);
		request.setAttribute("like", map);
		PageInfo.prepareAndForward(request, response, PageType.HOME_RECOMEND_VIDEO);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
