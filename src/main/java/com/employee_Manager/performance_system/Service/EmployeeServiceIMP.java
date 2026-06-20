package com.employee_Manager.performance_system.Service;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.employee_Manager.performance_system.Entity.Departments;
import com.employee_Manager.performance_system.Entity.Employees;
import com.employee_Manager.performance_system.Enums.RoleTypes;
import com.employee_Manager.performance_system.Exceptions.DepartmentNotFoundException;
import com.employee_Manager.performance_system.Exceptions.EmployeeNotFoundException;
import com.employee_Manager.performance_system.Exceptions.NotaManagerException;
import com.employee_Manager.performance_system.Repository.DepartmentRepository;
import com.employee_Manager.performance_system.Repository.EmployeeRepository;

@Service
public class EmployeeServiceIMP implements EmployeeService {


	private final  EmployeeRepository empRepo;
	private final DepartmentRepository deptRepo;
	
	

	public EmployeeServiceIMP(EmployeeRepository empRepo, DepartmentRepository deptRepo) {
		super();
		this.empRepo = empRepo;
		this.deptRepo = deptRepo;
	}

	@Override
	public List<Employees> getAllEmployees() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}

	@Override
	public Employees addEmployees(Employees emp , Integer deptId) {
		// TODO Auto-generated method stub
		
		Departments depts = deptRepo.findById(deptId)
				.orElseThrow(()-> new DepartmentNotFoundException("NO Department Found for DEPT-ID : " + deptId));
		
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
	public Employees addEmployeeAndAssigntoManager(Employees emp, Integer managerID) {
		// TODO Auto-generated method stub
		
		Employees manager = empRepo.findById(managerID)
				.orElseThrow(() -> new EmployeeNotFoundException("The Manager not found for ID :" + managerID));
		
		
		if(!manager.getUser().getRole().equals(RoleTypes.MANAGER)) {
			throw new NotaManagerException("The id u have paswed was not a Manager");
		}
		
		manager.getSubordinate().add(emp);
		
		
		
		emp.setJoindate(LocalDate.now());
		emp.setManager(manager);
		emp.setDepartments(manager.getDepartments());
		
		empRepo.save(emp);
		
		
		return  emp;
	}

}
