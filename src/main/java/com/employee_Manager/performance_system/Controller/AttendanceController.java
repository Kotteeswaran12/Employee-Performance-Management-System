package com.employee_Manager.performance_system.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee_Manager.performance_system.DTOMapper.DTOMapper;
import com.employee_Manager.performance_system.Entity.Attendance;
import com.employee_Manager.performance_system.ResponseDtoLayer.AttendanceDTO;
import com.employee_Manager.performance_system.Service.AttendanceService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/")
public class AttendanceController {

	private final AttendanceService attendanceService;

	public AttendanceController(AttendanceService attendanceService) {
		super();
		this.attendanceService = attendanceService;
	}

	@Tag(name = "Employee - ONLY Access")
	@Operation(summary = "Employee can Check - In for a Work", description = "Employee can Only Check-IN only once in a Day !!")
	@PreAuthorize("hasRole('EMPLOYEE')")
	@PostMapping("attendance/check-in")
	public ResponseEntity<AttendanceDTO> checkIn(Authentication authentication) {

//		System.out.println("Hello");

		return new ResponseEntity<>(DTOMapper.toAttendaceDTO(attendanceService.checkIn(authentication.getName())),
				HttpStatus.OK);

	}

	@Tag(name = "Employee - ONLY Access")
	@Operation(summary = "Employee can Check - Out at End of the Day", description = "Employee can Only Check-OUT only once in a Day !!")
	@PreAuthorize("hasRole('EMPLOYEE')")
	@PostMapping("attendance/check-out")
	public ResponseEntity<AttendanceDTO> checkOut(Authentication authentication) {

		return new ResponseEntity<>(
				DTOMapper.toAttendaceDTO(attendanceService.checkOutAndCalculateWorkingHours(authentication.getName())),
				HttpStatus.OK);

	}

	@Tag(name = "Employee - ONLY Access")
	@Operation(summary = "Employee can get all the Attendance Details", description = "Employee can See the Working Hours and Ddeatils of they Attendance !!")
	@PreAuthorize("hasRole('EMPLOYEE')")
	@GetMapping("attendance/")
	public ResponseEntity<List<AttendanceDTO>> getAllAttendaceByEmployeeId(Authentication authentication) {

		System.out.println("Hello");

		List<Attendance> att = attendanceService.getAllAttendaceByEmployeeId(authentication.getName());

		List<AttendanceDTO> attenDto = new ArrayList<>();

		for (Attendance a : att) {

			attenDto.add(DTOMapper.toAttendaceDTO(a));

		}

		return new ResponseEntity<>(attenDto, HttpStatus.OK);

	}
}
