package com.employee_Manager.performance_system.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee_Manager.performance_system.Entity.ApplyLeave;
import com.employee_Manager.performance_system.Enums.LeaveStatus;

@Repository
public interface ApplyLeaveRepo extends JpaRepository<ApplyLeave, Integer> {

	List<ApplyLeave> findByemployeesId(Integer id);

	List<ApplyLeave> findByStatus(LeaveStatus pending);

//	Optional<List<ApplyLeave>> findByStatusAndEmployees_Empcode(LeaveStatus pending, String empcode);

	Optional<List<ApplyLeave>> findByStatusAndEmployees_Departments_id(LeaveStatus pending, Integer id);

	Page<ApplyLeave> findByEmployees_Firstname(String employeeName , Pageable pageable);

	int countByStatus(LeaveStatus pending);

	int countByStatusAndEmployees_Departments_id(LeaveStatus pending, Integer id);
	
}
