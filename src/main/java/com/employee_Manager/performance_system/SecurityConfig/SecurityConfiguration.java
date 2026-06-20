package com.employee_Manager.performance_system.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	private final JWTFilter jwtFilter;

	public SecurityConfiguration(JWTFilter jwtFilter) {
		super();
		this.jwtFilter = jwtFilter;
	}

	@Bean
	public SecurityFilterChain chain(HttpSecurity http) throws Exception {
		return http.csrf(c -> c.disable()).authorizeHttpRequests(a ->

		a.

				requestMatchers("/api/user/add-user/{empId}", "/api/user/log-in").permitAll()
				.anyRequest()
				.authenticated()

		).sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
				.httpBasic(Customizer.withDefaults())
//				.formLogin(Customizer.withDefaults())

				.build();

	}

	
}
