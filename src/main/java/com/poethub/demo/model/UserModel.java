package com.poethub.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "USER")
public class UserModel {
	//public static final String user_role = "USER";

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int userId;

@NotNull
@Size(min=5, max=16, message = "Username must be between 5 and 16 characters")
@Column(name = "username", nullable = false, unique = true)
private String username;

@Column(name = "enabled", nullable = false)
private boolean enabled;

@NotNull
@Email(message = "Please enter a valid email")
@Column(name = "email", nullable = false, unique = true)
private String email;

@NotNull
@Size(min=5, max=30, message = "First Name must be between 5 and 30 characters")
@Column(name = "firstName", nullable = false)
private String firstName;

@NotNull
@Size(min=5, max=30, message = "Last Name must be between 5 and 16 characters")
@Column(name = "lastName", nullable = false)
private String lastName;

@NotNull
@Size(min=5, max=30, message = "Password must be between 5 and 16 characters")
@Column(name = "password", nullable = false)
private String password;

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
 
//override equals and hashcode



}
