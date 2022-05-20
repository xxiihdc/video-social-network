package site.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.PasswordAuthentication;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;

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

import common.Xdate;
import dao.ResetPasswordTokenDAO;
import dao.UserDAO;
import model.User;
import sub.model.ResetPasswordToken;


@WebServlet({ "/forgetpass", "/reset" })
public class ResetPasswordServlet extends HttpServlet {
	static final long EXPIRY_TIME = 1000 * 60 * 5; // 5 min
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ResetPasswordServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		System.out.println(uri);
		if (uri.contains("/reset")) {

			// click mail
			String token = request.getParameter("token");
			ResetPasswordToken tok = new ResetPasswordTokenDAO().findByToken(token);
			if (tok == null) {
				response.getWriter().append("Token is invalid");
				return;
			}
			long tokenTime = Xdate.addTime(tok.getCreateTime(), EXPIRY_TIME);
			long curentTime = new Date().getTime();
			if (tokenTime < curentTime) {
				response.getWriter().append("Token timeout");
				return;
			}
			request.setAttribute("type", 1);
			System.out.println(token);
			request.getRequestDispatcher("views/site/change-pass.jsp").forward(request, response);
		} else {
			// click tu trang quen mk
			request.setAttribute("type", 2);
			request.getRequestDispatcher("views/site/change-pass.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String msg = "";
		if (uri.contains("/reset")) {
			// change pass
			String token = request.getParameter("token");
			String password = request.getParameter("password");
			ResetPasswordToken tok = new ResetPasswordTokenDAO().findByToken(token);
			if (tok != null) {
				long time = Xdate.addTime(tok.getCreateTime(), EXPIRY_TIME);
				if (time > new Date().getTime()) {
					User u = tok.getUser();
					u.setPassword(password);
					new UserDAO().update(u);
					response.getWriter().append("Cập nhật mật khẩu thành công");
					return;
				}
			}
			response.getWriter().append("time out or token is invalidd!!!!");

		} else {
			// send mail
			String username = request.getParameter("username");
			String email = request.getParameter("email");
			User u = new UserDAO().find(username);
			if (u != null && u.getEmail().equals(email)) {
				msg = "Thông tin cập nhật mật khẩu đã được gửi qua hộp thư";
				PrintWriter out = response.getWriter();
				out.append(msg);
				sendMail(u);
			} else {
				msg = "Kiểm tra lại tên đăng nhập và email";
				PrintWriter out = response.getWriter();
				out.append(msg);
			}
		}

	}

	private void sendMail(User u) {
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
		MimeMessage msg = new MimeMessage(session);
		UUID uuid = UUID.randomUUID();
		ResetPasswordToken rpt = new ResetPasswordToken();
		rpt.setCreateTime(new Date());
		rpt.setToken(uuid.toString());
		rpt.setUser(u);
		new ResetPasswordTokenDAO().insert(rpt);
		String content = "<!DOCTYPE html>\r\n" + "<html lang=\"en\">\r\n" + "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n" + "</head>\r\n" + "<body>\r\n" + "    <div>\r\n"
				+ "        <p>JZTR Entertaiment - Diễn đàn đầu hàng công nghệ</p>\r\n" + "        <p>Dear:</p>\r\n"
				+ "        <p>Chúng tôi nhận được yêu cầu lấy lại mật khẩu của bạn</p>\r\n"
				+ "        <p>Click vào nút phía dưới để lấy lại mật khẩu, vì lí do bảo mật email có hiệu lực trong 5 phút</p>\r\n"
				+ "        <button style=\" border: none;\r\n" + "        color: white;\r\n"
				+ "        padding: 15px 32px;\r\n" + "        text-align: center;\r\n"
				+ "        text-decoration: none;\r\n" + "        display: inline-block;\r\n"
				+ "        font-size: 16px;\r\n"
				+ "        background-color:#3498db\"><a href=\"http://localhost:8080/pd04166.asm/reset?token="
				+ uuid.toString() + "\" style=\"text-decoration: none; color: white;\">Đổi mật khẩu</a></button>\r\n"
				+ "    </div>\r\n" + "</body>\r\n" + "</html>";

		try {
			msg.setFrom(new InternetAddress("ductran090500@gmail.com"));
			msg.setRecipients(Message.RecipientType.TO, u.getEmail());
			msg.setSubject("JZTR 0.4 - Diễn đàn đầu hàng công nghệ", "UTF-8");
			msg.setContent(content, "text/html;charset=utf-8");
			msg.setReplyTo(msg.getFrom());
			Transport.send(msg, "ductran090500@gmail.com", "hoaiduc123");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

}
