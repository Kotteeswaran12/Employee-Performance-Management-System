package com.employee_Manager.performance_system.ResponseDtoLayer;

import java.time.LocalDate;

import com.employee_Manager.performance_system.Entity.Employees;


public class TaskDTO {

	private Integer id;
	private String title;
	private String description;
	private String estimatedHours;
	private String createdBy;
	private LocalDate createdDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEstimatedHours() {
		return estimatedHours;
	}

	public void setEstimatedHours(String estimatedHours) {
		this.estimatedHours = estimatedHours;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "TaskDTO [id=" + id + ", title=" + title + ", description=" + description + ", estimatedHours="
				+ estimatedHours + ", createdBy=" + createdBy + ", createdDate=" + createdDate + "]";
	}

}
