package com.employee_Manager.performance_system.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import com.employee_Manager.performance_system.Entity.Departments;

public interface DepartmentServiceInterface {
	
	
	Departments addDepartments (Departments departments) ;
	
	Page<Departments> getAllDepartments(int page , int size) ;
	
	Departments getDeprtById(Integer id);
	
	void deleteDeptById(Integer id) ;
	
	

}
