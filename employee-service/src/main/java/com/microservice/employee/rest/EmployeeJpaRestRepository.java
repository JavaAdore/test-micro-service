package com.microservice.employee.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.microservice.employee.entity.Employee;

@RepositoryRestResource
public interface EmployeeJpaRestRepository extends JpaRepository<Employee, Long> {

}