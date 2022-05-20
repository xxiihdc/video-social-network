package test;

import java.util.List;

import dao.HistoryDAO;
import domain.LikeReportFull;

public class TestVideo {
	public static void main(String[] args) {
		HistoryDAO dao = new HistoryDAO();
		List<LikeReportFull> lst = dao.reportLikeByVideoForAdmin("zOILX7GCbjQ");
		System.out.println(lst.size());
		for(LikeReportFull l : lst) {
			System.out.println(l.getFullname());
		}
	}
}
