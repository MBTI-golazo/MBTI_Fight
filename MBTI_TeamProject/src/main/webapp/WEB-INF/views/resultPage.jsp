<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="resources/css/resultpage.css">
    <script>
	    function popuptest(){
	    	
	    	alert("test")
	        var url = "http://localhost:8080/springmbti/popuptest.jsp";
	        var name = "popup test";
	        var option = "width = 500, height = 500, top = 100, left = 200, location = no"
	        window.open(url, name, option);
	    }
    </script>
    <style>
ul {
	display: table;
	margin-left: auto;
	margin-right: auto;
}

/* button.share_btn {
	background-color: grey;
	width: 200px;
	height: 30px;
}

button.battle_btn {
	background-color: skyblue;
	width: 200px;
	height: 30px;
}

button.myPage_btn {
	background-color: lightgrey;
	width: 200px;
	height: 30px;
	box-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.1), 0 2px 4px -1px
		rgba(0, 0, 0, 0.06);
	cursor: pointer;
	transition: 0.5s;
} */
</style>
</head>
<body>
    <div align="center"><h3>당신의 MBTI는...</h3></div>
    <div align="center"><h3>????입니다.</h3></div>
    <div align="center"><h1>당신의 캐릭터는 ???입니다.</h1></div>
    
    <h3><CENTER>
		<img
		width="300"
		src="resources/img/00.jpg">
	</CENTER></h3>
    <div>
    	<ul>
    		<li>
    			결과 코멘트 
    		</li>
    		<li>
    			결과 코멘트 2
    		</li>
    	</ul>
    </div>
    <div class="btn_div">
    	<button class="share_btn">공유하기</button><br>
    	<button class="battle_btn" onclick="popuptest()">대전하기</button><br>
    	<button class="myPage_btn">마이페이지</button>
    </div>
    
</body>
</html>