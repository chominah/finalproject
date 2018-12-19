<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mainboard.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="resources/js/default.js"></script>
</head>
<body>
	<div id="wrap">
		<fieldset>
			<legend>mainboard</legend>
			<table class="table table-hover">
				<thead>
					<tr class="table-primary">
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>날짜</th>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<td colspan="4">
						</td>
					</tr>
				</tfoot>
				<tbody>
				<% int i = 1; %>
					<c:forEach var="e" items="${list}">
						<tr class="table-light">
							<td><%=i++%></td>
							<td><a href="javascript:goConfirmUrl('mainboard_detail?',${e.tboard.tbnum})" class="card-link" >${e.tboard.tbtitle}</a></td>
							<td>${e.tname }</td>
							<td>${e.tboard.tbdate }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</fieldset>
	</div>
</body>
</html>