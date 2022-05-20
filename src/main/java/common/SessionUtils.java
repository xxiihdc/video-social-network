package common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtils {
	public static void add(HttpServletRequest req, String name, Object value) {
		HttpSession session = req.getSession();
		session.setAttribute(name, value);
	}

	public static Object get(HttpServletRequest req, String name) {
		HttpSession session = req.getSession();
		return session.getValue(name);
	}

	public static void inValidate(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.removeAttribute("user");
		session.invalidate();
	}
	public static boolean isLogin(HttpServletRequest req) {
		return get(req,"user") != null;
	}
	public static String getLoginUsername(HttpServletRequest req) {
		Object username = get(req,"username");
		return username == null ? null : username.toString();
	}
}
