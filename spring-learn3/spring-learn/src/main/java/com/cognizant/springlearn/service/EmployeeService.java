package com.cognizant.springlearn.service;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cognizant.springlearn.dao.EmployeeDAO;
import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;


@Service
public class EmployeeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
	
	@Autowired
	public EmployeeDAO employeeDAO;
	
	
	public List<Employee> getAllEmployees(){
		LOGGER.info("Start getAllEmployees");
		return employeeDAO.getAllEmployees();
	}
	
	public void updateEmployee(Employee employee) throws EmployeeNotFoundException{
		LOGGER.info("Start updateEmployees");
		employeeDAO.updateEmployee(employee);
	}
	
	public void deleteEmployee(int id) throws EmployeeNotFoundException{
		LOGGER.info("Start deleteEmployees");
		employeeDAO.deleteEmployee(id);
	}
}
