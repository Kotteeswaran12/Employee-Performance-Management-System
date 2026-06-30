package com.employee_Manager.performance_system.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee_Manager.performance_system.DTOMapper.DTOMapper;
import com.employee_Manager.performance_system.DTOMapper.RequestDTOMapper;
import com.employee_Manager.performance_system.Entity.Departments;
import com.employee_Manager.performance_system.RequestDTO.DepartmentRequestDTO;
import com.employee_Manager.performance_system.ResponseDtoLayer.DepartmentResponseDTO;
import com.employee_Manager.performance_system.Service.DepartmentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/api/")
public class DepartmentController {

	
	private final DepartmentService deptService;
	private final RequestDTOMapper dtoMapper ;
	
	

	public DepartmentController(DepartmentService deptService, RequestDTOMapper dtoMapper) {
		super();
		this.deptService = deptService;
		this.dtoMapper = dtoMapper;
	}

	@Tag(name = "ADMIN - ONLY Access")
	@Operation(summary = "Admin can Add Department" , description = "BY passing the Department Details in Body  !!")
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("department")
	public ResponseEntity<DepartmentResponseDTO> addDepartment(@RequestBody DepartmentRequestDTO dept) {
		
		return new ResponseEntity<>(
				
				DTOMapper.toDepartmentDto(deptService.addDepartments(dtoMapper.toDepartmentEntity(dept)))
				, HttpStatus.CREATED);
	}
	
	

	@Tag(name = "ADMIN - ONLY Access")
	@Operation(summary = "Admin can Delete the Department" , description = "by Passing the Department ID !!")
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("department/{id}")
	public ResponseEntity<DepartmentResponseDTO> deleteDepartment(@PathVariable Integer id) {
		deptService.deleteDeptById(id);

		return ResponseEntity.noContent().build();
	}

	
	@Tag(name = "ADMIN - ONLY Access")
	@Operation(summary = "Admin can Get all The Department")
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("department")
	public ResponseEntity<List<DepartmentResponseDTO>> getAllDepartment() {
		
		List<Departments> dept = deptService.getAllDepartments() ;
		
		List<DepartmentResponseDTO> dto = new ArrayList<>();
		
		for(Departments d : dept) {
			dto.add(DTOMapper.toDepartmentDto(d));
		}

		return new ResponseEntity<>(dto
				, HttpStatus.OK);
	}

	
	@Tag(name = "General APIs")
	@Operation(summary = "Get Department by Department ID" )
	@GetMapping("department/{id}")
	public ResponseEntity<DepartmentResponseDTO> getDepartmentById(@PathVariable Integer id) {
		return new ResponseEntity<>(
				DTOMapper.toDepartmentDto(deptService.getDeprtById(id))
				, HttpStatus.OK);
	}
}
