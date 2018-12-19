<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<title>Login.jsp</title>
</head>
<body>
<div>
<li>
			<c:choose>
			<c:when test="${sessionScope.tid == null }">
			<a href="teacher_Login" class="card-link">로그인 |</a>
			</c:when>
			<c:otherwise>
			${sessionScope.tname}님 <a href="teacher_logout" class="card-link">로그아웃</a>
			</c:otherwise>
			</c:choose>
</li>
</div>
</body>
</html>