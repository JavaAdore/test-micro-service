package com.employee.client.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
	
}
