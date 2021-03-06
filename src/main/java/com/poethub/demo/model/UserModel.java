package com.poethub.demo.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "USER")
public class UserModel {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="userId")
	private int userId;

	@NotNull
	@Size(min = 5, max = 16, message = "Username must be between 5 and 16 characters")
	@Column(name = "username", nullable = false, unique = true)
	private String username;

	@Column(name = "enabled", nullable = false)
	private boolean enabled;

	@NotNull
	@Email(message = "Please enter a valid email")
	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@NotNull
	@Size(min = 2, max = 30, message = "First Name must be between 2 and 30 characters")
	@Column(name = "firstName", nullable = false)
	private String firstName;

	@NotNull
	@Size(min = 2, max = 30, message = "Last Name must be between 2 and 30 characters")
	@Column(name = "lastName", nullable = false)
	private String lastName;

	//@NotNull
	@Size(min = 5, message = "Password must be atleast 5 characters")
	@Column(name = "password", nullable = true)
	@JsonIgnore
	private String password;

	@OneToMany(mappedBy="userModel")
	private Collection<PoemModel> poems;
	
	@Column(name = "role", nullable= false)
	private String role;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Collection<PoemModel> getPoems() {
		return poems;
	}

	public void setPoems(Collection<PoemModel> poems) {
		this.poems = poems;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
