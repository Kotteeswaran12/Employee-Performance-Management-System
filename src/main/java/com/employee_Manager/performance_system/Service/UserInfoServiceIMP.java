package com.employee_Manager.performance_system.Service;

import java.time.LocalDate;
import java.util.Objects;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.employee_Manager.performance_system.Entity.Employees;
import com.employee_Manager.performance_system.Entity.UserInfo;
import com.employee_Manager.performance_system.Enums.RoleTypes;
import com.employee_Manager.performance_system.Exceptions.AdminAlreadyExists;
import com.employee_Manager.performance_system.Exceptions.EmployeeNotFoundException;
import com.employee_Manager.performance_system.Exceptions.UserNotFoundException;
import com.employee_Manager.performance_system.Repository.EmployeeRepository;
import com.employee_Manager.performance_system.Repository.UserInfoRepository;

import net.bytebuddy.implementation.bytecode.Throw;

@Service
public class UserInfoServiceIMP implements UserInfoService {

	private final UserInfoRepository userInfoRepository;

	private final EmployeeRepository employeeRepository;
	
	private final BCryptPasswordEncoder bCryptPasswordEncoder ;

//	private final p
	

	@Override
	public UserInfo createUser(String empID, UserInfo user) {

		Employees emp = employeeRepository.findByEmpcode(empID)
				.orElseThrow(() -> new EmployeeNotFoundException("No Employee Found for EMPID : " + empID));

		emp.setUser(user);
		
		if(empID.startsWith("EMP")) {
			user.setRole(RoleTypes.EMPLOYEE);
		}else {
			user.setRole(RoleTypes.MANAGER);
		}
		
		user.setUsername(emp.getFirstname());
		user.setCreatedate(LocalDate.now());
		user.setEmployees(emp);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

		return userInfoRepository.save(user);
	}

	public UserInfoServiceIMP(UserInfoRepository userInfoRepository, EmployeeRepository employeeRepository,
		BCryptPasswordEncoder bCryptPasswordEncoder) {
	super();
	this.userInfoRepository = userInfoRepository;
	this.employeeRepository = employeeRepository;
	this.bCryptPasswordEncoder = bCryptPasswordEncoder;
}

	@Override
	public UserInfo getUserById(String username) {
		// TODO Auto-generated method stub
		return userInfoRepository.findByUsername(username)
				.orElseThrow(() -> new UserNotFoundException("The User not Found for name :" + username));
	}

	@Override
	public UserInfo getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userInfoRepository.findByUsername(username)
				.orElseThrow(()-> new UserNotFoundException("Not user Found for User name :" + username));
	}

	@Override
	public void deleteUserById(Integer id) {
		// TODO Auto-generated method stub

		

		userInfoRepository.deleteById(id);

	}

	@Override
	public UserInfo changepasword(String password, String username) {
		// TODO Auto-generated method stub
		UserInfo user = getUserByUsername(username);

		user.setPassword(password);

		return userInfoRepository.save(user);
	}

	@Override
	public UserInfo createAdmin(UserInfo user) {
		// TODO Auto-generated method stub
		
//		UserInfo existingUserInfo = userInfoRepository.findByUsername(user.getUsername())
//				.orElse( user);
//		
//		if(!Objects.isNull(existingUserInfo) &&  existingUserInfo.getRole().equals(RoleTypes.ADMIN)  ) {
//			
//			throw new AdminAlreadyExists("The Admin alredy Exsist with name :"+ user.getUsername() + " And He is Already Admin also");
//			
//		}
//		
		user.setRole(RoleTypes.ADMIN);
		user.setCreatedate(LocalDate.now());
		
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
		return userInfoRepository.save(user);
	}

	@Override
	public Page<UserInfo> getAllUsers(int page, int size) {
		// TODO Auto-generated method stub
		
		Pageable pageable = PageRequest.of(page, size);
		
		return userInfoRepository.findAll(pageable);
	}

}
