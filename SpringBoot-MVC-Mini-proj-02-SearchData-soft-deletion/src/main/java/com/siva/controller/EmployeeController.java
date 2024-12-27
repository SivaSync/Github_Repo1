package com.siva.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.siva.entity.Employee;
import com.siva.service.IEmployeeServiceMngm;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeeController
{
	@Autowired
	private IEmployeeServiceMngm empSeervice;
	
	@GetMapping
	public String getHomePage()
	{
		//return Logical View Name
		return "home";
	}
	
	@GetMapping("/report")
	public String showDataPage(Map<String,Object> map,@ModelAttribute("emp") Employee emp)
	{
		//get data from service 
		List<Employee> list = empSeervice.showAllEmployeeData();
		//data shared memory to View Component
		map.put("listEmp", list);
		return "report";
	}

	 @GetMapping("/edit")
	public String editEmployeePage(@RequestParam("no") Integer no,@ModelAttribute("emp") Employee employedit)
	{
		 System.out.println("EmployeeController.editEmployeePage()");
		 //use service
		Employee emp1 = empSeervice.getEmployeeById(no);
		// copy data
		// emp.setDeptno(emp1.getDeptno());
		 BeanUtils.copyProperties(emp1, employedit);
		 // return LVN
		return "edit";
	}
	 @PostMapping("/edit")
	 public String UpadateShowPage(RedirectAttributes attrs,@ModelAttribute("emp") Employee empployee)
	 {
		System.out.println("EmployeeController.UpadateShowPage()");
		 //use service 
		 String result = empSeervice.UpadateemployeeData(empployee);
		 // add result message addFlash Attribute
		 attrs.addFlashAttribute("msg", result);
		 //return LVN
		 return "redirect:report";
	 }
	 @GetMapping("/delete")
	 public String deleteEmployeeById(RedirectAttributes attrs,@RequestParam int no)
	 {
		 //use service
		 String result = empSeervice.inActiveEmployeeById(no);
		 //add result message add flash Attribute
		 attrs.addFlashAttribute("msg",result);
		 //return LVN
		 return "redirect:report";
	 }

     @GetMapping("/register")
     public String registerEmployeeFormPage(@ModelAttribute("emp") Employee emp)
     {    	 
    	 return "register";
     }
     
		/* @PostMapping("/register") // no massage handler method
		 public String registerEmployeeResult(Map<String,Object> map,@ModelAttribute("emp") Employee emp )
		 {
			String addreuslt = empSeervice.registerEmployee(emp);
			map.put("msg", addreuslt);
			 
			 return "report";
			 
		 }
		 */
     
		/* @PostMapping("/register") // this is good handler method 
		 public String registerEmployeeResult(RedirectAttributes attrs,@ModelAttribute("emp") Employee emp )
		 {
			String addreuslt = empSeervice.registerEmployee(emp);
			attrs.addFlashAttribute("msg", addreuslt);
			 
			 return "redirect:report";
		 }*/
     

     @PostMapping("/register") // this is good handler method 
     public String registerEmployeeResult(HttpSession ses,@ModelAttribute("emp") Employee emp )
     {
    	String addreuslt = empSeervice.registerEmployee(emp);
    	ses.setAttribute("msg", addreuslt);
    	 
    	 return "redirect:report";
     }
     
     @PostMapping("/search")
     public String showEmployeeReportDynamicallySearch(Map<String,Object> map,@ModelAttribute("emp") Employee emp)
 	{
 		//get data from service 
 		List<Employee> list = empSeervice.dynamicallySerachForEmployee(emp);
 		//data shared memory to View Component
 		map.put("listEmp", list);
 		return "report";
 	}
     @GetMapping("/inactive")
     public String inActiveEmployeeData(Map<String,Object> map)
     {
    	 //use service''
    	 List<Employee> InActiveEmp = empSeervice.showInActiveEmployeeData();
    	 // shared memory 
    	 map.put("InActivelistEmp", InActiveEmp);
    	 return "inactive";
     }
     @GetMapping("/active")
     public String updateInActiveEmployeeData(@RequestParam("empno") Integer empno,RedirectAttributes rAttrs)
	{
		 System.out.println("EmployeeController.updateInActiveEmployeeData()");
    	 //use service
	      String updateInactive = empSeervice.updateInActiveEmployee(empno);
	          
		// copy data
		rAttrs.addFlashAttribute("edmsg", updateInactive);
		
		 // return LVN
		return "redirect:inactive";
	}
     @GetMapping("/pdelete")
    public String permenentDeleteById(@RequestParam("empno") int empno,RedirectAttributes ratts)
    {
    	//use
    	String deletemsg = empSeervice.permentDeleteEmployeeDataById(empno);
    	// use shared memory
    	ratts.addFlashAttribute("edmsg",deletemsg);
    	return "redirect:inactive";
    }
     @GetMapping("/likesearch")
     public String jobLikeOperator(@ModelAttribute("emp") Employee emp)
     {
    	 
         return "jobsearch";	 
     }
          
		@PostMapping("/likesearch")
		public String showLikeJobOperator(Map<String,Object>map,@ModelAttribute("emp") Employee emp)
		{
		 //use service
		 
		 List<Employee> joblike = empSeervice.getLikeEmployeeEname(emp);
		 //shared memory
		 map.put("msg","sorting by Job Data");
		 map.put("listEmp",joblike);
		 
		 //return LVN
		 return "jobsearch";
		}
    // @GetMapping("/dysearch")
     @RequestMapping("/dysearch")
		public String showBetweenSalary(Map<String, Object> map
				/*,
				@RequestParam(value = "salFrom", required = false) Double salFrom,
				@RequestParam(value = "salTo", required = false) Double salTo,
				@ModelAttribute("emp") Employee emp*/
				, @ModelAttribute("emp") Employee emp)
     {
    	 //use service
    	 List<Employee> joblike = empSeervice.getEmployeeBetweenBySalary(800.0,3000.0);
    	 //shared memory
    	 map.put("msg","sorting by Job Data");
    	 map.put("listEmp",joblike);
    	 
    	 //return LVN
    	 return "jobsearch";
     }
     
     
	/*
	@PostMapping("/inactive")
	public String UpadateInActiveData(RedirectAttributes attrs,@ModelAttribute("emp") Employee empployee)
	{
	System.out.println("EmployeeController.UpadateShowPage()");
	 //use service 
	 String result = empSeervice.UpadateemployeeData(empployee);
	 // add result message addFlash Attribute
	 attrs.addFlashAttribute("msg", result);
	 //return LVN
	 return "redirect:report";
	}*/
	/*
	@GetMapping("/shutdown")
	public void shutdownPage()
	{
	 System.out.println("EmployeeController.shutdownPage()");
	 
	 System.exit(0);
	}*/
     
     @GetMapping("/shutdown")
     public String shutdownPage(HttpServletRequest request, HttpServletResponse response) {
         System.out.println("EmployeeController.shutdownPage()");
         
         // Render the JSP page
         new Thread(() -> {
             try {
                 // Wait for a few seconds to ensure the page is rendered
                 Thread.sleep(5000);
                 System.exit(0); // Gracefully shutdown the application
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }).start();
         
         // Return the JSP view name (assumes `shutdown.jsp` exists in the view folder)
         return "shutdown";
     }
     
}
