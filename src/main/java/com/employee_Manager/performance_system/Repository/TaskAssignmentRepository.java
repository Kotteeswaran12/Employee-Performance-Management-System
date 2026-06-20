package com.employee_Manager.performance_system.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee_Manager.performance_system.Entity.TaskAssignments;

public interface TaskAssignmentRepository extends JpaRepository<TaskAssignments, Integer> {

	List<TaskAssignments> findByAssignedTo_Id(Integer id);
	
	List<TaskAssignments> findByAssignedBy_Id(Integer id);
	
//	
//	@ManyToOne
//	private Employees assignedTo;
//	@ManyToOne
//	private Employees assignedBy;

 }
