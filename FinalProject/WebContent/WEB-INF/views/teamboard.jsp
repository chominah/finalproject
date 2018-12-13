<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
			<form method="post" action="makegroup">
				<div>
					<table>
						<thead>
							<tr>
								<th colspan="6">리스트</th>
							</tr>
							<tr>
								<td>이름</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="slist" items="${slist}">
								<tr>
									<td><input type="checkbox" name="grouplist"
										value="${slist.sname}">${slist.sname}</td>
								</tr>
							</c:forEach>
						</tbody>
						<tfoot>
						</tfoot>
					</table>
					<input type="submit" value="그룹만들기" />
				</div>
			</form>