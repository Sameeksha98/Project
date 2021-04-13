package com.cognizant.springlearn.model;

import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;


public class Skill {


	@NotNull
	@Positive
	private int id;
	@NotNull
	@NotEmpty
	@Size(min=1, max=30)
	private String name;
	
	

	
	public Skill(@NotNull @Positive int id, @NotNull @NotEmpty @Size(min = 1, max = 30) String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Skill() {
		super();
		// TODO Auto-generated constructor stub
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

	/*private Set<Employee> employeeList;
	public Set<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(Set<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	*/
	@Override
	public String toString() {
		return "Skill [id=" + id + ", name=" + name +"]";
	}
	
	
}
