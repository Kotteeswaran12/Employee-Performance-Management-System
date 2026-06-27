package com.employee_Manager.performance_system.RequestDTO;

public class DepartmentRequestDTO {

	private String dept;

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "DepartmentResponseDTO [ dept=" + dept + "]";
	}

}
