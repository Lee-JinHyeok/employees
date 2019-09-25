<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>employees Count By Gender</title>
</head>
<body>
<table>
	<h2><a href="${pageContext.request.contextPath}/index">홈으로</a>
	<thead>
		<tr>
			<th>gender</th>
			<th>COUNT(gender)</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="employees" items="${list }">
			<tr>
				<td>${employees.gender }</td>
				<td>${employees.count }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>