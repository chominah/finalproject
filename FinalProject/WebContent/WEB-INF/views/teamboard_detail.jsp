<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<title>teamboard_detail.jsp</title>
<script src="resources/js/default.js"></script>
</head>
<body >
<div id="wrap">
		<legend>teamboard_detail</legend>
		<fieldset>
		<table>
		<div class="form-group">
		<td style="width: 200px;">
		제목 : &nbsp;
		</td>
		<td>
		<input class="form-control" value="${svo.sboard_detail.btitle }" readonly="" style="width: 700px;"> 
		</td>
		</div>
		</table>

		<table>
		<div class="form-group">
		<td style="width: 200px;">
		 작성자 : &nbsp;
		</td>
		<td>
		<input class="form-control" value="${svo.sname }" readonly="" style="width: 700px;">
		</td>
		</div>
		</table>
		
		<table>
		<div class="form-group">
		<td style="width: 200px;">
		작성날짜 : &nbsp;
		</td>
		<td>
		 <input class="form-control" value="${svo.sboard_detail.bdate }" readonly="" style="width: 700px;">
		</td>
		</div>
		</table>
		
		<table>
		<div class="form-group">
		<td style="width: 200px;">
		내용 : &nbsp;
		</td>
		<td>
		<input class="form-control" value="${svo.sboard_detail.bcontent}" readonly="" style="width: 700px;">
		</td>
		</div>
		</table>
		
		<table>
		<div>
		<td style="width: 200px;">
		이미지 파일 : &nbsp;
		</td>
		<tr>
			<c:forEach var="list" items="${list}">
					<td>&nbsp;</td>
					<td>&nbsp;<img src="resources/upload/${list}" style="height: 200px; width: 300px; display: block; margin-left: 50px"/></td>
				    <td style="width: 50px;"> &nbsp; </td>
			</c:forEach>
			</tr>
		</div>
		</table>
		<table>
			<td></td>
		</table>
		<table>
		<div>
		<td style="width: 250px;">
		파일 다운로드 : &nbsp;
		</td>
		<td>
			<c:forEach var="list" items="${list }">
				<td><a href="teamImgDown?bfile=${list}" class="card-link"> &nbsp; ${list}</a></td>
			</c:forEach>
		</td>
		</div>
		</table>
		
		<table>
		<div>
		<td style="width: 250px;">
		엑셀로 내보내기 : &nbsp;
		</td>
		<td>
		<a href="TeamExcelDown" class="card-link"> &nbsp; Excel_Send</a>
		</td>
		</div>
		</table>
		
		<table>
		<div>
			<input type="button" value="목록으로" onclick="location='teamboard'" class="btn btn-outline-primary">
			<button class="btn btn-outline-primary"><a href="teamboard_modify_btn?bnum=${svo.sboard_detail.bnum}">수정하기</a></button>
			<button class="btn btn-outline-primary"><a href="teamboard_delete?num=${svo.sboard_detail.bnum}">글삭제</a></button>
		</div>		
		</table>
	</fieldset>
</div>
</body>
</html>