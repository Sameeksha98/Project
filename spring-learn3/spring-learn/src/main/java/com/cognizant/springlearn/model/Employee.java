package com.cognizant.springlearn.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;



public class Employee {

	
	@NotNull
	@Positive
	private int id;
	
	
	
	@NotNull
	@NotEmpty
	@Size(min=1, max=30)
	private String name;

	@NotNull
	@PositiveOrZero
	private double salary;

	@NotNull
	private boolean permanent;

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	private String dateOfBirth;


	private Department department; 
	
	
	private Set<Skill> skillList;
	
	

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(@NotNull @Positive int id, @NotNull @NotEmpty @Size(min = 1, max = 30) String name,
			@NotNull @PositiveOrZero double salary, @NotNull boolean permanent, String dateOfBirth,
			Department department, Set<Skill> skillList) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.permanent = permanent;
		this.dateOfBirth = dateOfBirth;
		this.department = department;
		this.skillList = skillList;
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public boolean isPermanent() {
		return permanent;
	}

	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	
	public Set<Skill> getSkillList() {
		return skillList;
	}

	public void setSkillList(Set<Skill> skillList) {
		this.skillList = skillList;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", permanent=" + permanent
				+ ", dateOfBirth=" + dateOfBirth + ", department=" + department + "]";
	}

	
	
}
