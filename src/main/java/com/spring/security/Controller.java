package com.spring.security;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;


@RestController
public class Controller {
	
	@GetMapping
	public String greet(HttpServletRequest httpServletRequest) {

		// java with html return 
//		return """
//				<h1>yes</h1>
//				<p>no</>
//				
//			  """;
		
		return "My Servlet Request is -> " + httpServletRequest.getSession().getId();
	}

}
