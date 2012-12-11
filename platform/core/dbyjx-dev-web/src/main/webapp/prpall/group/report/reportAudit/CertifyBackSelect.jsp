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
    
    <title>单证回收任务选取</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="common/js/SimpleCalendar.js"></script>

  </head>
  
  <body>
    <form name="fm" method="post" onkeypress="KeyDown()">
	<TABLE id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
	
	
	
	<TR>
		<TD class="left">单证编码</TD>
		<TD class="right"><INPUT name="InsuredName" class="common" type="text" onchange="clickable()"></TD>
	</TR>
	<TR>
		<TD class="left">单证号码</TD>
		<TD class="right"><INPUT name="InsuredName" class="common" type="text" style="width:73%" onchange="clickable()"></TD>
		<TD class="left">有效日期</TD>
		<TD class="right"><INPUT name="Date1" id="Date1" class="common" type="text" onchange="clickable()" style="width:73%"
    	  value='2012-04-28'>
			<img style='cursor:hand' align="absmiddle" src="common/images/bgcalendar.gif" onClick="TogglePopupCalendarWindow('document.fm.Date1', '1997', '2014')"></TD>
	</TR>
	<TR>
		<TD class="left">发放机构</TD>
		<TD class="right"><INPUT name="InsuredName" class="common" type="text" onchange="clickable()"></TD>
		<TD class="left">接收机构</TD>
		<TD class="right"><INPUT name="InsuredName" class="common" type="text" onchange="clickable()"></TD>
	</TR>
	<TR>
		<TD class="left">经办人</TD>
		<TD class="right"><INPUT name="InsuredName" class="common" type="text" onchange="clickable()"></TD>
		<TD class="left">经办日期</TD>
		<TD class="right"><INPUT name="Date2" id="Date2" class="common" type="text" onchange="clickable()" style="width:73%"
    	  value='2012-04-28'>
			<img style='cursor:hand' align="absmiddle" src="common/images/bgcalendar.gif" onClick="TogglePopupCalendarWindow('document.fm.Date2', '1997', '2014')"></TD>
	</TR>
	<TR>
		<TD><input type="button" class="button" name = "queryButton" value="查询" onClick="" >
			<input type="button" class="button" name = "queryButton" value="返回" onClick="" >
		</TD>
	</TR>
	<tr>
		<td>单证印刷表结果</td>
	</tr>
	<tr>
		<td colspan="4"><table width="1200" border="1">
				<tr>
					<th scope="col">&nbsp;</th>
					<th scope="col">序号</th>
					<th scope="col">单证编码</th>
					<th scope="col">单证号码</th>
					<th scope="col">发放机构</th>
					<th scope="col">接受机构</th>
					<th scope="col">操作员</th>
					<th scope="col">有效日期</th>
					<th scope="col">经办人</th>
					<th scope="col">经办日期</th>
					<th scope="col">发放号</th>
					<th scope="col">回收号</th>
					<th scope="col">发放日期</th>
					<th scope="col">回收日期</th>
					<th scope="col">&nbsp;</th>
				</tr>
				<tr>
					<td><label>
						<input type="radio" name="radiobutton" value="radiobutton" />
						</label></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
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
		<TD colspan="4"><input type="button" class="button" name = "queryButton" value="首页" onClick="" >
			<input type="button" class="button" name = "queryButton" value="上一页" onClick="" >
			<input type="button" class="button" name = "queryButton" value="下一页" onClick="" >
			<input type="button" class="button" name = "queryButton" value="尾页" onClick="" >
		</TD>
	</TR>
	</TABLE>
</form>
  </body>
</html>
