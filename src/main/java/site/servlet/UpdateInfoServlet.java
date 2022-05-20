package site.servlet;

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

import common.SessionUtils;
import dao.ActivityUserDAO;
import dao.UserDAO;
import domain.ActivityUser;
import google.login.Constants;
import model.User;

@MultipartConfig
@WebServlet("/info")
public class UpdateInfoServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User u = (User) SessionUtils.get(request, "user");
		List<ActivityUser> lst = new ActivityUserDAO().getActivity(u);
		request.setAttribute("activity", lst);
		request.getRequestDispatcher("views/site/infomation.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletContext servletContext = this.getServletConfig().getServletContext();
			File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
			factory.setRepository(repository);
			ServletFileUpload upload = new ServletFileUpload(factory);
			User u = new User();
			UserDAO dao = new UserDAO();
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
						//System.out.println("change image OK");
					}
				} else if (item.getFieldName().equals("username")) {
					u.setUsername(item.getString());
					String pass = dao.find(u.getUsername()).getPassword();
					u.setPassword(pass);
				} else if (item.getFieldName().equals("email")) {
					u.setEmail(item.getString());
				} else if (item.getFieldName().equals("fullName")) {
					u.setFullName(item.getString("UTF-8"));
				}
				//System.out.println("Vao vong for");
			}
			if((u.getImage()+"").equalsIgnoreCase("null")) {
				u.setImage(Constants.DEFAULT_IMAGE);
			}
			dao.update(u);
			doGet(request, response);
			System.out.println(u.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
