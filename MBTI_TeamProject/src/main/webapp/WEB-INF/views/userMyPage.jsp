<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>마이 페이지</h1>
	이름 - ${ sessionScope.myUser.userName } <br>
	이메일 - ${sessionScope.myUser.userEmail } <br>
	내 유저 번호 - ${ requestScope.myNum } <br>
	<h3>내 캐릭터 정보</h3>
	HP - ${ sessionScope.myCharacter.characterHP } <br>
	물리공격력 - ${ sessionScope.myCharacter.characterAD } <br>
	마법공격력 - ${ sessionScope.myCharacter.characterAP } <br>
	물리방어력 - ${ sessionScope.myCharacter.characterADDefence } <br>
	마법방어력 - ${ sessionScope.myCharacter.characterAPDefence } <br>
   	속도 - ${ sessionScope.myCharacter.characterSpeed } <br>
	명중률 - ${ sessionScope.myCharacter.characterHitRate } <br>
	회피율 - ${ sessionScope.myCharacter.characterAvoidanceRate } <br>
	크리티컬 확률 - ${ sessionScope.myCharacter.characterCritical } <br>
	기본추가공격력 - ${ sessionScope.myCharacter.characterHP } <br>
	
	
	
	test
</body>
</html>