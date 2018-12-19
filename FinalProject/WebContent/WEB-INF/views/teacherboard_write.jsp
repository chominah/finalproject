<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<title>teacherboard_write.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(function(){
	let wrapper = $('#target');
	 $("#plus").click(function(){
	let tags = "<div><input name=\"tb_file\" type=\"file\"></div>";
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
		<legend>teacherboard_write</legend>
		<form action="teacherboard_write" method="post" enctype="multipart/form-data">
		<table>
		<div class="form-group">
		<td style="width: 200px;">
		제목 : &nbsp;
		</td>
		<td>
		<input type="text" class="form-control" id="tbtitle" name="tbtitle" style="width: 700px;"> 
		</td>
		</div>
		</table>
	
		<table>
		<div class="form-group">
		<td style="width: 200px;">
		작성 날짜 : &nbsp;
		</td>
		<td>
		<input type="text" class="form-control" id="tbdate" name="tbdate" style="width: 700px;"> 
		</td>
		</div>
		</table>
		
		<table>
		<div class="form-group">
		<td style="width: 200px;">
		내용 : &nbsp;
		</td>
		<td>
		<textarea rows="8" cols="50"  class="form-control" name="tbcontent" id="tbcontent"></textarea> 
		</td>
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