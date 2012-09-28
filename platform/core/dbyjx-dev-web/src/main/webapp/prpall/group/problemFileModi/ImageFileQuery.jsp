<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>影像件查询</title>
    
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
		<TR>
			<TD colspan="4"><hr />
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p></td>
		</TR>
		<TR>
			<TD colspan="4"><hr /></td>
		</TR>
		<TR>
			<TD class="left">投保单号</TD>
			<TD class="right">4176736471623746</TD>
			<TD class="left">影像类别</TD>
			<TD class="right"><INPUT name="InsuredName" class="common" type="text" onchange="clickable()"></TD>
		</TR>
		<TR>
			<TD colspan="2"><input type="button" class="button" name = "queryButton" value="查询" onClick="" >
			</TD>
		</TR>
		<TR>
			<TD colspan="4"><hr /></td>
		</TR>
		<TR>
			<TD>影像资料信息</td>
		</TR>
		<tr>
			<td colspan="4"><table width="1000" border="1">
					<tr>
						<th width="51" scope="col"></th>
						<th width="65" scope="col">序号</th>
						<th width="159" scope="col">单证号</th>
						<th width="167" scope="col">影像类别</th>
						<th width="130" scope="col">影像名称</th>
						<th width="130" scope="col">扫描批次号</th>
						<th width="130" scope="col">页数</th>
						<th width="130" scope="col">扫描时间</th>
					</tr>
					<tr>
						<td><input name="" type="radio" value="" /></td>
						<td>1</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
				</table></td>
		</tr>
		<TR>
			<TD colspan="2"><input type="button" class="button" name = "queryButton" value="首页" onClick="" >
				<input type="button" class="button" name = "queryButton" value="上一页" onClick="" >
				<input type="button" class="button" name = "queryButton" value="下一页" onClick="" >
				<input type="button" class="button" name = "queryButton" value="尾页" onClick="" >
			</TD>
		</TR>
	</TABLE>
</form>
  </body>
</html>
