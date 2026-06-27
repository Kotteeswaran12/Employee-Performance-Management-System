package com.employee_Manager.performance_system.APIDashBoard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee_Manager.performance_system.Entity.ApplyLeave;
import com.employee_Manager.performance_system.Entity.EMPFeedBack;
import com.employee_Manager.performance_system.Entity.Employees;
import com.employee_Manager.performance_system.Entity.PerformanceReview;
import com.employee_Manager.performance_system.Entity.TaskAssignments;
import com.employee_Manager.performance_system.Enums.AssignmentStatus;
import com.employee_Manager.performance_system.Enums.LeaveStatus;
import com.employee_Manager.performance_system.Enums.RoleTypes;
import com.employee_Manager.performance_system.Exceptions.EmployeeNotFoundException;
import com.employee_Manager.performance_system.Repository.ApplyLeaveRepo;
import com.employee_Manager.performance_system.Repository.DepartmentRepository;
import com.employee_Manager.performance_system.Repository.EmployeeRepository;
import com.employee_Manager.performance_system.Repository.FeedbackRepository;
import com.employee_Manager.performance_system.Repository.PerformanceReviewRepository;
import com.employee_Manager.performance_system.Repository.TaskAssignmentRepository;
@Service
public class DashBoardService {

	private final TaskAssignmentRepository taskAssignmentRepository;
	private final EmployeeRepository employeeRepository;
	private final DepartmentRepository departmentRepository;
	private final ApplyLeaveRepo applyLeaveRepo;
	private final FeedbackRepository feedbackRepository;
	private final PerformanceReviewRepository performanceReviewRepository;
	private final TaskAssignmentRepository assignmentRepository;

	
	
	@Autowired
	public DashBoardService(TaskAssignmentRepository taskAssignmentRepository, EmployeeRepository employeeRepository,
			DepartmentRepository departmentRepository, ApplyLeaveRepo applyLeaveRepo,
			FeedbackRepository feedbackRepository, PerformanceReviewRepository performanceReviewRepository,
			TaskAssignmentRepository assignmentRepository) {
		super();
		this.taskAssignmentRepository = taskAssignmentRepository;
		this.employeeRepository = employeeRepository;
		this.departmentRepository = departmentRepository;
		this.applyLeaveRepo = applyLeaveRepo;
		this.feedbackRepository = feedbackRepository;
		this.performanceReviewRepository = performanceReviewRepository;
		this.assignmentRepository = assignmentRepository;
	}

	public AdminDashBoard AdminDahBoardDetails() {

		AdminDashBoard adminDashBoard = new AdminDashBoard();

		long completedTask = taskAssignmentRepository.countByStatus(AssignmentStatus.COMPLITED);

		int totalEmp = (int) employeeRepository.count();

		int manager = (int) employeeRepository.countByUser_Role(RoleTypes.MANAGER);

		long department = departmentRepository.count();

		List<ApplyLeave> pendingLeave = applyLeaveRepo.findByStatus(LeaveStatus.PENDING);

		adminDashBoard.setTotalDepartments((int) department);

		adminDashBoard.setTotalManagers(manager);

		adminDashBoard.setTotalEmployees(totalEmp);

		adminDashBoard.setCompletedTask((int) completedTask);
		adminDashBoard.setPendingLeaves(pendingLeave.size());

		return adminDashBoard;

	}

	public EmployeeDashBoard getAllEmployeeDashBoardDetails(String empname) {

		EmployeeDashBoard employeeDashBoard = new EmployeeDashBoard();

		List<PerformanceReview> performanceReviews = performanceReviewRepository.findByEmployees_Empcode(getEmployeesEmpCode(empname))
				.orElseThrow(() -> new EmployeeNotFoundException("The Employee not Found For name : " + empname));

		Integer attendanceScore = 0, TaskScore = 0, feedBackScore = 0;

		Double overAllScore = 0.0;

		for (PerformanceReview PR : performanceReviews) {

			attendanceScore += PR.getAttendanceScore();
			TaskScore += PR.getTaskScore();
			feedBackScore += PR.getFeedbackScore();
			overAllScore += PR.getOverallScore();

		}

		List<TaskAssignments> taskAssign = assignmentRepository
				.findByStatusAndAssignedTo_Empcode(AssignmentStatus.PENDING, getEmployeesEmpCode(empname))
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not Found With name :  " + empname));

		employeeDashBoard.setAttendaceScore(attendanceScore!=0 ? attendanceScore / performanceReviews.size() : 0);
		employeeDashBoard.setFeedbackScore(feedBackScore!=0? feedBackScore / performanceReviews.size() : 0);
		employeeDashBoard.setOverAllScore(overAllScore!=0? overAllScore / performanceReviews.size() : 0);
		employeeDashBoard.setTaskScore(TaskScore!=0? TaskScore / performanceReviews.size() : 0);

		employeeDashBoard.setPendingTask(taskAssign.size());

		return employeeDashBoard;

	}
	
	
	
	public ManagerDashBoard getAllManagerDashBoardDetails(String empname) {

		ManagerDashBoard managerDashBoard = new ManagerDashBoard();

		Employees manager = employeeRepository.findByEmpcode(getEmployeesEmpCode(empname))
				.orElseThrow(() -> new EmployeeNotFoundException("No Manager Found !!"));

		List<ApplyLeave> pendingLeave = applyLeaveRepo.findByStatusAndEmployees_Departments_id(LeaveStatus.PENDING , manager.getDepartments().getId())
				.orElseThrow(() -> new EmployeeNotFoundException("No Employee Found !!"));

		List<EMPFeedBack> pendingFeedbacks = feedbackRepository.findByEmployees_Departments_Dept(manager.getDepartments().getDept());

		List<TaskAssignments> taskAssign = taskAssignmentRepository.findByAssignedTo_Departments_Dept(manager.getDepartments().getDept());

		managerDashBoard.setTaskAssigned(taskAssign.size());
		managerDashBoard.setPendingReviews(pendingFeedbacks.size());
		managerDashBoard.setTeamSize(manager.getSubordinate().size());
		managerDashBoard.setPendingLeave(pendingLeave.size());

		return managerDashBoard;

	}
	
	public String getEmployeesEmpCode(String empname) {
		
		Employees emp = employeeRepository.findByFirstname(empname)
				.orElseThrow(() -> new EmployeeNotFoundException("No Employee Found for with name : "+ empname));
		return 	emp.getEmpcode();
	}
}
