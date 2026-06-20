package com.employee_Manager.performance_system.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee_Manager.performance_system.Entity.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer>{

	Optional<Attendance> findByEmployeesIdAndAttendanceDate(Integer id  , LocalDate date);
	List<Attendance> findByEmployeesId(Integer id );
}
