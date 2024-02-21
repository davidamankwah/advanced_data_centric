package com.example.demo.controllers;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Department;
import com.example.demo.services.DepartmentService;

@RestController
@Validated
public class DepartmentController{
	

	@Autowired
	DepartmentService ds;
	
	@GetMapping(path = "/api/departments")
	public Iterable<Department> getDepartment() {
		return ds.findDepartment();
	}
	
	@PutMapping(path = "/api/departments/{did}")
    public void updateDepartment(@PathVariable String did, @Valid @RequestBody Department d)
    {
        ds.updateDepartment(d, did);

    }
}