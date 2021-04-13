package com.cognizant.springlearn.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.springlearn.model.Department;


@Component
public class DepartmentDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentDAO.class);
	public static List<Department> DEPARTMENT_LIST;
	
	public DepartmentDAO() {
		LOGGER.info("Start DepartmentDAO constructor");
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		
		DEPARTMENT_LIST = (ArrayList<Department>) context.getBean("departmentList");
	}
	
	public List<Department> getAllDepartment(){
		LOGGER.info("Start getAllDepartment");
		return DEPARTMENT_LIST;
	}
}
