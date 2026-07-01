package com.employee_Manager.performance_system.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee_Manager.performance_system.Entity.EMPFeedBack;

public interface FeedbackRepository  extends JpaRepository<EMPFeedBack, Integer>{

	List<EMPFeedBack> findByEmployees_Departments_Dept(String dept);

	int countByEmployees_Departments_Dept(String dept);

}
