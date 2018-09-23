package com.microservice.department.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservice.department.entity.Department;
import com.microservice.department.repository.DepartmentJpaRepository;

@Service
public class DepartmentService {
	
	Logger logger = LoggerFactory.getLogger(DepartmentService.class);
	private final static String  DEPARTMENT_CACHE_NAME= "departmentCache";
	private static final String FIND_ALL_METHOD_NAME = "findAll";
	
	@Autowired
	private CacheManager cacheManager;
	
	@Autowired
	private DepartmentJpaRepository departmentJpaRepository;
	
	// departments usually not freuqently changed .. so it cached and will be evicted when add/update or delete
	@Cacheable(value="departmentCache" ,key="#root.methodName")
 	public List<Department> findAll()
	{
		logger.info("hitting database for fetching all department");
		return departmentJpaRepository.findAll();
	}
	
	@Cacheable(value=DEPARTMENT_CACHE_NAME, key="#id" , unless="#result==null")
 	public Department findDepartment(Long id)
	{
		logger.info("hitting database for fetching all department with id {} then put in cache if it exists", id);
		Optional<Department> d =  departmentJpaRepository.findById(id);
		return d.orElseGet(()->null);
	}
	
	@CachePut(value=DEPARTMENT_CACHE_NAME , key="#department.id")
 	public Department add(Department department)
	{
		logger.info("evitc {} method cache due add new department",FIND_ALL_METHOD_NAME);
		cacheManager.getCache(DEPARTMENT_CACHE_NAME).evict(FIND_ALL_METHOD_NAME);
 		return departmentJpaRepository.save(department);
	}
	
	@CachePut(value=DEPARTMENT_CACHE_NAME , key="#department.id")
 	public Department update(Long id, Department department)
	{
		if(null == department.getId() || id ==null || !department.getId().equals(id)  )
		{
			// will through business exception later on
			return null;
		}
		
		Optional<Department> departmentOptional = departmentJpaRepository.findById(id);

		if (!departmentOptional.isPresent()) {
			// will through business exception later on
			return null;
		}
  		department =  departmentJpaRepository.save(department);
		logger.info("evitc {} method cache due add new department",FIND_ALL_METHOD_NAME);
		cacheManager.getCache(DEPARTMENT_CACHE_NAME).evict(FIND_ALL_METHOD_NAME);
		return department;
	}
	
	@CacheEvict(value=DEPARTMENT_CACHE_NAME , key="#departmentId")
 	public void delete(Long departmentId)
	{	
		if(departmentJpaRepository.existsById(departmentId)) {
			departmentJpaRepository.deleteById(departmentId);
			cacheManager.getCache(DEPARTMENT_CACHE_NAME).evict(FIND_ALL_METHOD_NAME);

		}
	}
	
	
	
	
}
