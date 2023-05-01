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

public class EmployeeDeleteController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		EmployeeService employeeService = new EmployeeService();
		
		int id1 = employeeService.deleteEmployee(id);
		
		PrintWriter printWriter = resp.getWriter();
		
		printWriter.write("<html><body>");
		
		if(id!=0) {
			printWriter.write("<h3 stle='color:green'>Data Deleted Sucessfully</h3>");
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("delete.jsp");
			
			dispatcher.include(req, resp);
			
		}
		else {
			printWriter.write("<h3 stle='color:green>Given id is not present in Database</h3>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("delete.jsp");
			dispatcher.include(req, resp);
			
		}
		printWriter.write("</body></html>");
		
		
		
		
		
	}
	
	


}
