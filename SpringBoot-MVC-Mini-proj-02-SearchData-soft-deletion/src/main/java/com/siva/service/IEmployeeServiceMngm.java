package com.siva.service;

import java.util.List;

import com.siva.entity.Employee;

public interface IEmployeeServiceMngm 
{
	public List<Employee> showAllEmployeeData();
	
	public String registerEmployee(Employee emp);
	
	public Employee getEmployeeById(int id);
	
	public String UpadateemployeeData(Employee employee);
	
	public String inActiveEmployeeById(int id);
	
	public List<Employee> dynamicallySerachForEmployee(Employee employee);

	public List<Employee> showInActiveEmployeeData();
	
	public String updateInActiveEmployee(int empno);
	
	public String permentDeleteEmployeeDataById(int empno);
	
	public List<Employee> getLikeEmployeeEname(Employee emp);
	
	public List<Employee> getEmployeeBetweenBySalary(Double start, Double end);
}
