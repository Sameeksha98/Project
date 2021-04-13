package com.cognizant.springlearn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.dao.DepartmentDAO;
import com.cognizant.springlearn.model.Department;


@Service
public class DepartmentService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentService.class);
	
	@Autowired
	public DepartmentDAO departmentDAO;
	
	public List<Department> getAllDepartments(){
		LOGGER.info("Start getAllDepartments");
		return departmentDAO.getAllDepartment();
	}
}
