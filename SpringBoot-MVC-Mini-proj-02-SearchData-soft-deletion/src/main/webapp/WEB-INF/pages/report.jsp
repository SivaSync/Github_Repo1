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
<body bgcolor="skyblue">
	<marquee behavior="scroll" direction="right" bgcolor="silver">
    <h1 style="color:blue; text-align: center;height:20px;  ">SpringBoot MVC
			Mini-Project CRUD Operations</h1>
	</marquee>
	<div id="se">
 <frm:form modelAttribute="emp" action="search">
EmpName ::<frm:input path="ename"/><br>
EmpSal :: <frm:input path="sal"/><br>
EmpJob :: <frm:input path="job"/><br>
DeptNo :: <frm:select path="deptno">
          <frm:option value="">No Value</frm:option>
           <frm:option value="10">10</frm:option>
           <frm:option value="20">20</frm:option>
           <frm:option value="30">30</frm:option>
            <frm:option value="40">40</frm:option>
          </frm:select><br>
 <input class="im" type="image" value="submit" src="image/search.png" alt="Submit"  />
<input class="im" type="image" value="reset" src="image/cancel.jpeg" alt="Reset" />

</frm:form>
	</div>
	<h1 style="color:green; text-align: center;">${msg}  </h1>
  <div>
	<c:choose>
	<c:when test="${!empty listEmp}">
	<p style="color:green;">Employee Data </p>
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
	<c:forEach var="emp" items="${listEmp}">
	<tr>
	  <td>${emp.empno}</td>
	  <td>${emp.ename}</td>
	  <td>${emp.sal}</td>
	  <td>${emp.job}</td>
	  <td>${emp.deptno}</td>
	  <td style=" color:white; font-size: 25px; text-shadow: 2px 4px 2px gray;">${emp.status}</td>
	  <td>
 <a href="edit?no=${emp.empno}"> <img src="image/edit.jpeg" width="40px" height="40px"> </a>
 <a href="delete?no=${emp.empno}"> <img src="image/disable.jpeg" width="40px" height="40px" onclick="return confirm('Do you want inActive the employee data ??')"></a>
 
	  </td>
	</tr>
	
	</c:forEach>
	</table>
	
	</c:when>
	<c:otherwise>
	 <h1 style="color:red;">Employee Data is not Found </h1>
	 <h1>${msg}</h1>
	</c:otherwise>
	</c:choose> 
	<br><br>
	
</div>
<a href="./" style="margin-left: 350px;"> <img src="image/home.jpeg" width="50px" height="50px">HomePage</a> 
 <a href="register" style="margin-left: 250px;"> <img src="image/reg1.jpeg" width="50px" height="50px">Register Employee</a>
 <br>
 
 <a href="report" style="margin-left: 350px;"> <img src="image/data.jpeg" width="70px" height="70px">Total Employee Data</a>
  <h2 style=" margin-left :750px;"><a href="inactive"><img alt="" src="image/inactive.png" width="70px" height="70px"><br> InActive Data</a></h2>
  
   <h2 style=" margin-left :250px;"><a href="likesearch"><img alt="JobSearchData" src="image/view.jpeg" width="60px" height="60px"><br> JobSearch Data Data</a></h2>
   
 
</body>
</html>