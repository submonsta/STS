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
		<th>MOVIE_ID</th>
		<th>TITLE</th>
		<th>RATE</th>
		<th>RUNNING_TIME</th>
		<th>OPEN_DATE</th>
		<th>GRADE_ID</th>
		<th>GRADE_TITLE</th>
	</tr>

	<tr align="center">
		<td>${ selectMovie.movieId }</td>
		<td>${ selectMovie.title }</td>
		<td>${ selectMovie.rate }</td>
		<td>${ selectMovie.runningTime }</td>
		<td>${ selectMovie.openDate }</td>
		<td>${ selectMovie.gradeId }</td>
		<td>${ selectMovie.gradeTitle }</td>
	</tr>

</table>

<table border="1">	
	<tr>
		<th>DIRECTOR_NAME</th>
	</tr>
	<c:forEach items="${ selectDirector }" var="directors">
	<tr align="center">
		<td>${ directors.directorName }</td>
	</tr>
	</c:forEach>
</table>

<table border="1">	
	<tr>
		<th>ACTOR_NAME</th>
	</tr>
	<c:forEach items="${ selectActor }" var="actors">
	<tr align="center">
		<td>${ actors.actorName }</td>
	</tr>
	</c:forEach>
</table>

<table border="1">	
	<tr>
		<th>GENRE_TITLE</th>
	</tr>
	<c:forEach items="${ selectGenre }" var="genres">
	<tr align="center">
		<td>${ genres.genreTitle }</td>
	</tr>
	</c:forEach>
</table>


</body>
</html>