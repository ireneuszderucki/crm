<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/fragments/header.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit customer form</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
	<div class="w3-container w3-orange">
  		<p>Edit customer form</p>
  	</div>
	<form class="w3-container" action="EditCustomer" method="post">
		<label>Customer ID</label>
			<input class="w3-input" name="id" type="text" value="${customer.id}" readonly>
		<label>Name</label>
			<input class="w3-input" name="name" type="text" value="${customer.name}">
		<label>Surname</label>
			<input class="w3-input" name="surname" type="text" value="${customer.surname}">
		<label>Birthday</label>
			<input class="w3-input" name="birthday" type="text" value="${customer.birthday}">
		<input class="w3-input" name="submitEdit" value="Submit" type="submit">
</form>
	


</body>
</html>
<%@ include file="/WEB-INF/fragments/footer.jspf" %>