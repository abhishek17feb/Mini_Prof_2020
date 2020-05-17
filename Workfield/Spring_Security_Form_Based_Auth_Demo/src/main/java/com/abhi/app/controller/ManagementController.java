package com.abhi.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/admin")
public class ManagementController {

	@RequestMapping
	public String helloAdmin() {
		return "Admin call";
	}
	
}
