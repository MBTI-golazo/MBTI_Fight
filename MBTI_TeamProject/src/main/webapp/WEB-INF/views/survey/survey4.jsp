<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<style>
label {
    padding-right: 10px;
    font-size: 1rem;
}


</style>
</head>
<body>
	<div class="box1" style="font-family:verdana; text-align: center"> 
      <h2>나만의  MBTI 캐릭터 만들기</h2>
      <h3 style="font-family:courier">모두 덤벼라!</h3>
   </div>
   <br>
	<div class="box2" style="font-family:verdana; text-align: center">
	<h3>1. 친구에게 먼저 만나자고 연락하는 편이다.</h3>
	<input type="radio" name="myCheckBox1" value="0">매우 아니다 
	<input type="radio" name="myCheckBox1" value="1">아니다
	<input type="radio" name="myCheckBox1" value="2">그렇다
	<input type="radio" name="myCheckBox1" value="3">매우 그렇다
	</div>
	<br>
	<div class="box3" style="font-family:verdana; text-align: center">
	<h3>2. 대부분의 시간을 혼자서 일할 수 있는 직업을 원한다.</h3>
	<input type="radio" name="myCheckBox2" value="0">매우 아니다 
	<input type="radio" name="myCheckBox2" value="1">아니다
	<input type="radio" name="myCheckBox2" value="2">그렇다
	<input type="radio" name="myCheckBox2" value="3">매우 그렇다
	</div>
	<br>
	<div class="box4" style="font-family:verdana; text-align: center">
	<h3>3. 관심이 가는 사람에게 다가가서 대화를 시작하기가 어렵지 않다.</h3>
	<input type="radio" name="myCheckBox3" value="0">매우 아니다 
	<input type="radio" name="myCheckBox3" value="1">아니다
	<input type="radio" name="myCheckBox3" value="2">그렇다
	<input type="radio" name="myCheckBox3" value="3">매우 그렇다
	</div>
	<br>
	<div class="box5" style="font-family:verdana; text-align: center">
	<h3>4. 단체 활동에 참여하는 일을 즐긴다.</h3>
	<input type="radio" name="myCheckBox4" value="0">매우 아니다 
	<input type="radio" name="myCheckBox4" value="1">아니다
	<input type="radio" name="myCheckBox4" value="2">그렇다
	<input type="radio" name="myCheckBox4" value="3">매우 그렇다
	</div>
	<br>
	<div class="box5" style="font-family:verdana; text-align: center">
	<h3>5. 혼자보다는 다른 사람과 시간을 보내고 싶어한다.</h3>
	<input type="radio" name="myCheckBox5" value="0">매우 아니다 
	<input type="radio" name="myCheckBox5" value="1">아니다
	<input type="radio" name="myCheckBox5" value="2">그렇다
	<input type="radio" name="myCheckBox5" value="3">매우 그렇다
	</div>
	<br>
	<div class="box5" style="font-family:verdana; text-align: center">
	<form action="" method="post">
		<input type="submit" value="제출">
	</form>
	</div>	
</body>
<script>
function surveyone1() {
	$.ajax({
		url : "surveyone1",
		type : "POST",
		async : "false",
		dataType : "json",
		data : { myid: $("#myid").val(),
				 otherid: $("#otherid").val(),
				 bnum: $("#boardnum").val(),
				 likenum: $("#likenum").val()
				},
		success : function(data) {
			
			var values = Object.values(data);
			let liketr = $("<tr></tr>");
			
			if(data['ajaxresult'] == 7){
			console.log('좋아요 성공하셨습니다!');
			$('#likecount').text(data['likeresult']);
			} else if(data['ajaxresult'] == 4) {
				alert('당신이 작성한 글입니다!');
			} else {
				alert('이미 좋아요를 하셨습니다!');
			}
		},
		error: function(data) {
			alert('ajax 실패!');
		}
			
	});
}

function surveyone2() {
	$.ajax({
		url : "likeajax",
		type : "POST",
		async : "false",
		dataType : "json",
		data : { myid: $("#myid").val(),
				 otherid: $("#otherid").val(),
				 bnum: $("#boardnum").val(),
				 likenum: $("#likenum").val()
				},
		success : function(data) {
			
			var values = Object.values(data);
			let liketr = $("<tr></tr>");
			
			if(data['ajaxresult'] == 7){
			console.log('좋아요 성공하셨습니다!');
			$('#likecount').text(data['likeresult']);
			} else if(data['ajaxresult'] == 4) {
				alert('당신이 작성한 글입니다!');
			} else {
				alert('이미 좋아요를 하셨습니다!');
			}
		},
		error: function(data) {
			alert('ajax 실패!');
		}
			
	});
}

function surveyone3() {
	$.ajax({
		url : "likeajax",
		type : "POST",
		async : "false",
		dataType : "json",
		data : { myid: $("#myid").val(),
				 otherid: $("#otherid").val(),
				 bnum: $("#boardnum").val(),
				 likenum: $("#likenum").val()
				},
		success : function(data) {
			
			var values = Object.values(data);
			let liketr = $("<tr></tr>");
			
			if(data['ajaxresult'] == 7){
			console.log('좋아요 성공하셨습니다!');
			$('#likecount').text(data['likeresult']);
			} else if(data['ajaxresult'] == 4) {
				alert('당신이 작성한 글입니다!');
			} else {
				alert('이미 좋아요를 하셨습니다!');
			}
		},
		error: function(data) {
			alert('ajax 실패!');
		}
			
	});
}

function surveyone4() {
	$.ajax({
		url : "likeajax",
		type : "POST",
		async : "false",
		dataType : "json",
		data : { myid: $("#myid").val(),
				 otherid: $("#otherid").val(),
				 bnum: $("#boardnum").val(),
				 likenum: $("#likenum").val()
				},
		success : function(data) {
			
			var values = Object.values(data);
			let liketr = $("<tr></tr>");
			
			if(data['ajaxresult'] == 7){
			console.log('좋아요 성공하셨습니다!');
			$('#likecount').text(data['likeresult']);
			} else if(data['ajaxresult'] == 4) {
				alert('당신이 작성한 글입니다!');
			} else {
				alert('이미 좋아요를 하셨습니다!');
			}
		},
		error: function(data) {
			alert('ajax 실패!');
		}
			
	});
}

function surveyone5() {
	$.ajax({
		url : "likeajax",
		type : "POST",
		async : "false",
		dataType : "json",
		data : { myid: $("#myid").val(),
				 otherid: $("#otherid").val(),
				 bnum: $("#boardnum").val(),
				 likenum: $("#likenum").val()
				},
		success : function(data) {
			
			var values = Object.values(data);
			let liketr = $("<tr></tr>");
			
			if(data['ajaxresult'] == 7){
			console.log('좋아요 성공하셨습니다!');
			$('#likecount').text(data['likeresult']);
			} else if(data['ajaxresult'] == 4) {
				alert('당신이 작성한 글입니다!');
			} else {
				alert('이미 좋아요를 하셨습니다!');
			}
		},
		error: function(data) {
			alert('ajax 실패!');
		}
			
	});
}
</script>
</html>