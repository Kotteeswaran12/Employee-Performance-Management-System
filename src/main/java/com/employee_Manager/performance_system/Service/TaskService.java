package com.employee_Manager.performance_system.Service;

import java.util.List;

import com.employee_Manager.performance_system.Entity.Task;

public interface TaskService {
	
	public Task createtask(Task task , String managerName);
	
	public Task updateTask(Task task);
	
	public List<Task> getAlltask(String managerName);
	
	public Task getTaskById(Integer id);
	
	public void deleteTaskById(Integer id);

}
