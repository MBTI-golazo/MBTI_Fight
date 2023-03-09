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

#radio-previous1{
opacity:0;} 

#radio-previous3{
opacity:0;}
</style>
</head>
<body>
	
	<div class="box0" style="font-family:verdana; text-align: center"> 
      <h1>1/4</h1>
      <h3 style="font-family:courier">E or I</h3>
   </div>
   <br>
   <div class="box1" id = "boxe" style="font-family:verdana; text-align: center">
   <label for="efile">E</label>
   <progress id="efile" max="100" value="0"></progress>
</div>
	<div class="box2" id = "boxi" style="font-family:verdana; text-align: center">
   <label for="ifile">I</label>
   <progress id="ifile" max="100" value="0"></progress>
</div>
   <br>
	<div class="box3" style="font-family:verdana; text-align: center">
	<h3>1. 친구에게 먼저 만나자고 연락하는 편이다.</h3>
	<input type="radio" name="myRadio1" value="0">매우 아니다 
	<input type="radio" name="myRadio1" value="1">아니다
	<input type="radio" name="myRadio1" value="2">그렇다
	<input type="radio" name="myRadio1" value="3">매우 그렇다
	<input type="radio" id="radio-previous1" name="myRadio1" value="-1" checked="true"/>
	</div>
	<br>
	<div class="box4" style="font-family:verdana; text-align: center">
	<h3>2. 대부분의 시간을 혼자서 일할 수 있는 직업을 원한다.</h3>
	<input type="radio" name="myRadio2" value="0">매우 아니다 
	<input type="radio" name="myRadio2" value="1">아니다
	<input type="radio" name="myRadio2" value="2">그렇다
	<input type="radio" name="myRadio2" value="3">매우 그렇다
	</div>
	<br>
	<div class="box5" style="font-family:verdana; text-align: center">
	<h3>3. 관심이 가는 사람에게 다가가서 대화를 시작하기가 어렵지 않다.</h3>
	<input type="radio" name="myRadio3" value="0">매우 아니다 
	<input type="radio" name="myRadio3" value="1">아니다
	<input type="radio" name="myRadio3" value="2">그렇다
	<input type="radio" name="myRadio3" value="3">매우 그렇다
	<input type="radio" id="radio-previous3" name="myRadio3" value="-1" checked="true"/>
	</div>
	<br>
	<div class="box6" style="font-family:verdana; text-align: center">
	<h3>4. 단체 활동에 참여하는 일을 즐긴다.</h3>
	<input type="radio" name="myRadio4" value="0">매우 아니다 
	<input type="radio" name="myRadio4" value="1">아니다
	<input type="radio" name="myRadio4" value="2">그렇다
	<input type="radio" name="myRadio4" value="3">매우 그렇다
	</div>
	<br>
	<div class="box7" style="font-family:verdana; text-align: center">
	<h3>5. 혼자보다는 다른 사람과 시간을 보내고 싶어한다.</h3>
	<input type="radio" name="myRadio5" value="0">매우 아니다 
	<input type="radio" name="myRadio5" value="1">아니다
	<input type="radio" name="myRadio5" value="2">그렇다
	<input type="radio" name="myRadio5" value="3">매우 그렇다
	</div>
	<br>
	<div class="box8" style="font-family:verdana; text-align: center">
	<form action="/springmbti/surveytwo" method="post">
		<input type="submit" value="제출">
	</form>
	</div>	
</body>
<script>
$("input[name=myRadio1]").mouseup(function() {
	 oldnum= $('input[name=myRadio1]:checked').val();
	
}).change(function () {
	var changenum = $('input[name=myRadio1]:checked').val();
	var eoldValue = $('#efile').attr("value");
	var ioldValue = $('#ifile').attr("value");
	$.ajax({
		url : "surveyone1",
		type : "POST",
		async : "false",
		dataType : "json",
		data : { 
		 onum : oldnum,		
		 qnum : changenum
		},
		success : function(data) {
			var values = Object.values(data);
			if (data['onum'] == 3) {
				console.log('3');
				var everyold = eoldValue - 20;
				$('#efile').attr("value",everyold);
			} else if (data['onum'] == 2) {
				console.log('2');
				var eold = eoldValue - 10;
				$('#efile').attr("value",eold);	
			} else if (data['onum'] == 1) {
				console.log('1');
				var iold = ioldValue - 10;
				$('#ifile').attr("value",iold);
			} else if (data['onum'] == 0) {
				console.log('0');
				var iveryold = ioldValue - 20;
				$('#ifile').attr("value",iveryold);
			} else {
				console.log('-1');
			}
			
			var eold = $('#efile').attr("value");
			var iold = $('#ifile').attr("value");
			
			if(data['qnum']==3) {
				console.log('3');
				var number = eold + 20;
				$('#efile').attr("value",number);
			} else if(data['qnum']==2) {
				console.log('2');
				var number = eold + 10;
				$('#efile').attr("value",number);
			} else if(data['qnum']==1) {
				console.log('1');
				var number = iold + 10;
				$('#ifile').attr("value",number);
			} else if(data['qnum']==0) {
				console.log('0');
				var number = iold + 20;
				$('#ifile').attr("value",number);
		} else {
			console.log('-1');
		}	
		},
		error: function(data) {
		alert('ajax 실패!');
		}
	});
})


$("input[name=myRadio3]").mouseup(function() {
	 oldnum3= $('input[name=myRadio3]:checked').val();
	
}).change(function () {
	var changenum3 = $('input[name=myRadio3]:checked').val();
	var eoldValue3 = $('#efile').attr("value");
	var ioldValue3 = $('#ifile').attr("value");
	$.ajax({
		url : "surveyone3",
		type : "POST",
		async : "false",
		dataType : "json",
		data : { 
		 onum : oldnum3,		
		 qnum : changenum3
		},
		success : function(data3) {
			var values3 = Object.values(data3);
			if (data3['onum3'] == 3) {
				console.log('3');
				var everyold3 = eoldValue3 - 20;
				$('#efile').attr("value",everyold3);
			} else if (data3['onum3'] == 2) {
				console.log('2');
				var eold3 = eoldValue3 - 10;
				$('#efile').attr("value",eold3);	
			} else if (data3['onum3'] == 1) {
				console.log('1');
				var iold3 = ioldValue3 - 10;
				$('#ifile').attr("value",iold3);
			} else if (data3['onum3'] == 0) {
				console.log('0');
				var iveryold3 = ioldValue3 - 20;
				$('#ifile').attr("value",iveryold3);
			} else {
				console.log('-1');
			}
			
			var eold3 = $('#efile').attr("value");
			var iold3 = $('#ifile').attr("value");
			
			if(data3['qnum3']==3) {
				console.log('3');
				var number3 = eold3 + 20;
				$('#efile').attr("value",number3);
			} else if(data3['qnum3']==2) {
				console.log('2');
				var number3 = eold3 + 10;
				$('#efile').attr("value",number3);
			} else if(data3['qnum3']==1) {
				console.log('1');
				var number3 = iold3 + 10;
				$('#ifile').attr("value",number3);
			} else if(data3['qnum3']==0) {
				console.log('0');
				var number3 = iold3 + 20;
				$('#ifile').attr("value",number3);
		} else {
			console.log('-1');
		}	
		},
		error: function(data3) {
		alert('ajax 실패!');
		}
	});
})


</script>
</html>