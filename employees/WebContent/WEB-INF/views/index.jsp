<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
	<h1>index</h1>
	<h2><a href="${pageContext.request.contextPath}/index">홈으로</a></h2>
	<!-- WEP APP 네비게이션 -->
	<h2>데이터베이스 테이블</h2>
	<table>
		<thead>
			<tr>
				<th>테이블 명</th>
				<th>전체 행</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>departments</td>
				<td>${departmentsRowCount }</td>
			</tr>
			<tr>
				<td>dept_emp</td>
				<td>${deptEmpRowCount}</td>
			</tr>
			<tr>
				<td>dept_manager</td>
				<td>${deptManagerRowCount }</td>
			</tr>
			<tr>
				<td>employees</td>
				<td>${employeesRowCount}</td>
			</tr>
			<tr>
				<td>salaries</td>
				<td>${salariesRowCount }</td>
			</tr>
			<tr>
				<td>titles</td>
				<td>${titlesRowCount }</td>
			</tr>
		</tbody>
	</table>
	
	<div>
		<ul>
			<li><a href="${pageContext.request.contextPath}/department/getDepartmentsList">부서 목록</a></li>
			<li><a href="${pageContext.request.contextPath }/employees/getEmployeesList?limit=10">사원 목록</a></li>
			<li>
				사원 목록 first_name
				<a href="${pageContext.request.contextPath }/employees/getEmployeesListOrderBy?order=asc">오름차순(limit 50)</a>
				<a href="${pageContext.request.contextPath }/employees/getEmployeesListOrderBy?order=desc">내림차순(limit 50)</a>
			</li>			
		</ul>
	</div>
</body>
</html>