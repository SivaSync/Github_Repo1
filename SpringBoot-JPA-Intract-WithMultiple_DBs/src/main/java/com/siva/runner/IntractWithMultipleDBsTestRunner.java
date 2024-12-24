package com.siva.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.siva.model.from.EmployeeFrom;
import com.siva.service.IEmployeeServiceMultiDBs;

@Component
public class IntractWithMultipleDBsTestRunner implements CommandLineRunner {

	@Autowired
	private IEmployeeServiceMultiDBs empSerive;

	@Override
	public void run(String... args) throws Exception {

		try {
			System.out.println("\033[1;39m________________________________________OracleEMP2TableData___________________________________________\033[1;0m");

			List<EmployeeFrom> listOfOracle =empSerive.getAllEmployeesOracle();
			 	  	    
			
			
			listOfOracle.forEach((list)->
			{
			
			System.out.println("\033[1;33m"+list+"\033[1;0m");
			 // method calling  register MYSQL from Oracle Data
			
			//    		 String msg = multiDbsSerive.fetchOracleToRegisterMysql(list);
			//    		 System.out.println(msg); 	
			});//1 for Each close 
			/*
			
			String msgMYsql = empSerive.insertMultipleEmployeeInMySQl(listOfOracle);
			System.out.println(msgMYsql);
			*/
			/*
			List<EmployeeFrom> listOfMySQL = empSerive.getEmployeeMySQL();
			 	        
			System.out.println("MySQL Employee from emp2");
			
			listOfMySQL.forEach((list)->
			{
			 System.out.println("\033[1;31m"+list+"\033[1;0m");	
			 // register Oracle from MySQL Data
			//    		 String oraReg = empSerive.registerEmployeeOracle(list);
			//    		 System.out.println(oraReg);
			});
			
			
				 
				 
				 
			
			 EmployeeFrom mySqlEmp = new EmployeeFrom("Lakshmi", 20000.0, "Butician", 40);
			
			String mysqlRegMsg = empSerive.fetchOracleToRegisterMysql(mySqlEmp);
			System.out.println(mysqlRegMsg);
			*/
			
			System.out.println("\033[1;39m______________________________________Registered EMP table in MySQl_____________________________________________\033[1;0m");   	 
			
			 empSerive.transferEmployeeData();
			//System.out.println("\033[1;32m"+msgtd+"\033[1;0m");
			
			System.out.println("\033[1;39m___________________________________________________________________________________\033[1;0m");
			
		}

		catch (Exception e) {
			System.out.println("\033[1;30mIntractWithMultipleDBsTestRunner.run()----->EXception is Raised\033[1;0m");
			e.printStackTrace();
		}

	}

}
