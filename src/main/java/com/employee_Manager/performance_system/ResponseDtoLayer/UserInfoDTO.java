package com.employee_Manager.performance_system.ResponseDtoLayer;

import java.time.LocalDate;

import com.employee_Manager.performance_system.Enums.RoleTypes;

public class UserInfoDTO {

	private Integer id;

	private String username;

	private String email;
	private String password;
	private LocalDate createdate;

	private RoleTypes role;

	private String employees;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getCreatedate() {
		return createdate;
	}

	public void setCreatedate(LocalDate createdate) {
		this.createdate = createdate;
	}

	public RoleTypes getRole() {
		return role;
	}

	public void setRole(RoleTypes role) {
		this.role = role;
	}

	

	public String getEmployees() {
		return employees;
	}

	public void setEmployees(String employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "UserInfoDTO [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", createdate=" + createdate + ", role=" + role + ", employees=" + employees + "]";
	}

}
