package servlet.api;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;
import org.json.JSONObject;

import dao.UserDAO;
import model.User;

@WebServlet("/check")
public class ValidateMailAndUsername extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		if(email!=null) {
			boolean check = new UserDAO().checkEmail(email);
			Map<String,String> map = new HashedMap();
			if(check) {
				map.put("email","true");//mail hop le	
			}else {
				map.put("email","false");
			}
			JSONObject json = new JSONObject(map);
			response.getWriter().write(json.toString());
			return;
		}
		if(username != null) {
			User user = new UserDAO().find(username);
			boolean check = user == null;
			System.out.println("");
			Map<String,String> map = new HashedMap();
			if(check) {
				map.put("username","true");// hop le	
			}else {
				map.put("username","false");
			}
			JSONObject json = new JSONObject(map);
			response.getWriter().write(json.toString());
			return;
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
