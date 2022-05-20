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

import common.CookieUtils;
import common.SessionUtils;
import dao.UserDAO;
import model.User;

/**
 * Servlet Filter implementation class CharsetFilter
 */

//charset and logger filter

@WebFilter({"/*"})
public class CharsetFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public CharsetFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		HttpServletRequest req =  (HttpServletRequest) request;
		if(CookieUtils.get("username", req) != null) {
			User u = new UserDAO().find(CookieUtils.get("username", req));
			if (u!=null) {
				SessionUtils.add(req, "user", u);
			}
		}
//		if(req.getParameter("lang")!=null) {
//			SessionUtils.add(req, "lang", req.getParameter("lang"));
//		}
		chain.doFilter(request, response);
		
	}
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
