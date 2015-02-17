<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration</title>
<style type="text/css">
<%@ include file="/WEB-INF/css/style.css"%>
</style>
</head>

<body class="center">
	<div class="registration_div"> 
	<h2 >User Registration</h2> 
	<form action="LoginTutorial/register" method="POST">
		<ul class="form-style-1">
			<li><label>Full Name <span class="required">*</span></label><input
				type="text" name="first_name" class="field-divided" placeholder="First" />&nbsp;<input
				type="text" name="last_name" class="field-divided" placeholder="Last" /></li>
			<li><label>UserId <span class="required">*</span></label> <input
				type="text" name="user_name" class="field-long" /></li>
			<li><label>Email <span class="required">*</span></label> <input
				type="email" name="email" class="field-long" /></li>
			<li><label>Password <span class="required">*</span></label> <input
				type="password" name="password" class="field-long" /></li>
			<li><input type="submit" value="Submit" /></li>
		</ul>
	</form>
	</div>

</body>
</html>