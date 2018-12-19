<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<title>teacherboard_detail.jsp</title>
<script src="resources/js/default.js"></script>
</head>
<body >
<div id="wrap">
		<legend>teacherboard_detail</legend>
		<fieldset>
		<table>
		<div class="form-group">
		<td style="width: 200px;">
		제목 : &nbsp;
		</td>
		<td>
		<input class="form-control" value="${cvo.tboard_detail.tbtitle }" readonly="" style="width: 700px;">
		</td>
		</div>
		</table>
		
		<table>
		<div class="form-group">
		<td style="width: 200px;">
		작성 날짜 :  &nbsp;
		</td>
		<td>
		<input class="form-control" value="${cvo.tboard_detail.tbdate }" readonly="" style="width: 700px;">
		</td>
		</div>
		</table>
		
		<table>
		<div class="form-group">
		<td style="width: 200px;">
		강좌명 :  &nbsp;
		</td>
		<td>
		<input class="form-control" value="${cvo.cname}" readonly="" style="width: 700px;">
		</td>
		</div>
		</table>
		
		<table>
		<div class="form-group">
		<td style="width: 200px;">
		내용 :  &nbsp;
		</td>
		<td>
		<input class="form-control" value="${cvo.tboard_detail.tbcontent}" readonly="" style="width: 700px;">
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
					<td> &nbsp; <img src="resources/upload/${list}" style="height: 200px; width: 300px; display: block; margin-left: 50px "/></td>
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
				<td><a href="teacherFileDown?tbfile=${list}" class="card-link"> &nbsp; ${list}</a></td>
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
		<a href="TeacherExcelDown" class="card-link">&nbsp; Excel_Send</a>
		</td>
		</div>
		</table>
	
		<table>
		<div>
			<input type="button" value="목록으로" onclick="location='teacherboard'" class="btn btn-outline-primary">
			<button class="btn btn-outline-primary"><a href="teacherboard_modify_btn?tbnum=${cvo.tboard_detail.tbnum}">수정하기</a></button>
			<button class="btn btn-outline-primary"><a href="teacherboard_delete?num=${cvo.tboard_detail.tbnum}">글삭제</a></button>
		</div>		
		</table>
		
	</fieldset>
</div>
</body>
</html>