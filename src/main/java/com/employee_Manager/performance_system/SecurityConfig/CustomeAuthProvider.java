package com.employee_Manager.performance_system.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Configuration
public class CustomeAuthProvider {
	
	private final BCryptPasswordEncoder bCryptPasswordEncoder ;
	
	private final UserDetailsService userDetails ;
	
	

	public CustomeAuthProvider(BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailsService userDetails) {
		super();
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.userDetails = userDetails;
	}



	@Bean
	public AuthenticationProvider authenticationProvider () {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider(userDetails);
		
		authenticationProvider.setPasswordEncoder(bCryptPasswordEncoder);
		
		return authenticationProvider;
	}
}
