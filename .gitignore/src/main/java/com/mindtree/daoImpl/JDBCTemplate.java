package com.mindtree.daoImpl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mindtree.dao.EmployeeDao;
import com.mindtree.entity.Employee;
import com.mindtree.entity.EmployeeRowMapper;

public class JDBCTemplate implements EmployeeDao {
	//private DataSource dataSource;
	private JdbcTemplate template;
	
	public JDBCTemplate() {
		super();
	}
	
	public void JDBCTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public void setTemplate(JdbcTemplate template)
	{
		this.template = template;
	}
	public JdbcTemplate getTemplate()
	{
		return template;
	}
	
	public String addEmployee(Employee emp) {
		String query = "insert into employee values (?,?,?,?,?,?,?,?)";
		template.update(query, emp.getName(),emp.getPassword(),emp.getFullName(),emp.getEmailid(),
				emp.getDob(),emp.getGender(),emp.getSecurityQuestion(),emp.getSecurityAnswer());
		return "Added Successfully...";
	}

	public String deleteEmployee(String name) {
		String query = "delete from employee where name = ?";
		template.update(query, name);
		return "Deleted Successfully...";
	}

	public List<Employee> getAllEmployee() {
		String query = "select * from employee";
		List<Employee> emp = (List<Employee>)template.query(query, new EmployeeRowMapper());
		return emp;
	}

	public Employee getEmployeeByName(String name) {
		String query = "select * from employee where name = '"+name+"'";
		Employee emp = (Employee) template.query(query,new EmployeeRowMapper());
		return emp;
	}

	public String UpdatePassword(String name, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
