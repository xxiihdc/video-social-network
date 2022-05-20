package model;

import java.io.Serializable;
import javax.persistence.*;

import com.google.common.collect.Lists;

import sub.model.ResetPasswordToken;

import java.util.List;


/**
 * The persistent class for the Users database table.
 * 
 */
@Entity
@Table(name="Users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String username;

	private boolean admin;

	private String email;
	
	 @Column(name = "full_name")
	private String fullName;

	private String password;
	
	private String image;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="user")
	private List<Comment> comments;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	//bi-directional many-to-one association to History
	@OneToMany(mappedBy="user",fetch = FetchType.EAGER)
	@OrderBy("date")
	private List<History> histories;

	//bi-directional many-to-one association to ReplyComment
	@OneToMany(mappedBy="user")
	private List<ReplyComment> replyComments;

	//bi-directional many-to-one association to Share
	@OneToMany(mappedBy="user")
	private List<Share> shares;

	@OneToMany(mappedBy="user")
	private List<ResetPasswordToken> resetPasswordTokens;
	
	
	public User() {
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", admin=" + admin + ", email=" + email + ", fullName=" + fullName
				+ ", password=" + password + ", image=" + image + "]";
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean getAdmin() {
		return this.admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setUser(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setUser(null);

		return comment;
	}

	public List<History> getHistories() {
		return Lists.reverse(this.histories);//this.histories;
	}

	public void setHistories(List<History> histories) {
		this.histories = histories;
	}

	public History addHistory(History history) {
		getHistories().add(history);
		history.setUser(this);

		return history;
	}

	public History removeHistory(History history) {
		getHistories().remove(history);
		history.setUser(null);

		return history;
	}

	public List<ReplyComment> getReplyComments() {
		return this.replyComments;
	}

	public void setReplyComments(List<ReplyComment> replyComments) {
		this.replyComments = replyComments;
	}

	public ReplyComment addReplyComment(ReplyComment replyComment) {
		getReplyComments().add(replyComment);
		replyComment.setUser(this);

		return replyComment;
	}

	public ReplyComment removeReplyComment(ReplyComment replyComment) {
		getReplyComments().remove(replyComment);
		replyComment.setUser(null);

		return replyComment;
	}

	public List<Share> getShares() {
		return this.shares;
	}

	public void setShares(List<Share> shares) {
		this.shares = shares;
	}

	public Share addShare(Share share) {
		getShares().add(share);
		share.setUser(this);

		return share;
	}

	public Share removeShare(Share share) {
		getShares().remove(share);
		share.setUser(null);

		return share;
	}
	public List<ResetPasswordToken> getResetPasswordTokens() {
		return this.resetPasswordTokens;
	}

	public void setResetPasswordTokens(List<ResetPasswordToken> resetPasswordTokens) {
		this.resetPasswordTokens = resetPasswordTokens;
	}

	public ResetPasswordToken addResetPasswordToken(ResetPasswordToken resetPasswordToken) {
		getResetPasswordTokens().add(resetPasswordToken);
		resetPasswordToken.setUser(this);

		return resetPasswordToken;
	}

	public ResetPasswordToken removeResetPasswordToken(ResetPasswordToken resetPasswordToken) {
		getResetPasswordTokens().remove(resetPasswordToken);
		resetPasswordToken.setUser(null);
		return resetPasswordToken;
	}
}