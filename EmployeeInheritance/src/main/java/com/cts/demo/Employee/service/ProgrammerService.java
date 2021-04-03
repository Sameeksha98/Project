package com.cts.demo.Employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.demo.Employee.dao.ProgrammerRepository;
import com.cts.demo.Employee.model.Employee;

@Service
public class ProgrammerService implements EmployeeService{

	@Autowired
	private ProgrammerRepository programmerRepository;
	
	public Employee addEmployee(Employee emp) {
		return programmerRepository.save(emp);
	}
	
	public Employee deleteEmployee(int id) {
		Optional<Employee> employee = programmerRepository.findById(id);
		Employee find = null;
		if(employee.isPresent()) {
			find = employee.get();
			programmerRepository.delete(find);
		}
		return find;
	}
	
	public Employee updateEmployee(int id, Employee employee) {
		Optional<Employee> emp = programmerRepository.findById(id);
		Employee find = null;
		
		if(emp.isPresent()) {
			find = emp.get();
			return programmerRepository.save(employee);
		}
		
		return find;
	}
	
	public List<Employee> getEmployee() {
		return programmerRepository.findAll();
	}
}
