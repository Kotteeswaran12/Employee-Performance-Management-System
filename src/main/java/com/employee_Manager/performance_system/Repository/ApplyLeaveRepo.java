package com.employee_Manager.performance_system.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee_Manager.performance_system.Entity.ApplyLeave;

@Repository
public interface ApplyLeaveRepo extends JpaRepository<ApplyLeave, Integer> {

	List<ApplyLeave> findByemployeesId(Integer id);
	
}
