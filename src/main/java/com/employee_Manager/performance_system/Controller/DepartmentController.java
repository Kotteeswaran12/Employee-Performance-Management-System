package com.employee_Manager.performance_system.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee_Manager.performance_system.DtoLayer.DepartmentResponseDTO;
import com.employee_Manager.performance_system.Entity.Departments;
import com.employee_Manager.performance_system.Service.DepartmentService;
import com.employee_Manager.performance_systemDTOMapper.DTOMapper;


@RestController
@RequestMapping("/api/")
public class DepartmentController {

	@Autowired
	private DepartmentService deptService;

	@PostMapping("admin/department/add")
	public ResponseEntity<DepartmentResponseDTO> addDepartment(@RequestBody Departments dept) {
		
		return new ResponseEntity<>(
				
				DTOMapper.toDepartmentDto(deptService.addDepartments(dept))
				, HttpStatus.CREATED);
	}

	@DeleteMapping("admin/department/deleteBy/{id}")
	public ResponseEntity<DepartmentResponseDTO> deleteDepartment(@PathVariable Integer id) {
		deptService.deleteDeptById(id);

		return ResponseEntity.noContent().build();
	}

	@GetMapping("admin/department/getall")
	public ResponseEntity<List<DepartmentResponseDTO>> getAllDepartment() {
		
		List<Departments> dept = deptService.getAllDepartments() ;
		
		List<DepartmentResponseDTO> dto = new ArrayList<>();
		
		for(Departments d : dept) {
			dto.add(DTOMapper.toDepartmentDto(d));
		}

		return new ResponseEntity<>(dto
				, HttpStatus.OK);
	}

	@GetMapping("department/getBy/{id}")
	public ResponseEntity<DepartmentResponseDTO> getDepartmentById(@PathVariable Integer id) {
		return new ResponseEntity<>(
				DTOMapper.toDepartmentDto(deptService.getDeprtById(id))
				, HttpStatus.OK);
	}
}
