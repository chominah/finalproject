<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>teamboard.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="resources/js/default.js"></script>
</head>
	<div id="wrap">
		<fieldset>
			<legend>teamboard</legend>
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
						<button class="btn btn-outline-primary"><a href="teamboard_write_btn">게시글작성</a></button>
						</td>
					</tr>
				</tfoot>
				<tbody>
						<% int i = 1; %>
					<c:forEach var="e" items="${list }">
						<c:forEach var="f" items="${e.sboard }">
							<tr class="table-light">
								<td><%=i++%></td>
								<td><a href="javascript:goConfirmUrl('teamboard_detail?',${f.bnum})" class="card-link">${f.btitle}</a></td>
								<td>${e.sname}</td>
								<td>${f.bdate}</td>
							</tr>
						</c:forEach>
					</c:forEach>
				</tbody>
			</table>
		</fieldset>
	</div>