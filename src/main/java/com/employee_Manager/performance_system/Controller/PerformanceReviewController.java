package com.employee_Manager.performance_system.Controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee_Manager.performance_system.DTOMapper.DTOMapper;
import com.employee_Manager.performance_system.Entity.PerformanceReview;
import com.employee_Manager.performance_system.ResponseDtoLayer.PerformanceReviewDTO;
import com.employee_Manager.performance_system.Service.PerformanceReviewService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/")
public class PerformanceReviewController {

	private final PerformanceReviewService performanceReviewServiceIMP ;
	public PerformanceReviewController(PerformanceReviewService performanceReviewServiceIMP) {
		super();
		this.performanceReviewServiceIMP = performanceReviewServiceIMP;
	}
	
	
	@Tag(name = "Manager - ONLY Access")
	@Operation(summary = "Manager Can Create a Review To They Employees" ,
	description = "by Passing the Employee ID , ManagerID , QualityScore , Remarks  !!")
	@PreAuthorize("hasRole('MANAGER')")
	@PostMapping("performanceReview/")
	public ResponseEntity<PerformanceReviewDTO> createReview(@RequestParam Integer empId,
														@RequestParam Integer managerId, 
														@RequestParam Integer qualityScore,
														@RequestParam String remarks) {
		
		return new ResponseEntity<>(
					DTOMapper.toPerformanceReviewDTO(performanceReviewServiceIMP.createReview(empId, managerId, qualityScore, remarks)) ,
					
					HttpStatus.CREATED
				);
		
	}
	
	
	

	@Tag(name = "General APIs")
	@Operation(summary = "can get all the Review ")
	@GetMapping("performanceReview")
	
	public ResponseEntity<Page<PerformanceReviewDTO>> getAllBYEmployeeId(Authentication authentication , @RequestParam(defaultValue = "0") int page , @RequestParam(defaultValue = "10")int size){
		
		Page<PerformanceReview> list = performanceReviewServiceIMP.getAllPerformanceReviewById(authentication.getName() , page , size) ;
		
		Page<PerformanceReviewDTO> dtos = list.map(DTOMapper :: toPerformanceReviewDTO);
		
		
		
		return new ResponseEntity<>(
					dtos , HttpStatus.OK
				);
	}
	
}
