package admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import common.PageInfo;
import common.PageType;
import dao.HistoryDAO;
import dao.UserDAO;
import dao.VideoDAO;
import dao.VisitDAO;
import model.Visit;

@WebServlet("/admin/home")
public class AdminHomePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AdminHomePageServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getRequestDispatcher("").forward(request, response);
		long sumVideo = new VideoDAO().findAll().size();
		long sumLike = new HistoryDAO().allLikeCount();
		long sumMem = new UserDAO().findAll().size();
		long visit = new VisitDAO().getCountVisit();
		List<Visit> lst = new VisitDAO().getTwoWeekVisit();
		JsonArray jarr = new JsonArray();
		for(Visit v:lst) {
			JsonObject jobj = new JsonObject();
			jobj.addProperty("date", v.getDate().getTime());
			jobj.addProperty("count", v.getCount());
			jarr.add(jobj);
		}
		request.setAttribute("data", jarr);
		request.setAttribute("sumVideo", sumVideo);
		request.setAttribute("sumLike", sumLike);
		request.setAttribute("sumMem", sumMem);
		request.setAttribute("visit", visit);
		
		PageInfo.prepareAndForwardAdmin(request, response, PageType.ADMIN_HOME);
		System.out.println("home page admin");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
