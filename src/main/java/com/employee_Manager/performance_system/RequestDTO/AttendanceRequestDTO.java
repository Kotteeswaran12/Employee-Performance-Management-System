package com.employee_Manager.performance_system.RequestDTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class AttendanceRequestDTO {

	private LocalDate attendanceDate;
	private LocalTime checkIn;
	private LocalTime checkOut;
	private Double WorkingHours;

	private String employeName;

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
		return "AttendanceDTO [ attendanceDate=" + attendanceDate + ", checkIn=" + checkIn + ", checkOut=" + checkOut
				+ ", WorkingHours=" + WorkingHours + ", employeName=" + employeName + "]";
	}

}
