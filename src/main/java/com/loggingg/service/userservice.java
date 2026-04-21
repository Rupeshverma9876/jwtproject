package com.loggingg.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.BeanDefinitionDsl.Role;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.loggingg.dto.userlogindto;
import com.loggingg.dto.usersignupdto;

import com.loggingg.entity.userentity;
import com.loggingg.repository.userrepository;

@Service
public class userservice{
	
	private final userrepository userrepository;
	
	
	public userservice(userrepository userrepository) {
		this.userrepository =  userrepository;
	}
	
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private jwtService jservice;
	
	public String saveuserdata(userentity u) {
		u.setEmial(u.getEmial());
		u.setUsername(u.getUsername());
		userrepository.save(u);
		return "data saved ok";
	}
	
	public List<userentity> getalldata(){
		return userrepository.findAll();
	}
	
	public userentity getsingledata(Long id) {
		return userrepository.findById(id).orElseThrow();
	}
	
	
	public String signup(usersignupdto dto) {

	    userentity user = new userentity();

	    user.setUsername(dto.getUsername().trim().toLowerCase());
	    user.setPassword(encoder.encode(dto.getPassword()));
	    

	    userrepository.save(user);

	    return "saved";
	}
	 public String login(userlogindto user) {
	        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
	        if (authentication.isAuthenticated()) {
	            return jservice.generatetoken(user.getUsername());
	        } else {
	            return "fail";
	        }
	    }

	}

	
	
