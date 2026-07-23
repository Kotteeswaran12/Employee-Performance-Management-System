package com.employee_Manager.performance_system.Service;

import java.time.LocalDate;


import org.springframework.data.domain.Page;

import com.employee_Manager.performance_system.Entity.TaskAssignments;

public interface TaskAssignmentService {
	
	public TaskAssignments assignTask(Integer taskid ,
												LocalDate dueDate ,
												Integer employeeId , 
												Integer managerid);
	
	
	public TaskAssignments processingTask(Integer id);
	
	public TaskAssignments completedTask(Integer id);
	
	public Page<TaskAssignments> getAllTaskAssignToEmployee(String  empName , int page ,int size);
	
	public Page<TaskAssignments> getAllTaskAssignByManager(String managerName , int page ,int size);


    public Page<TaskAssignments> getAllTaskAssignments(int page, int size);
	
	

}
