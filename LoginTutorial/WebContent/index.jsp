<%@page import="org.login.tutorials.DAO.UserDAO"%>
<%@page import="org.login.tutorial.resource.UserDetailsDTO"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Details</title>
<style type="text/css">
<%@include file="/WEB-INF/css/style.css"%>
</style>
</head>
<body class="center">

	<div class="registration_div">
		<h2>User Details</h2>

		<div class="form-style-1">
			<table border="1" width="100%">
				<tbody>
					<tr>
						<th>Name</th>
						<th>User Id</th>
						<th>Email</th>
					</tr>
					<%
						UserDAO repositry = new UserDAO();
						Iterator<UserDetailsDTO> iterator = repositry.getUserCollection().iterator();
						while (iterator.hasNext()) {
							UserDetailsDTO userDetailsDTO = iterator.next();
					%>
					<tr>
						<td><%=userDetailsDTO.getName()%></td>
						<td><%=userDetailsDTO.getUserName()%></td>
						<td><%=userDetailsDTO.getEmail()%></td>
					</tr>
					<%
						}
					%>

				</tbody>
			</table><br/>
			<input type="button" value="Login" onclick="window.location.href='login.jsp'"> 
			<input type="button" value="Register" onclick="window.location.href='register.jsp'">
		</div>
	</div>
</body>
</html>