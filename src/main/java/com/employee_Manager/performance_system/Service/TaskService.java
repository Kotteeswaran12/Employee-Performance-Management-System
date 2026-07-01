package com.employee_Manager.performance_system.Service;

import org.springframework.data.domain.Page;

import com.employee_Manager.performance_system.Entity.Task;

public interface TaskService {
	
	public Task createtask(Task task , String managerName);
	
	public Task updateTask(Task task);
	
	public Page<Task> getAlltask(String managerName , int page , int size);
	
	public Task getTaskById(Integer id);
	
	public void deleteTaskById(Integer id);

}
