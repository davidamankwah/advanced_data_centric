package com.example.demo.controllers;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.exceptions.EmployeeExceptions;
import com.example.demo.models.Employee;
import com.example.demo.models.validations.EmployeePOSTValidations;
import com.example.demo.services.EmployeeService;

@RestController
@Validated
public class EmployeeController{
	
	@Autowired
	EmployeeService es;
	
	@GetMapping(path = "/api/employees")
	public Iterable<Employee> getEmployee() {
		return es.findEmployee();
	}
	
	@Validated(EmployeePOSTValidations.class)
	@PostMapping(path = "/api/employees",consumes={"application/json"})
	public void addEmployee(@Valid @RequestBody Employee s ) throws EmployeeExceptions {
		try 
		{
			es.save(s);
		} 
		catch (EmployeeExceptions e) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());

		}
	}
	
	@DeleteMapping(path = "/api/employees/{eid}")
	public void deleteEmployee(@PathVariable String eid) {
		try
		{
			es.deleteEmployee(eid);
		}
		catch(EmployeeExceptions e) 
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
}
