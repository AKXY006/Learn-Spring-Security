package com.spring.security.config;

import java.net.Authenticator.RequestorType;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.websocket.Session;

@Configuration
@EnableWebSecurity
public class config {
	
	
	//we will buy-pass all the security
	
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
		
		//due to customizer disable all request are denied
//		httpSecurity.csrf(Customizer -> Customizer.disable());
//		httpSecurity.authorizeHttpRequests(request -> request.anyRequest().fullyAuthenticated());
		
		//Now we will customised the login page to open
		//but in postman show login form
//		httpSecurity.formLogin(Customizer.withDefaults());
		
		//authenticates the user and directly returns the controller’s output.
//		httpSecurity.httpBasic(Customizer.withDefaults());
		
		//same 
		return httpSecurity
				.csrf(Customizer -> Customizer.disable())
				.authorizeHttpRequests(request -> request.anyRequest().authenticated())
				.httpBasic(Customizer.withDefaults())
				.sessionManagement(session ->
				          session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.build();
		
	}
	 
	@Bean
	public UserDetailsService userDetailsService() {

		//set multiple user name and password 
	    UserDetails user1 = User
	            .withDefaultPasswordEncoder()
	            .username("krrish")
	            .password("krrish")
	            .roles("Admin")
	            .build();
	    
	    UserDetails user2 = User
	            .withDefaultPasswordEncoder()
	            .username("Admin")
	            .password("root")
	            .build();

	    return new InMemoryUserDetailsManager(user2,user1);
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider(null);
		return provider;
		
	}

}
