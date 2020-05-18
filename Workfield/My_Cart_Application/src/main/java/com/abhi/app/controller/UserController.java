package com.abhi.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.app.dto.Student;

@RestController
@RequestMapping("/v1/user")
public class UserController {
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello";
	}
	
	@GetMapping("/student/{id}")
	public Student fetchStudent( @PathVariable("id") String studentId ) {
		System.out.println("ID is"  +studentId);
		return new Student("Abhishke",25);
	}
	
	@PutMapping("/student")
	public Student updateStudent(@RequestBody() String name ) {
		System.out.println("Updated student is " + name);
		return new Student("Aniket",45);
	}
	
}
