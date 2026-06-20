package com.employee_Manager.performance_system.DtoLayer;

import java.time.LocalDate;

import com.employee_Manager.performance_system.Enums.LeaveStatus;

public class ApplyLeaveDTO {

	private Integer id;

	private String reason;

	private LeaveStatus status;
	private LocalDate startingDate;
	private LocalDate endingDate;

	private String employeName;

	private String managerName;

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

	public String getEmployeName() {
		return employeName;
	}

	public void setEmployeName(String employeName) {
		this.employeName = employeName;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	@Override
	public String toString() {
		return "ApplyLeaveDTO [id=" + id + ", reason=" + reason + ", status=" + status + ", startingDate="
				+ startingDate + ", endingDate=" + endingDate + ", employeName=" + employeName + ", managerName="
				+ managerName + "]";
	}

}
