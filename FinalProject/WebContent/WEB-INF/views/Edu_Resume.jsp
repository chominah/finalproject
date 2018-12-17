<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<h1>학생관리_이력서&포트폴리오 피드백</h1>
		<table class="table table-hover">
			<thead>
				<tr class="table-primary">
					<td>학생 이름</td>
					<td>이메일</td>
					<td>폰 번호</td>
					<td>강좌 이름</td>
					<td>기수</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="e" items="${list}">
					<tr id="${e.snum}" class="sel table-light">
						<td>${e.sname}</td>
						<td>${e.smail}</td>
						<td>${e.sphone}</td>
						<td>${e.cname}</td>
						<td>${e.cordinal}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="item2_jhp">
		<h1>학생 이력서&포트폴리오 리스트</h1>
		<table class="table table-hover">
	<thead>
		<tr class="table-primary">
			<td>파일</td>
			<td>입력일</td>
			<td>파일 업로드</td>
		</tr>
	</thead>
	<tbody id="tbody">
	</tbody>
</table>
	</div>
</div>
<script>
	$(function() {
		let num;
		$('.sel').click(function() {
			let sel = document.querySelectorAll('.sel');
			num = $(this).attr('id');
			$.ajax({
				url : 'feedback/resume_file?snum=' + num,
				type : 'POST',
				dataType : 'json',
				success : function(data) {
					console.log(data);
					let tag;
					$("#tbody").html("");
					$.each(data,function(idx,key){
						/* rnum,snum,rfile,rdate */
						console.log(idx+":"+key.rnum);
						tag +="<tr id="+key.rnum+" class='sel table-light'>";
						tag +="<td><a href='fileDown?fileName="+key.rfile+"'>"+key.rfile+"</a></td>";
						tag +="<td>"+key.rdate+"</td>";
						tag +="<td><form action='rfile_upload' method='post' enctype='multipart/form-data'>";
						tag +="<input type='hidden' id='rnum' name='rnum' value='"+key.rnum+"'>";
						tag +="<input type='file' id='mfile' name='mfile'>";
						tag +="<input type='submit' value='upload'></form></td></tr>";
					});
					$("#tbody").html(tag);
				}
			});
		});
	});
</script>
