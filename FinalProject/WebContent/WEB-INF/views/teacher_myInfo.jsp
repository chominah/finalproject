<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<title>teacher_myInfo</title>
</head>
<body>
<div id="content">
	<legend>강사_내정보</legend>
	<fieldset>
	<table>
		<div class="form-group">
		<td style="width: 200px;">
		아이디 : &nbsp;
		</td>
		<td>
		<input class="form-control" value="${tvo.tid}" readonly="" style="width: 700px;">
		</td>
		</div>
	</table>
	
	<table>
		<div class="form-group">
		<td style="width: 200px;">
		비밀번호 : &nbsp;
		</td>
		<td>
		<input class="form-control" value=" ${tvo.tpwd }" readonly="" style="width: 700px;">
		</td>
		</div>
	</table>
	
	<table>
		<div class="form-group">
		<td style="width: 200px;">
		이름 : &nbsp;
		</td>
		<td>
		<input class="form-control" value=" ${tvo.tname }" readonly="" style="width: 700px;">
		</td>
		</div>
	</table>

<table>
		<div class="form-group">
		<td style="width: 200px;">
		생년월일 : &nbsp;
		</td>
		<td>
		<input class="form-control" value="  ${tvo.tbirth }" readonly="" style="width: 700px;">
		</td>
		</div>
	</table>
	
	<table>
		<div class="form-group">
		<td style="width: 200px;">
		우편번호 : &nbsp;
		</td>
		<td>
		<input class="form-control" value=" ${tvo.tpost}" readonly="" style="width: 700px;">
		</td>
		</div>
	</table>
	
	<table>
		<div class="form-group">
		<td style="width: 200px;">
		주소 : &nbsp;
		</td>
		<td>
		<input class="form-control" value=" ${tvo.taddr1 }" readonly="" style="width: 700px;">
		</td>
		</div>
	</table>
	
	<table>
		<div class="form-group">
		<td style="width: 200px;">
		상세 주소 : &nbsp;
		</td>
		<td>
		<input class="form-control" value=" ${tvo.taddr2}" readonly="" style="width: 700px;">
		</td>
		</div>
	</table>
	<table>
		<div class="form-group">
		<td style="width: 200px;">
		연락처 : &nbsp;
		</td>
		<td>
		<input class="form-control" value=" ${tvo.tphone }" readonly="" style="width: 700px;">
		</td>
		</div>
	</table>
	<table>
		<div class="form-group">
		<td style="width: 200px;">
		이메일 : &nbsp;
		</td>
		<td>
		<input class="form-control" value=" ${tvo.tmail }" readonly="" style="width: 700px;">
		</td>
		</div>
	</table>
	<table>
		<div class="form-group">
		<td style="width: 200px;">
		성별 : &nbsp;
		</td>
		<td>
		<input class="form-control" value="${tvo.tgender }" readonly="" style="width: 700px;">
		</td>
		</div>
	</table>
	<table>
		<div>
			<button class="btn btn-outline-primary"><a href="teacher_myInfo_modify_btn">수정하기</a></button>
		</div>		
		</table>
</fieldset>
</form>
</div>
</body>
</html>