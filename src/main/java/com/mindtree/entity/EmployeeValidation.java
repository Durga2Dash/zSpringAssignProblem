package com.mindtree.entity;


public class EmployeeValidation {


		private String name;
		private String password;
		private String type;
		
		public EmployeeValidation(String name, String password, String type)
		{
			this.name = name;
			this.password = password;
			this.type = type;
		}
		
		
		public EmployeeValidation() {
			super();
			// TODO Auto-generated constructor stub
		}


		public String getType() {
			return type;
		}


		public void setType(String type) {
			this.type = type;
		}


		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
	}
