package com.employee_Manager.performance_system.Service;

import org.springframework.data.domain.Page;

import com.employee_Manager.performance_system.Entity.Employees;

public interface EmployeeService {

	Page<Employees> getAllSubordinatesByManagerName(String username, int page, int size);

	Employees addManagerToDepartment(Employees emp, Integer deptId);

	Employees deleteEmployeeById(Integer id);

	Employees getEmployeeById(Integer id);

	Employees addEmployeeAndAssigntoManager(Employees emp, String managerName);

	Employees getEmployeByFirstName(String name);
	
	Page<Employees> getAllEmployees(int page , int size);

	Object[] countAllTheEmployeesByDept();

    Employees getEmployeeByEmpCode(String empCode);

	

}
