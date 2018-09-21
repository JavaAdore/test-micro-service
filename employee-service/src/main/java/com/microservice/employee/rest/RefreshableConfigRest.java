package com.microservice.employee.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping(path="/refreshable")
public class RefreshableConfigRest {

	
	@Value("${refreshableMessage}")
	private String message;
	
	@GetMapping(path="/message")
	public String getMessage()
	{
		return this.message;
		
	}
	
}
