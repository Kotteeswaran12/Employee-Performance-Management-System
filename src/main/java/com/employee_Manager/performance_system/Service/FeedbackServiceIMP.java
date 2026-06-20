package com.employee_Manager.performance_system.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee_Manager.performance_system.Entity.EMPFeedBack;
import com.employee_Manager.performance_system.Entity.Employees;
import com.employee_Manager.performance_system.Exceptions.EmployeeNotFoundException;
import com.employee_Manager.performance_system.Repository.EmployeeRepository;
import com.employee_Manager.performance_system.Repository.FeedbackRepository;

@Service
public class FeedbackServiceIMP implements FeedbackService {

	private final EmployeeRepository employeeRepository;

	private final FeedbackRepository feedbackpository;

	public FeedbackServiceIMP(EmployeeRepository employeeRepository, FeedbackRepository feedbackpository) {
		super();
		this.employeeRepository = employeeRepository;
		this.feedbackpository = feedbackpository;
	}

	@Override
	public EMPFeedBack addFeedbacksToEmployee(Integer to, Integer from, EMPFeedBack feedback) {
		Employees employees = employeeRepository.findById(to)
				.orElseThrow(() -> new EmployeeNotFoundException("Manager OR UserNot Found !!"));
		Employees manager = employeeRepository.findById(from)
				.orElseThrow(() -> new EmployeeNotFoundException("Manager OR UserNot Found !!"));

		if (!employees.getManager().getId().equals(manager.getId())) {

			throw new RuntimeException("Only assigned manager can review employee");
		}

		employees.getFeedBacks().add(feedback);

		feedback.setEmployees(employees);
		feedback.setReviewedBy(manager);

		return feedbackpository.save(feedback);

	}

	@Override
	public List<EMPFeedBack> getAllFeedbackByEmpId(Integer id) {
		Employees employees = employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Manager OR UserNot Found !!"));
		
		
		return employees.getFeedBacks();
	}
}
