package com.cts.demo.Employee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.demo.Employee.model.Clerk;
import com.cts.demo.Employee.model.Employee;
import com.cts.demo.Employee.service.ClerkService;
import com.cts.demo.Employee.service.EmployeeService;
import com.cts.demo.Employee.service.ManagerService;
import com.cts.demo.Employee.service.ProgrammerService;

@RestController
public class EmployeeController {

	@Autowired
	ClerkService clerkService;
	
	@Autowired
	ProgrammerService programmerService;
	
	@Autowired
	ManagerService managerService;
	
	@PostMapping("/addClerkEmployee")
	public Clerk addClerkEmployee(@RequestBody Clerk employee) {
		
		Clerk emp = clerkService.addEmployee(employee);
		
		return emp;
		
	}
	
	@PutMapping("/updateClerkEmployee/{id}")
	public Employee updateClerkEmployee(@PathVariable int id, @RequestBody Employee employee) {
		return clerkService.updateEmployee(id, employee);
	}
	
	@DeleteMapping("/deleteClerkEmployee/{id}")
	public Employee deleteClerkEmployee(@PathVariable int id) {
		return clerkService.deleteEmployee(id);
	}
	
	@GetMapping("/getClerkEmployee")
	public List<Employee> getClerkEmployee(){
		return clerkService.getEmployee();
	}
	
	@PostMapping("/addProgrammerEmployee")
	public Employee addProgrammerEmployee(@RequestBody Employee employee) {
		
		Employee emp = programmerService.addEmployee(employee);
		
		return emp;
		
	}
	
	@PutMapping("/updateProgrammerEmployee/{id}")
	public Employee updateProgrammerEmployee(@PathVariable int id, @RequestBody Employee employee) {
		return programmerService.updateEmployee(id, employee);
	}
	
	@DeleteMapping("/deleteProgrammerEmployee/{id}")
	public Employee deleteProgrammerEmployee(@PathVariable int id) {
		return programmerService.deleteEmployee(id);
	}
	
	@GetMapping("/getProgrammerEmployee")
	public List<Employee> getProgrammerEmployee(){
		return programmerService.getEmployee();
	}
	
	
	@PostMapping("/addManagerEmployee")
	public Employee addManagerEmployee(@RequestBody Employee employee) {
		
		Employee emp = managerService.addEmployee(employee);
		
		return emp;
		
	}
	
	@PutMapping("/updateManagerEmployee/{id}")
	public Employee updateManagerEmployee(@PathVariable int id, @RequestBody Employee employee) {
		return managerService.updateEmployee(id, employee);
	}
	
	@DeleteMapping("/deleteManagerEmployee/{id}")
	public Employee deleteManagerEmployee(@PathVariable int id) {
		return managerService.deleteEmployee(id);
	}
	
	@GetMapping("/getManagerEmployee")
	public List<Employee> getManagerEmployee(){
		return managerService.getEmployee();
	}
}
