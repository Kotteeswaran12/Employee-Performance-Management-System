package com.employee_Manager.performance_system.Service;

import org.springframework.data.domain.Page;

import com.employee_Manager.performance_system.Entity.ApplyLeave;
import com.employee_Manager.performance_system.Enums.LeaveStatus;

public interface LeaveSerivece {

	Page<ApplyLeave> getAllEmployeeLeavesByEmployeeName(String EmployeeName , int page , int size);

	ApplyLeave applyForLeave(ApplyLeave leave , String username);

	void withDrawlLeaveById(Integer id);

	LeaveStatus getLeaveStatusById(Integer id);
	
	ApplyLeave setLeaveStatus(Integer id , LeaveStatus leaveStatus , String managerName);

    Page<ApplyLeave> getAllEmployeeLeavesRequest(int page, int size);
}
