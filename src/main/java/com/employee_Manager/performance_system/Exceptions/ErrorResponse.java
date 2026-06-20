package com.employee_Manager.performance_system.Exceptions;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ErrorResponse {

	private String message;
	private int status;
	private LocalDateTime timestamp;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "ErrorResponse [message=" + message + ", status=" + status + ", timestamp=" + timestamp + "]";
	}

}
