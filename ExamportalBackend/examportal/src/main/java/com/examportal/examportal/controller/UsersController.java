package com.examportal.examportal.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examportal.examportal.models.Roles;
import com.examportal.examportal.models.UserRole;
import com.examportal.examportal.models.Users;
import com.examportal.examportal.servicesimpl.UsersServiceImpl;

@RestController
@RequestMapping(value="/user")
@CrossOrigin(origins="http://localhost:4200")
public class UsersController {

	@Autowired
	private UsersServiceImpl usersServiceImpl;
	
	@PostMapping(value="/")
	public Users createUser(@RequestBody Users users) {
	 
		Set<UserRole> useroleset =new HashSet<>();
		
		Roles roles=new Roles();
		long idrole=45L;
		roles.setRoleid(idrole);
		roles.setRolename("NORMAL");
		
		
		UserRole userrole=new UserRole();
		userrole.setUser(users);
		userrole.setRole(roles);
		
		useroleset.add(userrole);
		
		return this.usersServiceImpl.createUser(users, useroleset);
	}
	
	@GetMapping(value="/{username}")
	public Users getUser(@PathVariable("username") String username) {
		return this.usersServiceImpl.getUser(username);
	}
	
	@DeleteMapping(value="/{userid}")
	public void deleteUser(@PathVariable("userid") Long userid) {
		this.usersServiceImpl.deleteUser(userid);
	}
	
}
