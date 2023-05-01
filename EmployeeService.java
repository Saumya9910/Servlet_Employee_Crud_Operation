package com.jsp.employee_crud.service;

import java.util.List;

import com.jsp.employee_crud.dao.EmployeeDao;
import com.jsp.employee_crud.dto.Employee;

public class EmployeeService {
	
	EmployeeDao employeeDao = new EmployeeDao();

	// saveEmployee method
	public Employee saveEmployee(Employee employee) {

		return employeeDao.saveEmployee(employee);
	}

	// delete method
	public int deleteEmployee(int id) {

		return employeeDao.deleteEmployee(id);

	}

	// displayMethodForEmployee
	public List<Employee> displayEmployee() {
		return employeeDao.displayEmployee();
	}

	// updateMethod For Employee
	public int updateEmployee(Employee employee, int employeeId) {

		return employeeDao.updateEmployee(employee,employeeId);
	}
}	