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
import com.microservice.department.repository.DepartmentJpaRepository;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentJpaRepository departmentJpaRepository;
	
	@GetMapping(path="/departments")
	public List<Department> findAll()
	{
		return departmentJpaRepository.findAll();
	}
	
	@GetMapping(path="departments/{id}")
	public Department findDepartment(@PathVariable("id") Long id)
	{
		return departmentJpaRepository.getOne(id);
	}
	
	
	@PostMapping(path="/departments")
	public Department add(@RequestBody Department department)
	{
		return departmentJpaRepository.save(department);
	}
	
	@PutMapping(path="/departments")
	public Department update(  @RequestBody Department department)
	{
		return departmentJpaRepository.save(department);
	}
	
	@DeleteMapping(path="/departments/{departmentId}")
	public void delete(@PathVariable("departmentId") Long departmentId)
	{
		departmentJpaRepository.deleteById(departmentId);
	}
	
	
}
