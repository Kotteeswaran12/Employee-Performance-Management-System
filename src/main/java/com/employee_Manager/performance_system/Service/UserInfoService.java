package com.employee_Manager.performance_system.Service;

import com.employee_Manager.performance_system.Entity.UserInfo;

public interface UserInfoService {
	
	
	UserInfo createUser(String empID ,UserInfo user);
	
	UserInfo getUserById(String username);
	
	UserInfo getUserByUsername(String username);
	
	void deleteUserById(Integer id);
	
	UserInfo changepasword(String password , String username);

	UserInfo createAdmin(UserInfo user);
	

}
