package com.microservice.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.microservice.department.entity.Department;

@Repository
public interface DepartmentJpaRepository extends JpaRepository<Department, Long> {

}