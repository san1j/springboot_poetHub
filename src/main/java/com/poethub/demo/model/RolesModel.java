package com.poethub.demo.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ROLES")
public class RolesModel {
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  @Column(name ="roleId")
      private int roleId;
	  @Column(name = "role", nullable = false) 
      private String role;
	  @ManyToMany(mappedBy = "roles", cascade = CascadeType.ALL)
      private Collection<UserModel> users;
		
	  public int getRoleId() {
			return roleId;
		}
	  public void setRoleId(int roleId) {
			this.roleId = roleId;
		}
      public String getRole() {
			return role;
		}
	  public void setRole(String role) {
			this.role = role;
		}
      public Collection<UserModel> getUsers() {
			return users;
		}
	  public void setUsers(Collection<UserModel> users) {
			this.users = users;
		}
	  
	  
}
