package com.employee_Manager.performance_system.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.stereotype.Service;

import com.employee_Manager.performance_system.Entity.Attendance;
import com.employee_Manager.performance_system.Entity.EMPFeedBack;
import com.employee_Manager.performance_system.Entity.Employees;
import com.employee_Manager.performance_system.Entity.PerformanceReview;
import com.employee_Manager.performance_system.Entity.TaskAssignments;
import com.employee_Manager.performance_system.Exceptions.EmployeeNotFoundException;
import com.employee_Manager.performance_system.Repository.EmployeeRepository;
import com.employee_Manager.performance_system.Repository.PerformanceReviewRepository;

@Service
public class PerformanceReviewServiceIMP implements PerformanceReviewService {

	private final PerformanceReviewRepository performanceReviewRepository;

	private final EmployeeRepository employeeRepository;

	public PerformanceReviewServiceIMP(PerformanceReviewRepository performanceReviewRepository,
			EmployeeRepository employeeRepository) {
		super();
		this.performanceReviewRepository = performanceReviewRepository;
		this.employeeRepository = employeeRepository;
	}

	@Override
	public PerformanceReview createReview(Integer empId, Integer managerId, Integer qualityScore, String remarks) {

		PerformanceReview performanceReview = new PerformanceReview();

		Employees emp = employeeRepository.findById(empId)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee Not Found !!"));

		Employees manager = employeeRepository.findById(managerId)
				.orElseThrow(() -> new EmployeeNotFoundException("Manager Not Found !!"));

		performanceReview.setQualityScore(qualityScore);
		performanceReview.setAttendanceScore(calculateAttendanceScore(emp));
		performanceReview.setTaskScore(calculateTaskScore(emp));
		performanceReview.setFeedbackScore(calculateFeedbackScore(emp));
		performanceReview.setOverallScore(calculateOverallScoreScore(emp , qualityScore));
		performanceReview.setReviewBy(manager);
		performanceReview.setReviewDate(LocalDate.now());
		performanceReview.setEmployees(emp);
		performanceReview.setRemarks(remarks);

		return performanceReviewRepository.save(performanceReview);
	}

	@Override
	public Integer calculateAttendanceScore(Employees emp) {
		List<Attendance> attendances = emp.getAttendances();

		if (attendances.size() == 0) {
			return 0;
		}

		int overall = attendances.size();
		long res = attendances.stream().filter(a -> a.getWorkingHours() >= 9.0).count();

		return (int) (res * 100) / overall;
	}

	@Override
	public Integer calculateTaskScore(Employees emp) {
		List<TaskAssignments> taskAss = emp.getAssignedTask();

		if (taskAss.size() == 0) {
			return 0;
		}

		int totalScore = 0;

		for (TaskAssignments a : taskAss) {

			if (a.getCompletedDate() == null) {
				continue;
			}

			long res = ChronoUnit.DAYS.between(a.getDueDate(), a.getCompletedDate());

			if (res < 0) {
				totalScore += 100;
			} else if (res == 0) {
				totalScore += 90;
			} else if (res <= 2) {
				totalScore += 70;

			} else {
				totalScore += 50;
			}

		}

		return (totalScore / taskAss.size());
	}

	public Double calculateOverallScoreScore(Employees empId , Integer qualityScore) {
		
		int attendace = calculateAttendanceScore(empId);
		int task = calculateTaskScore(empId);
		int feedback = calculateFeedbackScore(empId);
		
		

		 return (attendace * 0.25)
		         + (task * 0.35)
		         + (feedback * 0.20)
		         + (qualityScore * 0.20);
	}

	@Override
	public Integer calculateFeedbackScore(Employees emp) {

		List<EMPFeedBack> feedBacks = emp.getFeedBacks();

		if (feedBacks.size() == 0) {
			return 0;
		}

		int total = 0;

		for (EMPFeedBack f : feedBacks) {
			int res = f.getCommunicationScore() + f.getHelpfullnessScore() + f.getKnowledgeSharingScore()
					+ f.getTeamworkScore();

			double percentage  = (res / 400.00 )* 100;
			
			total += (int) percentage;
		}

		return total / feedBacks.size();
	}

	@Override
	public List<PerformanceReview> getAllPerformanceReviewById(Integer id) {
		// TODO Auto-generated method stub
		
		
		return performanceReviewRepository.findByEmployees_id(id);
	}

}
