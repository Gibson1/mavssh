<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
<script type="text/javascript">
	function check() {
		if (document.getElementById("username").value == '') {
			alert("Username should not be empty!");
			document.getElementById("username").focus();
		}

		if (document.getElementById("password").value == '') {
			alert("Password should not be empty!");
			document.getElementById("password").focus();
		}
		return true;
	}
</script>
<style>
body {
	background: black;
	color: white;
}

table, th, td {
	border: 0px solid black;
	border-collapse: collapse;
}

th, td {
	padding: 15px;
}
</style>
</head>
<body>
	<div align="center">
		<br /> <br />
		<h1>Hey! Here is the right place you want.</h1>
	</div>
	<br />
	<br />
	<br />
	<div align="center">
		<form action="user/login.do" method="post">
			<table align="center" style="width: 50%">
				<colgroup>
					<col span="1" width="50%" />
					<col span="1" width="50%" />
				</colgroup>
				<tr>
					<td align="right"><label>User</label></td>
					<td align="left"><input type="text" id="username"
						name="user.name" defaultValue="type your user name" required /></td>
				<tr>
					<td align="right"><label>Password</label></td>
					<td align="left"><input type="password" id="password"
						name="user.password" value="" required /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="Login" /></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>
