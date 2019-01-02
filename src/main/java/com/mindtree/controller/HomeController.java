package com.mindtree.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.daoImpl.JDBCTemplate;
import com.mindtree.entity.Employee;
import com.mindtree.entity.EmployeeValidation;
import com.mindtree.serviceImpl.EmployeeServiceImpl;
import com.mindtree.serviceImpl.EmployeeValidationServiceImpl;

	@Controller
	public class HomeController {

//		@RequestMapping("/")
//		public String index1(Locale locale, Model model)
//		{
//			return "index";
//		}
		ApplicationContext con=new ClassPathXmlApplicationContext("JdbcTemplate.xml");
		JDBCTemplate temp=con.getBean("d",JDBCTemplate.class);
		
		@RequestMapping(value = "/Admin_Op", method = RequestMethod.POST)
		public ModelAndView AdminPage(HttpServletRequest req)
		{
			EmployeeValidation ev = new EmployeeValidation();
			EmployeeValidationServiceImpl es = new EmployeeValidationServiceImpl();
			ev = es.fcredentials(req.getParameter("name"));
			if(ev.getName().equals(req.getParameter("name")) && ev.getPassword().equals(req.getParameter("password")))
			{
				if(ev.getType().equals("admin"))
				{
					return new ModelAndView("Admin_Op");
				}
				else
				{
					return new ModelAndView("Employee_Op");
				}
			}
			return new ModelAndView("Error");
		}
		@RequestMapping(value="/Employee_Op")
		public ModelAndView EmployeePage()
		{
			return new ModelAndView("Employee_Op");
		}
		@RequestMapping(value="/ChangePassword")
		public ModelAndView ChangePassword()
		{
			return new ModelAndView("ChangePassword");
		}
		@RequestMapping(value="/PassChange", method = RequestMethod.POST)
		public ModelAndView PasswordChanged(HttpServletRequest req)
		{
			String name = req.getParameter("name");
			String passWord = req.getParameter("password");
			System.out.println(name);
			System.out.println(passWord);
			EmployeeServiceImpl es = new EmployeeServiceImpl();
			EmployeeValidationServiceImpl es1 = new EmployeeValidationServiceImpl();
			System.out.println(es.UpdatePassword(name, passWord));
			System.out.println(es1.UpdatePassword(name, passWord));
			return new ModelAndView("/PassChange");
		}
		@RequestMapping("/UserTable")
		public ModelAndView UserPage()
		{
			
			//EmployeeServiceImpl es = new EmployeeServiceImpl();
			//JDBCTemplate jt = new JDBCTemplate();
			//mv.addObject("allEmployees", es.getAllEmployee());
			System.out.println(temp.getAllEmployee());
			return new ModelAndView("UserTable","allEmployees",temp.getAllEmployee());
			//return new ModelAndView("UserTable","allEmployees",es.getAllEmployee());
		}
		@RequestMapping("empName")
		public ModelAndView userName()
		{
			return new ModelAndView("empName");
		}
		@RequestMapping("/SingleEmp")
		public ModelAndView UserPageId(HttpServletRequest name)
		{
			ModelAndView mv = new ModelAndView();
			EmployeeServiceImpl es = new EmployeeServiceImpl();
			mv.addObject("allEmployees", es.getEmployeeByName(name.getParameter("name")));
			return mv;
		}
		@RequestMapping("/home")
		public String index(Locale locale,Model model)
		{
			System.out.println("tyuio");
//			System.out.println(ev.getName());
//			System.out.println(ev.getPassword());
			
			Employee e1 = new Employee();
			EmployeeServiceImpl es = new EmployeeServiceImpl();
			//e1 = es.getEmployeeByName(ev.getName());
			System.out.println("hello");
//			if(e1.getName().equals(ev.getName()) && e1.getPassword().equals(ev.getPassword()))
//			{
//				
//			}
			Date date = new Date();
			DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG , locale);
			String formattedDate = dateFormat.format(date);
			model.addAttribute("serverTime", formattedDate);
			return "home";
		}
		
		@RequestMapping(value="/user",method = RequestMethod.POST)
		public ModelAndView muser12(Employee ms)
		{
			EmployeeServiceImpl es = new EmployeeServiceImpl();
			EmployeeValidationServiceImpl es1 = new EmployeeValidationServiceImpl();
			EmployeeValidation ms1 = new EmployeeValidation(ms.getName(),ms.getPassword(),ms.getType());
			// Using JDBC Template
			System.out.println(temp.addEmployee(ms));
			// Using normal JDBC
			System.out.println(es1.addCredentials(ms1));
			//System.out.println("User Page requested...");
			ModelAndView mv = new ModelAndView("user");
			System.out.println(ms.getName());
			mv.addObject("userName", ms.getName());
			mv.addObject("id", ms.getPassword());
			return mv;
		}
	}

