<%@page import="demo.clininc.model.Patient"%>
<%@page import="demo.clininc.model.Prescription"%>
<%@page import="demo.clininc.model.Medicine"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Patient information form</h1>
	<form action="register" method="post">
	
		Id: <input type="number" name='patientId'/>
		<br>
		Name: <input type= 'text' name= 'name' />
		<br>
		Email: <input type= 'text' name= 'email' />
		<br>
	
		
		<button type='submit' name = 'regBtn'>Register</button>
	</form>
	
	<table>
		<thead>
			<tr>
				<th>Id</th><th>Name</th><th>Email</th><th>Registered Date</th>
			</tr>
		</thead>
		<tbody>
		
		<%
		
		List<Patient> patients = null;
		patients = (List<Patient>)request.getAttribute("patients");
			
			if(patients!=null){
				for(Patient p : patients){
					out.write("<form method='get' action='register'>");
					out.write("<tr>");
					out.write("<td>"+p.getPatientId()+"</td>");
					out.write("<td>"+p.getName()+"</td>");
					out.write("<td>"+p.getEmail()+"</td>");
					out.write("<td>"+p.getDate()+"</td>");
					
					out.write("<td>"+"<input type='hidden' name='del_name' value="+p.getName()+">"+"<button type='submit' name='delBtn'>Delete</button>"+"</td>");
					out.write("<td>"+ "<input type='hidden' name='edit_name' value="+p.getName()+">" +"<button type='submit' name='editBtn'>Edit</button>"+"</td>");
					out.write("</tr>");
					out.write("</form>");
				}
			}
		%>
		</tbody>
	</table>
</body>
</html>