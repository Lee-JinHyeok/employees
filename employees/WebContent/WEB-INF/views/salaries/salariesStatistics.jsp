<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>연봉 통계값(count, sum, avg, max, min, std)</h1>
	<h2><a href="${pageContext.request.contextPath}/index">홈으로</a></h2>
	<table>
		<thead>
			<tr>
				<th>연봉 개수</th>
				<th>연봉 합계</th>
				<th>연봉 평균</th>
				<th>연봉 최대</th>
				<th>연봉 최소</th>
				<th>연봉 편차</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${map.count}</td>
				<td>${map.sum}</td>
				<td>${map.avg}</td>
				<td>${map.max}</td>
				<td>${map.min}</td>
				<td>${map.std}</td>
			</tr>	
		</tbody>
	</table>
</body>
</html>