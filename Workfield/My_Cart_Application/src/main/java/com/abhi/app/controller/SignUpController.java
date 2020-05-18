package com.abhi.app.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.app.dto.ServerResponse;
import com.abhi.app.dto.UserDetails;

@RestController
@RequestMapping("/v1/signup")
public class SignUpController {

	@PostMapping("/user")
	public ServerResponse signUp( @RequestBody UserDetails userDetails ) {
		
	}
	
}
