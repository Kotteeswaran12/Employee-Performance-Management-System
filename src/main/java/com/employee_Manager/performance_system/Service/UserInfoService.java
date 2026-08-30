package com.employee_Manager.performance_system.Service;

import org.springframework.data.domain.Page;

import com.employee_Manager.performance_system.Entity.UserInfo;
import com.employee_Manager.performance_system.RequestDTO.ChangePassDTO;
import com.employee_Manager.performance_system.ResponseDtoLayer.UserInfoDTO;


public interface UserInfoService {
	

	
	
	UserInfo createUser(String empID ,UserInfo user);
	
	UserInfo getUserById(String username);
	
	UserInfo getUserByUsername(String username);
	
	void deleteUserById(Integer id);
	
	UserInfo UpdateUserInfo(UserInfoDTO UnserInfo , String username);

	UserInfo createAdmin(UserInfo user);
	
	Page<UserInfo> getAllUsers(int page , int size);

	UserInfo UpdatePassword (ChangePassDTO password , String UserName);
	

}
