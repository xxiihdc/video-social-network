package filter;


import java.util.Date;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import common.Xdate;
import dao.VisitDAO;
import model.Visit;

@WebListener
public class AppListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		VisitDAO dao = new VisitDAO();
		Visit v = dao.getLastVisit();
		String date = Xdate.toString(v.getDate(), "yyyy-MM-dd");
		String today =Xdate.toString(new Date(), "yyyy-MM-dd") ;
		if(date.equals(today)) {
			System.out.println("equal to day");
			long count = v.getCount();
			count++;
			v.setCount(count);
			dao.update(v);
		}else {
			System.out.println("not equal to day");
			Visit v2= new Visit();
			v2.setDate(new Date());
			v2.setCount(1);
			dao.insert(v2);
		}
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		HttpSessionListener.super.sessionDestroyed(se);
	}

}
