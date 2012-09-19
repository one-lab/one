<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>空白表格</title>
<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
</head>
<body topmargin="1" leftmargin="1" rightmargin="1" bottommargin="1" bgcolor="WHITE">
<table width="100%" cellpadding="0" cellspacing="0" border="0" class="common">
	<thead>
	<tr class="tableHead">
		<s:iterator begin="0" end="7">
			<td >&nbsp;</td>
		</s:iterator>
	</tr>
	</thead>
<s:iterator begin="0" end="19" step="1">
	<tr class="content">
		<c:forEach begin="0" end="7">
			<td >&nbsp;</td>
		</c:forEach>
	</tr>
</s:iterator>
</table>
</body>
</html>