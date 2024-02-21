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
import com.example.demo.models.Department;
import com.example.demo.models.Employee;
import com.example.demo.repositories.DepartmentRepository;


@Transactional
@Service
public class DepartmentService{
	
	@Autowired
	DepartmentRepository dr;
	
	public Iterable<Department> findDepartment() {
		return dr.findAll();
		
	}
	
	public Department updateDepartment(Department dept, String did) {
		if (dept.getDid() != null) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"update.department.did: did must not be provided ");
		}
	
		Optional<Department> department = dr.findByDid(did);
		
		if (department.isPresent()) 
		{
			department.get().setName(dept.getName());
			department.get().setLocation(dept.getLocation());
			
			Department dp = dr.save(department.get());
			return dp;
		} else 
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Department did:  " + did + " Doesn't Exist");
		}
	}

	/*public Iterable<Department> getDepartmentSalary(String did) {
		Optional<Department> e1 = dr.findByDid(did);
		dr.totalSalary(did);
		
		return null;
	}*/

	
}