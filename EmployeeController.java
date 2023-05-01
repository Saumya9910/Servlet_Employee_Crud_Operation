package com.jsp.employee_crud.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.employee_crud.dto.Employee;
import com.jsp.employee_crud.service.EmployeeService;

public class EmployeeController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		double salary  = Double.parseDouble(req.getParameter("salary"));
		long phone = Long.parseLong(req.getParameter("phone"));
		
		PrintWriter printWriter = resp.getWriter();
		
		Employee employee = new Employee();
		
		employee.setEmployeeid(id);
		employee.setEmployeename(name);
		employee.setEmployeephone(phone);
		employee.setEmployeesalary(salary);
		employee.setEmployeeemail(email);
		
		EmployeeService employeeService = new EmployeeService();
		
		employeeService.saveEmployee(employee);
		
		printWriter.write("<html><body>");
		printWriter.write("<h1 style='color:green'>Data Insertted Successfully</h1>");
		RequestDispatcher dispatcher = req.getRequestDispatcher("register.jsp");
		dispatcher.include(req, resp);
		printWriter.write("</body></html>");
		
	}
}
