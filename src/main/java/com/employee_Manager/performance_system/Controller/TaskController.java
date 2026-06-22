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

import com.employee_Manager.performance_system.DtoLayer.TaskDTO;
import com.employee_Manager.performance_system.Entity.Task;
import com.employee_Manager.performance_system.Service.TaskService;
import com.employee_Manager.performance_system.Service.TaskServiceIMP;
import com.employee_Manager.performance_systemDTOMapper.DTOMapper;

@RestController
@RequestMapping("/api/")
public class TaskController {

	private final TaskService taskService;
	
	

	public TaskController(TaskService taskService) {
		super();
		this.taskService = taskService;
	}

	@PostMapping("manager/task/add/{id}")
	public ResponseEntity<TaskDTO> addtask(@PathVariable Integer id, @RequestBody Task task) {
		return new ResponseEntity<>(DTOMapper.toTaskDTo(taskService.createtask(task, id)), HttpStatus.CREATED);
	}

	@PostMapping("manager/task/update")
	public ResponseEntity<TaskDTO> updateTask(@RequestBody Task task) {
		return new ResponseEntity<>(DTOMapper.toTaskDTo(taskService.updateTask(task)), HttpStatus.CREATED);
	}

	@GetMapping("manager/task/get-all")
	public ResponseEntity<List<TaskDTO>> getAllTask() {
		
		List<Task> task = taskService.getAlltask();
		
		List<TaskDTO> taskDto = new ArrayList<>();
		for(Task t : task) {
			taskDto.add(DTOMapper.toTaskDTo(t));
		}
		
		return new ResponseEntity<>(taskDto, HttpStatus.CREATED);
	}

	@GetMapping("manager/task/get-By/{id}")
	public ResponseEntity<TaskDTO> getTaskbyId(@PathVariable Integer id) {
		return new ResponseEntity<>(DTOMapper.toTaskDTo(taskService.getTaskById(id)), HttpStatus.CREATED);
	}

	@DeleteMapping("manager/delete-by/{id}")
	public ResponseEntity<Task> deleteTaskbyId(@PathVariable Integer id) {
		taskService.deleteTaskById(id);
		return ResponseEntity.noContent().build();
	}

}
