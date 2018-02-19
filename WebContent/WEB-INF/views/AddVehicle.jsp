<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/fragments/header.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add new vehicle form</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
	<div class="w3-container w3-green">
  		<p>Add new vehicle form</p>
  	</div>
	<form class="w3-container" action="AddVehicle" method="post">
		<label>Customer ID</label>
			<input class="w3-input" name="customer_id" type="number" placeholder="Customer ID">
		<label>Model</label>
			<input class="w3-input" name="model" type="text" placeholder="model">
		<label>Brand</label>
			<input class="w3-input" name="brand" type="text" placeholder="brand">
		<label>Production year</label>
			<input class="w3-input" name="productionY" type="text" placeholder="production year">
		<label>Registration number</label>
			<input class="w3-input" name="registrationNo" type="text" placeholder="registrationNo">
		<label>Next Inspection Date</label>
			<input class="w3-input" name="nextInspectionDate" type="text" placeholder="next inspection date">			
		<input class="w3-input" name="submitNew" value="Submit" type="submit">
	</form>
</body>
</html>
<%@ include file="/WEB-INF/fragments/footer.jspf" %>