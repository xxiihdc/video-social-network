package domain;

import java.util.Date;

public class LikeReportFull {
	private String userId;
	private String fullname;
	private String email;
	private Date likeDate;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getLikeDate() {
		return likeDate;
	}
	public void setLikeDate(Date likeDate) {
		this.likeDate = likeDate;
	}
	public LikeReportFull(String userId, String fullname, String email, Date likeDate) {
		this.userId = userId;
		this.fullname = fullname;
		this.email = email;
		this.likeDate = likeDate;
	}
	public LikeReportFull() {
	}
	
}
