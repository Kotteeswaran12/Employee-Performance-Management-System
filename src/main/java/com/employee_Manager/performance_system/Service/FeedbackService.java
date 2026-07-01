package com.employee_Manager.performance_system.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.employee_Manager.performance_system.Entity.EMPFeedBack;

public interface FeedbackService {

	
	public EMPFeedBack addFeedbacksToEmployee (Integer givenTo  ,  String managerName  , EMPFeedBack feedback);
	
	public List<EMPFeedBack> getAllFeedbackByEmpId(String empname);
	
	public Page<EMPFeedBack> getAllFeedback(int page , int size);
}
