package com.employee_Manager.performance_system.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee_Manager.performance_system.DtoLayer.AttendanceDTO;
import com.employee_Manager.performance_system.Entity.Attendance;
import com.employee_Manager.performance_system.Service.AttendanceService;
import com.employee_Manager.performance_system.Service.AttendanceServiceIMP;

import com.employee_Manager.performance_systemDTOMapper.DTOMapper;

@RestController
@RequestMapping("/api/")
public class AttendanceController {

	private final AttendanceService attendanceService;

	public AttendanceController(AttendanceService attendanceService) {
		super();
		this.attendanceService = attendanceService;
	}

	@PostMapping("employee/attendance/check-in/")
	public ResponseEntity<AttendanceDTO> checkIn(Authentication authentication) {
		
		

		return new ResponseEntity<>(DTOMapper.toAttendaceDTO(attendanceService.checkIn(authentication.getName())), HttpStatus.OK);

	}

	@PostMapping("employee/attendance/check-out/")
	public ResponseEntity<AttendanceDTO> checkOut(Authentication authentication) {

		return new ResponseEntity<>(DTOMapper.toAttendaceDTO(attendanceService.checkOutAndCalculateWorkingHours(authentication.getName())), HttpStatus.OK);

	}

	@GetMapping("employee/attendance/get-allBy/")
	public ResponseEntity<List<AttendanceDTO>> getAllAttendaceByEmployeeId(Authentication authentication) {
		
		List<Attendance> att = attendanceService.getAllAttendaceByEmployeeId(authentication.getName()) ;
		
		List<AttendanceDTO> attenDto = new ArrayList<>();
		
		for(Attendance a : att) {
			
			attenDto.add(DTOMapper.toAttendaceDTO(a));
			
		}

		return new ResponseEntity<>(attenDto, HttpStatus.OK);

	}
}
