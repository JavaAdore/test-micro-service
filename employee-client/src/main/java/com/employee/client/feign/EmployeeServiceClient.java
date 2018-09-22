package com.employee.client.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.employee.client.model.reponse.Employee;

@FeignClient(name="EMPLOYEE-SERVICE")
public interface EmployeeServiceClient {
	
	
	@RequestMapping(method=RequestMethod.GET, path="/employees")
	public List<Employee>findAllEmployees();
	 

}
