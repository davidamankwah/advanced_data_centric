package com.example.demo.repositories;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.*;

import com.example.demo.models.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{
	
	Optional<Employee> deleteByEid(String eid);
	
	Optional<Employee> findByEid(String Eid);
}