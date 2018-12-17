<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>FinalProj</title>
<!-- <link rel="stylesheet" href="resources/css/basic.css" type="text/css"  />
<link rel="stylesheet" href="resources/css/style.css" type="text/css" /> -->
<!-- ckeditor.js  -->
<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="//cdn.ckeditor.com/4.4.7/full/ckeditor.js"></script>
<!-- ckeditor.js  -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<style>
.item1 {
	grid-area: header;
}

.item2 {
	grid-area: menu;
}

.item3 {
	grid-area: body;
}

.item4 {
	grid-area: footer;
}

.grid-container {
	display: grid;
	grid-template-areas: 'header header header header header header'
		'menu body body body body body'
		'footer footer footer footer footer footer';
	grid-gap: 10px;
	padding: 10px;
	grid-gap: 10px;
	background: #F7F9FA;
}

.grid-container>div {
	background: white;
	text-align: center;
	padding: 20px 0;
	font-size: 30px;
}
</style>

<link rel="stylesheet" href="resources/css/bootstrap.min.css" type="text/css" />


</head>
<body>
	<div class="grid-container" id="wrap">
		<div class="item1">
			<tiles:insertAttribute name="header" />
		</div>
		<div class="item2">
			<!--  <div id="navigation"> -->
			<tiles:insertAttribute name="menu" />
			<!-- </div> -->
		</div>
		<div class="item3">
			<tiles:insertAttribute name="body" />
		</div>
		<div class="item4">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
</body>
</html>