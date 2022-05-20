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

/**
 * Servlet implementation class FavoriteServlet
 */
@WebServlet("/favorite")
public class FavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FavoriteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String page = request.getParameter("page");
		page = page + "";
		int pageI = 0;
		if (page.equals("null")) {
			pageI = 1;
		} else {
			pageI = Integer.parseInt(page);
		}
		if(pageI<1) {
			pageI=1;
		}
		// Like in video
		HistoryDAO hdao = new HistoryDAO();
		User u = (User) SessionUtils.get(request, "user");
		Map<String, String> map = new HashMap<String, String>();//
		if (SessionUtils.get(request, "likeByVideo") == null) {
			map = hdao.likeByVideo();
			SessionUtils.add(request, "likeByVideo", map);
		} else {
			map = (Map<String, String>) SessionUtils.get(request, "likeByVideo");
		}
		// like by user
		Map<String, Video> mapLikeByUser = new HashMap<String, Video>();
		// List history
		List<Video> lstHistory = new ArrayList<Video>();
		if (u != null) {
			if (SessionUtils.get(request, "lstHistory") != null) {
				lstHistory = (List<Video>) SessionUtils.get(request, "lstHistory");
			} else {
				u = new UserDAO().find(u.getUsername());
				List<History> lstH = new UserDAO().find(u.getUsername()).getHistories();
				if (u.getHistories().size() > 0) {
					for (History h : lstH) {
						lstHistory.add(h.getVideo());
						if (lstHistory.size() > 10) {
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

			if (SessionUtils.get(request, "mapLikeByUser") != null) {
				List<Video> favoriteLst = new ArrayList<>();
				Map<String, Video> map2 = (Map<String, Video>) SessionUtils.get(request, "mapLikeByUser");
				for (Map.Entry<String, Video> entry : map2.entrySet()) {
					favoriteLst.add(entry.getValue());
				}
				SessionUtils.add(request, "likeByUserLst", favoriteLst);
			}
		}
		List<Video> lst = new ArrayList<Video>();
		List<Video> lst8 = new ArrayList<Video>();
		if (SessionUtils.get(request, "likeByUserLst") != null) {
			lst = (List<Video>) SessionUtils.get(request, "likeByUserLst");
		} else {
			if (SessionUtils.get(request, "mapLikeByUser") != null) {
				Map<String, Video> map2 = new HashMap<String, Video>();
				for (Map.Entry<String, Video> entry : map2.entrySet()) {
					lst.add(entry.getValue());
				}
				SessionUtils.add(request, "likeByUserLst", lst);
			}
		}
		int from = pageI;
		lst8 = getResutl(lst, from);

		request.setAttribute("maplbu", mapLikeByUser);
		request.setAttribute("his", lstHistory);
		request.setAttribute("like", map);
		request.setAttribute("videos", lst8);
		PageInfo.prepareAndForward(request, response, PageType.HOME_FAVORITE_VIDEO);
	}

	private List<Video> getResutl(List<Video> lst, int from) {
		List<Video> lst2 = new ArrayList<Video>();
		if (from == 1) {
			for (int i = 0; i < 8; i++) {
				if (lst.size() > i) {
					lst2.add(lst.get(i));
				} else {
					break;
				}
			}
		} else {
			int start = (from - 1) * 8;
			int end = from * 8;
			for (int i = start; i < end; i++) {
				if (lst.size() > i) {
					lst2.add(lst.get(i));
				} else {
					break;
				}
			}
		}
		return lst2;

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
