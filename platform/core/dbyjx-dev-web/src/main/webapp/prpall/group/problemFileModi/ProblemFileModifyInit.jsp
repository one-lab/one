<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//Dtd HTML 4.01 transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>问题件修改首界面</title>
    
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
	<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
		<tr>
			<td>请输入查询投保单条件： </td>
		</tr>
		<tr>
			<td class="left">投保单号</td>
			<td class="right"><INPUT name="PolicyNo" class="common" type="text" onchange="clickable()"></td>
			<td  class="left">销售方式</td>
			<td  class="right"><INPUT name="PolicyNo" class="common" type="text" onchange="clickable()"></td>
			<td  class="left">管理机构</td>
			<td  class="right"><INPUT name="PolicyNo" class="common" type="text" onchange="clickable()"></td>
		</tr>
		<tr>
			<td class="left">业务员编码</td>
			<td class="right"><INPUT name="PolicyNo" class="common" type="text" onchange="clickable()"></td>
			<td class="left">问题件下发日期</td>
			<td class="right"><INPUT name="Startdate" id="Startdate" class="common" type="text" onchange="clickable()" style="width:73%"
    	  value='2012-04-28'>
				<img style='cursor:hand' align="absmiddle" src="common/images/bgcalendar.gif" onClick="TogglePopupCalendarWindow('document.fm.Startdate', '1997', '2014')"></td>
			<td class="left">投保单位全称</td>
			<td class="right"><INPUT name="PolicyNo" class="common" type="text" onchange="clickable()"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="button" class="button" name = "queryButton" value="查询" onClick="" ></td>
		</tr>
		<tr>
			<td>共享工作池</td>
		</tr>
		<tr>
			<td colspan="6"><table width="800" border="1">
					<tr>
						<th scope="col">&nbsp;</th>
						<th scope="col">序号</th>
						<th scope="col">投保单号</th>
						<th scope="col">销售方式</th>
						<th scope="col">投保单位全称</th>
						<th scope="col">问题件下发日期</th>
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
					</tr>
				</table></td>
		</tr>
		<tr>
			<td colspan="6"><input type="button" class="button" name = "queryButton" value="首页" onClick="" >
				<input type="button" class="button" name = "queryButton" value="上一页" onClick="" >
				<input type="button" class="button" name = "queryButton" value="下一页" onClick="" >
				<input type="button" class="button" name = "queryButton" value="尾页" onClick="" ></td>
		</tr>
		<tr>
			<td colspan="2"><input type="button" class="button" name = "queryButton" value="申请" onClick="parent.document.getElementById('fraInterface').src ='group/problemFileModi/ProblemFileModify.jsp'" ></td>
		</tr>
		<tr>
			<td>投保单信息</td>
		</tr>
	</table>
</form>
  </body>
</html>
