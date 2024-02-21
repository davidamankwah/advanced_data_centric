package com.example.demo.exceptions;
import org.springframework.http.HttpStatus;

public class EmployeeExceptions extends Exception {
	
	public EmployeeExceptions(String s) {
		super(s);
	}

}