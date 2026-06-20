package com.employee_Manager.performance_system.Service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.employee_Manager.performance_system.Entity.UserInfo;
@Component
public class CustomeUserDetailService implements UserDetailsService {

	private final UserInfoServiceIMP userInfoServiceIMP;

	public CustomeUserDetailService(UserInfoServiceIMP userInfoServiceIMP) {
		super();

		this.userInfoServiceIMP = userInfoServiceIMP;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserInfo user = userInfoServiceIMP.getUserByUsername(username);
		
		System.out.println(user);

		return new CustomeUserDetails(user);
	}

}
