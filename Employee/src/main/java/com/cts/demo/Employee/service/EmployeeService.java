package com.cts.demo.Employee.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.demo.Employee.dao.EmployeeRepository;
import com.cts.demo.Employee.model.Employee;

@Service
@Transactional
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee addEmployee(Employee emp) {
		return employeeRepository.save(emp);
	}
	
	public Employee deleteEmployee(int id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		Employee find = null;
		if(employee.isPresent()) {
			find = employee.get();
			employeeRepository.delete(find);
		}
		return find;
	}
	
	public Employee updateEmployee(int id, Employee employee) {
		Optional<Employee> emp = employeeRepository.findById(id);
		Employee find = null;
		
		if(emp.isPresent()) {
			find = emp.get();
			return employeeRepository.save(employee);
		}
		
		return find;
	}
	
	public List<Employee> getEmployee() {
		return employeeRepository.findAll();
	}
}
