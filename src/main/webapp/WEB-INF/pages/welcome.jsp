<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Welcome</title>
</head>
<body>
	<div align="center">
		<br /> <br />
		<h1>Welcome!</h1>
	</div>
	<br />
	<br />
	<br /> Here is the page after login.
	<br />
	<div align="center">
		<input type="button" value="Log Out"
			onclick="location.href=window.location.origin+'/MSSH/user/logout.do'" />
	</div>
	<br /> ${testname }
	<br />
	<s:if test="2 > 1">
		<s:text name="testname" />
		<br />
		<s:textarea name="testname" value="testname" />
		<br />
		<s:property value="testname" />
	</s:if>
	<br />
</body>
</html>
