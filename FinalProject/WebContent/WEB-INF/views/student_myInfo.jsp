<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<title>student_myInfo</title>
</head>
<body>
<div id="content">
	<legend>내정보</legend>
	<fieldset>
	<table>
		<div class="form-group">
		<td style="width: 200px;">
		아이디 : &nbsp;
		</td>
		<td>
		<input class="form-control" value="${crvo.myInfo.sid}" readonly="" style="width: 700px;">
		</td>
		</div>
	</table>
	
	<table>
		<div class="form-group">
		<td style="width: 200px;">
		비밀번호 : &nbsp;
		</td>
		<td>
		<input class="form-control" value=" ${crvo.myInfo.spwd }" readonly="" style="width: 700px;">
		</td>
		</div>
	</table>
	
	<table>
		<div class="form-group">
		<td style="width: 200px;">
		이름 : &nbsp;
		</td>
		<td>
		<input class="form-control" value=" ${crvo.myInfo.sname }" readonly="" style="width: 700px;">
		</td>
		</div>
	</table>

<table>
		<div class="form-group">
		<td style="width: 200px;">
		생년월일 : &nbsp;
		</td>
		<td>
		<input class="form-control" value="  ${crvo.myInfo.sbirth }" readonly="" style="width: 700px;">
		</td>
		</div>
	</table>
	
	<table>
		<div class="form-group">
		<td style="width: 200px;">
		우편번호 : &nbsp;
		</td>
		<td>
		<input class="form-control" value=" ${crvo.myInfo.spost}" readonly="" style="width: 700px;">
		</td>
		</div>
	</table>
	
	<table>
		<div class="form-group">
		<td style="width: 200px;">
		주소 : &nbsp;
		</td>
		<td>
		<input class="form-control" value=" ${crvo.myInfo.saddr1 }" readonly="" style="width: 700px;">
		</td>
		</div>
	</table>
	
	<table>
		<div class="form-group">
		<td style="width: 200px;">
		상세 주소 : &nbsp;
		</td>
		<td>
		<input class="form-control" value=" ${crvo.myInfo.saddr2}" readonly="" style="width: 700px;">
		</td>
		</div>
	</table>
	<table>
		<div class="form-group">
		<td style="width: 200px;">
		연락처 : &nbsp;
		</td>
		<td>
		<input class="form-control" value=" ${crvo.myInfo.sphone }" readonly="" style="width: 700px;">
		</td>
		</div>
	</table>
	<table>
		<div class="form-group">
		<td style="width: 200px;">
		이메일 : &nbsp;
		</td>
		<td>
		<input class="form-control" value=" ${crvo.myInfo.smail }" readonly="" style="width: 700px;">
		</td>
		</div>
	</table>
	<table>
		<div class="form-group">
		<td style="width: 200px;">
		전공 / 비전공 : &nbsp;
		</td>
		<td>
		<input class="form-control" value="${crvo.myInfo.smajor }" readonly="" style="width: 700px;">
		</td>
		</div>
	</table>
	<table>
		<div class="form-group">
		<td style="width: 200px;">
		성별 : &nbsp;
		</td>
		<td>
		<input class="form-control" value="${crvo.myInfo.sgender }" readonly="" style="width: 700px;">
		</td>
		</div>
	</table>
	
	<table>
		<div class="form-group">
		<td style="width: 200px;">
		보유 자격증 : &nbsp;
		</td>
		<td>
		<input class="form-control" value=" ${crvo.crname }" readonly="" style="width: 700px;">
		</td>
		</div>
	</table>
	<table>
		<div class="form-group">
		<td style="width: 200px;">
		관심 키워드 : &nbsp;
		</td>
		<td>
		<input class="form-control" value="${crvo.myInfo.keyword }" readonly="" style="width: 700px;">
		</td>
		</div>
	</table>
	
	<%-- <p>
	신청강좌 : ${svo.cnum }
	</p> --%>

	<table>
		<div>
			<button class="btn btn-outline-primary"><a href="student_myInfo_modify_btn">수정하기</a></button>
		</div>		
		</table>
</fieldset>
</form>
</div>
</body>
</html>