<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<div>
	<table>
		<thead>
		</thead>
		<tbody>
			<c:forEach var="e" items="${list}">
				<tr>
					<td>${e.cpnum}</td>
					<td>${e.cpname}</td>
					<td>${e.cploc}</td>
					<td>${e.keyword}</td>
					<td>${e.cplink}</td>
				</tr>
			</c:forEach>
		</tbody>
	
	</table>
	<a href="exceldown"><button>Down</button></a>
	<a href="addcomform">Goaddform</a>
</div>

</body>
</html>