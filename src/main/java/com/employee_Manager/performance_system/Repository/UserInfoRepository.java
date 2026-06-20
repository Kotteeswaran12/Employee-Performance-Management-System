package com.employee_Manager.performance_system.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee_Manager.performance_system.Entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer>{

	Optional<UserInfo> findByUsername(String username);
}
