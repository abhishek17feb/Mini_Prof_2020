package com.abhi.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/admin")
public class ManagementController {

	@GetMapping("/info")
	public String getAdminInformation() {
		return "Only Admins Allowed unlocked";
	}
	
}
