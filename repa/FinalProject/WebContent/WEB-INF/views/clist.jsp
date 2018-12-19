<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="c" items="#{cla }">

<hr style="color: black; height:2px; " >
<tr>

<td><strong>강의명</strong>:&nbsp;${c.cname }</td><br><br>
<td><strong>기수</strong>:&nbsp;${c.cordinal }</td><br><br>
<td><strong>강사</strong>:&nbsp;${c.adname }</td><br><br>
<td><strong>시작일</strong>:&nbsp;${c.cbegin }</td><br><br>
<td><strong>종료일</strong>:&nbsp;${c.cend }</td><br><br>
<td><strong>강의기간</strong>:&nbsp;${c.totaldays }</td><br><br>
<td><input type="button" value="강의보기" onclick="location.href='./classview?cnum=${c.cnum}'"></td>
</tr>
<hr style="color: black; height:2px;">
</c:forEach>
<tr>
</tr>

<td><input type="button" value="새 강의 등록" onclick="location.href='./create'"></td>
</body>
</html>