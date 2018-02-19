<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/fragments/header.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
	<c:choose>
  		<c:when test="${not empty vehicles}">
  			<div class="w3-responsive">
  				<table class="w3-table-all">
					<tr>
						<th>Vehicle ID</th>
						<th>Owner/Customer ID</th>
						<th>Model</th>
						<th>Brand</th>
						<th>Production Year</th>
						<th>Registration Number</th>
						<th>Next Inspection Date</th>
						<th>Link to vehicle's repairs list</th>
						<th>Edit the vehicle data</th>
						<th>Delete the vehicle data</th>
					</tr>
				<c:forEach items="${vehicles}" var="vehicle">
					<tr>
						<td>${vehicle.id}</td>			
						<td>${vehicle.customer_id}</td>
						<td>${vehicle.model}</td>
						<td>${vehicle.brand}</td>
						<td>${vehicle.productionY}</td>
						<td>${vehicle.registrationNo}</td>
						<td>${vehicle.nextInspectionDate}</td>
						<td><a href="VehicleRepairList?id=${vehicle.id}" class="w3-btn w3-khaki">Click here</a></td>
						<td><a href="EditVehicle?id=${vehicle.id}" class="w3-btn w3-orange">Edit</a></td>
						<td><a href="DeleteVehicle?id=${vehicle.id}" class="w3-btn w3-red">DELETE</a></td>
						
					</tr>
				</c:forEach>
			</table>
		</div>
  		</c:when>
  		<c:otherwise>
  			<div class="w3-container w3-red">
    			<h1>${defaultMsg}</h1>
    		</div>
  		</c:otherwise>
  	</c:choose>
  	<a href="AddVehicle" class="w3-block w3-green">Add new vehicle</a>


</body>
</html>
<%@ include file="/WEB-INF/fragments/footer.jspf" %>