package sub.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import model.Video;

/**
 * The persistent class for the SubVideos database table.
 * 
 */
@Entity
@Table(name = "SubVideos")
@NamedQuery(name = "SubVideo.findAll", query = "SELECT s FROM SubVideo s")
public class SubVideo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	
	@OneToOne()
	@JoinColumn(name = "videoId")
	private Video videoId;

	public SubVideo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Video getVideoId() {
		return this.videoId;
	}

	public void setVideoId(Video videoId) {
		this.videoId = videoId;
	}

}