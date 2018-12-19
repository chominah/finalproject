<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>

	<h2>새 강의 등록</h2>
	<form action="accept" method="post">
		<tr>
			<td><strong>강의명</strong>:&nbsp;<input type="text" name="cname"
				id="cname"></td>
			<br>
			<br>
			<td><strong>강의실</strong>:&nbsp;<input type="text" name="croom"
				id="croom"></td>
			<br>
			<br>
			<td><strong>시작일</strong>:&nbsp;<select name="cbegin" id="cbegin">
					<option>18/08/20</option>
					<option>18/09/27</option>
					<option>18/11/22</option>
					<option>18/12/18</option>
					<option>19/01/20</option>
					<option>19/03/03</option>
					<option>19/05/11</option>
			</select></td>
			<br>
			<br>
			<td><strong>종료일</strong>:&nbsp; <select name="cend" id="cend">
					<option>18/08/30</option>
					<option>18/10/07</option>
					<option>18/12/03</option>
					<option>18/12/18</option>
					<option>19/01/30</option>
					<option>19/03/13</option>
					<option>19/05/21</option>
			</select></td>
			<br>
			<br>
			<td><strong>강사번호</strong>:&nbsp; <select name="tnum" id="tnum">
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
					<option>5</option>
			</select></td>
			<br>
			<br>
			<td><strong>강의기간:&nbsp;10일</strong></td>
			<br>
			<td><input type="submit" value="등록" id="addBtn"></td>
		</tr>
	</form>








</body>
<script>
	$(function() {

		$('#addBtn').click(
				function() {

                    	if ($('#cname').val() == "" || $('#croom').val() == ""){
                    	         
                    		alert('회원정보를 모두 입력해주세요.');
                    		location.href="./create";
                    		
                    	}else{
                    		alert('등록되었습니다.');
                    		location.href="./my_main";
                    	}	
						
                    	
              
						
					
				});
	});
</script>
</html>