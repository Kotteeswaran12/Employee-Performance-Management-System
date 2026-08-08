package com.employee_Manager.performance_system.Service;

import org.springframework.data.domain.Page;

import com.employee_Manager.performance_system.Entity.Departments;

public interface DepartmentServiceInterface {
	
	
	Departments addDepartments (Departments departments) ;
	
	Page<Departments> getAllDepartments(int page , int size) ;
	
	Departments getDeprtById(Integer id);
	
	void deleteDeptById(Integer id) ;

	Departments updateDepartment( String deptName , int id);
	
	

}
