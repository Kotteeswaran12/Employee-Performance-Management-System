package com.employee_Manager.performance_system.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee_Manager.performance_system.DtoLayer.TaskAssignmentsDTO;
import com.employee_Manager.performance_system.Entity.TaskAssignments;
import com.employee_Manager.performance_system.Service.TaskAssignmentService;
import com.employee_Manager.performance_system.Service.TaskAssignmentServiceIMP;
import com.employee_Manager.performance_systemDTOMapper.DTOMapper;

@RestController
@RequestMapping("/api/")
public class TaskAssignmentController {

	private final TaskAssignmentService taskAssignmentService;

	public TaskAssignmentController(TaskAssignmentService taskAssignmentService) {
		super();
		this.taskAssignmentService = taskAssignmentService;
	}

	@PostMapping("manager/taskAssignment/assign-task/{taskid}/")
	public ResponseEntity<TaskAssignmentsDTO> assignTask(@PathVariable Integer taskid, @RequestParam LocalDate dueDate,
			@RequestParam Integer employeeId, @RequestParam Integer managerid) {

		return new ResponseEntity<>(
				DTOMapper.toTaskAssignmentsDTO(taskAssignmentService.assignTask(taskid, dueDate, employeeId, managerid))
				, HttpStatus.CREATED);

	}

	@PostMapping("employee/taskAssignment/start-task/{id}")
	public ResponseEntity<TaskAssignmentsDTO> processingTask(@PathVariable Integer id) {

		return new ResponseEntity<>(DTOMapper.toTaskAssignmentsDTO(taskAssignmentService.processingTask(id)),
				HttpStatus.OK);
	}

	@PostMapping("employee/taskAssignment/complete-task/{id}")
	public ResponseEntity<TaskAssignmentsDTO> completeTask(@PathVariable Integer id) {

		return new ResponseEntity<>(DTOMapper.toTaskAssignmentsDTO(taskAssignmentService.completedTask(id)),
				HttpStatus.OK);
	}

	@GetMapping("taskAssignment/getByEmployee/{id}")
	public ResponseEntity<List<TaskAssignmentsDTO>> getTaskAssignToEmployee(@PathVariable Integer id) {

		List<TaskAssignments> task = taskAssignmentService.getTaskAssignToEmployee(id);

		List<TaskAssignmentsDTO> dto = new ArrayList<>();

		for (TaskAssignments t : task) {
			dto.add(DTOMapper.toTaskAssignmentsDTO(t));
		}

		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@GetMapping("taskAssignment/getbyManager/{id}")
	public ResponseEntity<List<TaskAssignmentsDTO>> getTaskAssignToManager(@PathVariable Integer id) {

		List<TaskAssignments> task = taskAssignmentService.getTaskAssignToManager(id);

		List<TaskAssignmentsDTO> dto = new ArrayList<>();

		for (TaskAssignments t : task) {
			dto.add(DTOMapper.toTaskAssignmentsDTO(t));
		}

		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
}
