package com.employee_Manager.performance_system.Entity;

import java.time.LocalDate;

import com.employee_Manager.performance_system.Enums.RoleTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;

@Entity
public class UserInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique = true, nullable = false)
	private String username;
	@Email
	@Column(unique = true, nullable = false)
	private String email;
	private String password;
	private LocalDate createdate;

	@Enumerated(EnumType.STRING)
	private RoleTypes role;

	@OneToOne(mappedBy = "user")
	private Employees employees;

	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoleTypes getRole() {
		return role;
	}

	public void setRole(RoleTypes role) {
		this.role = role;
	}

	public Employees getEmployees() {
		return employees;
	}

	public void setEmployees(Employees employees) {
		this.employees = employees;
	}

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

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", createdate=" + createdate + ", role=" + role + "]";
	}

}
