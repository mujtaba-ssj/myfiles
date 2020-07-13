<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<style>
.error{
color:red}
</style>
<link href="https://fonts.googleapis.com/css2?family=Raleway:wght@200&display=swap" rel="stylesheet"> 
<link type="text/css"
rel="stylesheet"
href="${pageContext.request.contextPath}/resources/css/style1.css">
<link type="text/css"
rel="stylesheet"
href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
<title>Customer Forum - Add Details</title>
</head>
<body>
<div id="wrapper">
	<div id="header">
		<h2>Customer Relationship Manager</h2>
		</div>
		</div>
	<div id="container">
		<h3>Save Customer</h3>
		
<form:form action="saveCustomer" modelAttribute="customer" method="get">

<form:hidden path="id"/>

<table>
	<tr>
		<td><label>First Name:</label></td>
		<td><form:input path="firstName"/>
		<form:errors path="firstName" cssClass="error"/></td>
	</tr>
	<tr>
		<td><label>Last Name:</label></td>
		<td><form:input path="lastName"/></td>
	</tr>
	<tr>
		<td><label>Email:</label></td>
		<td><form:input path="email"/></td>
	</tr>
	<tr>
		<td><label>Gender:</label></td>
		<td ><label class="g"><em>Male:</em></label><form:radiobutton path="gender" value="Male"/>
		 <label class="g"><em>Female:</em></label><form:radiobutton path="gender" value="Female"/>
		 <label class="g"><em>Not Specified:</em></label><form:radiobutton path="gender" value="Not Specified"/></td>
	</tr>
	<tr>
		<td><input type="submit" value="Save" class="save"/></td>
	</tr>
</table>
</form:form>
</div>
<div style="clear; both;"></div>
<p>
	<a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
	</p>
</body>
</html>