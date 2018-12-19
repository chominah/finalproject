<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>teamboard_modify.jsp</title>
</head>
<body>
<div id="wrap">
<fieldset>
		<legend>teamboard_modify</legend>
		<form action="teamboard_modify" method="post" enctype="multipart/form-data">
		<input type="hidden" name="bnum" value="${ svo.sboard_detail.bnum}">
		<table>
		<div class="form-group">
		<td style="width: 200px;">
		제목 : &nbsp;
		</td>
		<td>
		<input type="text" class="form-control" id="btitle" name="btitle" value="${svo.sboard_detail.btitle}" style="width: 700px;"> 
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
		작성 날짜 : &nbsp;
		</td>
		<td>
		<input type="text" class="form-control" id="bdate" name="bdate" value="${svo.sboard_detail.bdate }" style="width: 700px;"> 
		</td>
		</div>
		</table>

		<table>
		<div class="form-group">
		<td style="width: 200px;">
		내용 : &nbsp;
		</td>
		<td>
		<textarea rows="8" cols="50"  class="form-control" name="bcontent" id="bcontent">${svo.sboard_detail.bcontent}</textarea> 
		</td>
		</div>
		</table>
		
		<table>
		<div  class="form-group">
		<td style="width: 200px;">
		이미지 파일 : &nbsp;
		</td>
		<tr>
			<c:forEach var="list" items="${list}">
					<td>&nbsp;<img src="resources/upload/${list}" style="height: 200px; width: 300px; display: block;"/></td>
				    <td>${list}</td>
			</c:forEach>
			</tr>
		</div>
		</table>
		
		<table>
		<div  class="form-group">
		<td style="width: 300px;">
		 파일 업로드 : &nbsp;
		 </td>
		 <td style="width: 300px;" class="btn btn-primary">
	 		&nbsp; <input multiple="multiple" name="b_file" id="b_file" type="file">
      </td>
      </div>
      </table>

 		<table>
		<div>
			<input type="submit" value="게시글 작성" class="btn btn-outline-primary">
			<button class="btn btn-outline-primary"><a href="teamboard_btn" >취소</a></button>
		</div>		
		</table>
		
		</form>
	</fieldset>
</div>
</body>
</html>