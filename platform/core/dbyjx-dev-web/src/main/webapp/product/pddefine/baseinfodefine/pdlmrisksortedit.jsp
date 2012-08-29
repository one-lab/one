<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>险种分类</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/common/calender/WdatePicker.js"></script>

  </head>
  <body>
    <form name="fm" method="post" onkeypress="KeyDown()">
	<div style = "width:60%">
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="left">险种代码：</td>
				<td class="right"><input name="GrpName" class="common" type="text"/></td>
				<td class="left">申请日期：</td>
				<td class="right">
					<input name="ApplyDate" id="ApplyDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'ApplyDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>				
			</tr>
		</table>
		
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">险种分类属性定义</td>
				</tr>
				<tr class="tableHead">
					<td width="10">&nbsp;</td>
					<td width="10%">序号</td>
					<td width="20%">险种类别</td>
					<td width="20%">险种类别类型值</td>
					<td width="30%">备注</td>
					<td width="10%">&nbsp;</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td>&nbsp;</td>
					<td>1</td>
					<td><input name="comCode" class="codecode" type="text" onchange="clickable()"></td>
					<td><input name="comCode" class="codecode" type="text" onchange="clickable()"></td>
					<td><input name="" class="common" type="text"/></td>
					<td align="center">-</td>
				</tr>
				<tr class="content">
					<td align="center" >+</td>
				</tr>
			</tbody>
		</table>
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type = "button" class="cssbutton" name="Button" value="保存" onclick="">
				</td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
