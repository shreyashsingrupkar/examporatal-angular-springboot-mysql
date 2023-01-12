package com.examportal.examportal.servicesimpl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examportal.examportal.models.UserRole;
import com.examportal.examportal.models.Users;
import com.examportal.examportal.repo.RoleRepository;
import com.examportal.examportal.repo.UserRepository;
import com.examportal.examportal.services.UsersService;

@Service
public class UsersServiceImpl implements UsersService{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	
	@Override
	public Users createUser(Users user, Set<UserRole> userRole) {
		// TODO Auto-generated method stub
		Users local=this.userRepository.findByUserName(user.getUsername());
		if(local!=null) {
			System.out.println("User is already present");
			String msg="userisalreadypresent";
			local.setMsg(msg);
			
		}else {
			for(UserRole ur:userRole) {
				roleRepository.save(ur.getRole());
			}
			user.getUserrole().addAll(userRole);
			local=this.userRepository.save(user);
			String msg="submitted";
			local.setMsg(msg);
		}
		return local;
	}


	@Override
	public Users getUser(String username) {
		// TODO Auto-generated method stub
		Users local=this.userRepository.findByUserName(username);
		return local;
	}


	@Override
	public void deleteUser(Long userid) {
		// TODO Auto-generated method stub
	 this.userRepository.deleteById(userid);;
	 
	 
		
	}


	@Override
	public Users updateUser(Users user,String username) {
		// TODO Auto-generated method stub
		
	
		
		return null;
		
	}

}
