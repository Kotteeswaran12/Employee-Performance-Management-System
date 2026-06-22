package com.employee_Manager.performance_system.SecurityConfig;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.employee_Manager.performance_system.Service.CustomeUserDetailService;
import com.employee_Manager.performance_system.Service.JWTService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class JWTFilter extends OncePerRequestFilter {

	private final JWTService jwtService;

	private final CustomeUserDetailService serviceIMP;

	public JWTFilter(JWTService jwtService, CustomeUserDetailService serviceIMP) {
		super();
		this.jwtService = jwtService;
		this.serviceIMP = serviceIMP;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String auth = request.getHeader("Authorization");
		
		if(auth == null || !auth.startsWith("Bearer ")) {
			filterChain.doFilter(request, response);
			return ;
		}
		
		
		String jwt = auth.substring(7);
		String username = jwtService.getusername(jwt);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if(jwt !=null && authentication == null) {
			
			UserDetails user = serviceIMP.loadUserByUsername(username);
			
			if(jwtService.isTokenValid(jwt , user)) {
				
			UsernamePasswordAuthenticationToken authenticationFilter =new UsernamePasswordAuthenticationToken(
					user , null ,  user.getAuthorities()
					);
			
			authenticationFilter.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			
			SecurityContextHolder.getContext().setAuthentication(authenticationFilter);
			
			}
			
		}
		
		filterChain.doFilter(request, response);
		
	}

}
