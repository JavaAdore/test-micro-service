package com.microservice.department;

import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.microservice.department.entity.Department;
import com.microservice.department.repository.DepartmentJpaRepository;

@EnableCaching
@SpringBootApplication
@EnableDiscoveryClient
public class DepartmentServiceApplication {
	
	Logger logger = LoggerFactory.getLogger(DepartmentServiceApplication.class);
	
	public static void main(String ...args)
	{
        SpringApplication.run(DepartmentServiceApplication.class, args);

	}
	
	@Bean 
	CommandLineRunner commandLinerRunner(DepartmentJpaRepository departmentJpaRestRepository)
	{
		logger.info("start initializing test data");
		return strings ->
		{
 			Stream.of(new Department("IT")  ,
					  new Department("Marketing"),
					  new Department("Sales") )
			.forEach(e->departmentJpaRestRepository.save(e));
			
 			logger.info("test data has been initialized successfully");

			
		};
		
	}
 }


