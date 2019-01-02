package com.mindtree.serviceImpl;

import com.mindtree.daoImpl.EmployeeValidationDaoImpl;
import com.mindtree.entity.EmployeeValidation;
import com.mindtree.service.EmployeeValidationService;

public class EmployeeValidationServiceImpl implements EmployeeValidationService {

	public String addCredentials(EmployeeValidation emp1) {
		EmployeeValidationDaoImpl ed = new EmployeeValidationDaoImpl();
		return ed.addCredentials(emp1);
	}

	public EmployeeValidation fcredentials(String sname) {
		EmployeeValidationDaoImpl ed = new EmployeeValidationDaoImpl();
		return ed.fcredentials(sname);
	}

	public String UpdatePassword(String name, String password) {
		EmployeeValidationDaoImpl ed = new EmployeeValidationDaoImpl();
		return ed.UpdatePassword(name, password);
	}

}
