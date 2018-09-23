package com.microservice.department.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.department.entity.Department;
import com.microservice.department.service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	
	@GetMapping(path="/departments")
	public List<Department> findAll()
	{
		return departmentService.findAll();
	}
	
	@GetMapping(path="departments/{id}")
	public Department findDepartment(@PathVariable("id") Long id)
	{
		return departmentService.findDepartment(id);
	}
	
	
	@PostMapping(path="/departments")
	public Department add(@RequestBody Department department)
	{
		return departmentService.add(department);
	}
	
	@PutMapping(path="/departments/{id}")
	public Department update( @PathVariable(name="id" , required=true ) Long id, @RequestBody Department department)
	{
		return departmentService.update(id , department);
	}
	
	@DeleteMapping(path="/departments/{departmentId}")
	public void delete(@PathVariable("departmentId") Long departmentId)
	{
		departmentService.delete(departmentId);
	}
	
	
}
