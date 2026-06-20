package com.employee_Manager.performance_system.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee_Manager.performance_system.DtoLayer.AttendanceDTO;
import com.employee_Manager.performance_system.Entity.Attendance;
import com.employee_Manager.performance_system.Service.AttendanceServiceIMP;

import com.employee_Manager.performance_systemDTOMapper.DTOMapper;

@RestController
@RequestMapping("/api/attendace")
public class AttendanceController {

	private final AttendanceServiceIMP attendanceService;

	public AttendanceController(AttendanceServiceIMP attendanceService) {
		super();
		this.attendanceService = attendanceService;
	}

	@PostMapping("/check-in/{empId}")
	public ResponseEntity<AttendanceDTO> checkIn(@PathVariable Integer empId) {

		return new ResponseEntity<>(DTOMapper.toAttendaceDTO(attendanceService.checkIn(empId)), HttpStatus.OK);

	}

	@PostMapping("/check-out/{empId}")
	public ResponseEntity<AttendanceDTO> checkOut(@PathVariable Integer empId) {

		return new ResponseEntity<>(DTOMapper.toAttendaceDTO(attendanceService.checkOutAndCalculateWorkingHours(empId)), HttpStatus.OK);

	}

	@GetMapping("/get-allBy/{empId}")
	public ResponseEntity<List<AttendanceDTO>> getAllAttendaceByEmployeeId(@PathVariable Integer empId) {
		
		List<Attendance> att = attendanceService.getAllAttendaceByEmployeeId(empId) ;
		
		List<AttendanceDTO> attenDto = new ArrayList<>();
		
		for(Attendance a : att) {
			
			attenDto.add(DTOMapper.toAttendaceDTO(a));
			
		}

		return new ResponseEntity<>(attenDto, HttpStatus.OK);

	}
}
