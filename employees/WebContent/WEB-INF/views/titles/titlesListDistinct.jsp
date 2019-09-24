<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>titles List Distinct</title>
</head>
<body>
	<h1>업무 목록 중복제거(Distinct)</h1>
		<h2><a href="${pageContext.request.contextPath}/index">홈으로</a></h2>
	<table>
		<thead>
			<tr>
				<th>직급</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="row" items="${list}">
				<tr>
					<td>${row}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>