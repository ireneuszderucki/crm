<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/fragments/header.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit vehicle form</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
	<div class="w3-container w3-orange">
  		<p>Edit vehicle form</p>
  	</div>
	<form class="w3-container" action="EditVehicle" method="post">
		<label>Vehicle ID</label>
			<input class="w3-input" name="id" type="text" value="${vehicle.id}" readonly>
		<label>Customer ID</label>
			<input class="w3-input" name="customer_id" type="number" value="${vehicle.customer_id}">
		<label>Model</label>
			<input class="w3-input" name="model" type="text" value="${vehicle.model}">
		<label>Brand</label>
			<input class="w3-input" name="brand" type="text" value="${vehicle.brand}">
		<label>Production Year</label>
			<input class="w3-input" name="productionY" type="text" value="${vehicle.productionY}">
		<label>Registration Number</label>
			<input class="w3-input" name="registrationNo" type="text" value="${vehicle.registrationNo}">
		<label>Next Inspection Date</label>
			<input class="w3-input" name="nextInspectionDate" type="text" value="${vehicle.nextInspectionDate}">			
		<input class="w3-input" name="submitEdit" value="Submit" type="submit">
	</form>
</body>
</html>
<%@ include file="/WEB-INF/fragments/footer.jspf" %>