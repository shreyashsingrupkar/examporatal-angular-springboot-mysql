package com.examportal.examportal.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userroleid;
	
	
	//required user table for create relationship 
	//particular role assign to single user
	@ManyToOne(fetch = FetchType.EAGER)
	private Users user;
	
	@ManyToOne
	private Roles role;

	public Long getUserroleid() {
		return userroleid;
	}

	public void setUserroleid(Long userroleid) {
		this.userroleid = userroleid;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	public UserRole(Long userroleid, Users user, Roles role) {
		super();
		this.userroleid = userroleid;
		this.user = user;
		this.role = role;
	}

	public UserRole() {
		super();
	}
	
	
	
}
