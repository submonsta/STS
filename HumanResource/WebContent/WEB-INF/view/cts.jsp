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
		<th>COUNTRY_ID</th>
		<th>COUNTRY_NAME</th>
		<th>REGION_ID</th>
	</tr>
	<c:forEach items="${ allCountries }" var="cts">
	<tr>
		<td>${ cts.countryId }</td>
		<td>${ cts.countryName }</td>
		<td>${ cts.regionId }</td>
	</tr>
	</c:forEach>
</table>

</body>
</html>