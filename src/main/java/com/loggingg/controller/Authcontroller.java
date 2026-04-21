package com.loggingg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loggingg.dto.userlogindto;
import com.loggingg.dto.usersignupdto;
import com.loggingg.service.userservice;

@RequestMapping("/a")
@RestController
public class Authcontroller {
		@Autowired
	private userservice userservice;
		@PostMapping("/signup")
		public String signup(@RequestBody usersignupdto u) {
			return userservice.signup(u);
		}
		@PostMapping("/ul")
		public String login(@RequestBody userlogindto ul) {
			return userservice.login(ul);
		}
}
