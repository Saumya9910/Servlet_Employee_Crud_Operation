package com.jsp.employee_crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsp.employee_crud.connection.EmployeeConnection;
import com.jsp.employee_crud.dto.Employee;

public class EmployeeDao {

	// saveEmployee method
	public Employee saveEmployee(Employee employee) {

		Connection connection = EmployeeConnection.getEmployeeConnection();

		String insertEmployeeQuery = "insert into employee values(?,?,?,?,?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(insertEmployeeQuery);

			preparedStatement.setInt(1, employee.getEmployeeid());
			preparedStatement.setString(2, employee.getEmployeename());
			preparedStatement.setString(3, employee.getEmployeeemail());
			preparedStatement.setDouble(4, employee.getEmployeesalary());
			preparedStatement.setLong(5, employee.getEmployeephone());

			preparedStatement.execute();

			return employee;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// delete method
	public int deleteEmployee(int id) {
		
		Connection connection = EmployeeConnection.getEmployeeConnection();

		String deleteEmployeeQuery = "delete from employee where employeeid=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(deleteEmployeeQuery);

			preparedStatement.setInt(1,id);
			

			return preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	//displayMethodForEmployee
	public List<Employee> displayEmployee(){
		
		Connection connection = EmployeeConnection.getEmployeeConnection();

		String displayEmployeeQuery = "SELECT * FROM EMPLOYEE";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(displayEmployeeQuery);
			
			List<Employee> employees = new ArrayList<Employee>();

			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				Employee employee = new Employee();
				
				employee.setEmployeeid(resultSet.getInt("employeeid"));
				employee.setEmployeename(resultSet.getString("employeename"));
				employee.setEmployeeemail(resultSet.getString("employeeemail"));
				employee.setEmployeesalary(resultSet.getDouble("employeesalary"));
				employee.setEmployeephone(resultSet.getLong("employeephone"));
				
				employees.add(employee);
			}
			
			return employees;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	//updateMethod For Employee
	public int updateEmployee(Employee employee,int employeeId) {
		
		Connection connection = EmployeeConnection.getEmployeeConnection();
		
		if((employee.getEmployeename()!=null)&&(employee.getEmployeeemail()!=null)
				&&(employee.getEmployeephone()!=0)&&(employee.getEmployeesalary()!=0.0)) {
			
			String updateQuery = "update employee set employeename=?,"
					+ "employeeemail=?,employeephone=?,employeesalary=? where employeeid=?";
			
			PreparedStatement preparedStatement;
			try {
				preparedStatement = connection.prepareStatement(updateQuery);
				preparedStatement.setString(1, employee.getEmployeename());
				preparedStatement.setString(2, employee.getEmployeeemail());
				preparedStatement.setLong(3, employee.getEmployeephone());
				preparedStatement.setDouble(4, employee.getEmployeesalary());
				preparedStatement.setInt(5, employeeId);
				
				return preparedStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}
}
