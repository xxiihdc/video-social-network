package admin.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import common.PageInfo;
import common.PageType;
import common.SessionUtils;
import dao.HistoryDAO;
import dao.SubVideoDAO;
import dao.VideoDAO;
import filter.AuthFilter;
import model.Video;
import sub.model.SubVideo;
import youtube.servlet.ReadJsonYoutube;

@MultipartConfig
@WebServlet({ "/admin/crud/views", "/admin/crud/edit", "/admin/crud/add", "/admin/crud/hide" })
public class CrudVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CrudVideoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI();
		if (uri.contains("add")) {
			add(request, response);

		} else if (uri.contains("views")) {
			read(request, response);
		} else if (uri.contains("edit")) {
			edit(request, response);
		}
	}

	private void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageS = request.getParameter("page");
		final Integer VIDEO_SIZE = new VideoDAO().findAll().size();
		System.out.println(VIDEO_SIZE);
		pageS = pageS + "";
		int page = 1;
		if (pageS.equals("null")) {
			page = 1;
		} else {
			page = Integer.parseInt(pageS);
			if ((page - 1) > VIDEO_SIZE / 10 || page < 1) {
				page = 1;
			}
		}
		List<Video> lst = new VideoDAO().findAllDesc("views", (page - 1)*10, 10);
		Map<String, String> map = new HistoryDAO().likeByVideo();
		List<Video> hideVideos = new VideoDAO().findAllHide();
		request.setAttribute("hide", hideVideos);
		request.setAttribute("like", map);
		request.setAttribute("list", lst);
		request.setAttribute("pageNumber", page);
		request.setAttribute("size", (VIDEO_SIZE / 10) + 1);
		request.setAttribute("videoNum", VIDEO_SIZE);
		PageInfo.prepareAndForwardAdmin(request, response, PageType.ADMIN_LIST_VIDEO);
		String fullUrl = request.getRequestURL() + "?" + request.getQueryString();
		SessionUtils.add(request, "adminCurrentUrl", fullUrl);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("link");
		id = id + "";
		VideoDAO dao = new VideoDAO();
		if (id.contains("youtube.com/watch")) {
			Video video = getVideo(id);
			request.setAttribute("video", video);
			request.setAttribute("action", "add");
			boolean v = dao.isExist(video.getId());
			if (!v) {
				PageInfo.prepareAndForwardAdmin(request, response, PageType.ADD_VIDEO_DETAIL);
				return;
			} else {
				PageInfo.prepareAndForwardAdmin(request, response, PageType.ADD_VIDEO);
				return;
			}
		} else {
			PageInfo.prepareAndForwardAdmin(request, response, PageType.ADD_VIDEO);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("add")) {
			addVideo(request, response);
		} else if (uri.contains("edit")) {
			editVideo(request, response);
		} else if (uri.contains("hide")) {
			hideVideo(request, response);
		}

	}

	private void hideVideo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		VideoDAO dao = new VideoDAO();
		Video v = dao.find(id);
		v.setActive(!v.getActive());
		System.out.println(v.getActive());
		dao.update(v);
		response.getWriter().append("Update done");
		dao.closeSession();

	}

	private void editVideo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Video video = new Video();
		try {
			BeanUtils.populate(video, request.getParameterMap());
			VideoDAO dao = new VideoDAO();
			String des = video.getDescription();
			video.setDescription(replaceDes(des));
			dao.update(video);
			String currentUrl = SessionUtils.get(request, "adminCurrentUrl").toString();
			if ((currentUrl + "").equals("null")) {
				PageInfo.prepareAndForwardAdmin(request, response, PageType.ADMIN_LIST_VIDEO);
			} else {
				response.sendRedirect(currentUrl);
			}

		} catch (IllegalAccessException e) {

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		VideoDAO dao = new VideoDAO();
		Video v = dao.find(id);
		if (v == null) {
			System.out.println("video null");
		} else {
			v.setDescription(v.reveseDes());
			System.out.println("video not null");
			request.setAttribute("video", v);
			request.setAttribute("action", "edit");

			PageInfo.prepareAndForwardAdmin(request, response, PageType.ADD_VIDEO_DETAIL);
		}
		dao.closeSession();
	}

	private void addVideo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Video video = new Video();
		try {
			BeanUtils.populate(video, request.getParameterMap());
			VideoDAO dao = new VideoDAO();
			String des = video.getDescription();
			video.setDescription(replaceDes(des));
			SubVideo svideo = new SubVideo();
			svideo.setVideoId(video);
			dao.insert(video);
			new SubVideoDAO().insert(svideo);
			System.out.println(video.getDescription());
			PageInfo.prepareAndForwardAdmin(request, response, PageType.ADD_VIDEO);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private Video getVideo(String id) {
		return ReadJsonYoutube.getVideo(id);
	}

	private String replaceDes(String des) {
		return des.replaceAll("\n", "..breakline..");
	}
}
