<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1">
	<tr>
		<th>DEPARTMENT_ID</th>
		<th>DEPARTMENT_NAME</th>
		<th>MANAGER_ID</th>
		<th>LOCATION_ID</th>
	</tr>
	
	<c:forEach items="${ allDepartments }" var="dep">
	<tr>
		<td>${ dep.departmentId }</td>
		<td>${ dep.departmentName }</td>
		<td>${ dep.managerId }</td>
		<td>${ dep.locationId }</td>
	</tr>
	</c:forEach>
</table>

</body>
</html>