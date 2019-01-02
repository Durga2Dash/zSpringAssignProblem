package com.mindtree.util;
import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.SQLException;
public class DBUtil {

		static String url = "jdbc:mysql://localhost:3306/expertEmployee";
		static String username = "root";
		static String password = "Welcome123";
		public static Connection getConnection1()
		{
			Connection con = null;
			try {
				System.out.println("HI");
				
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url, username, password);
				System.out.println("Hello");
			} catch (SQLException  e) {
				System.out.println("Failed to connect to  the Driver...");
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return con;
		}
		public static void closeConnection(Connection con)
		{
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println("Unable to close connection...");
				}
			}
		}
	}

