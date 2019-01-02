package com.mindtree.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowMapper implements RowMapper<Employee> {

	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee e = new Employee();
		e.setName(rs.getString(1));
		e.setPassword(rs.getString(2));
		e.setFullName(rs.getString(3));
		e.setEmailid(rs.getString(4));
		e.setDob(rs.getString(5));
		e.setGender(rs.getString(6));
		e.setSecurityQuestion(rs.getString(7));
		e.setSecurityAnswer(rs.getString(8));
		//e.setType(rs.getString(9));
		return e;
	}

}
