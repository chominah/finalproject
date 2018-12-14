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

<!-- Kosta link start -->

<!-- Vendor styles -->
<link rel="stylesheet" media="screen" href="view-source:edu2.kosta.or.kr/assets/fontawesome/css/font-awesome.min.css">
<link rel="stylesheet" media="screen" href="view-source:edu2.kosta.or.kr/assets/metisMenu/dist/metisMenu.min.css">
<link rel="stylesheet" media="screen" href="view-source:edu2.kosta.or.kr/assets/animate.css/animate.min.css">
<link rel="stylesheet" media="screen" href="view-source:edu2.kosta.or.kr/assets/bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet" media="screen" href="view-source:edu2.kosta.or.kr/assets/bootstrap-datepicker-master/dist/css/bootstrap-datepicker3.min.css">
<link rel="stylesheet" media="screen" href="view-source:edu2.kosta.or.kr/assets/toastr/build/toastr.min.css" />
<link rel="stylesheet" media="screen" href="view-source:edu2.kosta.or.kr/assets/sweetalert/lib/sweet-alert.css" />
<link rel="stylesheet" media="screen" href="view-source:edu2.kosta.or.kr/assets/ladda/dist/ladda-themeless.min.css" />

<!-- App styles -->
<link rel="stylesheet" media="screen" href="view-source:edu2.kosta.or.kr/assets/fonts/pe-icon-7-stroke/css/pe-icon-7-stroke.css">
<link rel="stylesheet" media="screen" href="view-source:edu2.kosta.or.kr/assets/fonts/pe-icon-7-stroke/css/helper.css">
<link rel="stylesheet" media="screen" href="view-source:edu2.kosta.or.kr/assets/css/style.css">

<link rel="stylesheet" media="screen" href="view-source:edu2.kosta.or.kr/assets/css/main.css">
<link rel="shortcut icon" type="image/png" href="view-source:edu2.kosta.or.kr/assets/images/favicon.png">
<!-- Kosta link end -->


<!-- Kosta script start -->
<script src="view-source:edu2.kosta.or.kr/assets/lib/jquery/jquery.min.js" type="text/javascript"></script>
<script src="view-source:edu2.kosta.or.kr/assets/modernizr/modernizr-custom.js" type="text/javascript"></script>
<script src="view-source:edu2.kosta.or.kr/assets/slimScroll/jquery.slimscroll.min.js"></script>
<script src="view-source:edu2.kosta.or.kr/assets/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="view-source:edu2.kosta.or.kr/assets/bootstrap-datepicker-master/dist/js/bootstrap-datepicker.min.js"></script>
<script src="view-source:edu2.kosta.or.kr/assets/bootstrap-datepicker-master/dist/locales/bootstrap-datepicker.kr.min.js"></script>
<script src="view-source:edu2.kosta.or.kr/assets/metisMenu/dist/metisMenu.min.js"></script>
<script src="view-source:edu2.kosta.or.kr/assets/iCheck/icheck.min.js"></script>
<script src="view-source:edu2.kosta.or.kr/assets/holder/holder.min.js" type="text/javascript"></script>
<script src="view-source:edu2.kosta.or.kr/assets/sparkline/index.js"></script>
<script src="view-source:edu2.kosta.or.kr/assets/angularjs-1.6.4/angular.min.js" type="text/javascript"></script>
<script src="view-source:edu2.kosta.or.kr/assets/angularjs-1.6.4/angular-sanitize.min.js" type="text/javascript"></script>
<script src="view-source:edu2.kosta.or.kr/assets/angularjs-1.6.4/angular-animate.min.js" type="text/javascript"></script>
<script src="view-source:edu2.kosta.or.kr/assets/angularjs-1.6.4/angular-resource.min.js?v=1.3.14" type="text/javascript"></script>
<script src="view-source:edu2.kosta.or.kr/assets/angularjs-1.6.4/angular.ng-modules.js" type="text/javascript"></script>
<script src="view-source:edu2.kosta.or.kr/assets/jsgrid/jsgrid.min.js" type="text/javascript"></script>
<script src="view-source:edu2.kosta.or.kr/assets/jquery-validation/jquery.validate.min.js" type="text/javascript"></script>

<script src="view-source:edu2.kosta.or.kr/assets/ladda/dist/spin.min.js" type="text/javascript"></script>
<script src="view-source:edu2.kosta.or.kr/assets/ladda/dist/ladda.min.js" type="text/javascript"></script>
<script src="view-source:edu2.kosta.or.kr/assets/ladda/dist/ladda.jquery.min.js" type="text/javascript"></script>

<!-- App scripts -->
<script type="text/javascript" src="view-source:edu2.kosta.or.kr/assets/scripts/homer.js"></script>
<script type="text/javascript" src="view-source:edu2.kosta.or.kr/assets/scripts/moment.js"></script>
<script type="text/javascript" src="view-source:edu2.kosta.or.kr/assets/toastr/build/toastr.min.js"></script>
<script type="text/javascript" src="view-source:edu2.kosta.or.kr/assets/sweetalert/lib/sweet-alert.min.js"></script>
<script type="text/javascript" src="view-source:edu2.kosta.or.kr/assets/scripts/main.js"></script>
<!-- Kosta script end -->

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
	background-color: #2196F3;
	padding: 10px;
	grid-gap: 10px;
}

.grid-container>div {
	background-color: rgba(255, 255, 255, 0.8);
	text-align: center;
	padding: 20px 0;
	font-size: 30px;
}
</style>

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








