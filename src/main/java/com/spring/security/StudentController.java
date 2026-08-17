package com.spring.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
	

}
