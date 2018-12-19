<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

</head>

<body>

<table>
<c:forEach var="j" items="#{jobinfo}">
<tr>
<th><strong>기업명</strong></th>
<td>${j.cpname }</td>
</tr>
<tr>
<th><strong>기업위치</strong></th>
<td>${j.cploc }</td>
</tr>
<tr>
<th><strong>필요기술</strong></th>
<td>${j.keyword }</td>
</tr>
<tr>
<th><strong>기업링크</strong></th>
<td><a href="${j.cplink }">${j.cplink }</a></td>
</tr>
<tr>
<th><strong>대표메일</strong></th>
<td>${j.ceomail }&nbsp;<input type="button" onclick="location.href='./mail?ceomail=${j.ceomail}'" value="메일쓰기"></td>
</tr>

</c:forEach>
</table>


</body>
</html>