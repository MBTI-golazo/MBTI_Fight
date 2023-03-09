<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script type="text/JavaScript" src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
    <link rel="stylesheet" href="resources/css/resultpage.css">
    <style>
	ul {
		display: table;
		margin-left: auto;
		margin-right: auto;
	}
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
    	<button class="share_btn" onClick="sendLinkDefault()">공유하기</button><br>
    	<button class="battle_btn">대전하기</button><br>
    	<button class="myPage_btn" onClick="location.href='/springmbti/test1'">마이페이지</button>
    </div>
</body>
<script type="text/javascript">
	function sendLinkCustom(){
		Kakao.init("14ff9a0b93923e6ee771ed79828eb683");
		Kakao.Link.sendCustom({
			templateId:90915
		});
	}
	try {
		  function sendLinkDefault() {
		    Kakao.init("14ff9a0b93923e6ee771ed79828eb683")
		    Kakao.Link.sendDefault({
		      objectType: "feed",
		      content: {
		        title: "MBTI결과공유",
		        description: "친구의 MBTI결과를 확인해보세요",
		        imageUrl:
		          "https://i.imgur.com/gz3FELd.jpg",
		        link: {
		          mobileWebUrl: "http://123.142.252.26:23232/springmbti/test",
		          webUrl: "http://123.142.252.26:23232/springmbti/test",
		        },
		      },
		      itemContent:{
		    	profileText:"${ myUser.userName }",
		    	profileImageUrl:"${ myUser.userProfile }"
		      },
		      buttons: [
		        {
		          title: "확인하러 가기",
		          link: {
		            mobileWebUrl: "http://123.142.252.26:23232/springmbti/test",
		            webUrl: "http://123.142.252.26:23232/springmbti/test",
		          },
		        }
		      ],
		    })
		  }
		; window.kakaoDemoCallback && window.kakaoDemoCallback() }
		catch(e) { 
			window.kakaoDemoException && window.kakaoDemoException(e) 
		}
</script>
</html>