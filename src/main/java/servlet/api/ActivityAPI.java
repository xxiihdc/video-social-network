package servlet.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.SessionUtils;
import common.Xdate;
import dao.ActivityUserDAO;
import dao.UserDAO;
import domain.ActivityUser;
import model.User;

/**
 * Servlet implementation class ActivityAPI
 */
@WebServlet({ "/admin/activity", "/userActivity" })
public class ActivityAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ActivityAPI() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User u = null;
		String uri = request.getRequestURI();
		if (uri.contains("admin")) {
			String username = request.getParameter("id");
			u = new UserDAO().find(username);
			
		}else {
			u = (User) SessionUtils.get(request, "user");
		}
		List<ActivityUser> lst = new ActivityUserDAO().getActivity(u);
		String head = "<div class=\"col-12\" style = \"padding: 15px\">\r\n"
				+ "		<div class=\"card mt-3\">\r\n" + "			<div class=\"card-header\" >\r\n"
				+ "				<i class=\"fas fa-edit\"></i> Danh sách hoạt động\r\n" + "			</div>\r\n"
				+ "			<div class=\"card-body\" style=\"max-height:500px; overflow: scroll; overflow-x: hidden;\">\r\n"
				+ "				<table class=\"table table-bordered table-hover\">\r\n"
				+ "					<thead>\r\n"
				+ "						<tr class=\"text-center table-warning\">\r\n"
				+ "							<th scope=\"col\">#</th>\r\n"
				+ "							<th class=\"align-middle\">Nội dung</th>\r\n"
				+ "							<th class=\"align-middle\">Video</th>\r\n"
				+ "							<th class=\"align-middle\">Ngày</th>\r\n"
				+ "						</tr>\r\n" + "					</thead>\r\n"
				+ "					<tbody>";
		String foot = "</tbody>\r\n" + "				</table>\r\n" + "			</div>\r\n"
				+ "			<div class=\"card-footer\"></div>\r\n" + "		</div>\r\n" + "	</div>";
		StringBuilder sb = new StringBuilder();
		for (int i =0; i<lst.size();i++) {
			String date = Xdate.toString(lst.get(i).getDate(), "dd-MM-yyyy");
			sb.append("						<tr>\r\n" + "							<th scope=\"row\">"+(i+1)+"</th>\r\n"
					+ "							<td class=\"text-center align-middle\">"+lst.get(i).getContent()+"</td>\r\n"
					+ "							<td class=\"text-center align-middle\">"+lst.get(i).getVideoTitle()+"</td>\r\n"
					+ "							<td class=\"text-center align-middle\">"+date+"</td>\r\n"
					+ "							\r\n" + "						</tr>");
		}
			response.getWriter().append(head+sb.toString()+foot);
	}
}
