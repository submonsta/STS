<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="/jQueryTest/resource/js/jquery-1.12.1.js"></script>
<script>
	$(document).ready(function(){
		
	    $("#btn1").click(function(){
	        alert("Text: " + $("#test").text());
	    });
	    
	    $("#btn2").click(function(){
	        alert("HTML: " + $("#test").html());
	    });
	    
	    $("#btn3").click(function(){
	        $("#p1").css("color", "red")
	            .slideUp(2000)
	            .slideDown(2000);
	    });
	    
	    $("#btn4").click(function(){
	        var div = $("#divbox");  
	        div.animate({left: '100px'}, "slow");
	        div.animate({fontSize: '3em'}, "slow");
	    });
	    
	    $("#btn5").click(function(){
	        $("#div1").fadeToggle();
	        $("#div2").fadeToggle("slow");
	        $("#div3").fadeToggle(3000);
	    });
	    
	});
</script>
</head>
<body>

<button id="btn1">Show Text</button>
<button id="btn2">Show HTML</button>
<button id="btn3">Fade Animation</button>
<button id="btn5">Fade In/Out Animation</button>
<button id="btn4">Start Animation</button>


<br><br>

<p id="test">This is some <b>bold</b> text in a paragraph.</p>

<br>

<p id="p1">jQuery is Not fun!!</p>

<br><br>

<div id="divbox" style="background:#98bf21;height:100px;width:200px;position:absolute;">Box</div>

<br><br><br><br><br><br><br><br>

<div id="div1" style="width:80px;height:80px;background-color:red;"></div>
<br>
<div id="div2" style="width:80px;height:80px;background-color:green;"></div>
<br>
<div id="div3" style="width:80px;height:80px;background-color:blue;"></div>

</body>
</html>