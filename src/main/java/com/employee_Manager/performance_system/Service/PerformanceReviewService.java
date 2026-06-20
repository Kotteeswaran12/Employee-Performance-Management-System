package com.employee_Manager.performance_system.Service;

import java.util.List;

import com.employee_Manager.performance_system.Entity.Employees;
import com.employee_Manager.performance_system.Entity.PerformanceReview;

public interface PerformanceReviewService {

	PerformanceReview createReview(

			Integer empId, Integer managerId, Integer qualityScore, String remarks

	);

	Integer calculateAttendanceScore(Employees empId);

	Integer calculateTaskScore(Employees empId);

	Double calculateOverallScoreScore(Employees empId , Integer qualityScore);

	Integer calculateFeedbackScore(Employees empId);
	
	List<PerformanceReview> getAllPerformanceReviewById(Integer id);

}
