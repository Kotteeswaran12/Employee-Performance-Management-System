package com.employee_Manager.performance_system.Service;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.employee_Manager.performance_system.Entity.Employees;
import com.employee_Manager.performance_system.Entity.Task;
import com.employee_Manager.performance_system.Entity.TaskAssignments;
import com.employee_Manager.performance_system.Enums.AssignmentStatus;
import com.employee_Manager.performance_system.Exceptions.EmployeeManagerException;
import com.employee_Manager.performance_system.Exceptions.EmployeeNotFoundException;
import com.employee_Manager.performance_system.Exceptions.TaskAssignmentException;
import com.employee_Manager.performance_system.Exceptions.TaskException;
import com.employee_Manager.performance_system.Repository.EmployeeRepository;
import com.employee_Manager.performance_system.Repository.TaskAssignmentRepository;
import com.employee_Manager.performance_system.Repository.TaskRepository;

@Service
public class TaskAssignmentServiceIMP implements TaskAssignmentService {

    private final TaskAssignmentRepository taskAssignmentRepository;

    private final TaskRepository taskRepository;

    private final EmployeeRepository employeeRepository;

    public TaskAssignmentServiceIMP(TaskAssignmentRepository taskAssignmentRepository, TaskRepository taskRepository,
            EmployeeRepository employeeRepository) {
        super();
        this.taskAssignmentRepository = taskAssignmentRepository;
        this.taskRepository = taskRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public TaskAssignments assignTask(Integer taskid, LocalDate dueDate, Integer employeeId, Integer managerid) {
        // TODO Auto-generated method stub

        Task existingTask = taskRepository.findById(taskid)
                .orElseThrow(() -> new TaskException("Task Not Found For id :" + taskid));

        Employees emp = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee Not Found for ID :" + employeeId));

        Employees manager = employeeRepository.findById(managerid)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee Not Found for ID :" + managerid));

        if (emp.getManager() == null) {
            throw new EmployeeManagerException("no manager is assigned to this Employee id :" + employeeId);
        }

        if (!emp.getManager().getId().equals(manager.getId())) {
            throw new EmployeeManagerException("Manager can assign tasks only to subordinates");
        }

        if (dueDate.isBefore(LocalDate.now())) {
            throw new RuntimeException("Due date cannot be in the past");
        }

        TaskAssignments assignments = new TaskAssignments();

        assignments.setDueDate(dueDate);
        assignments.setTask(existingTask);
        assignments.setAssignedTo(emp);
        assignments.setAssignedBy(manager);
        assignments.setAssignedDate(LocalDate.now());
        assignments.setStatus(AssignmentStatus.PENDING);

        return taskAssignmentRepository.save(assignments);
    }

    @Override
    public TaskAssignments processingTask(Integer id) {
        // TODO Auto-generated method stub
        TaskAssignments assignments = taskAssignmentRepository.findById(id)
                .orElseThrow(() -> new TaskAssignmentException("no Task assigned !!"));

        if (assignments.getStatus() == AssignmentStatus.COMPLITED) {
            throw new TaskAssignmentException("Complited  task Can't modify");
        }

        assignments.setStatus(AssignmentStatus.PROCESSING);
        taskAssignmentRepository.save(assignments);

        return assignments;
    }

    @Override
    public TaskAssignments completedTask(Integer id) {
        // TODO Auto-generated method stub
        TaskAssignments assignments = taskAssignmentRepository.findById(id)
                .orElseThrow(() -> new TaskAssignmentException("no Task assigned !!"));

        if (assignments.getStatus() == AssignmentStatus.COMPLITED) {
            throw new TaskAssignmentException("Task is already Complited ");
        }

        assignments.setCompletedDate(LocalDate.now());

        assignments.setStatus(AssignmentStatus.COMPLITED);

        return taskAssignmentRepository.save(assignments);
    }

    @Override
    public Page<TaskAssignments> getAllTaskAssignToEmployee(String empName, int page, int size) {
        // TODO Auto-generated method stub

        Employees emp = employeeRepository.findByFirstname(empName)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not Found for name : " + empName));

        Pageable pageable = PageRequest.of(page, size);

        return taskAssignmentRepository.findByAssignedTo_Id(emp.getId(), pageable);

    }

    @Override
    public Page<TaskAssignments> getAllTaskAssignByManager(String managerName, int page, int size) {
        Employees emp = employeeRepository.findByFirstname(managerName)
                .orElseThrow(() -> new EmployeeNotFoundException("Manager not Found for name : " + managerName));

        Pageable pageable = PageRequest.of(page, size);
        return taskAssignmentRepository.findByAssignedBy_Id(emp.getId(), pageable);
    }

    // @Over
    @Override
    public Page<TaskAssignments> getAllTaskAssignments(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

		return taskAssignmentRepository.findAll(pageable);
    }
}
