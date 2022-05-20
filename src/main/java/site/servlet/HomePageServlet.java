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
import dao.VideoDAO;
import model.History;
import model.User;
import model.Video;
import recomended.RecomendedItem;

@WebServlet("/home")
public class HomePageServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			UserDAO udao = new UserDAO();
			VideoDAO dao = new VideoDAO();
			HistoryDAO hdao = new HistoryDAO();
			final Integer VIDEO_SIZE = (Integer) SessionUtils.get(request, "VIDEO_SIZE");
			String pageS = request.getParameter("page");
			pageS = pageS + "";
			int page = 1;
			if (pageS.equals("null")) {
				page = 1;
			} else {
				page = Integer.parseInt(pageS);
				if ((page - 1) > VIDEO_SIZE / 8) {
					page = 1;
				}
			}
			List<Video> list = dao.findAllDesc("views", (page - 1) * 8, 8);
			User u = (User) SessionUtils.get(request, "user");

			// Like in video
			Map<String,String> map = new HashMap<String,String>();//
			if(SessionUtils.get(request, "likeByVideo") == null) {
				map = hdao.likeByVideo();
				SessionUtils.add(request, "likeByVideo",map);
			}else {
				map = (Map<String, String>) SessionUtils.get(request, "likeByVideo");
			}
			// like by user
			Map<String, Video> mapLikeByUser = new HashMap<String,Video>();
			// List history
			List<Video> lstHistory = new ArrayList<Video>();
			if (u != null) {
				if (SessionUtils.get(request, "lstHistory") != null) {
					lstHistory = (List<Video>) SessionUtils.get(request, "lstHistory");
				} else {
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
				if (SessionUtils.get(request, "mapLikeByUser") != null) {
					System.out.println("session map like by user not null");
					mapLikeByUser = (Map<String, Video>) SessionUtils.get(request, "mapLikeByUser");
				} else {
					mapLikeByUser = hdao.likeByUser(u);
					SessionUtils.add(request, "mapLikeByUser", mapLikeByUser);
				}

			}
			request.setAttribute("maplbu", mapLikeByUser);
			request.setAttribute("pageNumber", page);
			request.setAttribute("size", (VIDEO_SIZE / 8) + 1);
			request.setAttribute("videos", list);
			request.setAttribute("his", lstHistory);
			request.setAttribute("like", map);
			PageInfo.prepareAndForward(request, response, PageType.HOME_PAGE);
			
			
			
			if (SessionUtils.get(request, "mapLikeByUser") != null) {
				List<Video> favoriteLst = new ArrayList<>();
				Map<String,Video> map2 = (Map<String, Video>) SessionUtils.get(request, "mapLikeByUser");
				for (Map.Entry<String, Video> entry : map2.entrySet()) {
					favoriteLst.add(entry.getValue());
				}
				SessionUtils.add(request, "likeByUserLst", favoriteLst);
			}
			
			
			
			if(SessionUtils.get(request, "recomendedVideo") == null && u != null) {
				List<Video> lst = RecomendedItem.getRecomendVideo(udao.find(u.getUsername()));
				SessionUtils.add(request,"recomendedVideo" , lst);
			}
		} catch (Exception e) {
			e.printStackTrace();
			PageInfo.prepareAndForward(request, response, PageType.HOME_PAGE);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
