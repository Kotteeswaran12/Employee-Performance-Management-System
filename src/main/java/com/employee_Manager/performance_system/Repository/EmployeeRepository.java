package com.employee_Manager.performance_system.Repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employee_Manager.performance_system.Entity.ApplyLeave;
import com.employee_Manager.performance_system.Entity.Employees;
import com.employee_Manager.performance_system.Enums.RoleTypes;

@Repository
public interface EmployeeRepository extends JpaRepository<Employees, Integer> {

    Optional<Employees> findByEmpcode(String empcode);

    Optional<Employees> findByFirstname(String username);

    long countByUser_Role(RoleTypes manager);

    Page<Employees> findByManager(Employees empManager, Pageable pageable);

    @Query("""
			select e.departments.dept , count(e) from Employees e
			group By e.departments.dept
			""")
    Object[] countAllByDepartments();

    @Query("""
			select l
			from ApplyLeave l
			where l.employees.id in ( select e.id from Employees e
							where e.manager.id = ( select m.id from Employees m where m.firstname = ?1 )
			
				)
			""")
    Page<ApplyLeave> getAllSubordinateLeaves(String Managername, Pageable pageable);

}
