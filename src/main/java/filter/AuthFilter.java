package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.PageInfo;
import common.SessionUtils;
import model.User;

// /admin/*
@WebFilter({"/admin/*","/watch","/recomended","/info","/changepassword","/favorite"})
public class AuthFilter implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setAttribute("isLogin", SessionUtils.isLogin((HttpServletRequest) request));
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String uri = req.getRequestURI();
		User user = (User) req.getSession().getAttribute("user");
		if (user == null) {
			HttpSession session = req.getSession();
			session.setAttribute("currentUrl", req.getRequestURL().toString()+"?"+req.getQueryString());
			System.out.println(req.getRequestURL().toString());
			PageInfo.prepareAndRedirectLogin(res);
			System.out.println("auth filer usernull");
			return;
		}
		if (uri.contains("admin")) {
			if (user.getAdmin()) {
				chain.doFilter(request, response);
				return;
			}else {
				System.out.println("not admin");
				//res.sendRedirect("http://localhost:8080/pd04166.asm/home");
				PageInfo.prepareAndRedirectHome(res);
				return;
			}
		}
		req.setAttribute("isLogin", SessionUtils.isLogin(req));
		chain.doFilter(request, response);
		return;
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
