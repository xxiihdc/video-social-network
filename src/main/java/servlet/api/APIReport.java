package servlet.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Xdate;
import dao.HistoryDAO;
import dao.VideoDAO;
import domain.LikeReportFull;
import model.Share;
import model.Video;

@WebServlet("/admin/apireport")
public class APIReport extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		HistoryDAO dao = new HistoryDAO();
		VideoDAO vdao = new VideoDAO();
		Video v = vdao.find(id);
		List<Share> lst2 = v.getShares();
		List<LikeReportFull> lst = dao.reportLikeByVideoForAdmin(id);
		String responseData;
		if(lst.isEmpty()) {
			responseData="<h3>Video này chưa có lượt like nào</h3>";
		}else {
			String headResponse = "<div class=\"col-12\">\r\n"
					+ "								<div class=\"card mt-3\">\r\n"
					+ "									<div class=\"card-header\">\r\n"
					+ "										<i class=\"fas fa-list-alt\"></i> Danh sách người dùng đã like\r\n"
					+ "										Video " + v.getTitle() + "<table class=\"table table-bordered table-hover\"\r\n"
							+ "											>\r\n"
							+ "											<thead>\r\n"
							+ "												<tr class=\"text-center table-warning\">\r\n"
							+ "													<th class=\"align-middle\">#</th>\r\n"
							+ "													<th class=\"align-middle\">Tên đăng nhập</th>\r\n"
							+ "													<th class=\"align-middle\">Tên người dùng</th>\r\n"
							+ "													<th class=\"align-middle\">Email</th>\r\n"
							+ "													<th class=\"align-middle\">Ngày thích</th>\r\n"
							+ "												</tr>\r\n"
							+ "											</thead>\r\n"
							+ "											<tbody>";
			StringBuilder tableLikeVideoResponse = new StringBuilder();
			for(int i = 0; i < lst.size(); i ++) {
				String date = Xdate.toString(lst.get(i).getLikeDate(), "dd/MM/yyyy");
				tableLikeVideoResponse.append("<tr>\r\n"
						+ "													<th scope=\"row\">"+(i+1)+"</th>\r\n"
						+ "													<td>"+lst.get(i).getUserId()+"</td>\r\n"
						+ "													<td>"+lst.get(i).getFullname()+"</td>\r\n"
						+ "													<td>"+lst.get(i).getEmail()+"</td>\r\n"
						+ "													<td>"+date+"</td>\r\n"
						+ "												</tr>");
			}
			tableLikeVideoResponse.append("</tbody>\r\n"
					+ "										</table>\r\n"
					+ "									</div>\r\n"
					+ "								</div>\r\n"
					+ "							</div>");
			responseData = headResponse+tableLikeVideoResponse.toString();
		}
		
		
		if(lst2.isEmpty()) {
			responseData = responseData + "\n"+"<h3>Video này chưa có lượt chia sẻ nào</h3";
		}else {
			String headShare = "<div class=\"card mt-3 col-12  \">\r\n"
					+ "									<div class=\"card-header\">\r\n"
					+ "										<i class=\"fas fa-list-alt\"></i> Danh sách người dùng đã like\r\n"
					+ "										Video " + v.getTitle()+ "<table class=\"table table-bordered table-hover\"\r\n"
							+ "											>\r\n"
							+ "											<thead>\r\n"
							+ "												<tr class=\"text-center table-warning\">\r\n"
							+ "													<th class=\"align-middle\">#</th>\r\n"
							+ "													<th class=\"align-middle\">Tên đăng nhập</th>\r\n"
							+ "													<th class=\"align-middle\">VideoId</th>\r\n"
							+ "													<th class=\"align-middle\">Email</th>\r\n"
							+ "													<th class=\"align-middle\">Ngày thích</th>\r\n"
							+ "												</tr>\r\n"
							+ "											</thead>\r\n"
							+ "											<tbody>";
			StringBuilder tableShareVideoResponse = new StringBuilder();
			for(int i = 0; i< lst2.size();i++) {
				String date = Xdate.toString(lst2.get(i).getDate(), "dd/MM/yyyy");
				tableShareVideoResponse.append("<tr>\r\n"
						+ "													<th scope=\"row\">"+(i+1)+"</th>\r\n"
						+ "													<td>"+lst2.get(i).getUser().getFullName()+"</td>\r\n"
						+ "													<td>"+lst2.get(i).getVideo().getId()+"</td>\r\n"
						+ "													<td>"+lst2.get(i).getEmail()+"</td>\r\n"
						+ "													<td>"+date+"</td>\r\n"
						+ "												</tr>");
			}
			tableShareVideoResponse.append("</tbody>\r\n"
					+ "										</table>\r\n"
					+ "									</div>\r\n"
					+ "								</div>");
			responseData = responseData+headShare+tableShareVideoResponse.toString();
		}
		
		
		response.getWriter().append(responseData);
		vdao.closeSession();
	}



}
