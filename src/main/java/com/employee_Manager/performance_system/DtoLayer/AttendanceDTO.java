package com.employee_Manager.performance_system.DtoLayer;

import java.time.LocalDate;
import java.time.LocalTime;


public class AttendanceDTO {

	private Integer attendance_id;

	private LocalDate attendanceDate;
	private LocalTime checkIn;
	private LocalTime checkOut;
	private Double WorkingHours;

	private String employeName;

	public Integer getAttendance_id() {
		return attendance_id;
	}

	public void setAttendance_id(Integer attendance_id) {
		this.attendance_id = attendance_id;
	}

	public LocalDate getAttendanceDate() {
		return attendanceDate;
	}

	public void setAttendanceDate(LocalDate attendanceDate) {
		this.attendanceDate = attendanceDate;
	}

	public LocalTime getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(LocalTime checkIn) {
		this.checkIn = checkIn;
	}

	public LocalTime getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(LocalTime checkOut) {
		this.checkOut = checkOut;
	}

	public Double getWorkingHours() {
		return WorkingHours;
	}

	public void setWorkingHours(Double workingHours) {
		WorkingHours = workingHours;
	}

	public String getEmployeName() {
		return employeName;
	}

	public void setEmployeName(String employeName) {
		this.employeName = employeName;
	}

	@Override
	public String toString() {
		return "AttendanceDTO [attendance_id=" + attendance_id + ", attendanceDate=" + attendanceDate + ", checkIn="
				+ checkIn + ", checkOut=" + checkOut + ", WorkingHours=" + WorkingHours + ", employeName=" + employeName
				+ "]";
	}

}
