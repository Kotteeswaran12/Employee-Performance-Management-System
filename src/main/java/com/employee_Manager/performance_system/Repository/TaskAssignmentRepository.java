package com.employee_Manager.performance_system.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import com.employee_Manager.performance_system.Entity.TaskAssignments;
import com.employee_Manager.performance_system.Enums.AssignmentStatus;

public interface TaskAssignmentRepository extends JpaRepository<TaskAssignments, Integer> {

	Page<TaskAssignments> findByAssignedTo_Id(Integer id , Pageable pageable);
	
	Page<TaskAssignments> findByAssignedBy_Id(Integer id , Pageable pageable);

	List<TaskAssignments> findByStatus(AssignmentStatus complited);

	Optional<List<TaskAssignments>> findByStatusAndAssignedTo_Empcode(AssignmentStatus pending, String empId);

	List<TaskAssignments> findByAssignedTo_Departments_Dept(String dept);

	long countByStatus(AssignmentStatus complited);

	int countByStatusAndAssignedTo_Empcode(AssignmentStatus pending,
			String employeesEmpCode);

	int countByAssignedTo_Departments_Dept(String dept);
	
//	
//	@ManyToOne
//	private Employees assignedTo;
//	@ManyToOne
//	private Employees assignedBy;

 }
