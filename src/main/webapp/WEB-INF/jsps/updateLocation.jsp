<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="UTF-8">
<title>Edit Location</title>
	<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
	<c:url value="/css/main.css" var="jstlCss" />
	<link href="${jstlCss}" rel="stylesheet" />
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Spring Boot</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#about">About</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">

		<div class="starter-template">
			<h1>Spring Boot Web JSP Example</h1>
			<h2>Message: ${message}</h2>
		</div>

	</div>
<div align="center" style="background-color:lightblue">
<form action = "updateLoc" method = "post" >
Id: <input type = "text" name="id" value="${location.id}" readonly="true"/> <br>
Code: <input type = "text" name="code" value="${location.code}"/> <br>
Name: <input type = "text" name="name" value="${location.name}"/> <br>
Type: Urban <input type = "radio" name="type" value="URBAN" ${location.type=='URBAN'? 'checked' :''}/>
        Rural <input type = "radio" name="type" value="RURAL" ${location.type=='RURAL'? 'checked' :''}/> <br> <br>
<input type="submit" value= "save" />
</form>
<br> ${msg} <br>
<a href="displayLocations">View All</a>
</div>

<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>