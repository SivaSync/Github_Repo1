<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8" isELIgnored="false" %>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
 .r
 {
   font-size:30px;
 }
 b
 {
  color:orange;
 }
</style>
<title>Register Form page</title>
</head>
<body>
<div style =" color:blue; text-align:center; font-size: 25px;">
<h1 style ="color:green">Employee From page</h1>

<frm:form modelAttribute="emp">
EmpName ::<frm:input path="ename"/><br>
EmpSal :: <frm:input path="sal"/><br>
EmpJob :: <frm:input path="job"/><br>
DeptNo :: <frm:select path="deptno">
           <frm:option value="10">10</frm:option>
           <frm:option value="20">20</frm:option>
           <frm:option value="30">30</frm:option>
            <frm:option value="40">40</frm:option>
          </frm:select>          <br>
Status ::
         <frm:radiobutton path="status" value="active" class="r"/> <b>Active</b><br>
     &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <frm:radiobutton path="status" value="InActive" class="r"/> <b>Inactive</b>
<%-- <frm:select path="status">
           <frm:option value="active">active</frm:option>
            <frm:option value="InActive">InActive</frm:option>
          </frm:select> --%>
          
 <br>

<input type="submit" value="Register" src="image/register.png">
<input type="reset" src="image/cancel.jpeg">

</frm:form>
</div>

</body>
</html>