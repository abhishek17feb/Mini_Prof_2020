package com.abhi.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/student")
public class StudentController {

	@GetMapping
	public String getAllStudent() {
		return "All Student";
	}
	
}
