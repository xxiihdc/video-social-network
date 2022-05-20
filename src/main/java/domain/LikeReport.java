package domain;

public class LikeReport {
	String videoId;
	Long likeCount;
	public String getVideoId() {
		return videoId;
	}
	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}
	public Long getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(Long likeCount) {
		this.likeCount = likeCount;
	}
	public LikeReport(String videoId, Long likeCount) {
		this.videoId = videoId;
		this.likeCount = likeCount;
	}
	public LikeReport() {	
	}
	
}
