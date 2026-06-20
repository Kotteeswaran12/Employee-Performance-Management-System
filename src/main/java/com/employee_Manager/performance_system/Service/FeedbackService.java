package com.employee_Manager.performance_system.Service;

import java.util.List;

import com.employee_Manager.performance_system.Entity.EMPFeedBack;

public interface FeedbackService {

	
	public EMPFeedBack addFeedbacksToEmployee (Integer givenTo  ,  Integer givenBy  , EMPFeedBack feedback);
	
	public List<EMPFeedBack> getAllFeedbackByEmpId(Integer id);
}
