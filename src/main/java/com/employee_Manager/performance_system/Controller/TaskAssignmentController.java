package com.employee_Manager.performance_system.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee_Manager.performance_system.DTOMapper.DTOMapper;
import com.employee_Manager.performance_system.Entity.TaskAssignments;
import com.employee_Manager.performance_system.ResponseDtoLayer.TaskAssignmentsDTO;
import com.employee_Manager.performance_system.Service.TaskAssignmentService;

@RestController
@RequestMapping("/api/")
public class TaskAssignmentController {

	private final TaskAssignmentService taskAssignmentService;

	public TaskAssignmentController(TaskAssignmentService taskAssignmentService) {
		super();
		this.taskAssignmentService = taskAssignmentService;
	}

	@PreAuthorize("hasRole('MANAGER')")
	@PostMapping("/taskAssignment/{taskid}")
	public ResponseEntity<TaskAssignmentsDTO> assignTask(@PathVariable Integer taskid, @RequestParam LocalDate dueDate,
			@RequestParam Integer employeeId, @RequestParam Integer managerid) {

		return new ResponseEntity<>(
				DTOMapper.toTaskAssignmentsDTO(taskAssignmentService.assignTask(taskid, dueDate, employeeId, managerid))
				, HttpStatus.CREATED);

	}

	@PreAuthorize("hasRole('EMPLOYEE')")
	@PostMapping("/taskAssignment/start/{id}")
	public ResponseEntity<TaskAssignmentsDTO> processingTask(@PathVariable Integer id) {

		return new ResponseEntity<>(DTOMapper.toTaskAssignmentsDTO(taskAssignmentService.processingTask(id)),
				HttpStatus.OK);
	}

	
	@PreAuthorize("hasRole('EMPLOYEE')")
	@PostMapping("/taskAssignment/complete/{id}")
	public ResponseEntity<TaskAssignmentsDTO> completeTask(@PathVariable Integer id) {

		return new ResponseEntity<>(DTOMapper.toTaskAssignmentsDTO(taskAssignmentService.completedTask(id)),
				HttpStatus.OK);
	}

	
	@PreAuthorize("hasRole('EMPLOYEE')")
	@GetMapping("taskAssignment/employee")
	public ResponseEntity<List<TaskAssignmentsDTO>> getTaskAssignToEmployee(Authentication authentication) {

		List<TaskAssignments> task = taskAssignmentService.getTaskAssignToEmployee(authentication.getName());

		List<TaskAssignmentsDTO> dto = new ArrayList<>();

		for (TaskAssignments t : task) {
			dto.add(DTOMapper.toTaskAssignmentsDTO(t));
		}

		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('MANAGER')")
	@GetMapping("taskAssignment/manager")
	public ResponseEntity<List<TaskAssignmentsDTO>> getTaskAssignToManager(Authentication authentication) {

		List<TaskAssignments> task = taskAssignmentService.getTaskAssignToManager(authentication.getName());

		List<TaskAssignmentsDTO> dto = new ArrayList<>();

		for (TaskAssignments t : task) {
			dto.add(DTOMapper.toTaskAssignmentsDTO(t));
		}

		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
}
