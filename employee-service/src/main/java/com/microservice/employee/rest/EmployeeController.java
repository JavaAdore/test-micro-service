package com.microservice.employee.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.employee.entity.Employee;
import com.microservice.employee.repository.EmployeeJpaRepository;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeJpaRepository employeeJpaRepository;
	
	@GetMapping(path="/employees")
	public List<Employee> findAll()
	{
		return employeeJpaRepository.findAll();
	}
	
	
	@PostMapping(path="/employees")
	public Employee add(@RequestBody Employee employee)
	{
		return employeeJpaRepository.save(employee);
	}
	
	@PutMapping(path="/employees")
	public Employee update(  @RequestBody Employee employee)
	{
		return employeeJpaRepository.save(employee);
	}
	
	@DeleteMapping(path="/employees/{employeeId}")
	public void delete(@PathVariable("employeeId") Long employeeId)
	{
		employeeJpaRepository.deleteById(employeeId);
	}
	
	
}
