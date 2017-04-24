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
					<li class="nav-item"><a id="logout" class="nav-link"
						href="javascript:formSubmit()">Logout</a></li>
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
			<div class="panel panel-info">
				<div class="panel-heading">Student</div>
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-hover">
							<tr>
								<th>Action</th>
								<th>Mark</th>
								<th>Task Detail</th>
								<th>Completed</th>
								<th>Due Date</th>
							</tr>
							<c:forEach items="${tasks}" var="task">
								<tr>
									<td><a class="btn btn-primary"
										href="../Web/Task?class=${classId}&student=${studentId}&task=${task.id}">Detail</a>
									</td>
									<td>${task.mark}</td>
									<td>${task.task.taskDescription}</td>
									<td>${task.completed}</td>
									<td>${task.dueDate}</td>									
								</tr>
							</c:forEach>
						</table>
						<!--  div class="row">
						<div class="col-sm-offset-10 col-sm-2">
							<a href="ServiceBoxAdd" class="btn btn-primary btn-block">Add</a>
						</div>
					</div -->
					</div>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-md-7 col-xs-0"></div>
				<div class="col-md-2  col-xs-12">
					<!-- button type="submit" class="btn btn-primary btn-block">Update</button -->
				</div>
				<div class="col-md-2 col-xs-12 col-xs-offset-0">
					<a id="btnCancel" class="btn btn-danger btn-block"
						href="../Web/Class?class=${classId}">Back</a>
				</div>
			</div>
		</div>
	</section>



	<jsp:include page="../Shared/Foot.jsp"></jsp:include>

</body>

</html>
