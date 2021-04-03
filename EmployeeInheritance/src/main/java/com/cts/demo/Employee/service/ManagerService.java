package com.cts.demo.Employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cts.demo.Employee.dao.ManagerRepository;
import com.cts.demo.Employee.model.Employee;

@Service
public class ManagerService implements EmployeeService{

	@Autowired
	private ManagerRepository managerRepository;
	
	public Employee addEmployee(Employee emp) {
		return managerRepository.save(emp);
	}
	
	public Employee deleteEmployee(int id) {
		Optional<Employee> employee = managerRepository.findById(id);
		Employee find = null;
		if(employee.isPresent()) {
			find = employee.get();
			managerRepository.delete(find);
		}
		return find;
	}
	
	public Employee updateEmployee(int id, Employee employee) {
		Optional<Employee> emp = managerRepository.findById(id);
		Employee find = null;
		
		if(emp.isPresent()) {
			find = emp.get();
			return managerRepository.save(employee);
		}
		
		return find;
	}
	
	public List<Employee> getEmployee() {
		return managerRepository.findAll();
	}
}
