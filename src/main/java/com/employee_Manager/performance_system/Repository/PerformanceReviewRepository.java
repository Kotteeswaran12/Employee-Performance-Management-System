package com.employee_Manager.performance_system.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee_Manager.performance_system.Entity.PerformanceReview;

public interface PerformanceReviewRepository extends JpaRepository<PerformanceReview, Integer>{

	List<PerformanceReview> findByEmployees_id(Integer id);
}
