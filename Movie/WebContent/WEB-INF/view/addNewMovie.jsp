<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" buffer="20kb"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="/resource/js/jquery-1.12.1.js"/>"></script>
<script type="text/javascript">

	$(document).ready( function() {
		
		$("#directors").click( function() {
			var selectedDirectors = "";
			
			$("#directors option:selected").each(function(index, data) {
				selectedDirectors += data.text;
				selectedDirectors += " , ";
				
			});
				$("#directorsName").text( selectedDirectors );
		} );
		
		$("#addNewMovie").click( function() {
			
			// MovieTitle Validation Check
			var movieTitle = $("#movieTitle").val();
			movieTitle = $.trim( movieTitle );
			if ( movieTitle == "" ) {
				alert("영화명 재 입력");
				$("#movieTitle").focus();
				return;
			}
			
			
			// Rate Validation Check
			var rate = $("#rate").val();
			rate = $.trim( rate );
			if ( rate == "" ) {
				alert("평점 재 입력");
				$("#rate").focus();
				return;
			}
			
			rate = parseFloat(rate);
			if ( isNaN(rate) ) {
				alert("평점 올바르게 입력 \n 평점은 소수점 포함 숫자");
				return;
			}
			
			// RunningTime Validation Check
			var runningTime = $("#runningTime").val();
			runningTime = $.trim( runningTime );
			if ( runningTime == "" ) {
				alert("상영 시간 재 입력");
				$("#runningTime").focus();
				return;
			}
			
			if ( runningTime.lengh > 5 ) {
				alert("상영시간 올바르게 입력");
				return;
			}
			
			var regExp = new RegExp("^[0-2]{0,1}[0-9]{1}:[0-5][0-9]$");
			var isValidRunningTime = regExp.test(runningTime);
			if ( isValidRunningTime == false ) {
				alert("상영시간을 올바르게 입력");
				return;
			}
			
			// OpenDate Validation Check
			var openDate = $("#openDate").val();
			openDate = $.trim( openDate );
			if ( openDate == "" ) {
				alert("개봉일 재 입력");
				$("#openDate").focus();
				return;
			}
			
			// Grade Validation Check
			var grade = $(".grade:checked").val();
			grade = $.trim( grade );
			if ( grade == "" ) {
				alert("등급 재 입력");
				$(".grade").fadeOut().fadeIn().fadeOut().fadeIn();
				return;
			}
			
			// Director Validation Check
			var directors = $("#directors option:selected").val();
			directors = $.trim( directors );
			if ( directors == "" ) {
				alert("감독 재 입력");
				$("#directors").fadeOut().fadeIn().fadeOut().fadeIn();
				return;
			}
			
			// Actor Validation Check
			var actors = $("#actors option:selected").val();
			actors = $.trim( actors );
			if ( actors == "" ) {
				alert("배우 재 입력");
				$("#actors").fadeOut().fadeIn().fadeOut().fadeIn();
				return;
			}
			
			// Genre Validation Check
			var genres = $(".genres:checked").val();
			genres = $.trim( genres );
			if ( genres == "" ) {
				alert("장르 재 입력");
				$(".genres").fadeOut().fadeIn().fadeOut().fadeIn();
				return;
			}
			
			// AddNewMovie
			var form = $("#addNewMovieForm")
			form.attr("method", "post");
			form.attr("action", "<c:url value="/addNewMovieAction" />");
			
			form.submit();
			
		} );
		
	} );

</script>
</head>
<body>
		
	<h1>영화 등록</h1>
	<hr/>
	
	<span class="errorCode">${ errorCode }</span>
	
	<form id="addNewMovieForm">
		영화명 : <input type="text" id="movieTitle" name="movieTitle" /> <br />
		평   점 : <input type="text" id="rate" name="rate" /> <br />
		상영시간 : <input type="text" id="runningTime" name="runningTime" /> <br />
		개봉일 : <input type="date" id="openDate" name="openDate" /> <br />
		상영등급 :
		<c:forEach items="${gradeList}" var="grade">
			<input type="radio" class="grade" name="grade" value="${grade.gradeId}" /> ${grade.gradeTitle }
		</c:forEach> <br />
		감   독 :
		<select id="directors" name="directors" multiple="multiple">
			<c:forEach items="${directorList}" var="director">
				<option value="${director.directorId}">${director.directorName}</option>
			</c:forEach>
		</select>
		<span id="directorsName"></span> 
		
		<br />
		출연진 :
		<select id="actors" name="actors" multiple="multiple">
			<c:forEach items="${actorList}" var="actor">
				<option value="${actor.actorId}">${actor.actorName}</option>
			</c:forEach>
		</select> <br />
		장   르 :
		<c:forEach items="${genreList}" var="genre">
			<input type="checkbox" class="genres" name="genres" value="${genre.genreId}" /> ${genre.genreTitle}
		</c:forEach> <br />
		<input type="button" id="addNewMovie" value="영화 등록!" />
	</form>
	
</body>
</html>