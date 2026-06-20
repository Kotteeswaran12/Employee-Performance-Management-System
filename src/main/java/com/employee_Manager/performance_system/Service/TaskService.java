package com.employee_Manager.performance_system.Service;

import java.util.List;

import com.employee_Manager.performance_system.Entity.Task;

public interface TaskService {
	
	public Task createtask(Task task , Integer createById);
	
	public Task updateTask(Task task);
	
	public List<Task> getAlltask();
	
	public Task getTaskById(Integer id);
	
	public void deleteTaskById(Integer id);

}
