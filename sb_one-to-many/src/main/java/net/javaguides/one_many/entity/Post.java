package net.javaguides.one_many.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="post")
public class Post {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name="title")
	private String title;
	@Column(name="description")
	private String desctiption;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="pc_fid", referencedColumnName="id")
	private List<Comment> comments = new ArrayList();
	
	
	
	public Post() {}
	
	public Post(String title, String desctiption) {
		super();
		this.title = title;
		this.desctiption = desctiption;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesctiption() {
		return desctiption;
	}
	public void setDesctiption(String desctiption) {
		this.desctiption = desctiption;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	
	
}
