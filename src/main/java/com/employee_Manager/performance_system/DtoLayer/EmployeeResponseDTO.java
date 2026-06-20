package com.employee_Manager.performance_system.DtoLayer;


public class EmployeeResponseDTO {

	private Integer id;
	private String empcode;
	private String firstname;
	private String lastname;
	private String designation;
	private String departmentname;
	private String managername;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmpcode() {
		return empcode;
	}

	public void setEmpcode(String empcode) {
		this.empcode = empcode;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	public String getManagername() {
		return managername;
	}

	public void setManagername(String managername) {
		this.managername = managername;
	}

	@Override
	public String toString() {
		return "EmployeeResponseDTO [id=" + id + ", empcode=" + empcode + ", firstname=" + firstname + ", lastname="
				+ lastname + ", designation=" + designation + ", departmentname=" + departmentname + ", managername="
				+ managername + "]";
	}

}
