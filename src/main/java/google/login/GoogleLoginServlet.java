package google.login;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import common.PageInfo;
import common.PageType;
import common.SessionUtils;
import dao.UserDAO;
import model.User;


@WebServlet("/googleLoginResult")
public class GoogleLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public GoogleLoginServlet() {
        super();
     
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");
		String code = request.getParameter("code");
		String accessToken = getToken(code);
		UserGoogleDto user = getUserInfo(accessToken);
		try {
			User u= new User();
			u.setAdmin(false);
			u.setEmail(user.getEmail());
			u.setFullName(getFullName(user));
			u.setImage(user.getPicture());
			u.setPassword(createPassword());
			u.setUsername(createUserName(user));
			UserDAO dao = new UserDAO();
			User user2 = dao.find(u.getUsername());
			if(user2==null) {
				dao.insert(u);
			}
			SessionUtils.add(request, "user", u);
			if(u.getAdmin()) {
				PageInfo.prepareAndForwardAdmin(request, response,null);
			}else {
				String currentUrl = (String) SessionUtils.get(request,"currentUrl");
				if(currentUrl!=null) {
					SessionUtils.add(request, "currentUrl", null);
					response.sendRedirect(currentUrl);
				}else {
					PageInfo.prepareAndRedirectHome(response);
					System.out.println("login servlet here");
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	private String createPassword() {
		// TODO Auto-generated method stub
		Random generator = new Random();
		return "hoaiduc"+generator.nextLong();
	}
	private String createUserName(UserGoogleDto user) {
		String email = user.getEmail();
		int index = email.indexOf("@");
		return "gg."+email.substring(0,index);
	}
	private String getFullName(UserGoogleDto user) {
		String fullName = "";
		String fName = user.getFamilyName()+"";
		String givenName = user.getGiveName()+"";
		String name = user.getName()+"";
//		System.out.println(fName);
//		System.out.println(name);
//		System.out.println(givenName);
		if(!fName.equals("null")) fullName+=user.getFamilyName();
		if(!givenName.equals("null")) fullName+=user.getGiveName();
		if(!name.equals("null")) fullName+=user.getName();
		return fullName;
	}
	public static String getToken(String code) throws ClientProtocolException, IOException {
		// call api to get token
		String response = Request.Post(Constants.GOOGLE_LINK_GET_TOKEN)
				.bodyForm(Form.form().add("client_id", Constants.GOOGLE_CLIENT_ID)
						.add("client_secret", Constants.GOOGLE_CLIENT_SECRET)
						.add("redirect_uri", Constants.GOOGLE_REDIRECT_URI).add("code", code)
						.add("grant_type", Constants.GOOGLE_GRANT_TYPE).build())
				.execute().returnContent().asString();

		JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
		String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
		return accessToken;
	}

	public static UserGoogleDto getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
		String link = Constants.GOOGLE_LINK_GET_USER_INFO + accessToken;
		Content cont = Request.Get(link).execute().returnContent();
		String response;
		response=cont.asString(StandardCharsets.UTF_8);
		//String response = Request.Get(link).execute().returnContent().asString();
		UserGoogleDto googlePojo = new Gson().fromJson(response, UserGoogleDto.class);

		return googlePojo;
	}
}
