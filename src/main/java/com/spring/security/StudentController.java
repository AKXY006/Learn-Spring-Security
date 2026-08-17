package com.spring.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {
	
	private List<Student> students = new ArrayList<>(
			List.of(
	          new Student(1, "Akshay", 89),
			  new Student(2, "Raj", 90)
	));
	
	@GetMapping("/student")
	public List<Student> getStudents(){
		return students;
	}
	
	//generate csrf token
	@GetMapping ("/csrf-token")
	public CsrfToken getCsrfToken(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf");
	}
	
	
	
	//to add studnet when the dependencues of spring security will b/w remove
	//to save new student use csrf-token
	@PostMapping
	public Student addStudent(@RequestBody Student student) {
		students.add(student);
		return student; 
	}
	

}
