package com.siva.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.siva.entity.Employee;
import com.siva.repository.IEmployeeRepository;

@Service
public class EmployeeServiceMngmImpl implements IEmployeeServiceMngm {

	@Autowired
	private IEmployeeRepository empRepo;

	@Override
	public List<Employee> showAllEmployeeData() {
		List<Employee> list = empRepo.findAll();
		// return list.stream().sorted().toList();
		// list.forEach(System.out::println);
		return list.stream().sorted((e1, e2) -> e1.getEmpno().compareTo(e2.getEmpno())).toList();
	}

	@Override
	public String registerEmployee(Employee emp) {

		int idVal = empRepo.save(emp).getEmpno();

		return "Register the Employee Inforamtion With Id Value ::" + idVal;
	}

	@Override
	public Employee getEmployeeById(int id) {

		return empRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Id"));
	}

	@Override
	public String UpadateemployeeData(Employee employee) {

		return "Upadete the Employee Inforamtion With Id Value ::" + empRepo.save(employee).getEmpno();
	}

	@Override
	public String inActiveEmployeeById(int id) {
		empRepo.deleteById(id);
		return id + " Employee id Employee is inActive Mode..........";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Employee> dynamicallySerachForEmployee(Employee employee) {

		// replace empty String with nuls
		if (employee.getEname().equalsIgnoreCase("") || employee.getEname().length() == 0)
			employee.setEname(null);
		if (employee.getJob().equalsIgnoreCase("") || employee.getJob().length() == 0)
			employee.setJob(null);
		// prepare for example object
		Example example = Example.of(employee);

		List<Employee> list = empRepo.findAll(example);
		return list;
	}

	@Override
	public List<Employee> showInActiveEmployeeData() {
		return empRepo.inActiveEmployeeData();
	}

	@Override
	public String updateInActiveEmployee(int empno) {

		empRepo.updateInActiveToActve(empno);

		return " Sucessfully Upadete Active Employee with EmpId " + empno;
	}

	@Override
	public String permentDeleteEmployeeDataById(int empno) {

		empRepo.deletePermnentEmployyeById(empno);
		return "Employee Data permenent delete Succesfully this EmpId" + empno;
	}

	/*@Override
	public List<Employee> findByJobLikEmployees(Employee employee) {
		
		// replace empty String with nuls
				if(employee.getEname().equalsIgnoreCase("") || employee.getEname().length()==0)
					employee.setEname(null);
				if(employee.getJob().equalsIgnoreCase("")|| employee.getJob().length()==0)
					employee.setJob(null);
				if(employee.getStatus().equalsIgnoreCase("")|| employee.getStatus().length()==0)
					employee.setStatus(null);
				
				// prepare for example object	
				//Example example = Example.of(employee);
				
				List<Employee> list = empRepo.findByJobLike(employee);
		
		return list;
	}*/

	@Override
	public List<Employee> getLikeEmployeeEname(Employee employee) {
		List<Employee> list = null;
       try {
    	   
    	   if(employee.getEname().length()<=0 
    		&& employee.getJob().length()<=0 
            && Optional.ofNullable(employee.getSal()).orElse(800d) > 0d 
    		&& Optional.ofNullable(employee.getDeptno()).orElse(10)> 0)
   		{
   			System.out.println("\033[1;31m if --- Like Operator\033[1;0m");
   			return list = empRepo.getAllFieldsOfLikeOperator(employee.getEname()+"%", employee.getJob()+"%", employee.getDeptno(), employee.getSal());
   		}  
    	   
    	   
		if(employee.getEname().length()<=0 && employee.getJob().length()<=0 && employee.getSal()>0d && employee.getDeptno()>0)
		{
			System.out.println("\033[1;32mAll Like Operator\033[1;0m");
			return list = empRepo.getAllFieldsOfLikeOperator(employee.getEname()+"%", employee.getJob()+"%", employee.getDeptno(), employee.getSal());
		}
		
		if (employee.getEname().equalsIgnoreCase("") && employee.getEname().length() == 0)// || to &&
		{
			employee.setEname(null);
			if (employee.getJob().length() > 0)
			{
				System.out.println("\033[1;33mWorking with Job Like........\033[1;0m");
				// use service
				return list = empRepo.findByJobLike(employee.getJob() + "%");
			}
		}
		
		if (employee.getJob().equalsIgnoreCase("") && employee.getJob().length() == 0) // || to &&
		{
			employee.setJob(null);
			if (employee.getEname().length() > 0)
			{
				System.out.println("\033[1;34mWorking with Ename Like method..........\033[1;0m");
				return list = empRepo.LikeOpreatorEname(employee.getEname() + "%");
			}
		} 
		                                                                    // after write not working this method
		if(employee.getEname().length()>0 && employee.getJob().length()>0 ) // && employee.getSal()==null && employee.getDeptno()==null)
		{
			
			System.out.println("\033[1;35mWorking with job and Ename Like Operators......\033[1;0m");
			return list = empRepo.ShowEmployeeLikeJodAndEname(employee.getEname()+"%", employee.getJob()+"%");
		}
		
		/*if(employee.getSal()!=0)
		{
			return list = empRepo.getSalaryBetweenEmployeeData(employee.getSal(), employee.getSal());
		}*/
		
		System.out.println("\033[1;36m"
				+employee
				+ "Working with out of th if \033[1;0m");
		//return null;
       }catch(NullPointerException npe) {
    	   
    	   System.out.println("\033[1;34m Exception is raise is Null Pointer Exception \033[1;0m");
    	   System.out.println(npe.getMessage());
    	   npe.printStackTrace();
    	   
       }
		return list;
	}
	@Override
	public List<Employee> getEmployeeBetweenBySalary(Double start, Double end)
	{
		//List<Employee> list = empRepo.getSalaryBetweenEmployeeData(start, end);
		
		List<Employee> list = empRepo.getSalaryBetweenEmployeeData(start, end);
		return list;
	}
	
	
	
}
