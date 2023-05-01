package com.jsp.employee_crud.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EmployeeConnection {
	public static Connection getEmployeeConnection() {
		
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/employee";
		String user = "root";
		String pass = "root";
		
		Connection connection = DriverManager.getConnection(url, user, pass);
		
		return DriverManager.getConnection(url, user, pass);
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;

}
}