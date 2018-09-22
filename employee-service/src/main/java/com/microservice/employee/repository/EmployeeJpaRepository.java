package com.microservice.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.microservice.employee.entity.Employee;

@Repository
public interface EmployeeJpaRepository extends JpaRepository<Employee, Long> {

}