<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>부서 목록</h1>
	<table border = "1">
		<thead>
			<tr>
				<th>부서번호</th>
				<th>부서이름</th>
				<th>사원 수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var = "list" items="${list }">
				<tr>
					<td>${list.dept.deptNo}</td>
					<td>${list.dept.deptName}</td>
					<td>${list.count}</td>
				</tr>
			</c:forEach>
		</tbody>
				
	</table>
	<button onclick = "location.href='${pageContext.request.contextPath}/'">Home</button>
</body>
</html>