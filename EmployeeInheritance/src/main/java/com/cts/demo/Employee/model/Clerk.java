package com.cts.demo.Employee.model;
import javax.persistence.*;

@Entity
public class Clerk extends Employee{

	private double bonus;

	public Clerk() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Clerk(int id, String name, double salary, String designation) {
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
