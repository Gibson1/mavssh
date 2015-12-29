<html>
<head>
<script type="text/javascript">
function check(){
	if(document.getElementById("username").value == ''){
		alert("Username should not be empty!");
		document.getElementById("username").focus();
	}
	
	if(document.getElementById("password").value == ''){
		alert("Password should not be empty!");
		document.getElementById("password").focus();
	}
	return true;
}

</script>
<style>
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
	<form action="user/login.do" method="post">
		<table align="center" style="width:50%">
			<colgroup>
				<col span="1" width="30%" />
				<col span="1" width="70%" />
			</colgroup>
			<tr>
				<td><label>User</label></td>
				<td><input type="text" id="username" name="user.name" defaultValue="type your user name" required /></td>
			<tr>
				<td><label>Password</label></td>
				<td><input type="password" id="password" name="user.password" value="" required/></td>
			</tr>
			<tr>
				<td span="2"><input type="submit" value="Login" /></td>
			</tr>
		</table>
	</form>

</body>
</html>
