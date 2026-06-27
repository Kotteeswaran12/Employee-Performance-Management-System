package com.employee_Manager.performance_system.RequestDTO;

import java.time.LocalDate;

import com.employee_Manager.performance_system.Enums.RoleTypes;

public class UserInfoRequestDTO {



	private String email;
	private String password;
	

	

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


	@Override
	public String toString() {
		return "UserInfoDTO [ email=" + email + ", password=" + password
				+ "]";
	}

}
