package com.employee_Manager.performance_system.DtoLayer;

import java.time.LocalDate;

import com.employee_Manager.performance_system.Entity.Employees;
import com.employee_Manager.performance_system.Entity.Task;
import com.employee_Manager.performance_system.Enums.AssignmentStatus;

public class TaskAssignmentsDTO {

	private Integer assignmentId;

	private LocalDate assignedDate;
	private LocalDate dueDate;
	private LocalDate completedDate;
	private AssignmentStatus status;

	private String task;

	private String assignedTo;

	private String assignedBy;

	public Integer getAssignmentId() {
		return assignmentId;
	}

	public void setAssignmentId(Integer assignmentId) {
		this.assignmentId = assignmentId;
	}

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

	public AssignmentStatus getStatus() {
		return status;
	}

	public void setStatus(AssignmentStatus status) {
		this.status = status;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getAssignedBy() {
		return assignedBy;
	}

	public void setAssignedBy(String assignedBy) {
		this.assignedBy = assignedBy;
	}

	@Override
	public String toString() {
		return "TaskAssignmentsDTO [assignmentId=" + assignmentId + ", assignedDate=" + assignedDate + ", dueDate="
				+ dueDate + ", completedDate=" + completedDate + ", status=" + status + ", task=" + task
				+ ", assignedTo=" + assignedTo + ", assignedBy=" + assignedBy + "]";
	}

}
