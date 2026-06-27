package com.employee_Manager.performance_system.DTOMapper;

import org.springframework.stereotype.Component;


import com.employee_Manager.performance_system.Entity.ApplyLeave;
import com.employee_Manager.performance_system.Entity.Departments;
import com.employee_Manager.performance_system.Entity.EMPFeedBack;
import com.employee_Manager.performance_system.Entity.Employees;
import com.employee_Manager.performance_system.Entity.Task;
import com.employee_Manager.performance_system.Entity.UserInfo;
import com.employee_Manager.performance_system.RequestDTO.ApplyLeaveRequestDTO;
import com.employee_Manager.performance_system.RequestDTO.DepartmentRequestDTO;
import com.employee_Manager.performance_system.RequestDTO.EMPFeedBackRequestDTO;
import com.employee_Manager.performance_system.RequestDTO.EmployeeRequestDTO;
import com.employee_Manager.performance_system.RequestDTO.TaskRequestDTO;
import com.employee_Manager.performance_system.RequestDTO.UserInfoRequestDTO;

@Component
public class RequestDTOMapper {

	public Employees toEmployeeEntity(EmployeeRequestDTO e) {

		Employees emp = new Employees();

		emp.setDesignation(e.getDesignation());
		emp.setEmpcode(e.getEmpcode());
		emp.setFirstname(e.getFirstname());
		emp.setLastname(e.getLastname());
		return emp;

	}

	public ApplyLeave toApplyLeaveEntity(ApplyLeaveRequestDTO a) {

		ApplyLeave leave = new ApplyLeave();


		leave.setEndingDate(a.getEndingDate());
		leave.setReason(a.getReason());
		leave.setStartingDate(a.getStartingDate());

		return leave;
	}


	public Departments toDepartmentEntity(DepartmentRequestDTO d) {

		Departments department = new Departments();

		department.setDept(d.getDept());



		return department;

	}

	public EMPFeedBack toFeedBackEntity(EMPFeedBackRequestDTO feedback) {
		EMPFeedBack feedBack = new EMPFeedBack();

		feedBack.setComments(feedback.getComments());
		feedBack.setCommunicationScore(feedback.getCommunicationScore());

		feedBack.setHelpfullnessScore(feedback.getHelpfullnessScore());

		feedBack.setKnowledgeSharingScore(feedback.getKnowledgeSharingScore());

		feedBack.setTeamworkScore(feedback.getTeamworkScore());

		return feedBack;
	}




	public Task toTaskEntity(TaskRequestDTO t) {
		Task task = new Task();

		task.setDescription(t.getDescription());
		task.setEstimatedHours(t.getEstimatedHours());

		task.setTitle(t.getTitle());

		return task;
	}


	public UserInfo toUserInfoEntity(UserInfoRequestDTO user) {

		UserInfo userInfo = new UserInfo();

		userInfo.setEmail(user.getEmail());

		userInfo.setPassword(user.getPassword());

		return userInfo;

	}

}
