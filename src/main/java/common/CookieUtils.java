package common;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {
	public static String get(String name, HttpServletRequest req) {
		Cookie [] cookies = req.getCookies();
		if(cookies!= null) {
			for(Cookie c : cookies) {
				if(c.getName().equals(name)) {
					return c.getValue();
				}
			}
		}
		return null;
		}
	public static Cookie add(String name, String value, int hour, HttpServletResponse res) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(60*60*hour);
		cookie.setPath("/");
		res.addCookie(cookie);
		return null;
	}
}
