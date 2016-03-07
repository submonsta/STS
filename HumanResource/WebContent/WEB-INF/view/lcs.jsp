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
		<th>LOCATIONS_ID</th>
		<th>STREET_ADDRESS</th>
		<th>POSTAL_CODE</th>
		<th>CITY</th>
		<th>STATE_PROVINCE</th>
		<th>COUNTRY_ID</th>
	</tr>
	
	<c:forEach items="${ allLocations }" var="lcs">
	<tr>
		<td>${ lcs.locationId }</td>
		<td>${ lcs.streetAddress }</td>
		<td>${ lcs.postalCode }</td>
		<td>${ lcs.city }</td>
		<td>${ lcs.stateProvince }</td>
		<td>${ lcs.countryId }</td>
	</tr>
	</c:forEach>

</table>

</body>
</html>