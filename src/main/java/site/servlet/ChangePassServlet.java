package site.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.SessionUtils;
import dao.UserDAO;
import model.User;

//click doi mat khau sau khi dang nhap
@WebServlet("/changepassword")
public class ChangePassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ChangePassServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("views/site/change-pass.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password = request.getParameter("password");
		User u = (User) SessionUtils.get(request, "user");
		u.setPassword(password);
		new UserDAO().update(u);
		response.getWriter().append("Đã cập nhật mật khẩu");
		}

}
