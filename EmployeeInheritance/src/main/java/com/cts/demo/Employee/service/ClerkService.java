package com.cts.demo.Employee.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.demo.Employee.dao.ClerkRepository;
import com.cts.demo.Employee.model.Clerk;
import com.cts.demo.Employee.model.Employee;

@Service
@Transactional
public class ClerkService{

	@Autowired
	private ClerkRepository clerkRepository;
	
	public Clerk addEmployee(Clerk emp) {
		return clerkRepository.save(emp);
	}
	
	public Employee deleteEmployee(int id) {
		Optional<Employee> employee = clerkRepository.findById(id);
		Employee find = null;
		if(employee.isPresent()) {
			find = employee.get();
			clerkRepository.delete(find);
		}
		return find;
	}
	
	public Employee updateEmployee(int id, Employee employee) {
		Optional<Employee> emp = clerkRepository.findById(id);
		Employee find = null;
		
		if(emp.isPresent()) {
			find = emp.get();
			return clerkRepository.save(employee);
		}
		
		return find;
	}
	
	public List<Employee> getEmployee() {
		return clerkRepository.findAll();
	}

	
}
