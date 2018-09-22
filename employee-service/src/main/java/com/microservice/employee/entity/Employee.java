package com.microservice.employee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name=Employee.ENTITY_NAME)
@Table(name=Employee.TABLE_NAME)
@NoArgsConstructor
@Data
public class Employee{
 
	 
	
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

 
	public Employee(String firstName, String lastName,String job) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.job=job;
	}
	 
	

	
}
