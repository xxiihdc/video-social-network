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

import model.User;

/**
 * The persistent class for the SubUsers database table.
 * 
 */
@Entity
@Table(name = "SubUsers")
@NamedQuery(name = "SubUser.findAll", query = "SELECT s FROM SubUser s")
public class SubUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	
	@OneToOne
	@JoinColumn(name = "username")
	private User username;

	public SubUser() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUserId() {
		return this.username;
	}

	public void setUserId(User userId) {
		this.username = userId;
	}

}