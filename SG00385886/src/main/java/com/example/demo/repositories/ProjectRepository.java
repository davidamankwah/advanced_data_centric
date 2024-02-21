package com.example.demo.repositories;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.*;


import com.example.demo.models.Project;

public interface ProjectRepository extends CrudRepository<Project, Integer>{
	
	Optional<Project> findByPid(String pid);
	
	Optional<Project> deleteByPid(String pid);
}