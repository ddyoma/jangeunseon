<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>아이디</th>
			</tr>
		</thead>
		<tbody id="tBody"></tbody>
	</table>
	<button onclick="location.href='/views/user-info/user-info-insert'">등록</button>
	<script>
		window.onload = function() {
			var x = new XMLHttpRequest();
			x.open('GET', '/users');
			x.onreadystatechange = function() {
				if (x.readyState == 4 && x.status == 200) {
					
					console.log(x.responseText);
					var r = JSON.parse(x.responseText);
					var h = '';
					for(var i =0; i<r.length; i++){
						var user= r[i];
						h += '<tr onclick="location.href=\'/views/user-info/user-info-view?uiNum=' + user.uiNum  +'\'">';
						h += '<td>' + user.uiNum+'</td>';
						h += '<td>' + user.uiId+'</td>';
						h += '</tr>';
					}
					document.querySelector('#tBody').innerHTML = h;
				}
			}
			x.send();
		}
	</script>
</body>

</html>