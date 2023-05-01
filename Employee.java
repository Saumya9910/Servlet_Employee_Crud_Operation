package com.jsp.employee_crud.dto;

public class Employee {
	private int employeeid;
	private String employeename;
	private String employeeemail;
	private double employeesalary;
	private long employeephone;
	
	
	public double getEmployeesalary() {
		return employeesalary;
	}
	public void setEmployeesalary(double employeesalary) {
		this.employeesalary = employeesalary;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	public String getEmployeeemail() {
		return employeeemail;
	}
	public void setEmployeeemail(String employeeemail) {
		this.employeeemail = employeeemail;
	}
	public long getEmployeephone() {
		return employeephone;
	}
	public void setEmployeephone(long employeephone) {
		this.employeephone = employeephone;
	}
	

}
