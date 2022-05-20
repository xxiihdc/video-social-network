package servlet.api;

import java.io.IOException;
import java.net.PasswordAuthentication;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.SessionUtils;
import dao.ShareDAO;
import dao.VideoDAO;
import model.Share;
import model.User;

@WebServlet("/apimail")
public class APIMail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("send mail");
		Properties p = new Properties();
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		p.put("mail.smtp.port", "587");
		p.put("mail.smtp.ssl.protocols", "TLSv1.2");
		Session session = Session.getInstance(p, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPass() {
				String username = "ductran090500@gmail.com";
				String pass = "hoaiduc123";
				return new PasswordAuthentication(username, pass.toCharArray());
			}
		});
		User u = (User) SessionUtils.get(request, "user");
		String emailTo = request.getParameter("email");
		String title = "JZTR Entertainment - Diễn đàn đầu hàng công nghệ";
		String content = request.getParameter("content");
		String videoId = request.getParameter("id");
		String headerContent = "<p>Dear:</p> <br/>Người bạn "+ u.getFullName() +
				" muốn chia sẻ video này cho bạn, hãy đăng nhập và xem video luôn và ngay nhé <br/> <hr/>";
		content = content.replaceAll("\n", "<br/>");
		String footerContent = "<br/> <button style=\"border: none; color: white; padding: 15px 32px;\r\n"
				+ "text-align: center;text-decoration: none;\r\n"
				+ "display: inline-block;font-size: 16px;\r\n"
				+ "background-color:#3498db\">\r\n"
				+ "<a href=\"http://localhost:8080/pd04166.asm/watch?id="+videoId+"\" \r\n"
				+ "style=\"text-decoration: none; color: white;\">Xem luôn</a></button>";
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress("ductran090500@gmail.com"));
			msg.setRecipients(Message.RecipientType.TO, emailTo);
			msg.setSubject(title, "UTF-8");
			msg.setContent("","text/html;charset=utf-8");
			msg.setText(headerContent+content+footerContent, "UTF-8", "html");
			msg.setReplyTo(msg.getFrom());
			Transport.send(msg, "ductran090500@gmail.com", "hoaiduc123");
			response.getWriter().write("Gui mail thanh cong");
			VideoDAO vdao = new VideoDAO();
			Share share = new Share();
			share.setDate(new Date());
			share.setEmail(emailTo);
			share.setUser(u);
			share.setVideo(vdao.find(videoId));
			new ShareDAO().insert(share);
			vdao.closeSession();
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.getWriter().write(e.getMessage());
			
		}
		
	}

}
