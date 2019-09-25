<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>employees List By Page</title>
</head>
<body>
	<h1>회원 목록(10명씩 페이징)</h1>
	<h2><a href="${pageContext.request.contextPath}/index">홈으로</a></h2>
	<form method="get" action="${pageContext.request.contextPath}/employees/getEmployeesListByPage">
		<select name="rowPerPage">
			<option value="10">10개씩</option>
			<option value="15">15개씩</option>
			<option value="30">30개씩</option>
			<option value="50">50개씩</option>
		</select>
		<button type="submit">확인</button>
	</form>
	<table>
		<thead>
			<tr>
				<th>사원 번호</th>
				<th>사원 생일</th>
				<th>사원 이름</th>
				<th>사원 성</th>
				<th>사원 성별</th>
				<th>입사 날짜</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="employees" items="${list}">	
				<tr>
					<td>${employees.empNo }</td>
					<td>${employees.birthDate }</td>
					<td>${employees.firstName }</td>
					<td>${employees.lastName }</td>
					<td>${employees.gender }</td>
					<td>${employees.hireDate }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
	<c:if test="${currentPage > 1 }">
		<a href="${pageContext.request.contextPath}/employees/getEmployeesListByPage?currentPage=${currentPage-1}&rowPerPage=${rowPerPage}">이전</a>
	</c:if>
	<c:if test="${currentPage < lastPage }">
		<a href="${pageContext.request.contextPath}/employees/getEmployeesListByPage?currentPage=${currentPage+1}&rowPerPage=${rowPerPage}">다음</a>
	</c:if>
	</div>
</body>
</html>