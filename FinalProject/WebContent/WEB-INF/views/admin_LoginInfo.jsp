<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<title>Login.jsp</title>
</head>
<body>
<div>
<li>
			<c:choose>
			<c:when test="${sessionScope.adid == null }">
			<a href="admin_Login"  class="card-link">로그인 |</a>
			</c:when>
			<c:otherwise>
			${sessionScope.adname}님 <a href="admin_logout"  class="card-link" >로그아웃</a>
			</c:otherwise>
			</c:choose>
</li>
</div>
</body>
</html>