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

@RestController
@RequestMapping("/api/")
public class AttendanceController {

	private final AttendanceService attendanceService;

	public AttendanceController(AttendanceService attendanceService) {
		super();
		this.attendanceService = attendanceService;
	}

	@PreAuthorize("hasRole('EMPLOYEE')")
	@PostMapping("attendance/check-in")
	public ResponseEntity<AttendanceDTO> checkIn(Authentication authentication) {
		
//		System.out.println("Hello");

		return new ResponseEntity<>(DTOMapper.toAttendaceDTO(attendanceService.checkIn(authentication.getName())), HttpStatus.OK);

	}

	
	@PreAuthorize("hasRole('EMPLOYEE')")
	@PostMapping("attendance/check-out")
	public ResponseEntity<AttendanceDTO> checkOut(Authentication authentication) {

		return new ResponseEntity<>(DTOMapper.toAttendaceDTO(attendanceService.checkOutAndCalculateWorkingHours(authentication.getName())), HttpStatus.OK);

	}
	@PreAuthorize("hasRole('EMPLOYEE')")
	@GetMapping("attendance/")
	public ResponseEntity<List<AttendanceDTO>> getAllAttendaceByEmployeeId(Authentication authentication) {
		
		System.out.println("Hello");
		
		List<Attendance> att = attendanceService.getAllAttendaceByEmployeeId(authentication.getName()) ;
		
		List<AttendanceDTO> attenDto = new ArrayList<>();
		
		for(Attendance a : att) {
			
			attenDto.add(DTOMapper.toAttendaceDTO(a));
			
		}

		return new ResponseEntity<>(attenDto, HttpStatus.OK);

	}
}
