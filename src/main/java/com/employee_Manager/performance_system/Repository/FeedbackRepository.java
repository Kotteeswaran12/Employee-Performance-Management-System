package com.employee_Manager.performance_system.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee_Manager.performance_system.Entity.EMPFeedBack;

public interface FeedbackRepository  extends JpaRepository<EMPFeedBack, Integer>{

}
