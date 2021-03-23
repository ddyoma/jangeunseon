<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1" id ="tTable">
	
	</table>
	

	<script>
		var uiNum = ${param.uiNum};
		var x = new XMLHttpRequest();
		x.open('GET', '/user?uiNum=' + uiNum);
		x.onreadystatechange = function() {
			if (x.readyState == 4 && x.status == 200) {

				console.log(x.responseText);
				var r = JSON.parse(x.responseText);
				var h = '';
				for(var key in r){
					
					h += '<tr>';
					h += '<th>' + key+'</th>';
					h += '<td>' + r[key]+'</td>';
					h += '</tr>';
				
				}
				h += '<tr> <th colspan="2">';
				h += '<button onclick="location.href=\'/views/user-info/user-info-update?uiNum=' + r.uiNum  +'\'">수정</button>';
				h +='<button onclick="goDelete()">삭제</button></th></tr>';
				document.querySelector('#tTable').innerHTML = h;
			}
		}
		x.send();
		
		
		function goDelete(){
			x.open('DELETE','/user/${param.uiNum}');
			x.onreadystatechange = function() {
				if (x.readyState == 4 && x.status == 200) {
					var r = JSON.parse(x.responseText);
					console.log(r);
					
					
					}
					
				}
		
				x.send();
			}
	
	</script>

</body>
</html>