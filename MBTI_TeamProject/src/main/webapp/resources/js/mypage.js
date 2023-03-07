
function myFunc(){
	// 사용자가 선택한 url을 form의 action에 설정하는 작업을 해주기 - 확보해주기  
	let url = $("#myForm > select > option:selected").text();
	
	$("#myForm").attr("action",url);
	
	
	
}