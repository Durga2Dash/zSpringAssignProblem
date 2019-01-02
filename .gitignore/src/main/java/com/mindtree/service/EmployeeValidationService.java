package com.mindtree.service;

import com.mindtree.entity.EmployeeValidation;

public interface EmployeeValidationService {

	String addCredentials(EmployeeValidation emp1);
	EmployeeValidation fcredentials(String sname);
	String UpdatePassword(String name, String password);
}
