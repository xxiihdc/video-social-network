package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Where;

import com.google.common.collect.Lists;

import dao.HistoryDAO;


/**
 * The persistent class for the Videos database table.
 * 
 */
@Entity
@Table(name="Videos")
@NamedQuery(name="Video.findAll", query="SELECT v FROM Video v")
public class Video implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private boolean active;

	private String description;

	private String poster;

	private String title;

	private long views;

	//bi-directional many-to-one association to Comment
	@OneToMany(fetch = FetchType.LAZY, mappedBy="video", cascade = CascadeType.ALL)
	private List<Comment> comments;

	//bi-directional many-to-one association to History
	@OneToMany(fetch = FetchType.EAGER, mappedBy="video",cascade = CascadeType.ALL)
	private List<History> histories;
 
	//bi-directional many-to-one association to Share
	@OneToMany(mappedBy="video", fetch = FetchType.LAZY)
	private List<Share> shares;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy="video",cascade = CascadeType.ALL)
	@Where(clause="likes=5")
	private List<History> likes;
	
	public Video() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean getActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPoster() {
		return this.poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getViews() {
		return this.views;
	}

	public void setViews(long views) {
		this.views = views;
	}

	public List<Comment> getComments() {
		return Lists.reverse(comments);
		//return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setVideo(this);
		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setVideo(null);

		return comment;
	}

	public List<History> getHistories() {
		return this.histories;
	}

	public void setHistories(List<History> histories) {
		this.histories = histories;
	}

	public History addHistory(History history) {
		getHistories().add(history);
		history.setVideo(this);

		return history;
	}

	public History removeHistory(History history) {
		getHistories().remove(history);
		history.setVideo(null);

		return history;
	}

	public List<Share> getShares() {
		return this.shares;
	}

	public void setShares(List<Share> shares) {
		this.shares = shares;
	}

	public List<History> getLikes() {
		return likes;
	}

	public void setLikes(List<History> likes) {
		this.likes = likes;
	}

	public Share addShare(Share share) {
		getShares().add(share);
		share.setVideo(this);
		return share;
	}

	public Share removeShare(Share share) {
		getShares().remove(share);
		share.setVideo(null);
		return share;
	}
	@Deprecated
	public Long likeCount() {
		return new HistoryDAO().likeCount(this.id);
	}
	public String getDescriptionBreakLine() {
		return this.description.replaceAll("..breakline..","<br/>");
	}
	public String reveseDes() {
		return this.description.replaceAll("..breakline..", "");
	}
	public void addViews() {
		this.views++;
	}
}