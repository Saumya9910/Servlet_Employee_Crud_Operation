package com.jsp.employee_crud.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.employee_crud.dto.Employee;
import com.jsp.employee_crud.service.EmployeeService;

public class EmployeeDisplayController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EmployeeService employeeService = new EmployeeService();
		
		List<Employee> employees=employeeService.displayEmployee();
		
		PrintWriter printWriter = resp.getWriter();
		
		printWriter.write("<html><body>");
		printWriter.write("<h1>Employees Data</h1>");
		printWriter.write("<table border='2'>");
		printWriter.write("<tr><th>EmployeeId</th><th>EmployeeName</th><th>EmployeeSalary</th><th>EmployeeEmail</th><th>EmployeePhone</th></tr>");
		for (Employee employee : employees) {
			
			printWriter.write("<tr><td>"+employee.getEmployeeid()+"</td><td>"+employee.getEmployeename()+"</td><td>"+employee.getEmployeesalary()+"</td><td>"+employee.getEmployeeemail()+"</td><td>"+employee.getEmployeephone()+"</td></tr>");
		}
		
		printWriter.write("</table>");
		printWriter.write("</body></html>");
	}
}
