package com.example.demo.repositories;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;

import com.example.demo.models.Department;


public interface DepartmentRepository extends CrudRepository<Department, Integer>{
	
	Optional<Department> findByDid(String Did);
	
	@Query(value = "select dept_id, SUM(salary) FROM employee WHERE dept_id like %:dept_id% ", nativeQuery = true)
	public Optional<Department>getTotalSalary(int Salary);
}