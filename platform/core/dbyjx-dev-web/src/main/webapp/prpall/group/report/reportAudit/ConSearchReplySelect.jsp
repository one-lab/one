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
    
    <title>查看契调回复信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="common/js/SimpleCalendar.js"></script>

  </head>
  
  <body>
    <form name="fm" method="post" onkeypress="KeyDown()">
	<div style = "width:100%">
		<table id="ReportCompanyInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     请输入查询条件</td>
			</tr>
			<tr>
				<td  class="left">呈报申请号：</td>
				<td  class="right"><input name="ReportNo" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">通知书流水号：</td>
				<td  class="right"><input name="ManageCom" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">单位名称：</td>
				<td  class="right"><input name="GrpName" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td colspan="6"><input type="button" class="cssbutton" name="QueryButton" value="查  询" onclick=""></td>
			</tr>
		</table>
		<table id="AlivePlanInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     待回复契调任务</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="32%">呈报号</td>
					<td width="30%">契调通知书流水号</td>
					<td width="30%">单位名称</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>1</td>
					<td>S153151513511</td>
					<td>PR45424545</td>
					<td>中国航天技术有限公司</td>
				</tr>
			</tbody>
			<tbody>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>1</td>
					<td>S153153422511</td>
					<td>PR454243243</td>
					<td>北京航天技术有限公司</td>
				</tr>
			</tbody>			
			<table>
				<tr>
					<td width="45%" align='right'><input type = "button" class="cssbutton" value="首  页"></td>
					<td width="5%"><input type = "button" class="cssbutton" value="上一页"></td>
					<td width="5%"><input type = "button" class="cssbutton" value="下一页"></td>
					<td width="45%"><input type = "button" class="cssbutton" value="尾  页"></td>
				</tr>
			</table>
		</table>
		<hr>
		<table id="ReportCompanyInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="Add" value="开始录入" onclick="location.href='../reportAudit/ConSearchReply.jsp'">
					<input type = "button" class="cssbutton" name="ReturnBack" value="返  回" onclick="javascript:history.go(-1);">
				</td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
