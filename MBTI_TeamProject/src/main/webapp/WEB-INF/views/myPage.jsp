<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html>
<meta charset="UTF-8">

<head>
    <meta charset="UTF-8">
    <title>Title</title>
    
<script src="https://code.jquery.com/jquery-2.2.4.min.js" 
integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" 
rossorigin="anonymous"></script>


<script src="../js/mypage.js"></script>

</head>
<body>
    
    <div class="box1" style="font-family:verdana; text-align: left"> 
		<h2>나만의  MBTI 캐릭터 만들기</h2> <h3 style="font-family:courier">모두 덤벼라!</h3>
		<h1>MBTI 미니 대전</h1>
	</div>
    <!-- 개인 캐릭터 넣기, 없으면 물음표 , 있으면 캐릭터로 이미지 띄우고 -->
    
    <br><br>
    <!-- user email이 primary로 DB에 저장되어 있으면  토큰, 이메일, 닉네임, 프로필 이미지 가져오는데 
    	db에 없으면 저장이 되는데 , 여기서 확인을 하고  -->

	<form action="/springmbti/survey1" method="post">
    		<input type="submit" value="설문조사">
    </form>
    
    <!-- canregister는 가입이고 -->
	 <c:choose>
	      <c:when test="${ !canRegister }">
	         <button id="deleteBtn" disabled="disabled">삭제하기</button>
	         <button id="fightStartBtn" disabled="disabled">대결하기</button>
	      </c:when>
	      
	      <c:when test="${ characterNum }">
	         <button id="deleteBtn">삭제하기</button>
	         <button id="fightStartBtn">대결하기</button>
	      </c:when>
	 </c:choose>
	<!-- 삭제 하시겠습니까? 모달넣어야 하고  -->
	<!-- 캐릭터 넘버가 맞으면 삭제하기와 대결하기 버튼이 활성화가 되고 설문조사 버튼이 비활성화-->

  

</body>
</html>