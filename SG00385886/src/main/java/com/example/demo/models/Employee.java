package com.example.demo.models;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import com.example.demo.models.validations.EmployeePOSTValidations;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Employee {
	
	@Id		
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private int id;
	@NotNull(message = "eid be provided", groups = EmployeePOSTValidations.class)
	@Column(unique = true)
	@NotNull(message = "eid must be specified", groups = EmployeePOSTValidations.class)
	private String eid;
	@NotNull(message = "eid must be specified", groups = EmployeePOSTValidations.class)
	private String name;
	@Min(value = 20000, groups = EmployeePOSTValidations.class)
	private double salary;
	@ManyToOne
	@JoinColumn
	@JsonIgnore
	private Department dept;
	@ManyToMany
	@JsonIgnore
	private List<Project> projects;
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

}
