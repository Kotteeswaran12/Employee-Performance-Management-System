package com.employee_Manager.performance_system.RequestDTO;

import java.time.LocalDate;

import com.employee_Manager.performance_system.Entity.Employees;


public class TaskRequestDTO {

	private String title;
	private String description;
	private String estimatedHours;
	


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

	

	@Override
	public String toString() {
		return "TaskDTO [ title=" + title + ", description=" + description + ", estimatedHours="
				+ estimatedHours +  "]";
	}

}
