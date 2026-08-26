package com.employee_Manager.performance_system.Service;

import org.springframework.data.domain.Page;

import com.employee_Manager.performance_system.Entity.EMPFeedBack;

public interface FeedbackService {

	
	public EMPFeedBack addFeedbacksToEmployee (Integer givenTo  ,  String managerName  , EMPFeedBack feedback);
	
	public Page<EMPFeedBack> getAllFeedbackByEmpId(String empname , int page, int size);
	
	public Page<EMPFeedBack> getAllFeedback(int page , int size);
}
