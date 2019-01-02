package com.mindtree.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mindtree.dao.EmployeeValidationDao;
import com.mindtree.entity.EmployeeValidation;
import com.mindtree.util.DBUtil;

public class EmployeeValidationDaoImpl implements EmployeeValidationDao {

	private Connection con = null;
	private Statement st = null;
	private PreparedStatement ps = null;
	public String addCredentials(EmployeeValidation emp1) {
		String query = "insert into credentials values(?,?,?)";
		System.out.println("qwertyuiop");
		String msg = "";
		try {
			con = DBUtil.getConnection1();
			ps = con.prepareStatement(query);
			ps.setString(1, emp1.getName());
			ps.setString(2, emp1.getPassword());
			ps.setString(3, emp1.getType());
			
			int i = ps.executeUpdate();
			if(i == 1)
			{
				msg = "Credentials added...";
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

	public EmployeeValidation fcredentials(String sname) {
		String query = "select * from credentials where name=?";
		String msg = "";
		EmployeeValidation empval = new EmployeeValidation();
		try {
			con = DBUtil.getConnection1();
			ps = con.prepareStatement(query);
			ps.setString(1, sname);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				empval = new EmployeeValidation(rs.getString(1), rs.getString(2), rs.getString(3));
			}
		}
		catch(Exception e)
		{
			System.out.println("Couldn't fetch");
		}
		return empval;
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
