package com.employee_Manager.performance_system.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.employee_Manager.performance_system.Entity.Attendance;
import com.employee_Manager.performance_system.Entity.Employees;
import com.employee_Manager.performance_system.Exceptions.AttendanceException;
import com.employee_Manager.performance_system.Exceptions.EmployeeNotFoundException;
import com.employee_Manager.performance_system.Repository.AttendanceRepository;
import com.employee_Manager.performance_system.Repository.EmployeeRepository;

@Service
public class AttendanceServiceIMP implements AttendanceService {

	private final AttendanceRepository attendanceRepository;

	private final EmployeeRepository employeeRepository;

	public AttendanceServiceIMP(AttendanceRepository attendanceRepository, EmployeeRepository employeeRepository) {
		super();
		this.attendanceRepository = attendanceRepository;
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Attendance checkIn(Integer empId) {

		Employees emp = employeeRepository.findById(empId)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not Found for ID :" + empId));

		Attendance attendance = attendanceRepository.findByEmployeesIdAndAttendanceDate(empId, LocalDate.now())
				.orElse(new Attendance());

		if (attendance.getCheckIn() != null) {
			throw new AttendanceException("you have Already CHECK-IN !!");
		}

		attendance.setAttendanceDate(LocalDate.now());

		attendance.setEmployees(emp);
		emp.getAttendances().add(attendance);

		attendance.setCheckIn(LocalTime.now());

		return attendanceRepository.save(attendance);
	}

	@Override
	public Attendance checkOutAndCalculateWorkingHours(Integer empId) {

		Attendance attendance = attendanceRepository.findByEmployeesIdAndAttendanceDate(empId, LocalDate.now())
				.orElseThrow(() -> new AttendanceException("Try To Check in First and try Check out !!"));

		if (attendance.getCheckOut() != null) {
			throw new AttendanceException("You have Already CeckOut for Today Try tomorrow !!");
		}

		attendance.setCheckOut(LocalTime.now());

		Duration duration = Duration.between(attendance.getCheckIn(), attendance.getCheckOut());

		attendance.setWorkingHours(duration.toMinutes() / 60.0);

		return attendanceRepository.save(attendance);
	}

	@Override
	public List<Attendance> getAllAttendaceByEmployeeId(Integer empId) {
		// TODO Auto-generated method stub

		List<Attendance> attendances = attendanceRepository.findByEmployeesId(empId);

		if (attendances == null) {
			throw new AttendanceException("No Attendace Found !!");
		}
		return attendances;
	}

}
