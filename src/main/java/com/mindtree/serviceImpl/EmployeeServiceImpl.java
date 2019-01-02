package com.mindtree.serviceImpl;

import java.util.List;

import com.mindtree.service.EmployeeService;
import com.mindtree.dao.EmployeeDao;
import com.mindtree.daoImpl.EmployeeDaoImpl;
import com.mindtree.entity.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	EmployeeDao ed;
	
	public EmployeeServiceImpl(EmployeeDao ed) {
		this.ed = ed;
	}
	public EmployeeServiceImpl()
	{
		
	}

	public String addEmployee(Employee emp) {
		EmployeeDaoImpl ed = new EmployeeDaoImpl();
		return ed.addEmployee(emp);
	}

	public String deleteEmployee(String name) {
		EmployeeDaoImpl ed = new EmployeeDaoImpl();
		return ed.deleteEmployee(name);
	}

	public List<Employee> getAllEmployee() {
		EmployeeDaoImpl ed = new EmployeeDaoImpl();
		return ed.getAllEmployee();
	}

	public Employee getEmployeeByName(String name) {
		EmployeeDaoImpl ed = new EmployeeDaoImpl();
		return ed.getEmployeeByName(name);
	}

	public String UpdatePassword(String name, String password) {
		EmployeeDaoImpl ed = new EmployeeDaoImpl();
		return ed.UpdatePassword(name,password);
	}
}
