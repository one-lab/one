<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>单证回收</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/Standard.css" rel="stylesheet" type="text/css" />

  </head>
  
  <body>
    <form name="fm" method="post" onkeypress="KeyDown()">
	<TABLE id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
	
	<tr>
		<td><input name="" type="button" class="button" value="单证回收" /></td>
	</tr>
	<TR>
		<TD class="left">单证编码</TD>
		<TD class="right"><INPUT name="InsuredName" class="common" type="text" onchange="clickable()"></TD>
	</TR>
	<tr>
		<td>回收信息</td>
	</tr>
	
	<TR>
		<TD class="left">单证号码</TD>
		<TD class="right"><INPUT name="InsuredName" class="common" type="text" style="width:73%" onchange="clickable()"><input name="" type="button" value="单证查询" /></TD>
		<TD class="left">有效日期</TD>
		<TD class="right"></TD>
	</TR>
	<TR>
		<TD class="left">发放者</TD>
		<TD class="right"><INPUT name="InsuredName" class="common" type="text" onchange="clickable()"></TD>
		<TD class="left">接受者</TD>
		<TD class="right"><INPUT name="InsuredName" class="common" type="text" onchange="clickable()"></TD>
	</TR>
	
	<TR>
		<TD class="left">经办人</TD>
		<TD class="right"></TD>
		<TD class="left">经办日期</TD>
		<TD class="right"></TD>
	</TR>
	
		<TR>
		<TD class="left">操作员</TD>
		<TD class="right"></TD>
		<TD class="left">入机日期</TD>
		<TD class="right"></TD>
	</TR>
	
	<tr><td><br /></td></tr>
	
	<TR>
		<TD class="left">回收操作员</TD>
		<TD class="right"></TD>
		<TD class="left">回收日期</TD>
		<TD class="right"><INPUT name="InsuredName" class="common" type="text" onchange="clickable()"></TD>
	</TR>
	
	<TR>
		<TD class="left">发放批次号</TD>
		<TD class="right"></TD>
		<TD class="left">回收批次号</TD>
		<TD class="right"></TD>
	</TR>
	<TR>
		<TD class="left">回收操作日期</TD>
		<TD class="right"></TD>
		<TD class="left">回收操作时间</TD>
		<TD class="right"></TD>
	</TR>
	
	</TABLE>
</form>
  </body>
</html>
