<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/fragments/header.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete customer</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
	<div class="w3-container w3-red">
  		<p>Delete confirmation</p>
  	</div>
	<form class="w3-container" action="DeleteCustomer" method="post">
		<h1>Are you sure you want to delete the customer: ${customer.name} ${customer.surname}?</h1>
		<input type="hidden" name="id" value="${customer.id}">
		<input class="w3-bar w3-red" type="submit" name="yes" value="yes">
		<input class="w3-bar w3-green" type="submit" name="no" value="no">
	</form>
</body>
</html>
<%@ include file="/WEB-INF/fragments/footer.jspf" %>