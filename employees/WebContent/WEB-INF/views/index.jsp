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
			<li>
				<a href="${pageContext.request.contextPath}/titles/getTitlesListDistinct">업무 목록 (중복제거 distinct)</a>
			</li>
			<li>
				<a href="${pageContext.request.contextPath}/salaries/getSalariesStatistics">연봉 통계값 (count, sum, avg, max, min, std)</a>
			</li>
			<li>
				<a href="${pageContext.request.contextPath}/employees/getEmployeesCountByGender">사원 수 (성별 group by gender)</a>
			</li>
			<li><!--
					/departments/getDepartmentsCountByDeptNo
					GetDepartmentsCountByDeptNoServlet.class
					DepartmentsDao.selectDepartmentsCountByDeptNo()
					/WEB-INF/views/departments/departmentsCountByDeptNo.jsp
				 -->
				<a href="${pageContext.request.contextPath}/departments/getDepartmentsCountByDeptNo">현재 부서별 사원 수</a>
			</li>
			<li>
				<a href="${pageContext.request.contextPath}/employees/getEmployeesListByPage">사원목록 페이징(10명씩)</a>
			</li>						
		</ul>
	</div>
	<div>
		<form method="get" action ="${pageContext.request.contextPath}/employees/getEmployeesListBetween">
			<input type="number" name="begin"> ~ <input type="number" name="end">
			<button type="submit">사원 목록</button>
			(${min }~${max })
		</form>	
	</div>
</body>
</html>