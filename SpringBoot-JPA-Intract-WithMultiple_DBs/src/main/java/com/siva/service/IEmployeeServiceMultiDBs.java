package com.siva.service;

import java.util.List;

import com.siva.model.from.EmployeeFrom;
import com.siva.model.to.EmployeeTo;

public interface IEmployeeServiceMultiDBs 
{
	public List<EmployeeFrom> getAllEmployeesOracle();
	
	public String registerEmployeeOracle(EmployeeFrom oraEmp);
	
	//public String RegisterEmployeeMysql(EmployeeTo emp);
	
	public List<EmployeeTo> getEmployeeMySQL();
	 
	public String insertEmployeeToInMySQl(List<EmployeeTo> listofEmployees);
		
	 
	 public void transferEmployeeData();
	
	
  
}
