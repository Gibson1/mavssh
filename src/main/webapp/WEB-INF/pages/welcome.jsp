<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Welcome</title>
<style type="text/css">
.odd {
	background-color: silver;
}

.even {
	background-color: white;
}
</style>
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
	<div style="float: right;">
		<input type="button" value="Log Out"
			onclick="location.href=window.location.origin+'/MSSH/user/logout.do'" />
	</div>
	<br />
	<div align="center">
		<s:if test="UserHistories.size() > 0">
			<table border="1px" cellpadding="8px">
				<tr>
					<th>Code</th>
					<th>Red01</th>
					<th>Red02</th>
					<th>Red03</th>
					<th>Red04</th>
					<th>Red05</th>
					<th>Red06</th>
					<th>Blue</th>
					<th>Status</th>
				</tr>
				<s:iterator value="UserHistories" status="rowstatus">
					<tr
						class="<s:if test="#rowstatus.odd == true ">odd</s:if><s:else>even</s:else>">
						<td><s:property value="UHR_CODE" /></td>
						<td><s:property value="UHR_RED1" /></td>
						<td><s:property value="UHR_RED2" /></td>
						<td><s:property value="UHR_RED3" /></td>
						<td><s:property value="UHR_RED4" /></td>
						<td><s:property value="UHR_RED5" /></td>
						<td><s:property value="UHR_RED6" /></td>
						<td><s:property value="UHR_BLUE" /></td>
					</tr>
				</s:iterator>
			</table>
			<br />
			<br />
			<display:table defaultsort="1" id="UserHistory" name="UserHistories"
				pagesize="10" requestURI="/user/afterlogin.do" sort="UserHistories">
				<display:column property="UHR_CODE" title="CODE" sortable="true"
					defaultorder="ascending"></display:column>
				<display:column property="UHR_RED1" title="RED01" sortable="true"
					defaultorder="ascending"></display:column>
				<display:column property="UHR_RED2" title="RED02" sortable="true"
					defaultorder="ascending"></display:column>
				<display:column property="UHR_RED3" title="RED03" sortable="true"
					defaultorder="ascending"></display:column>
				<display:column property="UHR_RED4" title="RED04" sortable="true"
					defaultorder="ascending"></display:column>
				<display:column property="UHR_RED5" title="RED05" sortable="true"
					defaultorder="ascending"></display:column>
				<display:column property="UHR_RED6" title="RED06" sortable="true"
					defaultorder="ascending"></display:column>
				<display:column property="UHR_BLUE" title="BLUE" sortable="true"
					defaultorder="ascending"></display:column>
			</display:table>
		</s:if>
	</div>
	<br />
</body>
</html>
