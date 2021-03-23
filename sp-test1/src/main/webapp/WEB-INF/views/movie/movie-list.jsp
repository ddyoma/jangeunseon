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
				<th>번호(rn)</th>
				<th>썸네일</th>
				<th>제목</th>
				<th>부제</th>
				<th>제작일</th>
				<th>연결URL</th>
			</tr>
		</thead>
		<tbody id="tBody"></tbody>
	</table>

	<script>
	//구조체이기때문에 for문쓰지않음
	window.onload = function() {
	var x = new XMLHttpRequest();
		x.open('GET', '/movies');
		x.onreadystatechange = function() {
			if (x.readyState == 4 && x.status == 200) {
				console.log(x.responseText);
				var r = JSON.parse(x.responseText);
				var response = r.response;
				var body = r.response.body;
				var items = body.items;
				var itemList = items.item;
				
			var h ='';
				for(var item of itemList){
					
					h += '<tr onclick="location.href=\'/views/user-info/user-info-view?uiNum=' + item.url  +'\'">';
					h += '<td>' + item.rn+'</td>';
					h += '<td>' + item.referenceIdentifier+'</td>';
					h += '<td>' + item.title+'</td>';
					h += '<td>' + item.alternativeTitle+'</td>';
					h += '<td>' + item.createdDate+'</td>';
					h += '<td>' + item.url+'</td>';
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