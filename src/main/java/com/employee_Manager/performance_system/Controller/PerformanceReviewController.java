package com.employee_Manager.performance_system.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee_Manager.performance_system.DtoLayer.PerformanceReviewDTO;
import com.employee_Manager.performance_system.Entity.PerformanceReview;
import com.employee_Manager.performance_system.Service.PerformanceReviewServiceIMP;
import com.employee_Manager.performance_systemDTOMapper.DTOMapper;

@RestController
@RequestMapping("/api/performanceReview")
public class PerformanceReviewController {

	private final PerformanceReviewServiceIMP performanceReviewServiceIMP ;

	public PerformanceReviewController(PerformanceReviewServiceIMP performanceReviewServiceIMP) {
		super();
		this.performanceReviewServiceIMP = performanceReviewServiceIMP;
	}
	
	
	
	@PostMapping("/add-review")
	public ResponseEntity<PerformanceReviewDTO> createReview(@RequestParam Integer empId,
														@RequestParam Integer managerId, 
														@RequestParam Integer qualityScore,
														@RequestParam String remarks) {
		
		return new ResponseEntity<>(
					DTOMapper.toPerformanceReviewDTO(performanceReviewServiceIMP.createReview(empId, managerId, qualityScore, remarks)) ,
					
					HttpStatus.CREATED
				);
		
	}
	
	@GetMapping("/get-all/{id}")
	
	public ResponseEntity<List<PerformanceReviewDTO>> getAllBYEmployeeId(@PathVariable Integer id){
		
		List<PerformanceReview> list = performanceReviewServiceIMP.getAllPerformanceReviewById(id) ;
		
		List<PerformanceReviewDTO> dtos = new ArrayList<>();
		
		for(PerformanceReview l : list) {
			dtos.add(DTOMapper.toPerformanceReviewDTO(l));
		}
		
		
		return new ResponseEntity<>(
					dtos , HttpStatus.OK
				);
	}
	
}
