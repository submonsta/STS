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
		<th>MOVIE_TITLE</th>
		<th>ACTOR_NAME</th>
	</t999r>
	
	<c:forEach items="${ allList }" var="mas">
	<tr align="center">
		<td>${ mas.title }</td>.
		<td>${ mas.actorName }</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>