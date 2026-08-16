package com.spring.security.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {
	
	@GetMapping
	public String greet() {

		// java with html return 
		return """
				<h1>yes</h1>
				<p>no</>
				
			  """;
	}

}
