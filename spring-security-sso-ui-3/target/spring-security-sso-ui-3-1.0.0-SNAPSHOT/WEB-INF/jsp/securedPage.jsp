<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Spring Security SSO Client For Site C</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" />
</head>

<body>
<div class="container">
	<div class="col-sm-12">
		<h1>Secured Page For Site C</h1>
		Welcome, <span th:text="${#authentication.name}">Name</span>
		<br/>
        Your authorities are <span th:text="${#authentication.authorities}">authorities</span>        
	</div>
</div>
</body>
</html>