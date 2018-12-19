<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<title>Login.jsp</title>
<style type="text/css">
#loginWrap {
	width: 500px;
	margin: auto;
}

#loginWrap table {
	width: 100%;
	border: 1px dotted #9900ff
}

#loginWrap table thead {
	background-color: #b9b9ff;
}
</style>
</head>
<body>
	<div id="loginWrap">
		<h3>Student_Login</h3>
		<form action="stu_loginProcess" method="POST" autocomplete="off">
		<fieldset>
			<table>
				<tr>
					<td>ID:</td>
					<td><input class="form-control" type='text' name='sid' id="sid" placeholder="ID" /></td>
				</tr>
				<tr>
				<div class="form-group">
					<td>Password:</td>
					<td><input class="form-control" type='password' name='spwd' id="spwd" placeholder="Password" /></td>
				</div>
				</tr>
				<tr>
					<td colspan='2'><input name="submit" type="submit" value="Login" class="btn btn-outline-primary"/></td>
				</tr>
			</table>
			</fieldset>
		</form>
	</div>
</body>
</html>
