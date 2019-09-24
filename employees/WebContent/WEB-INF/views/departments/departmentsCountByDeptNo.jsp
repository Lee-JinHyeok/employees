<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>departments Count By DeptNo</title>
</head>
<body>
<table>
	<thead>
		<tr>
			<th>dept_no</th>
			<th>dept_name</th>
			<th>count(d.dept_no)</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="departments" items="${list}">
			<tr>
				<td>${departments.deptNo}</td>
				<td>${departments.deptName}</td>
				<td>${departments.deptCount}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>