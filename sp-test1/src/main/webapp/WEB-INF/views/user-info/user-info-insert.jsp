<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<input type="text" id="uiName" placeholder="이름"><br>
<input type="text" id="uiId"placeholder="아이디"><br>
<input type="text" id="uiPwd"placeholder="비번"><br>
<input type="text" id="uiGenre"placeholder="장르"><br>
<input type="text" id="uiEmail"placeholder="이메일"><br>
<input type="text" id="uiAddress"placeholder="휴대폰1"><br>
<input type="text" id="uiPhone1"placeholder="휴대폰2"><br>
<input type="text" id="uiPhone2"placeholder="주소"><br>
<input type="text" id="uiHint"placeholder="비번힌트"><br>
<input type="text" id="uiAnswer"placeholder="비번답"><br>
<button onclick="join()">회원가입 </button>
<script>function join(){
	var p ={};
	var objs = document.querySelectorAll('input[type=text]');
	for(var i=0; i<objs.length;i++){
		var obj = objs[i];
		var key = obj.id;
		var value = obj.value;
		p[key] = value;
	}
	console.log(p);
	var x = new XMLHttpRequest();
	x.open('POST', '/users');
	x.onreadystatechange = function() {
		if (x.readyState == 4 && x.status == 200) {
		
			console.log(x.responseText);
			
			}
			
		
	}
	x.setRequestHeader('content-type','application/json;charset=utf-8');
	x.send(JSON.stringify(p));
	
	
}</script>
</body>

</html>