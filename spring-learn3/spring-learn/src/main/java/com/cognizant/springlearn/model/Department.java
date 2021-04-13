package com.cognizant.springlearn.model;


import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.cognizant.springlearn.model.Employee;


public class Department {
	
	@NotNull
	@Positive
	private int id;
	@NotNull
	@NotEmpty
	@Size(min=1, max=30)
	private String name;
	
	
	

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Department(@NotNull @Positive int id,
			@NotNull @NotEmpty @Size(min = 1, max = 30) String name) {
		super();
		this.id = id;
		this.name = name;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}

	/*
	private Set<Employee> employeeList;
	public Set<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(Set<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	*/
	
	
	
}
