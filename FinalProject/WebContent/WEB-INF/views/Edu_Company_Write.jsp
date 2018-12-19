<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<div id="warp">
	<fieldset>
		<legend>학생관리 이력서_상세보기</legend>
		<form action="company_upload" method="post">
			<input type="hidden" id="cpfnum" name="cpfnum" value="${cpfnum}">
			<p>
				<textarea id="content" name="content" rows="5" cols="150">${content}</textarea>
			</p>
			<p>
				<input type="submit" value="수정하기 / 등록하기">
			</p>
		</form>
	</fieldset>

</div>