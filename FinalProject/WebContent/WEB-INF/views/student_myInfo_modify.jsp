<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<title>student_myInfo_modify.jsp</title>
</head>
<body>
<div id="content">
<form method="post" action="student_myInfo_modify" id="modify">
<fieldset>
	<legend>학생 회원수정 폼</legend>
				<table>
					<td style="width: 200px;">아이디 : &nbsp;</td>
					<td>
                     <input type="text" class="form-control" name="sid" id="sid"  value="${crvo.myInfo.sid}" required="required" style="width: 700px;">
					</td>
					<td>&nbsp; 
					<input type="button" id="idChkBtn" value="중복확인" class="btn btn-outline-primary">
					</td>
					<table>
					<tr id="chk_sid" >
					</tr>
					</table>
				</table>
				<table>
					<td style="width: 200px;">비밀번호 : &nbsp;
					</td>
					<td>
					<input type="password" class="form-control"
						name="spwd" id="spwd" value="${crvo.myInfo.spwd }" required="required"
						pattern="[a-zA-Z]+[0-9]+"
						oninvalid="this.setCustomValidity('영문과 숫자만 입력가능')"
						oninput="this.setCustomValidity('')" style="width: 700px;">
					</td>
					<table>
					<tr id="chk_spwd">
					</tr>
					</table>
				</table>
	
				<table>
					<td style="width: 200px;">이름 : &nbsp;
					</td>
					<td>
					<input type="text" class="form-control" value="${crvo.myInfo.sname }"
						name="sname" id="sname" required="required" pattern="[^a-zA-Z]+"
						oninvalid="this.setCustomValidity('한글만 입력가능')"
						oninput="this.setCustomValidity('')" style="width: 700px;">
					</td>
				</table>

				<table>
					<td style="width: 200px;">생년월일 : &nbsp;
					</td>
					<td><input type="text" class="form-control" value="${crvo.myInfo.sbirth }"
						name="sbirth" id="sbirth" required="required"
						style="width: 700px;"></td>
				</table>
	
				<table>
					<td style="width: 200px;">우편번호 : &nbsp;
					</td>
					<td><input type="text" id="spost" name="spost" value="${crvo.myInfo.spost }"
						class="form-control" placeholder="우편번호" style="width: 700px;">
					</td>
					<td>
					&nbsp; 
					<input type="button" id="spostBtn" value="우편번호찾기"
						class="btn btn-outline-primary"></td>
				</table>
				
				<table>
					<td style="width: 200px;">주소 : &nbsp;
					</td>
					<td><input type="text" id="saddr1" name="saddr1" value="${crvo.myInfo.saddr1 }"
						class="form-control" placeholder="주소" style="width: 700px;">
					</td>
				</table>
				
				<table>
					<td style="width: 200px;">상세주소 : &nbsp;
					</td>
					<td><input type="text" id="saddr2" name="saddr2" value="${crvo.myInfo.saddr2 }"
						class="form-control" placeholder="상세주소" style="width: 700px;">
					</td>
				</table>
				
				<table>
					<td style="width: 200px;">연락처 : &nbsp;
					</td>
					<td><input type="text" name="sphone" id="sphone" value="${crvo.myInfo.sphone }"
						required="required" class="form-control" placeholder="연락처"
						style="width: 700px;"></td>
				</table>
				
				<table>
					<td style="width: 200px;">이메일 : &nbsp;
					</td>
					<td><input type="text" name="smail" id="smail" value="${crvo.myInfo.smail }"
						required="required" class="form-control" placeholder="이메일"
						style="width: 700px;"></td>
				</table>
	
				<table>
					<div class="form-group">
						<td style="width: 200px;">전공 / 비전공 : &nbsp;
						</td>
						<td><select id="smajor" name="smajor" class="form-control" style="width: 500px;">
								<option>-선택하시오-</option>
								<option>전공</option>
								<option>비전공</option>
						</select></td>
					</div>
				</table>
	
				<table>
					<div class="form-group">
						<td style="width: 200px;">성별 : &nbsp;
						</td>
						<td><select id="sgender" name="sgender" class="form-control" style="width: 500px;">
								<option>-선택하시오-</option>
								<option>남</option>
								<option>여</option>
						</select></td>
					</div>
				</table>
	
				<table>
					<div class="form-group">
						<td style="width: 200px;">보유 자격증 : &nbsp;
						</td>
						<td><select id="crname" name="crname" class="form-control" style="width: 500px;">
								<option>-선택하시오-</option>
								<c:forEach var="certvo" items="${certlist}">
									<option>${certvo.crname}</option>
								</c:forEach>
						</select></td>
					</div>
				</table>
	
				<table>
					<div class="form-group">
						<td style="width: 200px;">관심 키워드 : &nbsp;
						</td>
						<td><select id="keyword" name="keyword" class="form-control" style="width: 500px;">
								<option>-선택하시오-</option>
								<c:forEach var="keyvo" items="${keylist}">
									<option>${keyvo.keyword }</option>
								</c:forEach>

						</select></td>
					</div>
				</table>
	
				<table>
					<tr>
						<input type="submit" value="수정완료" class="btn btn-primary">
					</tr>
				</table>
</fieldset>
</form>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>  
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
	$(function(){
		$('#spostBtn').click(function(){
			execDaumPostcode();
		})
		// 회원 아이디 중복확인!!
		$('#idChkBtn').click(function(){
			$.ajax({
				url:"data/idCheck?sid="+$('#sid').val(),
				success:function(data){
					if(data==0){
						$('#chk_sid').show().css("color","blue").text("사용가능한 아이디입니다.");
					}else{
						$('#chk_sid').show().css("color","red").text("사용불가능한 아이디입니다.");
					}
				}
			});
		});
		//비밀번호 길이
		var interVal = setInterval(
			function(){
				if($('#spwd').val().length >= 6) {
					$('#chk_spwd').show().css("color","blue").text("적합한 길이입니다.");
				}else{
					$('#chk_spwd').show().css("color","red").text("6자리이상 입력해주세요.")
				}
			}		
		);
	});
    function execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
             // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

             // 각 주소의 노출 규칙에 따라 주소를 조합한다.
 // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = ''; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수

                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { 
// 사용자가 도로명 주소를 선택했을 경우
                    fullAddr = data.roadAddress;

                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    fullAddr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                if(data.userSelectedType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
         // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('spost').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('saddr1').value = fullAddr;

                // 커서를 상세주소 필드로 이동한다.
                document.getElementById('saddr2').focus();
            }
        }).open();
    }
</script>
</body>
</html>