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
import org.springframework.web.bind.annotation.RestController;

import com.employee_Manager.performance_system.DtoLayer.EmployeeResponseDTO;
import com.employee_Manager.performance_system.Entity.Employees;
import com.employee_Manager.performance_system.Service.EmployeeServiceIMP;
import com.employee_Manager.performance_systemDTOMapper.DTOMapper;


@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	private final EmployeeServiceIMP employeeService;

	public EmployeeController(EmployeeServiceIMP employeeService) {
		super();
		this.employeeService = employeeService;
	}

//	Access by Manager
	@GetMapping("/get-all")
	public ResponseEntity<List<EmployeeResponseDTO>> getAllEmployees() {

		List<Employees> employees = employeeService.getAllEmployees();

		List<EmployeeResponseDTO> dtos = new ArrayList<>();

		for (Employees e : employees) {


			dtos.add(DTOMapper.toEmployeeDto(e));

		}

		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}

//	Access only by ADMIN
	@PostMapping("/add-toDept/{deptId}")
	public ResponseEntity<EmployeeResponseDTO> addEmployees(@RequestBody Employees emp, @PathVariable Integer deptId) {

		Employees e = employeeService.addEmployees(emp, deptId);

		

		return new ResponseEntity<>(DTOMapper.toEmployeeDto(e), HttpStatus.CREATED);
	}

//	Access only by ADMIN
	@DeleteMapping("/deleteBy/{id}")
	public ResponseEntity<EmployeeResponseDTO> deleteEmployeeById(@PathVariable Integer id) {

		Employees e = employeeService.deleteEmployeeById(id);


		return new ResponseEntity<>(DTOMapper.toEmployeeDto(e), HttpStatus.CREATED);
	}

	@GetMapping("/getBy/{id}")
	public ResponseEntity<EmployeeResponseDTO> getEmployeeById(@PathVariable Integer id) {
		
		Employees e = employeeService.getEmployeeById(id) ;

		

		return new ResponseEntity<>(DTOMapper.toEmployeeDto(e), HttpStatus.OK);
	}

//	Access only by Manager
	@PostMapping("/add-empByManager/{managerID}")
	public ResponseEntity<EmployeeResponseDTO> addEmployeeAndAssigntoManager(@RequestBody Employees emp,
			@PathVariable Integer managerID) {

		Employees e = employeeService.addEmployeeAndAssigntoManager(emp, managerID);
		
		
		return new ResponseEntity<>( DTOMapper.toEmployeeDto(e) ,

				HttpStatus.CREATED);
	}

}
