package com.microservice.employee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.microservice.base.BaseEntity;

@Entity(name=Employee.ENTITY_NAME)
@Table(name=Employee.TABLE_NAME)
public class Employee extends BaseEntity{

	
	
	public final static String ENTITY_NAME ="Employee";
	public final static String TABLE_NAME ="Employee";
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="JOB")
	private String job;


	public Employee()
	{
		
	}
	public Employee(String firstName, String lastName,String job) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.job=job;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	

	
}
