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


	<h1>키워드별 기업 간략리스트</h1>
<table>
<c:forEach var="key" items="#{job }">
<tr>
<th><strong>기업명</strong><th>
<td>${key.cpname }</td>&nbsp;
</tr>
<tr>
<th><strong>기업위치</strong></th>
<td">${key.cploc }</td>
</tr>
</c:forEach>
</table>

<td><input type="button" onclick="location.href='./keywordtotal?keyword=${keyword}&cploc=${cploc }&page=1'" value="더보기"></td>



</body>
</html>