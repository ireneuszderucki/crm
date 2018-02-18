<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/fragments/header.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add new customer form</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
	<div class="w3-container w3-green">
  		<p>Add new employee form</p>
  	</div>
	<form class="w3-container" action="AddEmployee" method="post">
		<label>Name</label>
			<input class="w3-input" name="name" type="text" placeholder="type the name">
		<label>Surname</label>
			<input class="w3-input" name="surname" type="text" placeholder="type the surname">
		<label>Adress</label>
			<input class="w3-input" name="address" type="text" placeholder="address">
		<label>Cell No</label>
			<input class="w3-input" name="cellNo" type="text" placeholder="cellNo">
		<label>Notice</label>
			<input class="w3-input" name="notice" type="text" placeholder="notice">
		<label>ManHourCost</label>
			<input class="w3-input" name="manHourCost" type="number" step="0.01" placeholder="manHourCost">
		<input class="w3-input" name="submitNew" value="Submit" type="submit">
	</form>
</body>
</html>
<%@ include file="/WEB-INF/fragments/footer.jspf" %>