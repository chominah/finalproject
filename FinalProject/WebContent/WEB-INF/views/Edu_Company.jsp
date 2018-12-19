<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.item1_jhp {
	grid-area: left;
}

.item2_jhp {
	grid-area: right;
}

.grid-container_jhp {
	display: grid;
	grid-template-areas: 'left left left left right right';
	grid-gap: 10px;
	padding: 10px;
	grid-gap: 10px;
}

.grid-container_jhp>div {
	text-align: center;
	padding: 20px 0;
	font-size: 30px;
}
</style>

<div class="grid-container_jhp">
	<div class="item1_jhp">
		<h1>학생관리_관심기업 피드백</h1>
		<table class="table table-hover">
			<thead>
				<tr class="table-primary">
					<td scope="col">피드백 요청 날짜</td>
					<td scope="col">기업 이름</td>
					<td scope="col">강좌 이름</td>
					<td scope="col">기수</td>
					<td scope="col">학생 이름</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="e" items="${list}">
					<tr id="${e.cpfnum}" class="sel table-light">
						<td scope="row">${e.cpfdate}</td>
						<td>${e.cpname}</td>
						<td>${e.cname}</td>
						<td>${e.cordinal}</td>
						<td>${e.sname}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="item2_jhp">
		<fieldset>
			<legend>피드백 요청 내용</legend>
			<a rows="10" cols="50" id="content" name="content"></a> <br>
			<button id="fco_w" name="fco_w">상세보기</button>
		</fieldset>
	</div>
</div>
<script>
	$(function() {
		let num;
		$('.sel').click(function() {
			let sel = document.querySelectorAll('.sel');
			num = $(this).attr('id');
			$.ajax({
				url : 'feedback/company_content?cpfnum=' + num,
				type : 'POST',
				dataType : 'json',
				cache : false,
				success : function(data) {
					$("#content").html(data.content);
				}
			});
		});
		$('#fco_w').click(function() {
			location.href = 'company_write?cpfnum=' + num;
		});
	});
</script>