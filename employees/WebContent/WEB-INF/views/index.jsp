<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/css/sb-admin-2.css" type="text/css" rel="stylesheet">

</head>
<body>
	<div class="card border-left-primary shadow h-100 py-2">
		<div class="card-body">
			<div class="row no-gutters align-items-center">
				<div class="col mr-2">
					<div class="text-xs font-weight-bold text-primary text-uppercase mb-1">Earnings
						(Monthly)</div>
					<div class="h5 mb-0 font-weight-bold text-gray-800">$40,000</div>
				</div>
				<div class="col-auto">
					<i class="fas fa-calendar fa-2x text-gray-300"></i>
				</div>
			</div>
		</div>
	</div>
	<div>
		<table border = "1">
			<thead>
				<tr>
					<th>테이블 이름</th>
					<th>전체 행의 수</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>departments</td>
					<td>${departmentsRowCount}</td>
				</tr>
				<tr>
					<td>employees</td>
					<td>${employeesRowCount}</td>
				</tr>
				<tr>
					<td>dept_manager</td>
					<td>${deptManagerRowCount}</td>
				</tr>
				<tr>
					<td>dept_emp</td>
					<td>${deptEmpRowCount }</td>
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
	</div>
	<div>
		<ul>
			<li><a href = "${pageContext.request.contextPath}/departments/getDepartmentsList">부서목록</a></li>
			<li><a href = "${pageContext.request.contextPath}/employees/getEmployeesList">사원목록</a></li>
			<li><a href = "${pageContext.request.contextPath}/employees/getEmployeesListByPage">사원목록페이징</a></li>
			<li>사원 목록 정렬
				<a href = "${pageContext.request.contextPath}/employees/getEmployeesListOrderby?order=asc">오름차순</a>
				<a href = "${pageContext.request.contextPath}/employees/getEmployeesListOrderby?order=desc">내림차순</a>
			</li>
			<li><a href = "${pageContext.request.contextPath}/titles/getTitlesListDistinct">전제 보직 목록</a></li>
			<li><a href = "${pageContext.request.contextPath}/salaries/getSalariesStatistics">연봉 통계</a></li>
			<li><a href = "${pageContext.request.contextPath}/employees/getEmployeesCountByGender">성별별 사원수</a></li>
			<li><a href = "${pageContext.request.contextPath}/departments/getDepartmentsCountByDeptNo">부서별 사원수</a></li>
		</ul>
	</div>
	사원검색
	<form method = "get" action = "${pageContext.request.contextPath}/employees/getEmployeesListBetween">
		<input type = "text" name = "begin">~<input type = "text" name = "end">
		<button type = "submit">검색</button>
	
	</form>
</body>
</html>