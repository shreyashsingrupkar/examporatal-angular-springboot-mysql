package com.examportal.examportal.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Roles {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Long roleid;
	private String rolename;
	
	//watch himbernate video for cascade,fetch,mappedBy
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "role")
	@JsonIgnore
	private Set<UserRole> userrole=new HashSet<>();
	
	public Long getRoleid() {
		return roleid;
	}
	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	
	public Set<UserRole> getUserrole() {
		return userrole;
	}
	public void setUserrole(Set<UserRole> userrole) {
		this.userrole = userrole;
	}
	
	public Roles(Long roleid, String rolename, Set<UserRole> userrole) {
		super();
		this.roleid = roleid;
		this.rolename = rolename;
		this.userrole = userrole;
	}
	public Roles() {
		super();
	}
	
	
	
}
