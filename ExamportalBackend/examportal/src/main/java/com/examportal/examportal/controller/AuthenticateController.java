package com.examportal.examportal.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examportal.examportal.config.JwtUtill;
import com.examportal.examportal.models.JwtRequest;
import com.examportal.examportal.models.JwtResponse;
import com.examportal.examportal.models.Users;
import com.examportal.examportal.servicesimpl.UserDetailsServiceImpl;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class AuthenticateController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	private JwtUtill jwtUtill;
	
	
	
	//generate token
	
	@PostMapping("/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest ){
		try {
			authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
		}
		catch(UsernameNotFoundException e) {
			
			throw new UsernameNotFoundException("User Not Found");
		}
		
		UserDetails  userDetails=this.userDetailsServiceImpl.loadUserByUsername(jwtRequest.getUsername());
		
		String token=this.jwtUtill.generateToken(userDetails);
		
		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	
	
	
	private void authenticate(String username,String password) {
		
		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		}catch(DisabledException e) {
			throw new DisabledException("User Disabled");
		}catch(BadCredentialsException e) {
			throw new BadCredentialsException("Invalid Credentials");
		}
	}
	 
	@GetMapping("/current-user")
	public Users getCurrentUser(Principal principal) {
		
		
		return ((Users)this.userDetailsServiceImpl.loadUserByUsername(principal.getName()));
		
	}
}
