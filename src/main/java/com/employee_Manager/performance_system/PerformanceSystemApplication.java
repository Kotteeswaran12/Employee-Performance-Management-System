package com.employee_Manager.performance_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication

@CrossOrigin (origins = "https://employee-performance-management-ui-xi.vercel.app/")
public class PerformanceSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PerformanceSystemApplication.class, args);
	}

}