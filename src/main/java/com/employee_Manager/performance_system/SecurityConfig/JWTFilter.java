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

        System.out.println("IM Filletr JWT");
        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String jwt = authHeader.substring(7);

        System.out.println("Header = [" + authHeader + "]");

        try {
            System.out.println("JWT : " + jwt);

            String username = jwtService.getusername(jwt);
            System.out.println("Username :" + username);

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            System.out.println("Auth Before : " + authentication);

            if (username != null && authentication == null) {

                UserDetails user = serviceIMP.loadUserByUsername(username);
                System.out.println("User load : " + user);

                if (jwtService.isTokenValid(jwt, user)) {

                    System.out.println("Token Valid");

                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(user, null,
                            user.getAuthorities());

                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(authToken);

                    System.out.println("AuthToken : " + authToken.getAuthorities());

                    System.out.println("Sucessfully Valid JWT");
                }
            }

        } catch (Exception e) {
            // Log if needed
            e.printStackTrace();
        }

        filterChain.doFilter(request, response);
    }

}
