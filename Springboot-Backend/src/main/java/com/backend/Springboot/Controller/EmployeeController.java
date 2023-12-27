package com.backend.Springboot.Controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.backend.Springboot.Repository.EmployeeRepository;
import com.backend.Springboot.entities.Employee;
import com.backend.Springboot.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api/v1/")

@CrossOrigin(origins="http://localhost:4200/")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	//Get all employess
	
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployee(){
		return employeeRepo.findAll();
	}
	
	//Post a Employee
	
	@PostMapping("/addEmployee")
	public Employee postAEmployee(@RequestBody Employee employee) {
		
		return employeeRepo.save(employee);
		
	}
	
	//Get Employee By Id
	@GetMapping("/employees/{id}")
	
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(name="id") long id) {
		
		 Employee emp = this.employeeRepo.findById(id).orElseThrow(() -> 
		 new ResourceNotFoundException("Employee does not match for id: " + id) );
		 
		 return ResponseEntity.ok(emp);
				 
		
	}
	
	//Update the data of the User
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value="id")  long id ,@RequestBody
			Employee employee){
		
		 Employee emp = this.employeeRepo.findById(id).orElseThrow(() -> 
		 new ResourceNotFoundException("Employee does not match for id: " + id) );
		 
		 emp.setFirstName(employee.getFirstName());
		 emp.setLastName(employee.getLastName());
		 emp.setEmailId(employee.getEmailId());
		 
		 Employee updatedEmployee = this.employeeRepo.save(emp);
		 
		 return ResponseEntity.ok(updatedEmployee);
		 
		 
		 
		
		
	}
	
	
	
	

}
