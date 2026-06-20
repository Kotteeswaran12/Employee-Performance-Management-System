package com.employee_Manager.performance_system.SecurityConfig;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

@Configuration
public class CustomeAuthManager {

	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configurator) throws Exception{
		
		
		return  configurator.getAuthenticationManager() ;
	}
}
