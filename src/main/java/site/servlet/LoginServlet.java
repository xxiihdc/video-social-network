package site.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import common.CookieUtils;
import common.PageInfo;
import common.PageType;
import common.SessionUtils;
import dao.UserDAO;
import domain.LoginForm;
import model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    public LoginServlet() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String username = CookieUtils.get("username", request);
		boolean check = SessionUtils.isLogin(request);
		System.out.println(check);
		if (username == null && !check) {
			PageInfo.forwardLogin(request, response);
			return;
		}
		System.out.println(username);
		SessionUtils.add(request, "username", username);
		PageInfo.prepareAndRedirectHome(response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			LoginForm form = new LoginForm();
			BeanUtils.populate(form, request.getParameterMap());
			UserDAO dao = new UserDAO();
			User user = dao.find(form.getUsername());
			if(user!=null && user.getPassword().equals(form.getPassword())){
				SessionUtils.add(request, "user", user);
				System.out.println("session done");
				if(form.isRemember()) {
					System.out.println(user.getFullName());
					CookieUtils.add("username", form.getUsername(), 24, response);
				}else {
					CookieUtils.add("username", form.getUsername(), 0, response);
				}
				request.setAttribute("name", user.getFullName());
				if(user.getAdmin()) {
					//PageInfo.prepareAndForwardAdmin(request, response, PageType.ADMIN_HOME);
					PageInfo.prepareAndRedirectAdminHome(request, response, PageType.ADMIN_HOME);
				}else {
					String currentUrl = (String) SessionUtils.get(request,"currentUrl");
					if(currentUrl!=null) {
						SessionUtils.add(request, "currentUrl", null);
						response.sendRedirect(currentUrl);
					}else {
						PageInfo.prepareAndRedirectHome(response);
						//request.getRequestDispatcher("views/site/home-all-video.jsp").forward(request, response);
						System.out.println("login servlet here");
					}
					
				}	
			}else {
				System.out.println("dang nhap that bai");
				//PageInfo.prepareAndForward(request, response, PageType.LOGIN_PAGE);
				PageInfo.forwardLogin(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
