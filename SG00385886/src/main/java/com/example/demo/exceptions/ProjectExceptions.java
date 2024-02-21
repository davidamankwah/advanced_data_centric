package com.example.demo.exceptions;
import org.springframework.http.HttpStatus;

public class ProjectExceptions extends Exception {
	
	public ProjectExceptions(String s) {
		super(s);
	}

}