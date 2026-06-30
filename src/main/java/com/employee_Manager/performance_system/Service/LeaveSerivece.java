package com.employee_Manager.performance_system.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.employee_Manager.performance_system.Entity.ApplyLeave;
import com.employee_Manager.performance_system.Enums.LeaveStatus;

public interface LeaveSerivece {

	List<ApplyLeave> getAllEmployeeLeavesByEmployeeName(String empName);

	ApplyLeave applyForLeave(ApplyLeave leave , String username);

	void withDrawlLeaveById(Integer id);

	LeaveStatus getLeaveStatusById(Integer id);
	
	ApplyLeave setLeaveStatus(Integer id , LeaveStatus leaveStatus , String managerName);
}
