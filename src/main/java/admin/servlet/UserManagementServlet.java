package admin.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import common.PageInfo;
import common.PageType;
import dao.UserDAO;
import google.login.Constants;
import model.User;

/**
 * Servlet implementation class UserManagementServlet
 */
@MultipartConfig
@WebServlet({ "/admin/crud/user", "/admin/crud/addUser" })
public class UserManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserManagementServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI();

		if (uri.contains("addUser")) {
			PageInfo.prepareAndForwardAdmin(request, response, PageType.ADMIN_ADD_USER);
		} else {
			String page = request.getParameter("page");
			int pageI;
			if ((page + "").equals("null")) {
				pageI = 1;
			} else {
				try {
					pageI = Integer.parseInt(page);
					if (pageI < 1)
						pageI = 1;
				} catch (NumberFormatException e) {
					pageI = 1;
				}
			}
			UserDAO dao = new UserDAO();
			List<User> lst = dao.findAll((pageI - 1) * 7, 7);
			request.setAttribute("users", lst);
			request.setAttribute("pageIndex", pageI);
			PageInfo.prepareAndForwardAdmin(request, response, PageType.ADMIN_LIST_USER);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			User u = new User();
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletContext servletContext = this.getServletConfig().getServletContext();
			File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
			factory.setRepository(repository);
			ServletFileUpload upload = new ServletFileUpload(factory);
			List<FileItem> items = upload.parseRequest(request);
			System.out.println(items.size());
			for (FileItem item : items) {
				if (item.getFieldName().equals("image")) {
					if (item.getSize() > 0) {
						String originalFiname = item.getName();
						int index = originalFiname.lastIndexOf(".");
						String ext = originalFiname.substring(index + 1);
						String fileName = System.currentTimeMillis() + "." + ext;
						File file = new File(Constants.DIR + "\\" + fileName);
						item.write(file);
						String urlFile = "http:\\\\localhost:8080/pd04166.asm\\image\\" + fileName;
						u.setImage(urlFile);
					}
				} else if (item.getFieldName().equals("username")) {
					u.setUsername(item.getString());
				} else if (item.getFieldName().equals("email")) {
					u.setEmail(item.getString());
				} else if (item.getFieldName().equals("fullName")) {
					u.setFullName(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("password")) {
					u.setPassword(item.getString());
				} else if (item.getFieldName().equals("admin")) {
					String admin = item.getString();
					if (admin.equals("true")) {
						u.setAdmin(true);
					} else {
						u.setAdmin(false);
					}
				}
				// System.out.println("Vao vong for");
			}
			if ((u.getImage() + "").equalsIgnoreCase("null")) {
				u.setImage(Constants.DEFAULT_IMAGE);
			}
			new UserDAO().insert(u);
			doGet(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
