package com.employee_Manager.performance_system.Entity;

import java.time.LocalDate;
import com.employee_Manager.performance_system.Enums.LeaveStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ApplyLeave {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String reason;
	@Enumerated(EnumType.STRING)
	private LeaveStatus status;
	private LocalDate startingDate;
	private LocalDate endingDate;

	@ManyToOne
	@JsonIgnore
	private Employees employees;

	@ManyToOne
	@JoinColumn(name = "aproved_by")
	@JsonIgnore
	private Employees aprovedBy;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public LeaveStatus getStatus() {
		return status;
	}

	public void setStatus(LeaveStatus status) {
		this.status = status;
	}

	public LocalDate getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(LocalDate startingDate) {
		this.startingDate = startingDate;
	}

	public LocalDate getEndingDate() {
		return endingDate;
	}

	public void setEndingDate(LocalDate endingDate) {
		this.endingDate = endingDate;
	}

	public Employees getEmployees() {
		return employees;
	}

	public void setEmployees(Employees employees) {
		this.employees = employees;
	}

	public Employees getAprovedBy() {
		return aprovedBy;
	}

	public void setAprovedBy(Employees aprovedBy) {
		this.aprovedBy = aprovedBy;
	}

	public ApplyLeave() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ApplyLeave [id=" + id + ", reason=" + reason + ", status=" + status + ", starting=" + startingDate
				+ ", ending=" + endingDate + "]";
	}

}
