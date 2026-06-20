package com.employee_Manager.performance_system.Service;

import java.util.List;

import com.employee_Manager.performance_system.Entity.Attendance;

public interface AttendanceService {

	public Attendance checkIn(Integer empId);

	public Attendance checkOutAndCalculateWorkingHours(Integer empId);

	public List<Attendance> getAllAttendaceByEmployeeId(Integer empId);

}
