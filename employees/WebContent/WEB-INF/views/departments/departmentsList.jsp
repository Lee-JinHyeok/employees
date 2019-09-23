<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>departmentList</title>
</head>
<body>
	<h1>부서 목록</h1>
	<h2><a href="${pageContext.request.contextPath}/index">홈으로</a></h2>
	<%
		//List<Departments> list = (List<Departments>)request.getAttribute("list");
		// ${list} 위 줄이랑 같음
	%>
	<table>
		<thead>
			<tr>
				<th>부서 번호</th>
				<th>부서 이름</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="departments" items="${list}">
				<tr>
					<td>${departments.deptNo}</td>
					<td>${departments.deptName}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>