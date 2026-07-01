package com.employee_Manager.performance_system.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.employee_Manager.performance_system.Entity.PerformanceReview;

public interface PerformanceReviewRepository extends JpaRepository<PerformanceReview, Integer>{

	List<PerformanceReview> findByEmployees_id(Integer id);
	
	Page<PerformanceReview> findByEmployees_firstname(String firstname , Pageable pageable);

	Optional<List<PerformanceReview>> findByEmployees_Empcode(String empcode); 
}
