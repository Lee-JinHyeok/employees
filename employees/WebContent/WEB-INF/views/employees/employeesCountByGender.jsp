<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1></h1>
	<table border = "1">
		<tr>
			<td>성별</td>
			<td>사원수</td>
		</tr>
		<c:forEach var = "employees" items = "${list }">
		<tr>
			<td>${employees.gender }</td>
			<td>${employees.count }</td>
		</tr>
		</c:forEach>
	</table>
	<button onclick = "location.href='${pageContext.request.contextPath}/'">Home</button>
</body>
</html>