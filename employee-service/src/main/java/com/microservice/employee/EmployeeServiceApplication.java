package com.microservice.employee;

import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.microservice.employee.entity.Employee;
import com.microservice.employee.repository.EmployeeJpaRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class EmployeeServiceApplication {
	
	Logger logger = LoggerFactory.getLogger(EmployeeServiceApplication.class);
	
	public static void main(String ...args)
	{
        SpringApplication.run(EmployeeServiceApplication.class, args);

	}
	
	@Bean 
	CommandLineRunner commandLinerRunner(EmployeeJpaRepository employeeJpaRestRepository)
	{
		logger.info("start initializing test data");
		return strings ->
		{
 			Stream.of(new Employee("Mahmoud","Mohamed","Developer")  ,
					  new Employee("Matt","Adams","Business Analyst"),
					  new Employee("Tom","Tomson","Project Manager") )
			.forEach(e->employeeJpaRestRepository.save(e));
			
 			logger.info("test data has been initialized successfully");

			
		};
		
	}
 }


