package com.employee_Manager.performance_system.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.employee_Manager.performance_system.Entity.ApplyLeave;
import com.employee_Manager.performance_system.Entity.Employees;
import com.employee_Manager.performance_system.Enums.LeaveStatus;
import com.employee_Manager.performance_system.Exceptions.EmployeeNotFoundException;
import com.employee_Manager.performance_system.Exceptions.LeaveNotFoundException;
import com.employee_Manager.performance_system.Repository.ApplyLeaveRepo;
import com.employee_Manager.performance_system.Repository.EmployeeRepository;

@Service
public class LeaveSeriveceIMP implements LeaveSerivece {

	@Autowired
	private ApplyLeaveRepo leaveRepo;

	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public Page<ApplyLeave> getAllEmployeeLeavesByEmployeeName(String EmployeeName , int page , int size) {
		// TODO Auto-generated method stub
		
		Pageable pageable = PageRequest.of(page, size);
		
		return leaveRepo.findByEmployees_Firstname(EmployeeName , pageable);
	}

	@Override
	public ApplyLeave applyForLeave(ApplyLeave leave, String username) {
		// TODO Auto-generated method stub
		Employees emp = empRepo.findByFirstname(username)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee With username : " + username + "Not Found !!"));
		leave.setStatus(LeaveStatus.PENDING);
		leave.setEmployees(emp);
		leave.setAprovedBy(emp.getManager());

		return leaveRepo.save(leave);
	}

	@Override
	public void withDrawlLeaveById(Integer id) {
		// TODO Auto-generated method stub

		ApplyLeave applyLeave = leaveRepo.findById(id)
				.orElseThrow(() -> new LeaveNotFoundException("Leave Not Found for Leave ID : " + id));

		applyLeave.setStatus(LeaveStatus.WITHDRAWN);

//		return applyLeave;
	}

	@Override
	public LeaveStatus getLeaveStatusById(Integer id) {

		ApplyLeave applyLeave = leaveRepo.findById(id)
				.orElseThrow(() -> new LeaveNotFoundException("Leave Not Found for Leave ID : " + id));
		// TODO Auto-generated method stub

		return applyLeave.getStatus();
	}

	@Override
	public ApplyLeave setLeaveStatus(Integer leaveId, LeaveStatus leaveStatus, String managerName) {
		// TODO Auto-generated method stub

		ApplyLeave applyLeave = leaveRepo.findById(leaveId)
				.orElseThrow(() -> new LeaveNotFoundException("Leave Not Found for Leave ID : " + leaveId));

		applyLeave.setStatus(leaveStatus);
		Employees emp = empRepo.findByFirstname(managerName)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee With ID : " + managerName + "Not Found !!"));

		applyLeave.setAprovedBy(emp);

		leaveRepo.save(applyLeave);

		return applyLeave;
	}

	@Override
	public Page<ApplyLeave> getAllEmployeeLeavesRequest(int page, int size) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(page, size);
		return leaveRepo.findAll(pageable);
	}

}
