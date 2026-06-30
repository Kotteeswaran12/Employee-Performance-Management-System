package com.employee_Manager.performance_system.SwaggerConfig;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.tags.Tag;

@Configuration
public class SwaggerConfiguration {

	
	@Bean
	public OpenAPI customeOpenApi() {
		
		final String securiySchemeName = "Bearer Authentication";
		
		return new OpenAPI()
			
				.info(new Info()
						
						.title("Employee Management API")
						.version("1.0")
						.description("Backend REST API for an Employee Performance Management System built using Spring Boot, Spring Security (JWT), JPA/Hibernate, and MySQL.")
						 .contact( new Contact()
								 		.name("Kotteeswaran V")
								 		.email("Kotteeswaran2601@gmail.com")
								 		.url("https://github.com/Kotteeswaran12/Employee-Performance-Management-System")
								 
								 )
						)
				
				.tags(List.of(
						new  Tag().name("Log-in || Sign-Up"),
						new  Tag().name("ADMIN - ONLY Access"),
						new  Tag().name("Manager - ONLY Access"),
						new  Tag().name("Employee - ONLY Access"),
						new  Tag().name("General APIs")
						
						))
				.addSecurityItem(
						new SecurityRequirement()
						.addList(securiySchemeName)
						)
				.schemaRequirement(securiySchemeName, 
						new SecurityScheme()
							.name(securiySchemeName)
							.type(SecurityScheme.Type.HTTP)
							.scheme("Bearer")
							.bearerFormat("jwt")
						);
	}
	
}
