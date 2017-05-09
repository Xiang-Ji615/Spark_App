<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<jsp:include page="../Shared/Head.jsp"></jsp:include>
<link href="../Student/css/Student.css" rel="stylesheet">

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
			<a class="navbar-brand" href="#page-top">SparQ App</a>
			<div class="collapse navbar-collapse" id="navbarExample">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="#">Students</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#">Tasks</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Marks</a></li>
					<li class="nav-item"><a id="logout" class="nav-link"
						href="javascript:formSubmit()">Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<section id="contact">
		<div class="container">
			<div class="row">
				<div class="col-sm-12 col-sm-offset-0 col-md-4 col-md-offset-4">
					<div class="card">
						<img class="card-img-top" src="../Student/Img/201818.svg"
							alt="Card image cap">
						<div class="card-block">
							<h4 class="card-title">Mario</h4>
							<p class="card-text">Score: 120</p>
							<a href="#" class="btn btn-primary">Edit profile</a>
						</div>
					</div>
				</div>
			</div>
			<div class="panel panel-info">
				<div class="panel-heading">Student</div>
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-hover">
							<tr>
								<th>Mark</th>
								<th>Task Detail</th>
								<th>Completed</th>
								<th>Due Date</th>
							</tr>
							<c:forEach items="${tasks}" var="task">
								<tr>
									<td>${task.mark}</td>
									<td>${task.task.taskDescription}</td>
									<td>
									<c:if test="${task.completed == '1'}">
										Yes
									</c:if> 
									<c:if test="${task.completed != '1'}">
										No
									</c:if>
									</td>
									<td>${task.dueDate}</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>

	<jsp:include page="../Shared/Foot.jsp"></jsp:include>

</body>
</html>