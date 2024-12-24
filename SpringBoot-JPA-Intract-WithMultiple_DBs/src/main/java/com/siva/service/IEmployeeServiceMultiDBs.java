package com.siva.service;

import java.util.List;

import com.siva.model.from.EmployeeFrom;

public interface IEmployeeServiceMultiDBs 
{
	 public List<EmployeeFrom> getAllEmployeesOracle();
	 /* 
	public String registerEmployeeOracle(EmployeeFrom oraEmp);
	 
	 public String RegisterEmployeeMysql(EmployeeFrom emp);
	 
	 public List<EmployeeFrom> getEmployeeMySQL();
	  
	 public String insertMultipleEmployeeInMySQl(List<EmployeeFrom> listofEmployees);
	 */	
	 
	 public void transferEmployeeData();
	
	
  
}
