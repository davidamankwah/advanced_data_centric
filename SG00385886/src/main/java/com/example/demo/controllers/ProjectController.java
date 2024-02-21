package com.example.demo.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.exceptions.EmployeeExceptions;
import com.example.demo.exceptions.ProjectExceptions;
import com.example.demo.models.Project;
import com.example.demo.services.ProjectServices;

@RestController
@Validated
public class ProjectController{
	

	@Autowired
	ProjectServices ps;
	
	@GetMapping(path = "/api/projects")
	public Iterable<Project> getDepartment() {
		return ps.FindProject();
	}
	
	@DeleteMapping(path = "/api/projects/{pid}")
	public void deleteEmployee(@PathVariable String pid) {
		try
		{
			ps.deleteProject(pid);
		}
		catch(ProjectExceptions e) 
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	
}