package com.employee_Manager.performance_system.DTOMapper;

import com.employee_Manager.performance_system.Entity.ApplyLeave;
import com.employee_Manager.performance_system.Entity.Attendance;
import com.employee_Manager.performance_system.Entity.Departments;
import com.employee_Manager.performance_system.Entity.EMPFeedBack;
import com.employee_Manager.performance_system.Entity.Employees;
import com.employee_Manager.performance_system.Entity.PerformanceReview;
import com.employee_Manager.performance_system.Entity.Task;
import com.employee_Manager.performance_system.Entity.TaskAssignments;
import com.employee_Manager.performance_system.Entity.UserInfo;
import com.employee_Manager.performance_system.ResponseDtoLayer.ApplyLeaveDTO;
import com.employee_Manager.performance_system.ResponseDtoLayer.AttendanceDTO;
import com.employee_Manager.performance_system.ResponseDtoLayer.DepartmentResponseDTO;
import com.employee_Manager.performance_system.ResponseDtoLayer.EMPFeedBackDTO;
import com.employee_Manager.performance_system.ResponseDtoLayer.EmployeeResponseDTO;
import com.employee_Manager.performance_system.ResponseDtoLayer.LoginResponseDTO;
import com.employee_Manager.performance_system.ResponseDtoLayer.PerformanceReviewDTO;
import com.employee_Manager.performance_system.ResponseDtoLayer.TaskAssignmentsDTO;
import com.employee_Manager.performance_system.ResponseDtoLayer.TaskDTO;
import com.employee_Manager.performance_system.ResponseDtoLayer.UserInfoDTO;

public class DTOMapper {

	public static EmployeeResponseDTO toEmployeeDto(Employees e) {

		EmployeeResponseDTO empDto = new EmployeeResponseDTO();

		empDto.setDepartmentname(e.getDepartments().getDept());
		empDto.setDesignation(e.getDesignation());
		empDto.setEmpcode(e.getEmpcode());
		empDto.setFirstname(e.getFirstname());
		empDto.setLastname(e.getLastname());
		empDto.setManagername(e.getManager() != null ? e.getManager().getFirstname() : "null");
		empDto.setId(e.getId());

		return empDto;

	}

	public static ApplyLeaveDTO toApplyLeaveDto(ApplyLeave a) {

		ApplyLeaveDTO dto = new ApplyLeaveDTO();

		dto.setId(a.getId());
		dto.setStatus(a.getStatus());
		dto.setEndingDate(a.getEndingDate());
		dto.setEmployeName(a.getEmployees().getFirstname());
		dto.setManagerName(a.getAprovedBy() != null ? a.getAprovedBy().getFirstname() : null);
		dto.setReason(a.getReason());
		dto.setStartingDate(a.getStartingDate());

		return dto;
	}

	public static AttendanceDTO toAttendaceDTO(Attendance a) {

		AttendanceDTO dto = new AttendanceDTO();

		dto.setAttendance_id(a.getAttendance_id());
		dto.setAttendanceDate(a.getAttendanceDate());
		dto.setCheckIn(a.getCheckIn());
		dto.setCheckOut(a.getCheckOut());
		dto.setEmployeName(a.getEmployees().getFirstname());
		dto.setWorkingHours(a.getWorkingHours());

		return dto;

	}

	public static DepartmentResponseDTO toDepartmentDto(Departments d) {

		DepartmentResponseDTO departmentResponseDTO = new DepartmentResponseDTO();

		departmentResponseDTO.setDept(d.getDept());

		departmentResponseDTO.setId(d.getId());

		return departmentResponseDTO;

	}

	public static EMPFeedBackDTO toFeedBackDto(EMPFeedBack feedback) {
		EMPFeedBackDTO feeddto = new EMPFeedBackDTO();

		feeddto.setComments(feedback.getComments());
		feeddto.setCommunicationScore(feedback.getCommunicationScore());
		feeddto.setEmployeName(feedback.getEmployees().getFirstname());
		feeddto.setHelpfullnessScore(feedback.getHelpfullnessScore());
		feeddto.setId(feedback.getId());
		feeddto.setKnowledgeSharingScore(feedback.getKnowledgeSharingScore());
		feeddto.setReviewedBy(feedback.getReviewedBy().getFirstname());
		feeddto.setTeamworkScore(feedback.getTeamworkScore());

		return feeddto;
	}

	public static PerformanceReviewDTO toPerformanceReviewDTO(PerformanceReview pr) {
		PerformanceReviewDTO dto = new PerformanceReviewDTO();

		dto.setAttendanceScore(pr.getAttendanceScore());
		dto.setEmployees(pr.getEmployees().getFirstname());
		dto.setFeedbackScore(pr.getFeedbackScore());
		dto.setId(pr.getId());
		dto.setOverallScore(pr.getOverallScore());
		dto.setQualityScore(pr.getQualityScore());
		dto.setRemarks(pr.getRemarks());
		dto.setReviewBy(pr.getReviewBy().getFirstname());
		dto.setReviewDate(pr.getReviewDate());
		dto.setTaskScore(pr.getTaskScore());

		return dto;

	}

	public static TaskDTO toTaskDTo(Task t) {
		TaskDTO dto = new TaskDTO();

		dto.setCreatedBy(t.getCreatedBy().getFirstname());
		dto.setCreatedDate(t.getCreatedDate());
		dto.setDescription(t.getDescription());
		dto.setEstimatedHours(t.getEstimatedHours());
		dto.setId(t.getId());
		dto.setTitle(t.getTitle());

		return dto;
	}

	public static TaskAssignmentsDTO toTaskAssignmentsDTO(TaskAssignments task) {

		TaskAssignmentsDTO dto = new TaskAssignmentsDTO();

		dto.setAssignedBy(task.getAssignedBy().getFirstname());
		dto.setAssignedDate(task.getAssignedDate());
		dto.setAssignedTo(task.getAssignedTo().getFirstname());
		dto.setAssignmentId(task.getAssignmentId());
		dto.setCompletedDate(task.getCompletedDate() != null ? task.getCompletedDate() : null);
		dto.setDueDate(task.getDueDate());
		dto.setStatus(task.getStatus());
		dto.setTask(task.getTask().getTitle());

		return dto;
	}

	public static UserInfoDTO toUserInfoDTO(UserInfo user) {

		UserInfoDTO dto = new UserInfoDTO();

		dto.setCreatedate(user.getCreatedate());
		dto.setEmail(user.getEmail());
		dto.setEmployees(user.getEmployees()!=null? user.getEmployees().getFirstname() : null);
		dto.setId(user.getId());
		dto.setPassword(user.getPassword());
		dto.setRole(user.getRole());
		dto.setUsername(user.getUsername());

		return dto;

	}

	

}
