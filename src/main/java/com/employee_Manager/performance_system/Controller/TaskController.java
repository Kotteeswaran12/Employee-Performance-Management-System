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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee_Manager.performance_system.DTOMapper.DTOMapper;
import com.employee_Manager.performance_system.DTOMapper.RequestDTOMapper;
import com.employee_Manager.performance_system.Entity.Task;
import com.employee_Manager.performance_system.RequestDTO.TaskRequestDTO;
import com.employee_Manager.performance_system.ResponseDtoLayer.TaskDTO;
import com.employee_Manager.performance_system.Service.TaskService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/")
public class TaskController {

	private final TaskService taskService;
	private final RequestDTOMapper requestDTOMapper;
	
	

	
	public TaskController(TaskService taskService, RequestDTOMapper requestDTOMapper) {
		super();
		this.taskService = taskService;
		this.requestDTOMapper = requestDTOMapper;
	}




	@Tag(name = "Manager - ONLY Access")
	@Operation(summary = "Manager Can Create A Task then Ony they can Assign it" )
	@PreAuthorize("hasRole('MANAGER')")
	@PostMapping("/task")
	public ResponseEntity<TaskDTO> addtask( Authentication authentication, @RequestBody TaskRequestDTO task) {
		return new ResponseEntity<>(DTOMapper.toTaskDTo(taskService.createtask(requestDTOMapper.toTaskEntity(task), authentication.getName())), HttpStatus.CREATED);
	}
	
	
	

	@Tag(name = "Manager - ONLY Access")
	@Operation(summary = "Manager Can Update the Task" )
	@PreAuthorize("hasRole('MANAGER')")
	@PutMapping("/task")
	public ResponseEntity<TaskDTO> updateTask(@RequestBody Task task) {
		return new ResponseEntity<>(DTOMapper.toTaskDTo(taskService.updateTask(task)), HttpStatus.CREATED);
	}
	
	
	
	@Tag(name = "Manager - ONLY Access")
	@Operation(summary = "Manager Can all the task" )
	@PreAuthorize("hasRole('MANAGER')")
	@GetMapping("/task")
	public ResponseEntity<List<TaskDTO>> getAllTask(Authentication authentication) {
		
		List<Task> task = taskService.getAlltask(authentication.getName());
		
		List<TaskDTO> taskDto = new ArrayList<>();
		for(Task t : task) {
			taskDto.add(DTOMapper.toTaskDTo(t));
		}
		
		return new ResponseEntity<>(taskDto, HttpStatus.CREATED);
	}
	
	
	
	@Tag(name = "Manager - ONLY Access")
	@Operation(summary = "Manager Can get the Task by ID" )
	@PreAuthorize("hasRole('MANAGER')")
	@GetMapping("/task/{id}")
	public ResponseEntity<TaskDTO> getTaskbyId(@PathVariable Integer id) {
		return new ResponseEntity<>(DTOMapper.toTaskDTo(taskService.getTaskById(id)), HttpStatus.CREATED);
	}
	
	
	
	@Tag(name = "Manager - ONLY Access")
	@Operation(summary = "Manager Can Delete the Task " )
	@PreAuthorize("hasRole('MANAGER')")
	@DeleteMapping("task/{id}")
	public ResponseEntity<Task> deleteTaskbyId(@PathVariable Integer id) {
		taskService.deleteTaskById(id);
		return ResponseEntity.noContent().build();
	}

}
