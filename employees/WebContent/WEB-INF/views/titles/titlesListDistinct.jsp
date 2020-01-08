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
	<h1>보직 목록</h1>
	<ul>
		<c:forEach var = "titles" items = "${list}">
			<li>${titles }</li>
		</c:forEach>
	</ul>
	<button onclick = "location.href='${pageContext.request.contextPath}/'">home</button>
</body>
</html>