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
  		<c:when test="${not empty employees}">
  			<div class="w3-responsive">
  				<table class="w3-table-all">
					<tr>
						<th>Employee ID</th>
						<th>Name</th>
						<th>Surname</th>
						<th>Address</th>
						<th>CellNo</th>
						<th>Notice</th>
						<th>ManHourCost</th>
						<th>Link to employee's errands</th>
						<th>Edit the employee data</th>
						<th>Delete the employee data</th>
					</tr>
				<c:forEach items="${employees}" var="employee">
					<tr>
						<td>${employee.id}</td>			
						<td>${employee.name}</td>
						<td>${employee.surname}</td>
						<td>${employee.address}</td>
						<td>${employee.cellNo}</td>
						<td>${employee.notice}</td>
						<td>${employee.manHourCost}</td>
						<td><a href="EmployeeErrandsList?id=${employee.id}" class="w3-btn w3-khaki">Click here</a></td>
						<td><a href="EditEmployee?id=${employee.id}" class="w3-btn w3-orange">Edit</a></td>
						<td><a href="DeleteEmployee?id=${employee.id}" class="w3-btn w3-red">DELETE</a></td>
						
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
  	<a href="AddEmployee" class="w3-block w3-green">Add new employee</a>


</body>
</html>
<%@ include file="/WEB-INF/fragments/footer.jspf" %>