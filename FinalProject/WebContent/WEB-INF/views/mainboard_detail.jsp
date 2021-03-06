<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<title>mainboard_detail.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="resources/js/default.js"></script>
</head>
<body>
<div id="wrap">
		<legend>mainboard_detail</legend>
		<fieldset>
		<table>
		<div class="form-group">
		<td style="width: 200px;">
		제목 : &nbsp;
		</td>
		<td>
		<input class="form-control" value="${tvo.tboard.tbtitle }" readonly="" style="width: 700px;"> 
		</td>
		</div>
		</table>
		
		<table>
		<div class="form-group">
		<td style="width: 200px;">
		 작성자 : &nbsp;
		</td>
		<td>
		<input class="form-control" value="  ${tvo.tname }" readonly="" style="width: 700px;">
		</td>
		</div>
		</table>
		
		<table>
		<div class="form-group">
		<td style="width: 200px;">
		작성날짜 : &nbsp;
		</td>
		<td>
		 <input class="form-control" value="${tvo.tboard.tbdate }" readonly="" style="width: 700px;">
		</td>
		</div>
		</table>
		
		<table>
		<div class="form-group">
		<td style="width: 200px;">
		내용 : &nbsp;
		</td>
		<td>
		<input class="form-control" value=" ${tvo.tboard.tbcontent}" readonly="" style="width: 700px;">
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
					<td>&nbsp;<img src="resources/upload/${list}" style="height: 200px; width: 300px; display: block;margin-left: 50px"/></td>
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
				<td><a href="MainimgDown?tbfile=${list}" class="card-link"> &nbsp; ${list}</a></td>
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
		<a href="MainExcelDown" class="card-link"> &nbsp; Excel_Send</a>
		</td>
		</div>
		</table>
		
		<table>
		<div>
			<button class="btn btn-outline-primary"><a href="mainboard_btn">목록으로</a></button>
		</div>
		</table>
	</fieldset>
</div>
</body>
</html>