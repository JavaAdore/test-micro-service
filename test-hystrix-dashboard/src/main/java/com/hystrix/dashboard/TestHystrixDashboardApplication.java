package com.hystrix.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrixDashboard
@SpringBootApplication
public class TestHystrixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestHystrixDashboardApplication.class, args);
	}
}
