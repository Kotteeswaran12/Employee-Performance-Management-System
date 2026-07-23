package com.employee_Manager.performance_system.Controller;

import java.time.LocalDate;

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
import com.employee_Manager.performance_system.Entity.Attendance;
import com.employee_Manager.performance_system.ResponseDtoLayer.AttendanceDTO;
import com.employee_Manager.performance_system.Service.AttendanceService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/")
public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        super();
        this.attendanceService = attendanceService;
    }

    @Tag(name = "Employee - ONLY Access")
    @Operation(summary = "Employee can Check - In for a Work", description = "Employee can Only Check-IN only once in a Day !!")
    // @PreAuthorize("hasRole('EMPLOYEE')")
    @PostMapping("attendance/check-in")
    public ResponseEntity<AttendanceDTO> checkIn(Authentication authentication) {

        System.out.println("Hello");
        System.out.println("Authentication = " + authentication);

        if (authentication != null) {
            System.out.println("Name = " + authentication.getName());
            System.out.println("Authorities = " + authentication.getAuthorities());
        }

        return new ResponseEntity<>(DTOMapper.toAttendaceDTO(attendanceService.checkIn(authentication.getName())),
                HttpStatus.OK);

    }

    @Tag(name = "Employee - ONLY Access")
    @Operation(summary = "Employee can Check - Out at End of the Day", description = "Employee can Only Check-OUT only once in a Day !!")
    @PreAuthorize("hasRole('EMPLOYEE')")
    @PostMapping("attendance/check-out")
    public ResponseEntity<AttendanceDTO> checkOut(Authentication authentication) {
        System.out.println(authentication);
        return new ResponseEntity<>(
                DTOMapper.toAttendaceDTO(attendanceService.checkOutAndCalculateWorkingHours(authentication.getName())),
                HttpStatus.OK);

    }

    @Tag(name = "Employee - ONLY Access")
    @Operation(summary = "Employee can get all the Attendance Details", description = "Employee can See the Working Hours and Ddeatils of they Attendance !!")
    @PreAuthorize("hasRole('EMPLOYEE')")
    @GetMapping("attendance/")
    public ResponseEntity<Page<AttendanceDTO>> getAllAttendaceByEmployeeId(Authentication authentication, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {

        System.out.println("Hello");

        Page<Attendance> att = attendanceService.getAllAttendaceByEmployeeId(authentication.getName(), page, size);

        Page<AttendanceDTO> attenDto = att.map(DTOMapper::toAttendaceDTO);

        return new ResponseEntity<>(attenDto, HttpStatus.OK);

    }

    @Tag(name = "Employee - ONLY Access")
    @Operation(summary = "Employee can Filter the attendacen by Srating Date and Endig Date", description = "Employee can Only Check-OUT only once in a Day !!")
    @PreAuthorize("hasRole('EMPLOYEE')")
    @PostMapping("attendance")
    public ResponseEntity<Page<AttendanceDTO>> filterAttendanceByEndingAndStaringDates(Authentication authentication,
             @RequestParam LocalDate startingDate,
            @RequestParam LocalDate endingDate,
            @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {

        Page<Attendance> pageAttendace = attendanceService.filterAttendanceByEndingAndStaringDates(authentication.getName(), startingDate, endingDate, page, size);
        return new ResponseEntity<>(
                pageAttendace.map(DTOMapper::toAttendaceDTO),
                HttpStatus.OK);

    }

}
