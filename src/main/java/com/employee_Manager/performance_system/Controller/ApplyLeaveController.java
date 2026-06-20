package com.employee_Manager.performance_system.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee_Manager.performance_system.DtoLayer.ApplyLeaveDTO;
import com.employee_Manager.performance_system.Entity.ApplyLeave;
import com.employee_Manager.performance_system.Enums.LeaveStatus;
import com.employee_Manager.performance_system.Service.LeaveSeriveceIMP;

import com.employee_Manager.performance_systemDTOMapper.DTOMapper;

@RestController
@RequestMapping("api/leave")
public class ApplyLeaveController {

	private final LeaveSeriveceIMP leaveSerivece;

	public ApplyLeaveController(LeaveSeriveceIMP leaveSerivece) {
		super();
		this.leaveSerivece = leaveSerivece;
	}

	@GetMapping("/get-all/{id}")
	public ResponseEntity<List<ApplyLeaveDTO>> getAllEmployeeLeavesByEmpId(@PathVariable Integer id) {

		List<ApplyLeave> leaves = leaveSerivece.getAllEmployeeLeavesByEmpId(id);

		List<ApplyLeaveDTO> dtoLeave = new ArrayList<>();

		for (ApplyLeave a : leaves) {

			dtoLeave.add(DTOMapper.toApplyLeaveDto(a));
		}

		return new ResponseEntity<>(dtoLeave, HttpStatus.OK);
	}

	@PostMapping("/apply-leave/{id}")
	ResponseEntity<ApplyLeaveDTO> applyForLeave(@RequestBody ApplyLeave leave, @PathVariable Integer id) {
		return new ResponseEntity<>(DTOMapper.toApplyLeaveDto(leaveSerivece.applyForLeave(leave, id)),
				HttpStatus.CREATED);
	}

	@DeleteMapping("/delete-by/{id}")
	ResponseEntity<String> withDrawlLeaveById(@PathVariable Integer id) {

		leaveSerivece.withDrawlLeaveById(id);
		return new ResponseEntity<>("Sucessfully Withdrawed your Leave !!", HttpStatus.OK);
	}

	@GetMapping("/get-status/{id}")
	ResponseEntity<LeaveStatus> getLeaveStatusById(@PathVariable Integer id) {
		return new ResponseEntity<>(leaveSerivece.getLeaveStatusById(id), HttpStatus.OK);
	}

	@PostMapping("/update-status")
	ResponseEntity<ApplyLeaveDTO> setLeaveStatus(@RequestParam Integer id, @RequestParam LeaveStatus leaveStatus,
			@RequestParam Integer aprovedId) {
		return new ResponseEntity<>(DTOMapper.toApplyLeaveDto(leaveSerivece.setLeaveStatus(id, leaveStatus, aprovedId)),
				HttpStatus.OK);
	}
}
