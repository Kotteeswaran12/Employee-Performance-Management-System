package com.employee_Manager.performance_system.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee_Manager.performance_system.DtoLayer.EMPFeedBackDTO;
import com.employee_Manager.performance_system.Entity.EMPFeedBack;
import com.employee_Manager.performance_system.Service.FeedbackServiceIMP;
import com.employee_Manager.performance_systemDTOMapper.DTOMapper;

@RestController
@RequestMapping("/api/feedback")
public class EMPFeedBackController {

	private final FeedbackServiceIMP feedbackServiceIMP;

	public EMPFeedBackController(FeedbackServiceIMP feedbackServiceIMP) {
		super();
		this.feedbackServiceIMP = feedbackServiceIMP;
	}

	@PostMapping("/add")
	public ResponseEntity<EMPFeedBackDTO> addFeedbacksToEmployee(@RequestParam Integer givenTo,
			@RequestParam Integer givenBy, @RequestBody EMPFeedBack feedback) {

		return new ResponseEntity<>(
				DTOMapper.toFeedBackDto(feedbackServiceIMP.addFeedbacksToEmployee(givenTo, givenBy, feedback)),
				HttpStatus.CREATED);
	}

	@GetMapping("/getall-by/{id}")
	public ResponseEntity<List<EMPFeedBackDTO>> getAllFeedbackByEmpId(@PathVariable Integer id) {

		List<EMPFeedBack> feedback = feedbackServiceIMP.getAllFeedbackByEmpId(id);

		List<EMPFeedBackDTO> dto = new ArrayList<>();

		for (EMPFeedBack f : feedback) {

			dto.add(DTOMapper.toFeedBackDto(f));
		}

		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

}
