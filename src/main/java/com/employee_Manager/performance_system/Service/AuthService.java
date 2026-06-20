package com.employee_Manager.performance_system.Service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.employee_Manager.performance_system.Entity.UserInfo;

@Service
public class AuthService {

	public final AuthenticationManager authenticationManager;

	public final JWTService jwtService;

	public AuthService(AuthenticationManager authenticationManager, JWTService jwtService) {
		super();
		this.authenticationManager = authenticationManager;
		this.jwtService = jwtService;
	}

	public String getAuthentication(UserInfo user) {
		// TODO Auto-generated method stub

		Authentication auth = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

		return auth.isAuthenticated() ? jwtService.getToken(user.getUsername()) : "Username  or password is Incorrect !!";
	}

}
