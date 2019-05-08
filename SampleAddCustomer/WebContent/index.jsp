<%@page import="com.model.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.service.impl.StudentServiceImpl"%>
<%@page import="com.service.StudentService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="AddStudentServlet" method="post" >
	<input type="text" placeholder="stdId" name="stdId">
	<br>
	<br>
	<input type="text" placeholder="stdName" name="stdName">
	<br>
	<br>
	<input type="text" placeholder="stdAddress" name="stdAddress">
	<br>
	<br>
	<input type="text" placeholder="stdPhone" name="stdPhone">
	<br>
	<br>
	<input type="submit" placeholder="Save" name="Save">
	<br>
</form>

<table style="width:100%">
  <tr>
    <th>StudentIdNumber</th>
    <th>StudentName</th> 
    <th>Address</th>
    <th>PhoneNumber</th>
  </tr>
  
  <%
  	StudentService stdService = new StudentServiceImpl();
  ArrayList<Student> list = stdService.getAllStudents();
  
  for(Student s:list){
  %>
  
  
  <tr>
    <td><%=s.getStdIdNum()%></td>
    <td><%=s.getStdName() %></td>
    <td><%=s.getStdAddress() %></td>
    <td><%=s.getStdPhone() %></td>
  </tr>
 
 <%
 }
 
 %>
</table>


<form action="SearchStudentServlet" method="post">
	
	<input type="text" name="searchName" >
	<input type="submit" name="sub">

</form>

	<%
	
	Student s2 = (Student) request.getAttribute("student");
		
	if(s2!=null){
		System.out.print("JJJJJJJJJJJJJ");
	%>
	
	<table style="width:100%">
  <tr>
    <th>StudentIdNumber</th>
    <th>StudentName</th> 
    <th>Address</th>
    <th>PhoneNumber</th>
  </tr>
  
   <tr>
    <td><%=s2.getStdIdNum()%></td>
    <td><%=s2.getStdName() %></td>
    <td><%=s2.getStdAddress() %></td>
    <td><%=s2.getStdPhone() %></td>
  </tr>
  
  <%} %>
  </table>
	
	
</body>
</html>