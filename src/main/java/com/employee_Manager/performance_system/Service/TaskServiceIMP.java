package com.employee_Manager.performance_system.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.employee_Manager.performance_system.Entity.Employees;
import com.employee_Manager.performance_system.Entity.Task;
import com.employee_Manager.performance_system.Enums.RoleTypes;
import com.employee_Manager.performance_system.Exceptions.EmployeeNotFoundException;
import com.employee_Manager.performance_system.Exceptions.NotaManagerException;
import com.employee_Manager.performance_system.Exceptions.TaskException;
import com.employee_Manager.performance_system.Repository.EmployeeRepository;
import com.employee_Manager.performance_system.Repository.TaskRepository;

@Service
public class TaskServiceIMP implements TaskService {

	private final TaskRepository taskRepository;
	private final EmployeeRepository employeeRepository;

	public TaskServiceIMP(TaskRepository taskRepository, EmployeeRepository employeeRepository) {
		super();
		this.taskRepository = taskRepository;
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Task createtask(Task task, String managerName) {
		// TODO Auto-generated method stub
		Employees emp = employeeRepository.findByFirstname(managerName)
				.orElseThrow(() -> new EmployeeNotFoundException("No Employee Found for Name : " + managerName));

		task.setCreatedDate(LocalDate.now());
		task.setCreatedBy(emp);

		return taskRepository.save(task);
	}

	@Override
	public Task updateTask(Task task) {
		// TODO Auto-generated method stub
		Task t = taskRepository.findById(task.getId()).orElseThrow(() -> new TaskException("Task not Found !!"));

		t.setTitle(task.getTitle());
//		t.setCreatedDate(task.getCreatedDate());
		t.setDescription(task.getDescription());
		t.setEstimatedHours(task.getEstimatedHours());

		return taskRepository.save(t);
	}

	@Override
	public Page<Task> getAlltask(String managerName , int page , int size) {

		Employees manager = employeeRepository.findByFirstname(managerName)
				.orElseThrow(() -> new EmployeeNotFoundException("No Employee Found for Name : " + managerName));

		Pageable pageable = PageRequest.of(page, size);
		
		return taskRepository.findByCreatedBy_id(manager.getId() , pageable)
				.orElseThrow(() -> new TaskException("Task not Found !!"));
	}

	@Override
	public Task getTaskById(Integer id) {
		// TODO Auto-generated method stub
		return taskRepository.findById(id).orElseThrow(() -> new TaskException("Task not Found !!"));
	}

	@Override
	public void deleteTaskById(Integer id) {

		Task existingTask = taskRepository.findById(id)
				.orElseThrow(() -> new TaskException("Task Not found & unable to Delete"));

		taskRepository.deleteById(id);

	}

}
