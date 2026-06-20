package com.employee_Manager.performance_system.Service;

import java.time.LocalDate;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.employee_Manager.performance_system.Entity.Employees;
import com.employee_Manager.performance_system.Entity.UserInfo;
import com.employee_Manager.performance_system.Exceptions.EmployeeNotFoundException;
import com.employee_Manager.performance_system.Exceptions.UserNotFoundException;
import com.employee_Manager.performance_system.Repository.EmployeeRepository;
import com.employee_Manager.performance_system.Repository.UserInfoRepository;

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
	public UserInfo getUserById(Integer id) {
		// TODO Auto-generated method stub
		return userInfoRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("The User not Found for Id :" + id));
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

		UserInfo user = getUserById(id);

		userInfoRepository.deleteById(user.getId());

	}

	@Override
	public UserInfo changepasword(String password, String username) {
		// TODO Auto-generated method stub
		UserInfo user = getUserByUsername(username);

		user.setPassword(password);

		return userInfoRepository.save(user);
	}

}
