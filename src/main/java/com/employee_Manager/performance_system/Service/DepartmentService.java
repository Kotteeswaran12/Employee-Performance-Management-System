package com.employee_Manager.performance_system.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	public Page<Departments> getAllDepartments(int page , int size) {
		// TODO Auto-generated method stub
		
		Pageable pageable = PageRequest.of(page, size);
		
		return DeptRepo.findAll(pageable);
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
