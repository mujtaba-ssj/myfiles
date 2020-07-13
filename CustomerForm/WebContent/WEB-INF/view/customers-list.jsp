<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Customers List</title>
<link type="text/css"
	rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css"/>
	
<link href="https://fonts.googleapis.com/css2?family=Raleway:wght@200&display=swap" rel="stylesheet"> 
</head>
<body>

<div id="wrapper">
	<div id="header">
	<h2>Customer Relationship Manager</h2>
	</div>
</div>

<div id="container">
	<div id="content"> 
	<input type="button" value="Add Customer" class="add-button" onclick="window.location.href='showFormForAdd'; return false;">
	
	<form:form action="search" method="get">
		Search Customer: <input type="text" name="theSearchName"/>
		<input type="submit" value="Search" class="add-button"/>
	</form:form>	
			<table id="we">
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Gender</th>
				<th>Action</th>
			</tr>
			<c:forEach var="tempCustomer" items="${customers}">
				
				<c:url var="updateLink" value="/customer/showFormForUpdate">
					<c:param name="customerId" value="${tempCustomer.id}"/>
				</c:url>
				<c:url var="deleteLink" value="/customer/delete">
					<c:param name="customerId" value="${tempCustomer.id}"/>
				</c:url>
				
				<tr>
					<td> <em>${tempCustomer.firstName}</em> </td>
					<td> <em>${tempCustomer.lastName}</em> </td>
					<td> <em>${tempCustomer.email}</em> </td>
					<td> <em>${tempCustomer.gender}</em>	</td>
					<td> 
					<a href="${updateLink}">Update</a>|
					<a href="${deleteLink}" onclick="if(!(confirm('Are you sure you want to delete this entry ?'))) return false">Delete</a>
					</td>
				</tr>
			</c:forEach>
		
		</table>
		<hr>
		<c:url var="listCustomerLink" value="/customer/list"/>
		<a href="${listCustomerLink}">List All Customers</a>
	</div>
</div>

</body>
</html>