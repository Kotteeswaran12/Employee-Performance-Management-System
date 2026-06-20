package com.employee_Manager.performance_system.Entity;

import java.time.LocalDate;

import com.employee_Manager.performance_system.Enums.AssignmentStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

@Entity
public class TaskAssignments {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer assignmentId;

	private LocalDate assignedDate;
	private LocalDate dueDate;
	private LocalDate completedDate;
	@Enumerated(EnumType.STRING)
	private AssignmentStatus status;

	@ManyToOne
	private Task task;

	@ManyToOne
	private Employees assignedTo;
	@ManyToOne
	private Employees assignedBy;

	public TaskAssignments() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Employees getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(Employees assignedTo) {
		this.assignedTo = assignedTo;
	}

	public Employees getAssignedBy() {
		return assignedBy;
	}

	public void setAssignedBy(Employees assignedBy) {
		this.assignedBy = assignedBy;
	}

	@Override
	public String toString() {
		return "TaskAssignments [assignmentId=" + assignmentId + ", assignedDate=" + assignedDate + ", dueDate="
				+ dueDate + ", completedDate=" + completedDate + ", status=" + status + "]";
	}
	
	@PrePersist
	public void prePersist() {
		assignedDate = LocalDate.now();
	}

}
