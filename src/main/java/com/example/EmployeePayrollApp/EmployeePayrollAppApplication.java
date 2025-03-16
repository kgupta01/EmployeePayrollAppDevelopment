package com.example.EmployeePayrollApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.EmployeePayrollApp.repository") // Ensures repository scanning
public class EmployeePayrollAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(EmployeePayrollAppApplication.class, args);
	}
}