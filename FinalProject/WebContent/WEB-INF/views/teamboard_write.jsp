<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<title>teamboard_write.jsp</title>
</head>
<body>
<div id="wrap">
<fieldset>
		<legend>teamboard_write</legend>
		<form action="teamboard_write" method="post" enctype="multipart/form-data">
		
		<table>
		<div class="form-group">
		<td style="width: 200px;">
		제목 : &nbsp;
		</td>
		<td>
		<input type="text" class="form-control" id="btitle" name="btitle" style="width: 700px;"> 
		</td>
		</div>
		</table>
		
		<table>
		<div class="form-group">
		<td style="width: 200px;">
		작성 날짜 : &nbsp;
		</td>
		<td>
		<input type="text" class="form-control" id="bdate" name="bdate" style="width: 700px;"> 
		</td>
		</div>
		</table>
		
		<table>
		<div class="form-group">
		<td style="width: 200px;">
		내용 : &nbsp;
		</td>
		<td>
		<textarea rows="8" cols="50"  class="form-control" name="bcontent" id="bcontent"></textarea> 
		</td>
		</div>
		</table>
		
		<table>
		<div  class="form-group">
		<td style="width: 300px;">
		 파일 업로드 : &nbsp;
		 </td>
		 <td style="width: 300px;" class="btn btn-primary">
	 		&nbsp; <input multiple="multiple" name="b_file"type="file">
      </td>
      </div>
      </table>	
		
		<table>
		<div>
			<input type="submit" value="게시글 작성" class="btn btn-outline-primary">
			<button class="btn btn-outline-primary"><a href="teamboard_btn">취소</a></button>
		</div>		
		</table>
		</form>
	</fieldset>
</div>
</body>
</html>