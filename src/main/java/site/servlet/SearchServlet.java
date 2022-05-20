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

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String query = request.getParameter("search");
		HistoryDAO hdao = new HistoryDAO();
		UserDAO udao = new UserDAO();
		User u = (User) SessionUtils.get(request, "user");
		if ((query + "").equals("null")) {
			PageInfo.prepareAndRedirectHome(response);
			return;
		}

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
				List<History> lstH = udao.find(u.getUsername()).getHistories();
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

		}

		VideoDAO dao = new VideoDAO();
		List<Video> lstKey = dao.findByKeyword(query);
		request.setAttribute("maplbu", mapLikeByUser);
		request.setAttribute("videos", lstKey);
		request.setAttribute("his", lstHistory);
		request.setAttribute("like", map);
		PageInfo.prepareAndForward(request, response, PageType.SEARCH);
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
