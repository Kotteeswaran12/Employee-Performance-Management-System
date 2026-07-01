package com.employee_Manager.performance_system.Service;

import org.springframework.data.domain.Page;

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
	
	Page<PerformanceReview> getAllPerformanceReviewById(String username  , int page , int size);

}
