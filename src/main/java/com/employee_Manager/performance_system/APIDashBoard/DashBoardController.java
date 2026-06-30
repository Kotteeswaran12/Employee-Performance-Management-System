package com.employee_Manager.performance_system.APIDashBoard;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/api/")
@Tag(name = "Dashboard API's")
public class DashBoardController {

	private final DashBoardService boardService;
	

	
	
	public DashBoardController(DashBoardService boardService) {
		super();
		this.boardService = boardService;
	
	}

	@GetMapping("/admin/dash-board")
	public ResponseEntity<AdminDashBoard> getAdminDashBoard(Authentication authentication){
		
		
		return new ResponseEntity<>(boardService.AdminDahBoardDetails() , HttpStatus.OK);
		
	}
	
	@GetMapping("/manager/dash-board")
	public ResponseEntity<ManagerDashBoard> getManagerDashBoard(Authentication authentication){
		
	
		return new ResponseEntity<>(boardService.getAllManagerDashBoardDetails(authentication.getName()) , HttpStatus.OK);
		
	}
	
	@GetMapping("/employee/dash-board")
	public ResponseEntity<EmployeeDashBoard> getEmployeeDashBoard(Authentication authentication){
		
		
		
		return new ResponseEntity<>(boardService.getAllEmployeeDashBoardDetails(authentication.getName()) , HttpStatus.OK);
		
	}
	
	
	
	
	
	
	
	
	
}
