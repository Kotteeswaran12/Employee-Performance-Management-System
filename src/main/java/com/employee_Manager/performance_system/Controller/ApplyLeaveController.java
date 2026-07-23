package com.employee_Manager.performance_system.Controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee_Manager.performance_system.DTOMapper.DTOMapper;
import com.employee_Manager.performance_system.DTOMapper.RequestDTOMapper;
import com.employee_Manager.performance_system.Entity.ApplyLeave;
import com.employee_Manager.performance_system.Enums.LeaveStatus;
import com.employee_Manager.performance_system.RequestDTO.ApplyLeaveRequestDTO;
import com.employee_Manager.performance_system.ResponseDtoLayer.ApplyLeaveDTO;
import com.employee_Manager.performance_system.Service.LeaveSerivece;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/")
public class ApplyLeaveController {

    private final LeaveSerivece leaveSerivece;
    private final RequestDTOMapper requestdtoMapper;

    public ApplyLeaveController(LeaveSerivece leaveSerivece, RequestDTOMapper requestdtoMapper) {
        super();
        this.leaveSerivece = leaveSerivece;
        this.requestdtoMapper = requestdtoMapper;
    }

    @Tag(name = "General APIs")
    @Operation(
            summary = "Get all the Employee Leaves !!", description = "all all Employee Leave by the Id"
    )
    @GetMapping("/leave")
    public ResponseEntity<Page<ApplyLeaveDTO>> getAllEmployeeLeavesByEmpId(Authentication authentication, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {

        Page<ApplyLeave> leaves = leaveSerivece.getAllEmployeeLeavesByEmployeeName(authentication.getName(), page, size);

        Page<ApplyLeaveDTO> dtoLeave = leaves.map(DTOMapper::toApplyLeaveDto);

        return new ResponseEntity<>(dtoLeave, HttpStatus.OK);
    }

	@Tag(name = "ADMIN - Only Access")
	@Operation(summary= "Get all the Leave Request ")
	@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/leaves")
    public ResponseEntity<Page<ApplyLeaveDTO>> getalltheLeaveRequest(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {

        Page<ApplyLeave> leaves = leaveSerivece.getAllEmployeeLeavesRequest( page, size);

        Page<ApplyLeaveDTO> dtoLeave = leaves.map(DTOMapper::toApplyLeaveDto);

        return new ResponseEntity<>(dtoLeave, HttpStatus.OK);
    }

    @Tag(name = "Manager - ONLY Access")
    @Operation(summary = "Upadte the Leave Status for Employe", description = "By using the Employee ID")
    @PreAuthorize("hasRole('MANAGER')")
    @PostMapping("/leave")
    ResponseEntity<ApplyLeaveDTO> setLeaveStatus(@RequestParam Integer id, @RequestParam LeaveStatus leaveStatus,
            Authentication authentication) {
        return new ResponseEntity<>(
                DTOMapper.toApplyLeaveDto(leaveSerivece.setLeaveStatus(id, leaveStatus, authentication.getName())),
                HttpStatus.OK);
    }

//	Employee Functions
    @Tag(name = "Employee - ONLY Access")
    @Operation(summary = "Apply For Leave", description = "By Passing the Leave Details in Body !!")
    @PreAuthorize("hasRole('EMPLOYEE')")
    @PostMapping("/leave/apply")
    ResponseEntity<ApplyLeaveDTO> applyForLeave(@RequestBody ApplyLeaveRequestDTO leave,
            Authentication authentication) {

        String username = authentication.getName();

//		System.out.println(authentication.getDetails() + "\t\t");
        return new ResponseEntity<>(
                DTOMapper.toApplyLeaveDto(
                        leaveSerivece.applyForLeave(requestdtoMapper.toApplyLeaveEntity(leave), username)),
                HttpStatus.CREATED);
    }

    @Tag(name = "Employee - ONLY Access")
    @Operation(summary = "WithDraw the  Leave", description = "By Passing the Leave ID!!")
    @PreAuthorize("hasRole('EMPLOYEE')")
    @DeleteMapping("/leave/{id}")
    ResponseEntity<String> withDrawlLeaveById(@PathVariable Integer id) {

        leaveSerivece.withDrawlLeaveById(id);
        return new ResponseEntity<>("Sucessfully Withdrawed your Leave !!", HttpStatus.OK);
    }

    @Tag(name = "Employee - ONLY Access")
    @Operation(summary = "Get the Leave Status for the Leave", description = "By Passing the Leave ID  !!")
    @PreAuthorize("hasRole('EMPLOYEE')")
    @GetMapping("/leave/{id}")
    ResponseEntity<LeaveStatus> getLeaveStatusById(@PathVariable Integer id) {
        return new ResponseEntity<>(leaveSerivece.getLeaveStatusById(id), HttpStatus.OK);
    }

}
