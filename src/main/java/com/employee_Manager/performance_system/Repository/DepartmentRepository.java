package com.employee_Manager.performance_system.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee_Manager.performance_system.Entity.Departments;

public interface DepartmentRepository extends JpaRepository<Departments, Integer>{

	Optional<Departments> findBydept (String dept);
}
