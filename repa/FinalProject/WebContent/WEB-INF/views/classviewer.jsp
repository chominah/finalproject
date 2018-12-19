<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container" style="color: black;">
		<h2>수강생 정보</h2>

		<table class="table table-bordered">
			<thead>
				<tr>
					<th>수강자</th>
					<th>수강자 메일</th>
					<th>수강자 주소</th>
					<th>수강자 번호</th>
					<th>전공여부</th>
					<th>성별</th>

				</tr>
			</thead>
			
			<c:forEach var="k" items="#{list }">
			<tbody>
				<tr>
					<td>${k.sname }</td>
					<td>${k.smail }</td>
					<td>${k.saddr }</td>
					<td>${k.sphone }</td>
					<td>${k.smajor}</td>
					<td>${k.sgender}</td>
				
			
				</tr>
			</tbody>
				</c:forEach>
			
			
			
			</table>
			</div>
			

</body>
</html>