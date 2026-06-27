package com.employee_Manager.performance_system.RequestDTO;

import java.time.LocalDate;

public class EmployeeRequestDTO {

	private String empcode;
	private String firstname;
	private String lastname;
	private String designation;
	private LocalDate dob;
	private Long phone;
	private String gender;
	private String address;
	private Integer sal;

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getSal() {
		return sal;
	}

	public void setSal(Integer sal) {
		this.sal = sal;
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

	@Override
	public String toString() {
		return "EmployeeRequestDTO [empcode=" + empcode + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", designation=" + designation + ", dob=" + dob + ", phone=" + phone + ", gender=" + gender
				+ ", address=" + address + ", sal=" + sal + "]";
	}

}
