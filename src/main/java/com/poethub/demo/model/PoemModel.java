package com.poethub.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "POEM")
public class PoemModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int poemId;
	
	@NotNull (message = "Please enter a title")
	@Column(name = "title", nullable = false)
	private String title;
	
	@NotNull(message = "Please enter a poem")
	@Column(name = "body", nullable = false)
	@Lob
	private String body;
	
	@ManyToOne
	@NotNull
	@JoinColumn(name="userId", referencedColumnName="userId", nullable = false)
	private UserModel userModel;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public int getPoemId() {
		return poemId;
	}
	public void setPoemId(int poemId) {
		this.poemId = poemId;
	}
	public UserModel getUserModel() {
		return userModel;
	}
	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
	

}
