package site.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import common.PageInfo;
import common.SessionUtils;
import dao.SubUserDAO;
import dao.UserDAO;
import model.User;
import sub.model.SubUser;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PageInfo.prepareAndForward(request, response, PageType.REGISTER_PAGE);
		PageInfo.forwardResgiter(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
			new UserDAO().insert(user);
			SubUser sub = new SubUser();
			sub.setUserId(user);
			new SubUserDAO().insert(sub);
			SessionUtils.add(request, "user", user);
			//response.sendRedirect("http://localhost:8080/pd04166.asm/home");
			PageInfo.prepareAndRedirectHome(response);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
