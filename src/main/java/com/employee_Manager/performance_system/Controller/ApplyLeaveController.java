package com.employee_Manager.performance_system.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee_Manager.performance_system.DTOMapper.DTOMapper;
import com.employee_Manager.performance_system.DTOMapper.RequestDTOMapper;
import com.employee_Manager.performance_system.Entity.ApplyLeave;
import com.employee_Manager.performance_system.Enums.LeaveStatus;
import com.employee_Manager.performance_system.RequestDTO.ApplyLeaveRequestDTO;
import com.employee_Manager.performance_system.ResponseDtoLayer.ApplyLeaveDTO;
import com.employee_Manager.performance_system.Service.LeaveSerivece;


@RestController
@RequestMapping("/api/")
public class ApplyLeaveController {

	private final LeaveSerivece leaveSerivece;
	private final RequestDTOMapper requestdtoMapper;

	
	
public ApplyLeaveController(LeaveSerivece leaveSerivece, RequestDTOMapper requestdtoMapper) {
		super();
		this.leaveSerivece = leaveSerivece;
		this.requestdtoMapper = requestdtoMapper;
	}


//	Manager Functions
	
	@PreAuthorize("hasRole('MANAGER')")
	@GetMapping("/leave")
	public ResponseEntity<List<ApplyLeaveDTO>> getAllEmployeeLeavesByEmpId(@RequestParam Integer id) {

		List<ApplyLeave> leaves = leaveSerivece.getAllEmployeeLeavesByEmpId(id);

		List<ApplyLeaveDTO> dtoLeave = new ArrayList<>();

		for (ApplyLeave a : leaves) {

			dtoLeave.add(DTOMapper.toApplyLeaveDto(a));
		}

		return new ResponseEntity<>(dtoLeave, HttpStatus.OK);
	}
	
	
	@PreAuthorize("hasRole('MANAGER')")
	@PostMapping("/leave")
	ResponseEntity<ApplyLeaveDTO> setLeaveStatus(@RequestParam Integer id, @RequestParam LeaveStatus leaveStatus,
			@RequestParam Integer aprovedId) {
		return new ResponseEntity<>(DTOMapper.toApplyLeaveDto(leaveSerivece.setLeaveStatus(id, leaveStatus, aprovedId)),
				HttpStatus.OK);
	}
	
	
//	Employee Functions

	@PreAuthorize("hasRole('EMPLOYEE')")
	@PostMapping("/leave/apply")
	ResponseEntity<ApplyLeaveDTO> applyForLeave(@RequestBody ApplyLeaveRequestDTO leave, Authentication authentication) {
		
		String username = authentication.getName();
		
//		System.out.println(authentication.getDetails() + "\t\t");
		
		return new ResponseEntity<>(DTOMapper.toApplyLeaveDto(leaveSerivece.applyForLeave(requestdtoMapper.toApplyLeaveEntity(leave), username)),
				HttpStatus.CREATED);
	}

	@PreAuthorize("hasRole('EMPLOYEE')")
	@DeleteMapping("/leave/{id}")
	ResponseEntity<String> withDrawlLeaveById(@PathVariable Integer id) {

		leaveSerivece.withDrawlLeaveById(id);
		return new ResponseEntity<>("Sucessfully Withdrawed your Leave !!", HttpStatus.OK);
	}

	@PreAuthorize("hasRole('EMPLOYEE')")
	@GetMapping("/leave/{id}")
	ResponseEntity<LeaveStatus> getLeaveStatusById(@PathVariable Integer id) {
		return new ResponseEntity<>(leaveSerivece.getLeaveStatusById(id), HttpStatus.OK);
	}

	
}
