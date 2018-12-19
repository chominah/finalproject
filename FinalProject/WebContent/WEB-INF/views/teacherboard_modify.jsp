<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>teacherboard_modify.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(function(){
	let wrapper = $('#target');
	 $("#plus").click(function(){
	let tags = "<table><td><input class=\"btn btn-outline-primary\" type=\"file\"></td></table>";
	wrapper.append(tags);
	 });
	 $("#minus").click(function(e){
	       let total_fields = wrapper[0].childNodes.length;
	       console.log(total_fields);	       
	       if(total_fields > 2){
	           wrapper[0].childNodes[total_fields - 1 ].remove();
	       }
	  });
})
</script>
</head>
<body>
<div id="wrap">
<fieldset>
		<legend>teacherboard_modify</legend>
		<form action="teacherboard_modify" method="post" enctype="multipart/form-data">
		<input type="hidden" name="tbnum" value="${ cvo.tboard_detail.tbnum}">
		<table>
		<div class="form-group">
		<td style="width: 200px;">
		제목 : &nbsp;
		</td>
		<td>
		<input type="text" class="form-control" id="tbtitle" name="tbtitle" value="${cvo.tboard_detail.tbtitle}" style="width: 700px;"> 
		</td>
		</div>
		</table>
		
		<table>
		<div class="form-group">
		<td style="width: 200px;">
		작성 날짜 : &nbsp;
		</td>
		<td>
		<input type="text" class="form-control" id="tbdate" name="tbdate" value="${cvo.tboard_detail.tbdate }" style="width: 700px;"> 
		</td>
		</div>
		</table>
		
		<table>
		<div class="form-group">
		<td style="width: 200px;">
		내용 : &nbsp;
		</td>
		<td>
		<textarea rows="8" cols="50"  class="form-control" name="tbcontent" id="tbcontent">${cvo.tboard_detail.tbcontent}</textarea> 
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
		파일 업로드 :   &nbsp;
		</td>
		<td>
		<input type="button" id="plus" value="파일 추가" class="btn btn-outline-primary" >&nbsp;
		</td>
		<td>
		<input type="button" id="minus" value="파일 제거" class="btn btn-outline-primary">
		</td>
		</div>
		</table>
		
		<div  id="target">
		</div>
		
		<table>
		<div>
			<input type="submit" value="게시글 작성" class="btn btn-outline-primary">
			<button class="btn btn-outline-primary"><a href="teacherboard_btn" >취소</a></button>
		</div>		
		</table>
		</form>
	</fieldset>
</div>
</body>
</html>