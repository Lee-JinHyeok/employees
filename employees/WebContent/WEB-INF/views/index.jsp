<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
	<h1>index</h1>
	<!-- WEP APP 네비게이션 -->
	<div>
		<ul>
			<li><a href="${pageContext.request.contextPath}/departments/getDepartmentsList">부서 목록</a></li>
			
			<li><a href="${pageContext.request.contextPath }/employees/getEmployeesList?limit=10">사원 목록</a></li>
		</ul>
	</div>
	
	
	<div>
		employees table row count :  ${employeesRowCount}
	</div>
	
</body>
</html>