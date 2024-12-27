package com.siva.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.siva.model.from.EmployeeFrom;
import com.siva.model.to.EmployeeTo;
import com.siva.repo.from.IEmployeeRepositoryFromOracle;
import com.siva.repo.to.IEmployeeMySqlToRepository;

@Service
public class EmployeeServiceMultiDBsImpl implements IEmployeeServiceMultiDBs {

	@Autowired
	private IEmployeeRepositoryFromOracle fromRepo;
	@Autowired
	private IEmployeeMySqlToRepository toRepo;

	@Override
	public List<EmployeeFrom> getAllEmployeesOracle() {
		System.out.println("This Repository is used fromRepo internally Oracle");
		return fromRepo.findAll();
	}
	
	@Override
	@Transactional
	public String registerEmployeeOracle(EmployeeFrom OraEmp) {
		
	//	List<Integer> listOfEmpnos = toRepo.saveAll(list).stream().map(EmployeeFrom::getDeptno).toList();
	  fromRepo.save(OraEmp);
	  
	  
		return "\033[1;32mSuccessfully register Employees Oracle to MySql List Of Employee Empno: \033[1;0m"+" "+" \033[1;31m\033[1;0m";
	
	}
	
	
//	@Override
//	@Transactional
//	@Modifying
//	public String RegisterEmployeeMysql(EmployeeTo emp) {
//		
//		List<EmployeeFrom> listOfEmps = fromRepo.findAll();
//		listOfEmps.forEach(System.out::println);
//		
//		System.out.println("\033[1;36mEmployeeServiceMultiDBsImpl.fetchOracleAndRegisterMysql()\033[1;0m");
//		Integer listOfEmpnos = toRepo.save(emp).getEmpno();
//		return "\033[1;34mFind and Register Sucessfully withEmpnos ::\033[1;0m  \033[1;31m"+listOfEmpnos+"\033[1;0m";
//	}
	
	@Override
	@Transactional
	public List<EmployeeTo> getEmployeeMySQL() {
		
		System.out.println("This Repository is used toRepo internally MYSQL");
		
		return toRepo.findAll();
	}
	
	@Override
	@Transactional
	public String insertEmployeeToInMySQl(List<EmployeeTo> listofEmployees) 
	{
		List<Integer> lisEmpno = toRepo.saveAll(listofEmployees).stream().map(EmployeeTo::getEmpno).toList();
	   return "Register to Mysql DataBase Successfully Empno:: "+lisEmpno;	
	}

	@Transactional
	@Override
	public void transferEmployeeData() {
		// Fetch employees from the source database (EmployeeFrom)
		List<EmployeeFrom> employees = fromRepo.findAll();

		for (EmployeeFrom empFrom : employees) {
			// Map and save the employee data into the target database (EmployeeTo)
			EmployeeTo employeeTo = new EmployeeTo(
					empFrom.getEmpno(),
					empFrom.getEname(),
					empFrom.getSal(),
					empFrom.getJob(), 
					empFrom.getDeptno(),
					empFrom.getHiredata(),
					empFrom.getComm()
					);
		
			toRepo.save(employeeTo);
		}
		
		try {
			Thread.sleep(5000);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("\033[1;32m-----Sucessfully Oracle DB to Inserting MySQL DataBase--------------\033[1;0m");
		
	}

}
