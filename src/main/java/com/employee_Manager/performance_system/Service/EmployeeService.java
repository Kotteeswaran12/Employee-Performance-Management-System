package com.employee_Manager.performance_system.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.employee_Manager.performance_system.Entity.Employees;

public interface EmployeeService {

	List<Employees>  getAllEmployees(String username);

	Employees addEmployees(Employees emp , Integer deptId);

	Employees deleteEmployeeById(Integer id);

	Employees getEmployeeById(Integer id);
	
	Employees addEmployeeAndAssigntoManager (Employees emp ,String managerName);

	Employees getEmployeByFirstName(String name);

}
