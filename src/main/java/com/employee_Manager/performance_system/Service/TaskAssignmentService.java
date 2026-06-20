package com.employee_Manager.performance_system.Service;

import java.time.LocalDate;
import java.util.List;

import com.employee_Manager.performance_system.Entity.TaskAssignments;

public interface TaskAssignmentService {
	
	public TaskAssignments assignTask(Integer taskid ,
												LocalDate dueDate ,
												Integer employeeId , 
												Integer managerid);
	
	
	public TaskAssignments processingTask(Integer id);
	
	public TaskAssignments completedTask(Integer id);
	
	public List<TaskAssignments> getTaskAssignToEmployee(Integer id);
	
	public List<TaskAssignments> getTaskAssignToManager(Integer id);
	
	

}
