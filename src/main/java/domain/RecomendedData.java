package domain;

import java.util.Date;

public class RecomendedData {
	private int userId;
	private int videoId;
	private int value;
	private Date date;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getVideoId() {
		return videoId;
	}
	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public RecomendedData(int userId, int videoId, int value, Date date) {
		this.userId = userId;
		this.videoId = videoId;
		this.value = value;
		this.date = date;
	}
	public RecomendedData() {
	}
	
}
