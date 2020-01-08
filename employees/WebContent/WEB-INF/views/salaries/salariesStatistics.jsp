<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>salary 통계 ㄱㅄ</h1>
	<table border = "1">
		<tr>
			<td>count</td>
			<td>${map.count}</td>
		</tr>
		
		<tr>
			<td>sum</td>
			<td>${map.sum}</td>
		</tr>
		
		<tr>
			<td>avg</td>
			<td>${map.avg}</td>
		</tr>
		
		<tr>
			<td>max</td>
			<td>${map.max}</td>
		</tr>
		
		<tr>
			<td>min</td>
			<td>${map.min}</td>
		</tr>
		<tr>
			<td>std</td>
			<td>${map.std}</td>
		</tr>
	</table>
	
	<button onclick = "location.href='${pageContext.request.contextPath}/'">home</button>
</body>
</html>