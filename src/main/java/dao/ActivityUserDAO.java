package dao;

import java.util.List;

import domain.ActivityUser;
import model.User;

public class ActivityUserDAO {
	private List<ActivityUser> getActivityShare(User u){
		return new ShareDAO().getActivityByUser(u);
	}
	private List<ActivityUser> getActivityLike(User u){
		return new HistoryDAO().getActivityByUser(u);
	}
	private List<ActivityUser> getActivityComment(User u){
		return new CommentDAO().getActivityByUser(u);
	}
	private List<ActivityUser> getActivityReplyComment(User u){
		return new ReplyCommentDAO().getActivityByUser(u);
	}
	public List<ActivityUser> getActivity(User u){
		List<ActivityUser> lst = null;
		lst = getActivityLike(u);
		lst.addAll(getActivityShare(u));
		lst.addAll(getActivityComment(u));
		lst.addAll(getActivityReplyComment(u));
		return lst;
		
	}
	
}
