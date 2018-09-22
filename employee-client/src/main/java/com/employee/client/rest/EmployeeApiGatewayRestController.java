package com.employee.client.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.employee.client.feign.EmployeeServiceClient;
import com.employee.client.model.reponse.Employee;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class EmployeeApiGatewayRestController {

	
	 
	
	@Autowired
	private EmployeeServiceClient employeeServiceClient;
	
	@GetMapping(path="/getMessage")
	public String getMessage()
	{
//		ResponseEntity<String> resp = restTemplate.exchange("http://EMPLOYEE-SERVICE/refreshable/message", HttpMethod.GET, null, String.class);
//		return resp.getBody();
		return null;
	}
	
	
//	@HystrixCommand(fallbackMethod="findAllEmployeesFallBack")
	@GetMapping(path="/findAllEmployees")
	public List<Employee> findAllEmployees()
	{
		List<Employee> res=  employeeServiceClient.findAllEmployees();
 		return res;
	}
	
	public List<Employee> findAllEmployeesFallBack()
	{
		return new ArrayList<>();
	}
	
	
}
