package com.employee_Manager.performance_system.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/")
public class TaskAssignmentController {

	private final TaskAssignmentService taskAssignmentService;

	public TaskAssignmentController(TaskAssignmentService taskAssignmentService) {
		super();
		this.taskAssignmentService = taskAssignmentService;
	}

	
	@Tag(name = "Manager - ONLY Access")
	@Operation(summary = "Manager can Assign the task to The Employee" , description = "by Passing the TaskID , Duedate , EmployeeId , ManagerID !!")
	@PreAuthorize("hasRole('MANAGER')")
	@PostMapping("/taskAssignment/{taskid}")
	public ResponseEntity<TaskAssignmentsDTO> assignTask(@PathVariable Integer taskid, @RequestParam LocalDate dueDate,
			@RequestParam Integer employeeId, @RequestParam Integer managerid) {

		return new ResponseEntity<>(
				DTOMapper.toTaskAssignmentsDTO(taskAssignmentService.assignTask(taskid, dueDate, employeeId, managerid))
				, HttpStatus.CREATED);

	}

	
	@Tag(name = "Employee - ONLY Access")
	@Operation(summary = "Employee can Process they Task Assign fo they" , description = "by Passing the Task ID !!")
	@PreAuthorize("hasRole('EMPLOYEE')")
	@PostMapping("/taskAssignment/start/{id}")
	public ResponseEntity<TaskAssignmentsDTO> processingTask(@PathVariable Integer id) {

		return new ResponseEntity<>(DTOMapper.toTaskAssignmentsDTO(taskAssignmentService.processingTask(id)),
				HttpStatus.OK);
	}

	
	@Tag(name = "Employee - ONLY Access")
	@Operation(summary = "Employee can Complete they Task Assign fo they" , description = "by Passing the Task ID !!")
	@PreAuthorize("hasRole('EMPLOYEE')")
	@PostMapping("/taskAssignment/complete/{id}")
	public ResponseEntity<TaskAssignmentsDTO> completeTask(@PathVariable Integer id) {

		return new ResponseEntity<>(DTOMapper.toTaskAssignmentsDTO(taskAssignmentService.completedTask(id)),
				HttpStatus.OK);
	}

	
	
	@Tag(name = "Employee - ONLY Access")
	@Operation(summary = "Employee can Get all the task Assign " )
	@PreAuthorize("hasRole('EMPLOYEE')")
	@GetMapping("taskAssignment/employee")
	public ResponseEntity<Page<TaskAssignmentsDTO>> getTaskAssignToEmployee(Authentication authentication ,
			@RequestParam(defaultValue = "0") int page ,
			@RequestParam(defaultValue = "10") int size) {

		Page<TaskAssignments> task = taskAssignmentService.getAllTaskAssignToEmployee(authentication.getName() , page , size);

		Page<TaskAssignmentsDTO> dto = task.map(DTOMapper :: toTaskAssignmentsDTO);

		

		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	
	

	@Tag(name = "Manager - ONLY Access")
	@Operation(summary = "Manager can Get all the task Assign BY Manager " )
	@PreAuthorize("hasRole('MANAGER')")
	@GetMapping("taskAssignment/manager")
	public ResponseEntity<Page<TaskAssignmentsDTO>> getTaskAssignToManager(Authentication authentication ,
			@RequestParam(defaultValue = "0") int page ,
			@RequestParam(defaultValue = "10") int size
			) {

		Page<TaskAssignments> task = taskAssignmentService.getAllTaskAssignByManager(authentication.getName() , page , size);

		Page<TaskAssignmentsDTO> dto = task.map(DTOMapper :: toTaskAssignmentsDTO);

		

		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
}
