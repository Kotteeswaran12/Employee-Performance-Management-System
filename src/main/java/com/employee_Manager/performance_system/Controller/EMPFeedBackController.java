package com.employee_Manager.performance_system.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee_Manager.performance_system.DTOMapper.DTOMapper;
import com.employee_Manager.performance_system.DTOMapper.RequestDTOMapper;
import com.employee_Manager.performance_system.Entity.EMPFeedBack;
import com.employee_Manager.performance_system.RequestDTO.EMPFeedBackRequestDTO;
import com.employee_Manager.performance_system.ResponseDtoLayer.EMPFeedBackDTO;
import com.employee_Manager.performance_system.Service.FeedbackService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/")
public class EMPFeedBackController {

	private final RequestDTOMapper requestDTOMapper;
	private final FeedbackService feedbackServiceIMP;

	public EMPFeedBackController(RequestDTOMapper requestDTOMapper, FeedbackService feedbackServiceIMP) {
		super();
		this.requestDTOMapper = requestDTOMapper;
		this.feedbackServiceIMP = feedbackServiceIMP;
	}

	@Tag(name = "Manager - ONLY Access")
	@Operation(summary = "Manaer can add Feed Backs to the Employe", description = "Manager can Give Feedback only to they subordinator !!")
	@PreAuthorize("hasRole('MANAGER')")
	@PostMapping("feedback")
	public ResponseEntity<EMPFeedBackDTO> addFeedbacksToEmployee(@RequestParam Integer givenTo,
			Authentication authentication, @RequestBody EMPFeedBackRequestDTO feedback) {

		return new ResponseEntity<>(DTOMapper.toFeedBackDto(feedbackServiceIMP.addFeedbacksToEmployee(givenTo,
				authentication.getName(), requestDTOMapper.toFeedBackEntity(feedback))), HttpStatus.CREATED);
	}

	@Tag(name = "General APIs")
	@Operation(summary = "Can Get the all Feebacks ")
	@GetMapping("feedback")
	public ResponseEntity<List<EMPFeedBackDTO>> getAllFeedbackByEmpId(Authentication authentication) {

		List<EMPFeedBack> feedback = feedbackServiceIMP.getAllFeedbackByEmpId(authentication.getName());

		List<EMPFeedBackDTO> dto = new ArrayList<>();

		for (EMPFeedBack f : feedback) {

			dto.add(DTOMapper.toFeedBackDto(f));
		}

		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@Tag(name = "ADMIN - ONLY Access")
	@Operation(summary = "Get All Employee FeedBacks")
	@GetMapping("feeback")
	public ResponseEntity<Page<EMPFeedBackDTO>> getallFeedback(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {

		Page<EMPFeedBack> feedback = feedbackServiceIMP.getAllFeedback(page, size);

		Page<EMPFeedBackDTO> dto = feedback.map(DTOMapper::toFeedBackDto);

		return new ResponseEntity<>(dto, HttpStatus.OK);

	}

}
