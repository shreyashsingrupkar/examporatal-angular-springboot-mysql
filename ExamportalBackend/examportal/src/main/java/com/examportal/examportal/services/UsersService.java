package com.examportal.examportal.services;

import java.util.Set;

import com.examportal.examportal.models.UserRole;
import com.examportal.examportal.models.Users;

public interface UsersService {

	
	//creating user
	public Users createUser(Users user , Set<UserRole> userrole);
	
	//get user 
	
	public Users getUser(String username);
	
	//delete user
	public void deleteUser(Long userid);
	
	
	//update user
	public Users updateUser(Users user,String username);
	
}
