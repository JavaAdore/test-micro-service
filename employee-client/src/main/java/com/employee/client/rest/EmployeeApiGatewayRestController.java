package com.employee.client.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.employee.client.model.reponse.Employee;

@RestController
public class EmployeeApiGatewayRestController {

	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@GetMapping(path="/getMessage")
	public String getMessage()
	{
		ResponseEntity<String> resp = restTemplate.exchange("http://EMPLOYEE-SERVICE/refreshable/message", HttpMethod.GET, null, String.class);
		return resp.getBody();
	}
	
	
	@GetMapping(path="/findAllEmployees")
	public List<Employee> findAllEmployees()
	{
		ParameterizedTypeReference<Resources<Employee>> employees = new ParameterizedTypeReference<Resources<Employee>>() {};
		ResponseEntity<Resources<Employee>>  resp = restTemplate.exchange("http://EMPLOYEE-SERVICE/employees", HttpMethod.GET, null, employees);
		return resp.getBody().getContent().stream().collect(Collectors.toList());
	}
	
	
}
