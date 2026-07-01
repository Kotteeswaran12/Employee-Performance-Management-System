package com.employee_Manager.performance_system.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;

import com.employee_Manager.performance_system.Entity.Attendance;

public interface AttendanceService {

	public Attendance checkIn(String username);

	public Attendance checkOutAndCalculateWorkingHours(String username);

	public Page<Attendance> getAllAttendaceByEmployeeId(String username , int page   , int size);
	
	public  Page<Attendance> filterAttendanceByEndingAndStaringDates(String empName ,LocalDate startingDate , LocalDate endingDate ,int page   , int size);

}
