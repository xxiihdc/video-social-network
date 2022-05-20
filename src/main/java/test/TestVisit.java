package test;

import java.util.List;

import dao.VisitDAO;
import model.Visit;

public class TestVisit {
	public static void main(String[] args) {
			Visit v = new VisitDAO().getLastVisit();
//			System.out.println(v.getId());
//			List<Visit> lst = new VisitDAO().getTwoWeekVisit();
//			for(Visit vs : lst ) {
//				System.out.println(vs.getDate());
//			}
			System.out.println(new VisitDAO().getCountVisit());
	}
}
