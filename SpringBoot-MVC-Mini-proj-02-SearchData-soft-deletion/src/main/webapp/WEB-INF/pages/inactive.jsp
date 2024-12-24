<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reporting page</title>
<style type="text/css">

 div{
    margin-left: 350px;
 }
 marquee {
	font-size: 20px;
	
}
#se{
     margin-left: 250px;
     color:navy;
      font-size:30px;
   }
   input{
       background-color: silver;
       color:white;
       font-size:20px;
   }
   .im
   {
     width: 100px;
     height: 100px;
     margin-left: 50px;
   }
</style>
</head>
<body bgcolor="lightgreen">
	<marquee behavior="scroll" direction="right" bgcolor="silver">
    <h1 style="color:blue; text-align: center;height:20px;  ">SpringBoot MVC
			Mini-Project CRUD Operations</h1>
	</marquee>
	<h1 style="color:orange; text-align: center;">${edmsg}  </h1>
  <div>
	<c:choose>
	<c:when test="${!empty InActivelistEmp}">
	<h3 style="color:green;">InActive Employee Data </h3>
	<table border="1" bgcolor="green" algin="center">
	
	<tr bgcolor="cyan">
	   <th>EmpNo</th>
	   <th>EmpName</th>
	   <th>EmpSal</th>
	   <th>EmpJob</th>
	   <th>EmpDeptNo</th>
	   <th>Status</th>
	   <th>Operations </th>
	</tr>
	<c:forEach var="emp" items="${InActivelistEmp}">
	<tr>
	  <td>${emp.empno}</td>
	  <td>${emp.ename}</td>
	  <td>${emp.sal}</td>
	  <td>${emp.job}</td>
	  <td>${emp.deptno}</td>
	  <td>${emp.status}</td>
	  <td style=" color:white; font-size: 25px; text-shadow: 2px 4px 2px gray;">${emp.status}</td>
	  <td>
 <a href="active?empno=${emp.empno}"> <img  src="image/enable.jpeg" width="40px" height="40px"></a>
 <a href="pdelete?empno=${emp.empno}"> <img src="image/delete.jpeg" width="30px" height="30px" onclick="return confirm('Do you want delete the employee data ?')"></a>
 
	  </td>
	</tr>
	
	</c:forEach>
	</table>
	
	</c:when>
	<c:otherwise>
	 <h1 style="color:red;">Employee Data is not Found </h1>
	 <h1>${edmsg}</h1>
	</c:otherwise>
	</c:choose> 
	<br><br>
	
</div>
<a href="./" style="margin-left: 350px;"> <img src="image/home.jpeg" width="50px" height="50px">HomePage</a> 
 <a href="register" style="margin-left: 250px;"> <img src="image/reg1.jpeg" width="50px" height="50px">Register Employee</a><br><br>
 <a href="report" style="margin-left: 200px;"> <img src="image/data.jpeg" width="50px" height="50px"><br>Total Employee Data</a>
  
</body>
</html>