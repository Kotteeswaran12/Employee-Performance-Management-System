package com.employee_Manager.performance_system.DtoLayer;

public class DepartmentResponseDTO {

	private Integer id;
	private String dept;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "DepartmentResponseDTO [id=" + id + ", dept=" + dept + "]";
	}

}
