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

<!-- kosta style start -->
<style type="text/css">
@charset "UTF-8"; 

[ng\:cloak], [ng-cloak], [data-ng-cloak], [x-ng-cloak], .ng-cloak,
	.x-ng-cloak, .ng-hide:not (.ng-hide-animate ){
	display: none !important;
}

ng\:form {
	display: block;
}

.ng-animate-shim {
	visibility: hidden;
}

.ng-anchor {
	position: absolute;
}
</style>
<!-- Vendor styles -->
<link rel="stylesheet" media="screen"
	href="/assets/fontawesome/css/font-awesome.min.css">
<link rel="stylesheet" media="screen"
	href="/assets/metisMenu/dist/metisMenu.min.css">
<link rel="stylesheet" media="screen"
	href="/assets/animate.css/animate.min.css">
<link rel="stylesheet" media="screen"
	href="/assets/bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet" media="screen"
	href="/assets/bootstrap-datepicker-master/dist/css/bootstrap-datepicker3.min.css">
<link rel="stylesheet" media="screen"
	href="/assets/toastr/build/toastr.min.css">
<link rel="stylesheet" media="screen"
	href="/assets/sweetalert/lib/sweet-alert.css">
<link rel="stylesheet" media="screen"
	href="/assets/ladda/dist/ladda-themeless.min.css">

<!-- App styles -->
<link rel="stylesheet" media="screen"
	href="/assets/fonts/pe-icon-7-stroke/css/pe-icon-7-stroke.css">
<link rel="stylesheet" media="screen"
	href="/assets/fonts/pe-icon-7-stroke/css/helper.css">
<link rel="stylesheet" media="screen" href="/assets/css/style.css">

<script type="text/javascript" async=""
	src="https://www.google-analytics.com/analytics.js"></script>
<script src="/assets/lib/jquery/jquery.min.js" type="text/javascript"></script>
<script src="/assets/modernizr/modernizr-custom.js"
	type="text/javascript"></script>
<script src="/assets/slimScroll/jquery.slimscroll.min.js"></script>
<script src="/assets/bootstrap/dist/js/bootstrap.min.js"></script>
<script
	src="/assets/bootstrap-datepicker-master/dist/js/bootstrap-datepicker.min.js"></script>
<script
	src="/assets/bootstrap-datepicker-master/dist/locales/bootstrap-datepicker.kr.min.js"></script>
<script src="/assets/metisMenu/dist/metisMenu.min.js"></script>
<script src="/assets/iCheck/icheck.min.js"></script>
<script src="/assets/holder/holder.min.js" type="text/javascript"></script>
<script src="/assets/sparkline/index.js"></script>
<script src="/assets/angularjs-1.6.4/angular.min.js"
	type="text/javascript"></script>
<script src="/assets/angularjs-1.6.4/angular-sanitize.min.js"
	type="text/javascript"></script>
<script src="/assets/angularjs-1.6.4/angular-animate.min.js"
	type="text/javascript"></script>
<script src="/assets/angularjs-1.6.4/angular-resource.min.js?v=1.3.14"
	type="text/javascript"></script>
<script src="/assets/angularjs-1.6.4/angular.ng-modules.js"
	type="text/javascript"></script>
<script src="/assets/jsgrid/jsgrid.min.js" type="text/javascript"></script>
<script src="/assets/jquery-validation/jquery.validate.min.js"
	type="text/javascript"></script>

<script src="/assets/ladda/dist/spin.min.js" type="text/javascript"></script>
<style type="text/css"></style>
<script src="/assets/ladda/dist/ladda.min.js" type="text/javascript"></script>
<script src="/assets/ladda/dist/ladda.jquery.min.js"
	type="text/javascript"></script>

<link rel="stylesheet" media="screen" href="/assets/css/main.css">
<link rel="shortcut icon" type="image/png"
	href="/assets/images/favicon.png">

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->

<!-- App scripts -->
<script type="text/javascript" src="/assets/scripts/homer.js"></script>
<script type="text/javascript" src="/assets/scripts/moment.js"></script>
<script type="text/javascript" src="/assets/toastr/build/toastr.min.js"></script>
<script type="text/javascript"
	src="/assets/sweetalert/lib/sweet-alert.min.js"></script>
<script type="text/javascript" src="/assets/scripts/main.js"></script>

<!-- Global site tag (gtag.js) - Google Analytics -->
<script async=""
	src="https://www.googletagmanager.com/gtag/js?id=UA-110594605-1"></script>
<script type="text/javascript">
	window.dataLayer = window.dataLayer || [];
	function gtag() {
		dataLayer.push(arguments);
	}
	gtag('js', new Date());
	gtag('config', 'UA-110594605-1');
</script>

<script>
	var apps = [];
</script>
<style type="text/css">
.jqstooltip {
	position: absolute;
	left: 0px;
	top: 0px;
	visibility: hidden;
	background: rgb(0, 0, 0) transparent;
	background-color: rgba(0, 0, 0, 0.6);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr=#99000000,
		endColorstr=#99000000);
	-ms-filter:
		"progid:DXImageTransform.Microsoft.gradient(startColorstr=#99000000, endColorstr=#99000000)";
	color: white;
	font: 10px arial, san serif;
	text-align: left;
	white-space: nowrap;
	padding: 5px;
	border: 1px solid white;
	z-index: 10000;
}

.jqsfield {
	color: white;
	font: 10px arial, san serif;
	text-align: left;
}
</style>
<!-- kosta style end -->






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








