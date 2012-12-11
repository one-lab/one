<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@include file="/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>呈报契调回复</title>
    
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
	<div style = "width:100%">
		<table id="ReportComAppInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     请输入查询条件</td>
			</tr>		
			<tr>
				<td  class="left">呈报号：</td>
				<td  class="right"><input name="RepApplyNo" class="common" type="text"></td>
				<td  class="left">通知书流水号：</td>
				<td  class="right"><input name="Reportor" class="common" type="text" ></td>
				<td  class="left">单位名称：</td>
				<td  class="right"><input name="GrpName" class="common" type="text" ></td>
			</tr>
		</table>
		<table id="QueryApplyInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td><input type = "button" class="cssbutton" name="QueryButton" value="查  询"></td>
			</tr>
		</table>
	</div>
	<div style = "width:70%">
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">    待回复契调任务</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="25%">呈报号</td>
					<td width="25%">契调通知书流水号</td>
					<td width="42%">单位名称</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>1</td>
					<td>S860120120005</td>
					<td>4624789791000023350</td>
					<td>中科软科技股份有限公司</td>
				</tr>
			</tbody>
		</table>
		<table id="PageInfo1" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="45%" align='right'><input type = "button" class="cssbutton" value="首  页" onclick="location.href='ReportAuditDeal.jsp'"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="上一页"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="下一页"></td>
				<td width="45%"><input type = "button" class="cssbutton" value="尾  页"></td>
			</tr>
		</table>
		<table  id="ApplyInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type = "button"  name="ApplyButton" class="cssbutton" value="开始录入" onclick="location.href='./GroupContSearchReply.jsp'">
				</td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
