package com.mindtree.dao;

import com.mindtree.entity.EmployeeValidation;

public interface EmployeeValidationDao {

	String addCredentials(EmployeeValidation emp1);
	EmployeeValidation fcredentials(String sname);
	String UpdatePassword(String name, String password);
}
