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
			<form method="POST" action="/Web/UpdateMark">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
					<input type="hidden" class="form-control form-control-warning"
							id="inputMark" placeholder="class" name="class" value="${classId}">
					<input type="hidden" class="form-control form-control-warning"
							id="inputMark" placeholder="student" name="student" value="${studentId}">
					<input type="hidden" class="form-control form-control-warning"
							id="inputMark" placeholder="student" name="task" value="${taskId}">
				<div class="form-group row">
					<label for="inputTaskDescription" class="col-sm-2 col-form-label">Task
						Description</label>
					<div class="col-sm-10">
						<textarea rows="5" class="form-control" id="inputTaskDescription"
							placeholder="Task Description" name="taskDescription" disabled>${taskDetail.task.taskDescription}</textarea>
					</div>
				</div>
				<div class="form-group row">
					<label for="inputMark" class="col-sm-2 col-form-label">Mark</label>
					<div class="col-sm-10">
						<input type="text" class="form-control form-control-warning" name="mark"
							id="inputMark" placeholder="mark" value="${taskDetail.mark}">
					</div>
				</div>
				<div class="form-group row">
					<div class="col-md-7 col-xs-0">
					</div>
					<div class="col-md-2  col-xs-12">
						<button type="submit" class="btn btn-primary btn-block">Update</button>
					</div>
					<div class="col-md-2 col-xs-12 col-xs-offset-0">
						<button id="btnCancel" class="btn btn-danger btn-block"  onclick="history.go(-1);" >Cancel</button>
					</div>
				</div>
		</form>
		<!--  h1>${taskDetail.task.taskDescription}</h1 -->
		</div>
	</section>



	<jsp:include page="../Shared/Foot.jsp"></jsp:include>

</body>

</html>
