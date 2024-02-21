package com.example.demo.services;


import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.ProjectExceptions;
import com.example.demo.models.Project;
import com.example.demo.repositories.ProjectRepository;


@Transactional
@Service
public class ProjectServices{
	
	@Autowired
	ProjectRepository pr;
	
	public Iterable<Project> FindProject() {
		return pr.findAll();
		
	}
	
	public void deleteProject(String pid) throws ProjectExceptions{

		Optional<Project> p1 = pr.findByPid(pid);
		if(p1.isPresent() == false || p1.isEmpty())
		{
			throw new ProjectExceptions("Project: " + pid + " Not Found");
		}
		try 
		{
			pr.delete(p1.get());	
		} catch (DataIntegrityViolationException e) 
		{
			throw new ProjectExceptions("ERROR");
		}
	}
}