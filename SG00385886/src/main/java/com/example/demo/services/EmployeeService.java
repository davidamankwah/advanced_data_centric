package com.example.demo.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import javax.transaction.Transactional;

import com.example.demo.exceptions.EmployeeExceptions;
import com.example.demo.models.Employee;
import com.example.demo.repositories.EmployeeRepository;

@Transactional
@Service
public class EmployeeService{
	
	@Autowired
	EmployeeRepository er;
	
	// Find all
	public Iterable<Employee> findEmployee() {
		return er.findAll();
	}
	
	// Save Employee
	public void save(Employee s) throws EmployeeExceptions {
		try {
			// save salesperson
			er.save(s);
		} catch (DataIntegrityViolationException e) {
			// if the salesperson already exists this message will be thrown
			throw new EmployeeExceptions("Employee " + s.getEid() + " already exists");
		}
	}
	
	// Add EMployee
	public void addEmployee(Employee e) throws EmployeeExceptions {
		try {
			//Save Employee
			er.save(e);
		} catch (DataIntegrityViolationException e1) {
			throw new EmployeeExceptions("Salesperson " + e.getEid() + " already exists");
		}
	}
	
	// Delete Employee
	public void deleteEmployee(String eid) throws EmployeeExceptions{

		Optional<Employee> e1 = er.findByEid(eid);
		if(e1.isPresent() == false || e1.isEmpty())
		{
			throw new EmployeeExceptions("Employee: " + eid + " Not Found");
		}
		er.delete(e1.get());
		
	}
	
	

	
}