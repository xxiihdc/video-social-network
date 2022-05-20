package servlet.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.SessionUtils;
import common.Xdate;
import dao.ReplyCommentDAO;
import dao.VideoDAO;
import model.ReplyComment;
import model.User;
import model.Video;


@WebServlet("/apiReplyComment")
public class APIReplyComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cmtId = request.getParameter("id");
		ReplyCommentDAO dao = new ReplyCommentDAO();
		List<ReplyComment> lst = dao.getReplyCommentByCommentId(Long.parseLong(cmtId));
		PrintWriter out = response.getWriter();
		for(ReplyComment r : lst) {
			String time = Xdate.toString(r.getDate(), "HH:mm:ss dd/MM/yyyy");
			out.append("<div class=\" row mt-2\" style=\"padding: 4px 8px;\">\r\n"
					+ "<img src=\""+  r.getUser().getImage() +"\" class=\" rounded-circle\" width=\"35px\" height=\"35px\"\r\n"
					+ "style=\"float: left\" />\r\n"
					+ "<p style=\"float: left\">\r\n"
					+ "<span class=\"comment-name ml-2\">"+r.getUser().getFullName() +"\r\n"
					+ "<small class=\"text-muted\">"+time+"</small>\r\n"
					+ "</span> <br /> <span class=\"comment ml-2\">"+r.getText()+"</span>\r\n"
					+ "</p>\r\n"
					+ "</div>");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VideoDAO dao = new VideoDAO();
		String text = request.getParameter("text");
		String cmtId = request.getParameter("commentId");
		String videoId = request.getParameter("videoId");
		User u = (User) SessionUtils.get(request, "user");
		Video v = dao.find(videoId);
		dao.closeSession();
		ReplyComment rep = new ReplyComment();
		rep.setCommentId(Long.parseLong(cmtId));
		rep.setDate(new Date());
		System.out.println(rep.getDate());
		rep.setText(text);
		rep.setUser(u);
		String time = Xdate.toString(rep.getDate(), "hh:mm:ss dd/MM/yyyy");
		new ReplyCommentDAO().insert(rep);
		PrintWriter out = response.getWriter();
		out.append("<div class=\" row mt-2\" style=\"padding: 4px 8px;\">\r\n"
				+ "<img src=\"" + u.getImage() + "\" class=\"rounded-circle\" width=\"35px\" height=\"35px\" style=\"float: left\" />\r\n"
				+ "<p style=\"float: left\">\r\n"
				+ "<span class=\"comment-name ml-2\">"+ u.getFullName() +"\r\n"
				+ "<small class=\"text-muted\">"+time+"</small>\r\n"
				+ "</span> <br /> <span class=\"comment ml-2\">"+text+"</span>\r\n"
				+ "</p>\r\n"
				+ "</div>");
	}
	

}
