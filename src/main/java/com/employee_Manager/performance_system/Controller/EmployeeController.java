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
import org.springframework.web.bind.annotation.RestController;

import com.employee_Manager.performance_system.DTOMapper.DTOMapper;
import com.employee_Manager.performance_system.DTOMapper.RequestDTOMapper;
import com.employee_Manager.performance_system.Entity.Employees;
import com.employee_Manager.performance_system.RequestDTO.EmployeeRequestDTO;
import com.employee_Manager.performance_system.ResponseDtoLayer.EmployeeResponseDTO;
import com.employee_Manager.performance_system.Service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/")
public class EmployeeController {

	private final EmployeeService employeeService;
	private final RequestDTOMapper requestDTOMapper;

	public EmployeeController(EmployeeService employeeService, RequestDTOMapper requestDTOMapper) {
		super();
		this.employeeService = employeeService;
		this.requestDTOMapper = requestDTOMapper;
	}

//	Access by Manager
	
	@Tag(name = "Manager - ONLY Access")
	@Operation(
			summary = "Get All Employees - Manager",
			description = "Get all the Employee by Manager Referance "
			)
	@PreAuthorize("hasRole('MANAGER')")
	@GetMapping("employee")
	public ResponseEntity<List<EmployeeResponseDTO>> getAllEmployees(Authentication authentication) {

		List<Employees> employees = employeeService.getAllEmployees(authentication.getName());

		List<EmployeeResponseDTO> dtos = new ArrayList<>();

		for (Employees e : employees) {

			dtos.add(DTOMapper.toEmployeeDto(e));

		}

		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}

	
	
	
//	Access only by ADMIN
	@Tag(name = "ADMIN - ONLY Access")
	@Operation(
			summary = "Add Manager "
			, description = "to a Department by using Department ID"
			)
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("employee/manager/{deptId}")
	public ResponseEntity<EmployeeResponseDTO> addEmployees(@RequestBody EmployeeRequestDTO emp,
			@PathVariable Integer deptId) {

//		emp.setEmpcode("EMP);

		Employees e = employeeService.addEmployees(requestDTOMapper.toEmployeeEntity(emp), deptId);

		return new ResponseEntity<>(DTOMapper.toEmployeeDto(e), HttpStatus.CREATED);
	}

	
	
	
//	Access only by ADMIN
	@Tag(name = "ADMIN - ONLY Access")
	@Operation(
			summary = "Delete any Employee "
			, description = "By usind Employee ID"
			)
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("employee/{id}")
	public ResponseEntity<EmployeeResponseDTO> deleteEmployeeById(@PathVariable Integer id) {

		Employees e = employeeService.deleteEmployeeById(id);

		return new ResponseEntity<>(DTOMapper.toEmployeeDto(e), HttpStatus.CREATED);
	}
	
	
	
	
	
	
//	@Tag(name = "ADMIN - ONLY Access")
	@Tag(name = "General APIs")
	@Operation(
			summary = "Get all Details of Employee "
			, description = "By usind Employee Name Pass throught the JWT Token !!"
			)
	@GetMapping("/employee/by-UserName")
	public ResponseEntity<EmployeeResponseDTO> getEmployeeById(Authentication authentication ) {

		Employees e = employeeService.getEmployeByFirstName(authentication.getName());

		return new ResponseEntity<>(DTOMapper.toEmployeeDto(e), HttpStatus.OK);
	}

	
	
	
	
	
	
	
//	Access only by Manager
	 
	@Tag(name = "Manager - ONLY Access")
	@Operation(
			summary = "Add Employee to the Manager Department "
			, description = "Pass the Employees Details in Body "
			)
	@PreAuthorize("hasRole('MANAGER')")
	@PostMapping("employee")
	public ResponseEntity<EmployeeResponseDTO> addEmployeeAndAssigntoManager(@RequestBody EmployeeRequestDTO emp,
			Authentication authentication) {

		System.out.println("HI");
		Employees e = employeeService.addEmployeeAndAssigntoManager(requestDTOMapper.toEmployeeEntity(emp), authentication.getName());

		return new ResponseEntity<>(DTOMapper.toEmployeeDto(e),

				HttpStatus.CREATED);
	}

}
