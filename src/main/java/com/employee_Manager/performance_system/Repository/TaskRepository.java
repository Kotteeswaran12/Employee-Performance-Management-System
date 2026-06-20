package com.employee_Manager.performance_system.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee_Manager.performance_system.Entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>{

	Task findByTitle(String title);
}
