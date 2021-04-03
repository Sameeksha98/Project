package com.cts.demo.Employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.cts.demo.Employee.model.Employee;
import org.springframework.stereotype.Repository;

@NoRepositoryBean
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
