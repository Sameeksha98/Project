package com.cts.demo.Employee.model;


import javax.persistence.Entity;

@Entity
public class Manager extends Employee{

	private double bonus;

	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(int id, String name, double salary, String designation) {
		super(id, name, salary, designation);
		// TODO Auto-generated constructor stub
		this.bonus = bonus;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	
	
}
