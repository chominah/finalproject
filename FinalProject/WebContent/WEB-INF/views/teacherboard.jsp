<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="resources/js/default.js"></script>
	<div id="wrap">
		<fieldset>
			<legend>teacherboard.jsp</legend>
			<table class="table table-hover">
				<thead>
					<tr class="table-primary">
						<th>번호</th>
						<th>제목</th>
						<th>날짜</th>
						<th>강좌명</th>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<td colspan="4">
						<button class="btn btn-outline-primary"><a href="teacherboard_write_btn">게시글작성</a></button>
						</td>
					</tr>
				</tfoot>
				<tbody>
						<% int i = 1; %>
					<c:forEach var="e" items="${list}">
						<c:forEach var="f" items="${e.tboard}">						
							<tr class="table-light">
								<td><%=i++%></td>
								<td><a href="javascript:goConfirmUrl('teacherboard_detail?',${f.tbnum})" class="card-link">${f.tbtitle}</a></td>
								<td>${f.tbdate}</td>
								<td>${e.cname}</td>
							</tr>
						</c:forEach>						
					</c:forEach>
				</tbody>
			</table>
		</fieldset>
	</div>