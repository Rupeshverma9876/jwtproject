package com.loggingg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.loggingg.entity.userentity;
import com.loggingg.service.userservice;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/s")
public class usercontroller{
	@Autowired
	private userservice userservice;
	
	@PostMapping("/savedata")
	public String datasave(@RequestBody userentity u) {
		userservice.saveuserdata(u);
		return "okk saved data with all field ";
	}
	
	@GetMapping("/data")
	public List<userentity> getdata() {
		return userservice.getalldata();
		
	}
	@GetMapping("/singledata/{id}")
	public userentity returndata(@PathVariable Long id) {
		return userservice.getsingledata(id);
	}
	@GetMapping("/screen")
	public String showuserdataonscreen(HttpServletRequest request) {
		return"this is the session id"  + request.getSession().getId();
	}
	@GetMapping("/csrf-token")
	public CsrfToken genertaetoken(HttpServletRequest request) {
		return  (CsrfToken) request.getAttribute("_csrf");
		
	}
	
	
	
}