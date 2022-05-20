package servlet.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.SessionUtils;
import common.Xdate;
import dao.CommentDAO;
import dao.VideoDAO;
import model.Comment;
import model.User;

/**
 * Servlet implementation class APICommentServlet
 */
@WebServlet("/apicomment")
public class APICommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		VideoDAO dao = new VideoDAO();
		String cmt = request.getParameter("comment");
		String id = request.getParameter("id");
		User u = (User) SessionUtils.get(request, "user");
		Comment comment = new Comment();
		comment.setDate(new Date());
		comment.setText(cmt);
		comment.setUser(u);
		comment.setVideo(dao.find(id));
		dao.closeSession();
		new CommentDAO().insert(comment);
		comment = new CommentDAO().findLastId();
		String time = Xdate.toString(comment.getDate(), "HH:mm:ss dd/MM/yyyy");
		System.out.println("done");
		PrintWriter out = response.getWriter();
		out.append("<div class=\"row mb-3\">\r\n"
				+ "<div class=\"col-1\" style=\"padding: 0\">\r\n"
				+ "<img src=\""+u.getImage()+"\" class=\"img-fluid float-right rounded-circle\" width=\"50px\" />\r\n"
				+ "</div>\r\n"
				+ "<div class=\"col-11\">\r\n"
				+ "<p class=\"comment-name\">"+u.getFullName()+"\r\n"
				+ "<small class=\"text-muted\">"+time+"</small>\r\n"
				+ "</p>\r\n"
				+ "<p class=\"comment\">"+cmt+"</p>\r\n"
				+ "<small class=\"rep-comment-link text-muted\" onclick=\"showReply("+comment.getId()+");\">PHẢN HỒI</small>\r\n"
				+ "<div class=\"row input-repcmt\" id=\"input-reply"+comment.getId()+"\">\r\n"
				+ "<div class=\"col\">\r\n"
				+ "<div class=\"input-group input-group-sm mb-3\">\r\n"
				+ "<input type=\"text\" class=\"form-control\"\r\n"
				+ "id=\"textComment"+comment.getId()+"\">\r\n"
				+ "<div class=\"input-group-append\">\r\n"
				+ "<button class=\"btn btn-primary\" onclick=\"sendRepcmt("+comment.getId()+");\">BÌNH LUÂN</button>\r\n"
				+ "</div>\r\n"
				+ "</div>\r\n"
				+ "</div>\r\n"
				+ "</div>\r\n"
				+ "<div id=\"views-reply"+comment.getId()+"\" class = \"reply-cmt\">\r\n"
				+ "</div>\r\n"
				+ "</div>\r\n"
				+ "</div>");
	}
}
