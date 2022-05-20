package filter;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import dao.VideoDAO;

@WebListener
public class UserListener implements HttpSessionListener{
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		VideoDAO dao = new VideoDAO();
		final Integer VIDEO_SIZE = dao.findAll().size();
		session.setAttribute("VIDEO_SIZE", VIDEO_SIZE);
		session.setAttribute("lstHistory", null);
		session.setAttribute("mapLikeByUser", null);
		session.setAttribute("recomendedVideo", null);
		session.setAttribute("likeByVideo", null);
		session.setAttribute("likeByUserLst", null);
		session.setAttribute("lang", "vi");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		
	}

}
