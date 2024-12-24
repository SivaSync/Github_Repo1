<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8" isELIgnored="false" %>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Form page</title>
<style type="text/css">
  div{
     margin-left: 350px;
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
     margin-left: 100px;
   }
</style>
</head>
<body>
<div>
<h1 style="color:blue; text-align: center;"></h1>
<frm:form modelAttribute="emp">
EmpNo ::<frm:input path="empno" readonly="true"/><br>
EmpName ::<frm:input path="ename"/><br>
EmpSal :: <frm:input path="sal"/><br>
EmpJob :: <frm:input path="job"/><br>
DeptNo :: <frm:input path="deptno"/> <br>
Status :: <frm:radiobutton path="status" value="active" /> Active<br>
          <frm:radiobutton path="status" value="InActive" /> Inactive
          
<!-- <input type="submit" value="type" src="image/register.png">
     <input type="reset"  src="image/cancel.jpeg"> -->
  <input class="im" type="image" value="Submit" src="image/register.png" alt="Submit"  />
<input class="im" type="image" value="Reset" src="image/cancel.jpeg" alt="Reset" />

</frm:form>

</div>
<br><br><br>
<br><br><br>
<a href="./" style="margin-left: 350px;"> <img src="image/home.jpeg" width="50px" height="50px">HomePage</a> 

</body>
</html>