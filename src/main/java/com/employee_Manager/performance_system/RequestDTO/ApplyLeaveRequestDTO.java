package com.employee_Manager.performance_system.RequestDTO;

import java.time.LocalDate;


public class ApplyLeaveRequestDTO {

	private String reason;

	private LocalDate startingDate;
	private LocalDate endingDate;


	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
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



	@Override
	public String toString() {
		return "ApplyLeaveRequestDTO [ reason=" + reason + ", startingDate=" + startingDate + ", endingDate="
				+ endingDate +  "]";
	}

}
