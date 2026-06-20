package com.employee_Manager.performance_system.Entity;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Attendance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer attendance_id;

	private LocalDate attendanceDate;
	private LocalTime checkIn;
	private LocalTime checkOut;
	private Double WorkingHours;

	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Employees employees;

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

	public Employees getEmployees() {
		return employees;
	}

	public void setEmployees(Employees employees) {
		this.employees = employees;
	}

	public Attendance() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Attendance [attendance_id=" + attendance_id + ", attendanceDate=" + attendanceDate + ", checkIn="
				+ checkIn + ", checkOut=" + checkOut + ", WorkingHours=" + WorkingHours + "]";
	}

}
