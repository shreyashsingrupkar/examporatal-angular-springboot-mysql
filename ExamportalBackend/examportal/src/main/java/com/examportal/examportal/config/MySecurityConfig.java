package com.examportal.examportal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.examportal.examportal.servicesimpl.UserDetailsServiceImpl;

@SuppressWarnings("deprecation")
@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig {

	
	
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	


	
	
	@Bean
	public PasswordEncoder bCryptPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
		
	}
	
	
	 @Bean
	    public AuthenticationManager authenticationManager(
	            AuthenticationConfiguration authenticationConfiguration) throws Exception {
	        return authenticationConfiguration.getAuthenticationManager();
	    }
	
	/*@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(this.userDetailsServiceImpl).passwordEncoder(bCryptPasswordEncoder());
	}*/

	
	/*
	//end points
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
		 		.csrf()
		 		.disable()
		 		.cors()
		 		.disable()
		 		.authorizeRequests()
		 		.antMatchers("/generate-token", "/user/").permitAll()
		 		.antMatchers(HttpMethod.OPTIONS).permitAll()
		 		.anyRequest().authenticated()
		 		.and()
		 		.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
		 		.and()
		 		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		 		
		http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
		 		
	}

	*/
	
	@Bean
	 public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
		 		.csrf()
		 		.disable()
		 		.cors()
		 		.disable()
		 		.authorizeRequests()
		 		.antMatchers("/generate-token", "/user/").permitAll()
		 		.antMatchers(HttpMethod.OPTIONS).permitAll()
		 		.anyRequest().authenticated()
		 		.and()
		 		.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
		 		.and()
		 		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		 		
		http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
		 		
	}
	
}
