package com.employee_Manager.performance_system.Exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandeler {

	@ExceptionHandler({ AttendanceException.class, DepartmentNotFoundException.class, EmployeeManagerException.class,
			EmployeeNotFoundException.class, LeaveNotFoundException.class, NotaManagerException.class,
			TaskAssignmentException.class, TaskException.class, UserNotFoundException.class , RuntimeException.class })
	
	public ResponseEntity<ErrorResponse> handelGlobalException(RuntimeException e) {
		ErrorResponse er = new ErrorResponse();

		er.setMessage(e.getMessage());
		er.setStatus(404);
		er.setTimestamp(LocalDateTime.now());

		return new ResponseEntity<>(er, HttpStatus.NOT_FOUND);

	}
}
