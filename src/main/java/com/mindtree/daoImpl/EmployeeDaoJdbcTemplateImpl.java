package com.mindtree.daoImpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.mindtree.dao.EmployeeDao;
import com.mindtree.entity.Employee;
import com.mindtree.entity.EmployeeRowMapper;

@Component
public class EmployeeDaoJdbcTemplateImpl implements EmployeeDao {

	JdbcTemplate jdbcTemplate;
	
	private final String SQL_FIND_PERSON = "select * from employee where id = ?";
	private final String SQL_DELETE_PERSON = "delete from employee where id = ?";
	private final String SQL_UPDATE_PERSON = "update employee set password = ? where name = ?";
	private final String SQL_GET_ALL = "select * from employee";
	private final String SQL_INSERT_PERSON = "insert into employee(name, password, fullName, emailid, dob, gender, securityQuestion, securityAnswer) values(?,?,?,?,?,?,?,?)";

	@Autowired
	public EmployeeDaoJdbcTemplateImpl(DataSource dataSource)
	{
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	public String addEmployee(Employee emp) {
		return null;
	}

	public String deleteEmployee(String name) {
		int i = jdbcTemplate.update(SQL_DELETE_PERSON, new Object[] {name}); 
		String msg = "";
		if(i == 1)
		{
			msg = "Deleted successfully...";
		}
		return msg;
	}

	public List<Employee> getAllEmployee() {

		return jdbcTemplate.query(SQL_GET_ALL, new EmployeeRowMapper());
	}

	public Employee getEmployeeByName(String name) {
		
		
		return jdbcTemplate.queryForObject(SQL_FIND_PERSON, new Object[] {name},new EmployeeRowMapper());
	}

	public String UpdatePassword(String name, String password) {
		int i = jdbcTemplate.update(SQL_UPDATE_PERSON, new Object[] {password,name});
		String msg = "";
		if(i == 1)
		{
			msg = "Updated Successfully...";
		}
		else {
			msg="Couldn't update...";
		}
		return msg;
	}

}
