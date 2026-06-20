package com.employee_Manager.performance_system.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee_Manager.performance_system.Entity.Employees;

@Repository
public interface EmployeeRepository extends JpaRepository<Employees, Integer> {
	

	Optional<Employees> findByEmpcode(String emp_code);

}
