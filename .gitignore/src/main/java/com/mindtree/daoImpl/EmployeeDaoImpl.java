package com.mindtree.daoImpl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mindtree.util.DBUtil;
import com.mindtree.dao.EmployeeDao;
import com.mindtree.entity.Employee;;

public class EmployeeDaoImpl implements EmployeeDao {

	private Connection con = null;
	private Statement st = null;
	private PreparedStatement ps = null;
	public String addEmployee(Employee emp) {
		String query = "insert into employee values(?,?,?,?,?,?,?,?)";
		System.out.println("qwertyuiop");
		String msg = "";
		try {
			con = DBUtil.getConnection1();
			ps = con.prepareStatement(query);
			ps.setString(1, emp.getName());
			ps.setString(2, emp.getPassword());
			ps.setString(3, emp.getFullName());
			ps.setString(4, emp.getEmailid());
			ps.setString(5, emp.getDob());
			ps.setString(6, emp.getGender());
			ps.setString(7, emp.getSecurityQuestion());
			ps.setString(8, emp.getSecurityAnswer());
			int i = ps.executeUpdate();
			if(i == 1)
			{
				msg = "Added successfully...";
			}
			else
			{
				msg = "Couldn't add to the database...";
			}
		}
		catch(Exception e)
		{
			
		}
		return msg;
	}

	public String deleteEmployee(String name) {
		String query = "delete from employee where name = ?";
		String msg = "";
		try {
			con = DBUtil.getConnection1();
			ps = con.prepareStatement(query);
			ps.setString(1, name);
			int i = ps.executeUpdate();
			if(i == 1)
			{
				msg = "Deleted successfully...";
			}
			else
			{
				msg = "Unable to delete...";
			}
		}
		catch(Exception e)
		{
			
		}
		return msg;
	}

	public List<Employee> getAllEmployee() {
		String query = "select * from employee";
		List<Employee> l = new ArrayList<Employee>();
		try {
			con = DBUtil.getConnection1();
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next())
			{
				l.add(new Employee(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
			}
		}
		catch(Exception e)
		{
			
		}
		return l;
	}

	public Employee getEmployeeByName(String name) {
		String query = "select * from employee where name = ?";
		Employee e = new Employee();
		try {
			con = DBUtil.getConnection1();
			ps = con.prepareStatement(query);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				e = new Employee(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
			}
		}
		catch(Exception e1)
		{
			
		}
		return e;
	}

	public String UpdatePassword(String name, String password) {
		String query = "update employee set password = ? where name = ?";
		String msg = "";
		try {
			con = DBUtil.getConnection1();
			ps = con.prepareStatement(query);
			ps.setString(1, password);
			ps.setString(2, name);
			int i = ps.executeUpdate();
			if(i == 1)
			{
				msg = "Updated Successfully";
			}
			else {
				msg = "Unable to update...";
			}
		}
		catch(Exception e)
		{
			System.out.println("Update not possible...");
		}
		return msg;
	}
}
