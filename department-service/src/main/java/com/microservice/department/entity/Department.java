package com.microservice.department.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name=Department.ENTITY_NAME)
@Table(name=Department.TABLE_NAME)
@NoArgsConstructor
@Data
public class Department{

	
	
	public final static String ENTITY_NAME ="DEPARTMENT";
	public final static String TABLE_NAME ="DEPARTMENT";
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="NAME")
	private String departmentName;
	
	
	public Department(String departmentName) {
		super();
		this.departmentName = departmentName;
	}
	
	
	

	 
	 
	

	
}
