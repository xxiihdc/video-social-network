package common;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;

import google.login.Constants;

public class PageInfo {
	public static Map<PageType, PageInfo> pageRoute = new HashedMap();
	static {
		//pageRoute.put(PageType.REGISTER_PAGE, new PageInfo("Register New User", "views/site/register.jsp", null));
		//pageRoute.put(PageType.LOGIN_PAGE, new PageInfo("Login", "/views/site/login.jsp", null));
		pageRoute.put(PageType.HOME_PAGE, new PageInfo("JZTR Entertaiment All Video", "home-all-video.jsp", null));
		pageRoute.put(PageType.ADD_VIDEO, new PageInfo("JZTR Add Video", "video-id.jsp", null));
		pageRoute.put(PageType.ADD_VIDEO_DETAIL, new PageInfo("JZTR Add Video", "addVideo.jsp", null));
		pageRoute.put(PageType.ADMIN_HOME, new PageInfo("JZTR Add Video", "chart.jsp", null));
		pageRoute.put(PageType.ADMIN_LIST_VIDEO, new PageInfo("JZTR Add Video", "list-video.jsp", null));
		pageRoute.put(PageType.HOME_RECOMEND_VIDEO, new PageInfo("JZTR Recomended Video", "recomended-video.jsp", null));
		pageRoute.put(PageType.HOME_FAVORITE_VIDEO, new PageInfo("JZTR Video Favorite Video", "favorites.jsp", null));
		pageRoute.put(PageType.ADMIN_LIST_USER, new PageInfo("JZTR Admin Management", "user-management.jsp", null));
		pageRoute.put(PageType.SEARCH, new PageInfo("JZTR Search", "search.jsp", null));
		pageRoute.put(PageType.ADMIN_ADD_USER, new PageInfo("JZTR Admin", "addUser.jsp", null));
	}
	public static void prepareAndForward(HttpServletRequest req, HttpServletResponse res,PageType page) throws ServletException, IOException {
		PageInfo pageInfo = pageRoute.get(page);
		req.setAttribute("page", pageInfo);
		req.getRequestDispatcher("/views/site/layout.jsp").forward(req, res);
	}
	public static void prepareAndForwardAdmin(HttpServletRequest req, HttpServletResponse res,PageType page) throws ServletException, IOException {
		PageInfo pageInfo = pageRoute.get(page);
		req.setAttribute("page", pageInfo);
		req.getRequestDispatcher("/views/admin/index.jsp").forward(req, res);
	}
	public static void prepareAndRedirectLogin(HttpServletResponse res) throws IOException {
		res.sendRedirect("http://localhost:8080/pd04166.asm/login");
	}
	public static void prepareAndRedirectHome(HttpServletResponse res) throws IOException {
		res.sendRedirect("http://localhost:8080/pd04166.asm/home");
	}
	public static void forwardLogin(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		req.getRequestDispatcher("/views/site/login.jsp").forward(req, res);
	}
	public static void forwardResgiter(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		req.getRequestDispatcher("/views/site/register.jsp").forward(req, res);
	}
	private String title;
	private String contentUrl;
	private String scriptUrl;

	public String getTitle() {
		return title;
	}

	public PageInfo(String title, String contentUrl, String scriptUrl) {
		this.title = title;
		this.contentUrl = contentUrl;
		this.scriptUrl = scriptUrl;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContentUrl() {
		return contentUrl;
	}

	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}

	public String getScriptUrl() {
		return scriptUrl;
	}

	public void setScriptUrl(String scriptUrl) {
		this.scriptUrl = scriptUrl;
	}
	public static void prepareAndRedirectAdminHome(HttpServletRequest request, HttpServletResponse response,
			PageType adminHome) throws IOException {
		PageInfo pageInfo = pageRoute.get(adminHome);
		response.sendRedirect(Constants.WEBAPP_HOST+"pd04166.asm/admin/home");
	}
}
