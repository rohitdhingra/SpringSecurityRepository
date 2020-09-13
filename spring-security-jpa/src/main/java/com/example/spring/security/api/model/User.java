package com.example.spring.security.api.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity

public class User {
	@Id
	@Column(name = "user_id")
	private int userId;
	private String userName;
	private String encPassword;
	private String emailId;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinTable(name = "user_role",joinColumns = @JoinColumn(name = "userId",referencedColumnName = "user_id"),inverseJoinColumns = @JoinColumn(name="roleId",referencedColumnName = "role_id"))
	private Set<Role> roles;
	
	public String getEncPassword() {
		return encPassword;
	}
	public void setEncPassword(String encPassword) {
		this.encPassword = encPassword;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
}
