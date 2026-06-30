package com.employee_Manager.performance_system.Service;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.employee_Manager.performance_system.Entity.Departments;
import com.employee_Manager.performance_system.Entity.Employees;
import com.employee_Manager.performance_system.Entity.UserInfo;
import com.employee_Manager.performance_system.Enums.RoleTypes;
import com.employee_Manager.performance_system.Exceptions.DepartmentNotFoundException;
import com.employee_Manager.performance_system.Exceptions.EmployeeNotFoundException;
import com.employee_Manager.performance_system.Exceptions.NotaManagerException;
import com.employee_Manager.performance_system.Exceptions.UserNotFoundException;
import com.employee_Manager.performance_system.Repository.DepartmentRepository;
import com.employee_Manager.performance_system.Repository.EmployeeRepository;
import com.employee_Manager.performance_system.Repository.UserInfoRepository;

@Service
public class EmployeeServiceIMP implements EmployeeService {

	private final EmployeeRepository empRepo;
	private final DepartmentRepository deptRepo;
	private final UserInfoRepository userInfoRepository;

	public EmployeeServiceIMP(EmployeeRepository empRepo, DepartmentRepository deptRepo,
			UserInfoRepository userInfoRepository) {
		super();
		this.empRepo = empRepo;
		this.deptRepo = deptRepo;
		this.userInfoRepository = userInfoRepository;
	}

	@Override
	public List<Employees> getAllEmployees(String username) {
		// TODO Auto-generated method stub
		Employees empManager = empRepo.findByFirstname(username)
				.orElseThrow(() -> new UserNotFoundException("The Manager Not Found with name :" + username));

		return empManager.getSubordinate();
	}

	@Override
	public Employees addEmployees(Employees emp, Integer deptId) {
		// TODO Auto-generated method stub

		Departments depts = deptRepo.findById(deptId)
				.orElseThrow(() -> new DepartmentNotFoundException("NO Department Found for DEPT-ID : " + deptId));

		emp.setDepartments(depts);

		emp.setJoindate(LocalDate.now());

		return empRepo.save(emp);

	}

	@Override
	public Employees deleteEmployeeById(Integer id) {
		// TODO Auto-generated method stub
		Employees emp = empRepo.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee With ID : " + id + "Not Found !!"));

//		emp.setDepartments(null);

		empRepo.deleteById(id);

		return emp;
	}

	@Override
	public Employees getEmployeeById(Integer id) {
		// TODO Auto-generated method stub
		return empRepo.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee With ID : " + id + "Not Found !!"));
	}

	@Override
	public Employees addEmployeeAndAssigntoManager(Employees emp, String managerName) {
		// TODO Auto-generated method stub

		Employees manager = empRepo.findByFirstname(managerName)
				.orElseThrow(() -> new EmployeeNotFoundException("The Manager not found for Name :" + managerName));

		if (!manager.getUser().getRole().equals(RoleTypes.MANAGER)) {
			throw new NotaManagerException("The id u have paswed was not a Manager");
		}

		manager.getSubordinate().add(emp);

		emp.setJoindate(LocalDate.now());
		emp.setManager(manager);
		emp.setDepartments(manager.getDepartments());

		empRepo.save(emp);

		return emp;
	}

	@Override
	public Employees getEmployeByFirstName(String name) {
		// TODO Auto-generated method stub
		return empRepo.findByFirstname(name)
				.orElseThrow(() -> new EmployeeNotFoundException("No Employee Found for name : "+ name));
	}

}
