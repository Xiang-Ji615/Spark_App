<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />
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
			<a class="navbar-brand" href="#page-top">SparQ App</a>
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
				<div class="panel-heading">Assign Task</div>
				<div class="panel-body">
					<div class="table-responsive">
						<input type="hidden" class="form-control form-control-warning"
							id="class" placeholder="class" name="class" value="${classId}">
						<input type="hidden" class="form-control form-control-warning"
							id="student" placeholder="student" name="student"
							value="${studentId}">
						<table class="table table-hover" id="taskTable">
							<tr>
								<th width="35%">Action</th>
								<th width="35%">Due Date</th>
								<th width="30%">Task Detail</th>
							</tr>
							<c:forEach items="${tasks}" var="task">
								<tr>
									<td><input type="checkbox" class="form-control addtask"
										data-width="100%" name="add" data-toggle="toggle"
										data-on="Added" data-off="No" taskid="${task.id}" /></td>
									<td><input type="text"
										class="form-control form-control addduedate" id="inputDuedate"
										placeholder="duedate" name="duedate" value="${dueDate}" taskid="${task.id}"></td>
									<td>${task.taskDescription}</td>
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
					<button id="btnConfirm" class="btn btn-primary btn-block">Confirm</button>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-md-7 col-xs-0"></div>
				<div class="col-md-2  col-xs-12">
					<!-- button type="submit" class="btn btn-primary btn-block">Update</button -->
				</div>
				<div class="col-md-2 col-xs-12 col-xs-offset-0">
					<a id="btnCancel" class="btn btn-danger btn-block"
						href="../Web/Student?class=${classId}&student=${studentId}">Back</a>
				</div>
			</div>
		</div>
	</section>


	<jsp:include page="../Shared/Foot.jsp"></jsp:include>
	<script src="../js/TaskDetail/bootstrap-toggle.min.js"></script>
	<script src="../js/AssignTask/AssignTask.js"></script>
</body>
</html>