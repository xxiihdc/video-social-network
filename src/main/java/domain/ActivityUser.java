package domain;

import java.util.Date;

public class ActivityUser {
	private String username;
	private String videoId;
	private String videoTitle;

	private String content;
	private Date date;

	public String getUsername() {
		return username;
	}

	public ActivityUser() {
	}

	public String getVideoTitle() {
		return videoTitle;
	}

	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}

	public ActivityUser(String username, String videoId, String content, Date date, String title) {
		this.username = username;
		this.videoId = videoId;
		this.content ="Đã bình luân: " + content;
		this.date = date;
		this.videoTitle = title;
	}

	public ActivityUser(String username, long cmtId, String content, Date date) {
		this.username = username;
		this.videoId = cmtId + "";
		this.content ="Đã trả lời một bình luận: " +content;
		this.date = date;
	}

	public ActivityUser(String username, String videoId, int content, Date date, String title) {
		this.username = username;
		this.videoId = videoId;
		if (content == 1) {
			this.content = "Đã dislike video: ";
		} else {
			this.content = "Đã thích video: ";
		}
		this.videoTitle = title;

		this.date = date;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
