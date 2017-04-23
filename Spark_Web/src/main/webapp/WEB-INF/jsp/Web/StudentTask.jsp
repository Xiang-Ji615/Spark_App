<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<jsp:include page="../Shared/Head.jsp"></jsp:include>

<body class="index" id="page-top">

	<!-- Navigation -->
	<nav class="navbar fixed-top navbar-toggleable-md navbar-light"
		id="mainNav">
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navbarExample"
			aria-controls="navbarExample" aria-expanded="false"
			aria-label="Toggle navigation">
			Menu <i class="fa fa-bars"></i>
		</button>
		<div class="container">
			<a class="navbar-brand" href="#page-top">Spark App</a>
			<div class="collapse navbar-collapse" id="navbarExample">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="#">Teachers</a>
					</li>
					<li class="nav-item"><a id="logout" class="nav-link" href="javascript:formSubmit()">Logout</a></li>
					<!--  li class="nav-item">
                        <a class="nav-link" href="#about"></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#contact">Contact</a>
                    </li -->
				</ul>
			</div>
		</div>
	</nav>

	<section id="contact">
		<div class="container">
			<h1>Task Detail</h1>
		</div>
	</section>



	<jsp:include page="../Shared/Foot.jsp"></jsp:include>

</body>

</html>
