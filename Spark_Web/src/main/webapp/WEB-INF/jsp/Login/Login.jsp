<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../css/Admin/Login/Login.css" rel="stylesheet">
<link href="../bootstrap-combobox/css/bootstrap-combobox.css"
	rel="stylesheet">	
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="login">
		<h1>SparQ Login</h1>
		<form method="post" action="../User/Login/j_spring_security_check">
			<input type="text" name="username" placeholder="Username"
				required="required" /> <input type="password" name="password"
				placeholder="Password" required="required" /> <input type="hidden"
				name="${_csrf.parameterName}" value="${_csrf.token}" /> 
			<select
				class="input-large form-control" id="combobox" name="role">
				<option value="Student">Student</option>
				<option value="Teacher">Teacher</option>
				<option value="Parent">Parent</option>
			</select>
			<br/>
			<button type="submit" class="btn btn-primary btn-block btn-large">Log
				in</button>
		</form>
	</div>

	<script src="../vendor/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="../js/Admin/Login/Login.js"></script>
</body>
</html>