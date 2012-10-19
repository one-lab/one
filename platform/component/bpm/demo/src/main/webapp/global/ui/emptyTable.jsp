<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ include file="/global/ui/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>电子商务管理系统-空白表格</title>
<link type="text/css" rel="stylesheet" href="${ctx}/global/css/mis_basic.css">
</head>
<body topmargin="5" leftmargin="2" bgcolor="WHITE">
<table width="100%" cellpadding="0" cellspacing="0" border="0" class="table_Show">
<s:iterator begin="0" end="10">
	<tr>
		<s:iterator begin="0" end="8">
			<td class="td_head">&nbsp;</td>
		</s:iterator>
	</tr>
</s:iterator>
</table>
</body>
</html>