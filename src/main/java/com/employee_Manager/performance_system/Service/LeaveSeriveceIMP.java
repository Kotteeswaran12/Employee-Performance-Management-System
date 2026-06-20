package com.employee_Manager.performance_system.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public List<ApplyLeave> getAllEmployeeLeavesByEmpId(Integer id) {
		// TODO Auto-generated method stub
		return leaveRepo.findByemployeesId(id);
	}

	@Override
	public ApplyLeave applyForLeave(ApplyLeave leave, Integer id) {
		// TODO Auto-generated method stub
		Employees emp = empRepo.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee With ID : " + id + "Not Found !!"));
		leave.setStatus(LeaveStatus.PENDING);
		leave.setEmployees(emp);

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
	public ApplyLeave setLeaveStatus(Integer leaveId, LeaveStatus leaveStatus, Integer aprovedId) {
		// TODO Auto-generated method stub

		ApplyLeave applyLeave = leaveRepo.findById(leaveId)
				.orElseThrow(() -> new LeaveNotFoundException("Leave Not Found for Leave ID : " + leaveId));

		applyLeave.setStatus(leaveStatus);
		Employees emp = empRepo.findById(aprovedId)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee With ID : " + aprovedId + "Not Found !!"));

		applyLeave.setAprovedBy(emp);

		leaveRepo.save(applyLeave);

		return applyLeave;
	}

}
