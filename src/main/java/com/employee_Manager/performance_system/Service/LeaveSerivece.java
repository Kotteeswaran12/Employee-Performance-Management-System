package com.employee_Manager.performance_system.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.employee_Manager.performance_system.Entity.ApplyLeave;
import com.employee_Manager.performance_system.Enums.LeaveStatus;

public interface LeaveSerivece {

	List<ApplyLeave> getAllEmployeeLeavesByEmpId(Integer id);

	ApplyLeave applyForLeave(ApplyLeave leave , Integer id);

	void withDrawlLeaveById(Integer id);

	LeaveStatus getLeaveStatusById(Integer id);
	
	ApplyLeave setLeaveStatus(Integer id , LeaveStatus leaveStatus , Integer aprovedId);
}
