package com.abhi.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.app.dto.Student;

@RestController
@RequestMapping(path="v1/students")
public class StudentController {
	
	private static List<Student> studentList = new ArrayList<Student>();
	
	@GetMapping("/{rollNumber}")
	public Student getStudentInfo( @PathVariable("rollNumber") Integer rollNumber  ) {
		studentList.add(new Student(1,"Abhishek"));
		studentList.add(new Student(2,"Sumi"));
		studentList.add(new Student(3,"Sumi"));
		studentList.add(new Student(3,"Monu"));
		
		return studentList.stream()
			.filter( student -> rollNumber.equals(student.getRollNumber()) )
			.findFirst().orElseThrow(()-> new IllegalStateException("Student not found"));
	}
	
	@GetMapping("/course")
	public String getCourse() {
		return "My Course";
	}
	
	@PostMapping("/student")
	public String createStudent() {
		return "Student Created";
	}
	
	@PutMapping("/{rollNumber}")
	public String updateStudent() {
		return "Student Updated";
	}
	
	@PostMapping("/course")
	public String createdCourse() {
		return "Course created";
	}

}
