package com.employee_Manager.performance_system.Service;

import java.util.List;

import com.employee_Manager.performance_system.Entity.Attendance;

public interface AttendanceService {

	public Attendance checkIn(String username);

	public Attendance checkOutAndCalculateWorkingHours(String username);

	public List<Attendance> getAllAttendaceByEmployeeId(String username);

}
