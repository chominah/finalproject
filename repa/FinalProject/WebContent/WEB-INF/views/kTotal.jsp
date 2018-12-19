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

	<c:forEach var="j" items="#{keywordtotal}">
		<hr>
		<tr>
			<td><strong>기업명</strong>:${j.cpname }</td>&nbsp;
			<td><strong>기업위치</strong>:${j.cploc }</td>&nbsp;
			<td><input type="button"
				onclick="location.href='./jobinfo?cpnum=${j.cpnum}'" value="상세보기">
			<td>
		</tr>
		<hr>
	</c:forEach>
	<br>
    <br>
  
  <c:choose>
  <c:when test="${pageinfo.currentBlock eq 1 }">
  <a>이전</a>
  </c:when>
  <c:otherwise>
  <a href="keywordtotal??keyword=${keyword }&cploc=${cploc }
  &page=${(pageinfo.currentBlock-1)*pageinfo.pagesPerBlock }">이전</a>
  </c:otherwise>  
  </c:choose>

	<c:choose>
		<c:when test="${pageinfo.currentBlock ne pageinfo.totalBlocks }">
			<c:forEach begin="1" end="${pageinfo.pagesPerBlock}" varStatus="num">
                        [<a
					href="keywordtotal?keyword=${keyword }&cploc=${cploc }
					&page=${(pageinfo.currentBlock - 1) * pageinfo.pagesPerBlock + num.count }">
					${(pageinfo.currentBlock- 1) * pageinfo.pagesPerBlock + num.count }</a>]
                    			</c:forEach>
		</c:when>
		<c:otherwise>
			<c:forEach
				begin="${(pageinfo.currentBlock-1)*pageinfo.pagesPerBlock+1 }"
				end="${pageinfo.totalPages }" varStatus="num">
           
          [<a
					href="keywordtotal?keyword=${keyword }&cploc=${cploc }
					&page=${(pageinfo.currentBlock-1) * pageinfo.pagesPerBlock + num.count}">
					${(pageinfo.currentBlock-1) * pageinfo.pagesPerBlock + num.count}</a>] 		
		</c:forEach>
		</c:otherwise>

	</c:choose>

	<c:choose>
    <c:when test="${pageinfo.currentBlock eq pageinfo.totalBlocks }">
    <a>다음</a>
    </c:when>
    <c:otherwise>
    <a href="keywordtotal??keyword=${keyword }&cploc=${cploc }
    &page=${pageinfo.currentBlock*pageinfo.pagesPerBlock + 1 }">다음</a>
    </c:otherwise>
	</c:choose>

  
</body>

</html>