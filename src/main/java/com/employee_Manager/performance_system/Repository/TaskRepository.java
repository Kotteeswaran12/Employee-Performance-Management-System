package com.employee_Manager.performance_system.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee_Manager.performance_system.Entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>{

	Task findByTitle(String title);
	
	Optional<List<Task>> findByCreatedBy_id(Integer id);
}
