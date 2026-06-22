package com.employee_Manager.performance_system.Service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.employee_Manager.performance_system.Entity.Departments;
import com.employee_Manager.performance_system.Exceptions.DepartmentNotFoundException;
import com.employee_Manager.performance_system.Repository.DepartmentRepository;

@Service
public class DepartmentService implements DepartmentServiceInterface {

	@Autowired
	private DepartmentRepository DeptRepo;

	@Override
	public Departments addDepartments(Departments departments) {
		// TODO Auto-generated method stub

		

		return DeptRepo.save(departments);
	}

	@Override
	public List<Departments> getAllDepartments() {
		// TODO Auto-generated method stub
		return DeptRepo.findAll();
	}

	@Override
	public Departments getDeprtById(Integer id) {
		// TODO Auto-generated method stub
		return DeptRepo.findById(id)
				.orElseThrow(() -> new DepartmentNotFoundException(
						"Department Not Found with ur ID : " + id + " Try with Different ID !!"));
	}

	@Override
	public void deleteDeptById(Integer id) {

		Departments dept = DeptRepo.findById(id)
				.orElseThrow(() -> new DepartmentNotFoundException("Department Not Found with ur ID "));


		DeptRepo.deleteById(id);
		
	}

}
