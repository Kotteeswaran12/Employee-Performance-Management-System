package com.employee_Manager.performance_system.RequestDTO;

import java.time.LocalDate;

import com.employee_Manager.performance_system.Entity.Employees;
import com.employee_Manager.performance_system.Entity.Task;
import com.employee_Manager.performance_system.Enums.AssignmentStatus;

public class TaskAssignmentsRequestDTO {

	

	private LocalDate assignedDate;
	private LocalDate dueDate;
	private LocalDate completedDate;
	
	



	public LocalDate getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(LocalDate assignedDate) {
		this.assignedDate = assignedDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public LocalDate getCompletedDate() {
		return completedDate;
	}

	public void setCompletedDate(LocalDate completedDate) {
		this.completedDate = completedDate;
	}


	@Override
	public String toString() {
		return "TaskAssignmentsDTO [assignedDate=" + assignedDate + ", dueDate="
				+ dueDate + ", completedDate=" + completedDate +"]";
	}

}
