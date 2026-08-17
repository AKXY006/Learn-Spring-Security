package com.spring.security.config;

import java.net.Authenticator.RequestorType;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class config {
	
	
	//we will buy-pass all the security
	
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
		
		//due to customizer disable all request are denied
		httpSecurity.csrf(Customizer -> Customizer.disable());
		httpSecurity.authorizeHttpRequests(request -> request.anyRequest().fullyAuthenticated());
		
		//Now we will customised the login page to open
		//but in postman show login form
		httpSecurity.formLogin(Customizer.withDefaults());
		
		//authenticates the user and directly returns the controller’s output.
		httpSecurity.httpBasic(Customizer.withDefaults());
		
		
		return  httpSecurity.build();
	}

}
