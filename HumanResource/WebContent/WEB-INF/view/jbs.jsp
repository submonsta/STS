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
		<th>JOB_ID</th>
		<th>JOB_TITLE</th>
		<th>MIN_SALARY</th>
		<th>MAX_SALARY</th>
	</tr>
	
	<c:forEach items="${ allJobs }" var="jbs">
	<tr>
		<td>${ jbs.jobId }</td>
		<td>${ jbs.jobTitle }</td>
		<td>${ jbs.minSalary }</td>
		<td>${ jbs.maxSalary }</td>
	</tr>
	</c:forEach>

</table>

</body>
</html>